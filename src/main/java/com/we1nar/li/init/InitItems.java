package com.we1nar.li.init;

import com.we1nar.li.items.*;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class InitItems
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final EnumRarity RARITY_LEGENDARY = EnumHelper.addRarity("Легендарная редкость", TextFormatting.GOLD, "ЛЕГЕНДАРНОЕ");
    public static final EnumRarity RARITY_EPIC = EnumHelper.addRarity("Эпическая редкость", TextFormatting.LIGHT_PURPLE, "ЭПИЧЕСКОЕ");
    public static final EnumRarity RARITY_RAR = EnumHelper.addRarity("Редкая редкость", TextFormatting.GREEN, "РЕДКОЕ");
    public static final EnumRarity RARITY_COMMON = EnumHelper.addRarity("Обычная редкость", TextFormatting.GRAY, "ОБЫЧНОЕ");


    //Мои итемы
    public static final Item Sky_Broadsword =new SkyBroadsword("skybroadsword", SkyBroadsword.TOOL_MATERIAL);
    public static final Item Sharp_Sickle =new SharpSickle("sharpsickle", SharpSickle.TOOL_MATERIAL);
    public static final Item Blade_Of_Darkness =new BladeOfDarkness("bladeofdarkness", BladeOfDarkness.TOOL_MATERIAL);
    public static final Item Sword_OfChains =new SwordOfChains("swordofchains", SwordOfChains.TOOL_MATERIAL);
    public static final Item L =new LovLVLSword("llvlsw", LovLVLSword.TOOL_MATERIAL);
    public static final Item SawSword =new SawSword("sawsword", com.we1nar.li.items.SawSword.TOOL_MATERIAL);
    public static final Item Two =new TwoHandedDoom("twohandeddoom", TwoHandedDoom.TOOL_MATERIAL);
    public static final Item Scarlet_Madness =new ScarletMadness("scarletmadness", ScarletMadness.TOOL_MATERIAL);

    public static final Item Fire_Protector = new FireProtector();
}
