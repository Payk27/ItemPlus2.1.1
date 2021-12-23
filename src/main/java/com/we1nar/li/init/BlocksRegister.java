package com.we1nar.li.init;

import com.we1nar.li.items.BlockBlack;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class BlocksRegister {
    public static Block Block_Black = new BlockBlack("blockblack");
    public static void register(){
        setRegister(Block_Black);
    }
    private static void setRegister(Block block)
    {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        setRender(Block_Black);
    }
    @SideOnly(Side.CLIENT)
    private static void setRender(Block block)
    {

    }
    public static final List<Block> MBLOCKS = new ArrayList<Block>();

    public static final Block BLOCK = new BlockBlack("blockblack");
}
