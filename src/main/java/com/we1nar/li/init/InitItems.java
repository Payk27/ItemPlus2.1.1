package com.we1nar.li.init;

import com.we1nar.li.items.*;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class InitItems {
    public static final List<Item> items = new ArrayList<Item>();

    public static final EnumRarity rLegendary = EnumHelper.addRarity("Легендарная редкость", TextFormatting.GOLD, "ЛЕГЕНДАРНОЕ");
    public static final EnumRarity rEpic = EnumHelper.addRarity("Эпическая редкость", TextFormatting.LIGHT_PURPLE, "ЭПИЧЕСКОЕ");
    public static final EnumRarity rRar = EnumHelper.addRarity("Редкая редкость", TextFormatting.GREEN, "РЕДКОЕ");
    public static final EnumRarity rCommon = EnumHelper.addRarity("Обычная редкость", TextFormatting.GRAY, "ОБЫЧНОЕ");


    //Мои итемы
    public static final Item skybroadsword =new SkyBroadsword("skybroadsword", SkyBroadsword.toolMaterial);
    public static final Item sharpsickle =new SharpSickle("sharpsickle", SharpSickle.toolMaterial);
    public static final Item bladeofdarkness =new BladeOfDarkness("bladeofdarkness", BladeOfDarkness.toolMaterial);
    public static final Item swordofchains =new SwordOfChains("swordofchains", SwordOfChains.toolMaterial);
    public static final Item llvlsw =new LovLVLSword("llvlsw", LovLVLSword.toolMaterial);
    public static final Item sawsword =new SawSword("sawsword", SawSword.toolMaterial);
    public static final Item twohandeddoom =new TwoHandedDoom("twohandeddoom", TwoHandedDoom.toolMaterial);
    public static final Item scarletmadness =new ScarletMadness("scarletmadness", ScarletMadness.toolMaterial);

    public static final Item fireProtector = new FireProtector();
}
