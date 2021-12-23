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

public class SwordOfChains extends ItemSword implements IHasModel
{
    public static final Item.ToolMaterial TOOL_MATERIAL = EnumHelper.addToolMaterial("swordofchains", 2, 3000, 50.0F, 12.0F, 20);
    public SwordOfChains(String name, ToolMaterial material)
    {
        super(material);
        this.setRegistryName(name) ;
        this.setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.COMBAT);
        InitItems.ITEMS.add(this);
    }
    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this,0,"inventory");
    }

    public EnumRarity getRarity(ItemStack stack)
    {
        return InitItems.RARITY_EPIC;
    }
}
