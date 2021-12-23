package com.we1nar.li.items;

import com.we1nar.li.init.BlocksRegister;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBlack extends Block {
    public BlockBlack(String name)
    {
        super(Material.GLASS);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.COMBAT);
        BlocksRegister.MBLOCKS.add(this);
    }
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

}