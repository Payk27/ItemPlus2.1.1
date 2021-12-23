package com.we1nar.li.Proxy;

import com.we1nar.li.init.BlocksRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy
{
    public void registerItemRenderer(Item item, int meta, String id)
    {
    }
    public EntityPlayer getPlayerEntity(MessageContext ctx) {
        return ctx.getServerHandler().player;
    }


    public void preInit(FMLPreInitializationEvent event) {
        BlocksRegister.register();
    }



    public void init(FMLInitializationEvent event) {

    }


    public void postInit(FMLPostInitializationEvent event) {

    }

}
