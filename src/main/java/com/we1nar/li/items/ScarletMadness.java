package com.we1nar.li.items;

import com.google.common.collect.Multimap;
import com.we1nar.li.init.InitItems;
import com.we1nar.li.init.InitPotionsEffect;
import com.we1nar.li.main.Main;
import com.we1nar.li.utils.interfaces.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

import javax.annotation.Nullable;
import java.util.List;


public class ScarletMadness extends ItemSword implements IHasModel
{
    public static final Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial("scarletmadness", 2, 3000, 50.0F, -3.0F, 20);
    public ScarletMadness (String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name) ;
        this.setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.COMBAT);
        InitItems.items.add(this);
    }
    @Override
    public void registerModels() { Main.proxy.registerItemRenderer(this,0,"inventory"); }


    //скорость атаки
    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(EntityEquipmentSlot.MAINHAND);
            multimap.removeAll(SharedMonsterAttributes.ATTACK_SPEED.getName());
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -1.3D, 0));
            return multimap;
        }
        return super.getItemAttributeModifiers(equipmentSlot);
    }


    //редкость
    public EnumRarity getRarity(ItemStack stack)
    {
        return InitItems.rLegendary;
    }
    //наложение эффектов при ударе
    byte b = (byte) (Stats.chance+30);
    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        byte a = (byte) (1 + Math.random()*99);
        if (a<=b)
            target.addPotionEffect(new PotionEffect(InitPotionsEffect.bloodPotion, 200, 2));
            return true;
    }
    //описание
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> descript, ITooltipFlag flagIn) {
        descript.add("\u00a7f\u041d\u0430\u043a\u043b\u0430\u0434\u044b\u0432\u0430\u0435\u0442 \u044d\u0444\u0444\u0435\u043a\u0442 \u00a74\u041a\u0420\u041e\u0412\u041e\u0422\u0415\u0427\u0415\u041d\u0418\u042f \u0441 \u0448\u0430\u043d\u0441\u043e\u043c " + b + "%");
    }
}
