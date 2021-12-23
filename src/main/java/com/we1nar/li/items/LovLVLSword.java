package com.we1nar.li.items;

import com.we1nar.li.main.Main;
import com.we1nar.li.init.InitItems;
import com.we1nar.li.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class LovLVLSword extends ItemSword implements IHasModel
{
    public static final Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial("llvlsw", 2, 3000, 50.0F, 0.0F, 10);
    public LovLVLSword(String name, Item.ToolMaterial material) {
        super(material);
        this.setRegistryName(name) ;
        this.setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.COMBAT);
        InitItems.items.add(this);
    }
    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this,0,"inventory");
    }

    public EnumRarity getRarity(ItemStack stack)
    {
        return InitItems.rCommon;
    }
}
