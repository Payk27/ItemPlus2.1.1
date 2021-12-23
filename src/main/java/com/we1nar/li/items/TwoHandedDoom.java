package com.we1nar.li.items;

import com.google.common.collect.Multimap;
import com.we1nar.li.main.Main;
import com.we1nar.li.init.InitItems;
import com.we1nar.li.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class TwoHandedDoom extends ItemSword implements IHasModel {
    public static final Item.ToolMaterial TOOL_MATERIAL = EnumHelper.addToolMaterial("twohandeddoom", 2, 3000, 50.0F, 14.0F, 20);

    public TwoHandedDoom(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.COMBAT);
        InitItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(EntityEquipmentSlot.MAINHAND);
            multimap.removeAll(SharedMonsterAttributes.ATTACK_SPEED.getName());
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.8D, 0));
            return multimap;
        }
        return super.getItemAttributeModifiers(equipmentSlot);
    }

    public EnumRarity getRarity(ItemStack stack)
    {
        return InitItems.RARITY_EPIC;
    }
}
