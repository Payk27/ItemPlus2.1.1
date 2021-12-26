package com.we1nar.li.utils.interfaces.handlers;

import com.we1nar.li.init.BlocksRegister;
import com.we1nar.li.init.InitItems;
import com.we1nar.li.init.InitPotionsEffect;
import com.we1nar.li.utils.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@Mod.EventBusSubscriber


public class RegHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(InitItems.items.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onPotionReg(RegistryEvent.Register<Potion> event) {
        event.getRegistry().registerAll(InitPotionsEffect.mpotion.toArray(new Potion[0]));;
    }

    @SubscribeEvent
    public static void onBlockReg (RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlocksRegister.mblock.toArray(new  Block[0]));
        BlocksRegister.register();
    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : InitItems.items) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }
    }
}
