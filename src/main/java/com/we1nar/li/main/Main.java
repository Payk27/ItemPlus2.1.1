package com.we1nar.li.main;

import com.we1nar.li.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import com.we1nar.li.reference.Reference;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID,name = Reference.NAME,version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MINECRAFT_VERSIONS)

public class Main
{
    @Mod.Instance
    public static Main instance;
    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;
    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {}
    public static void Init(FMLInitializationEvent event) {}
    public static void postInit(FMLPostInitializationEvent event) {}
    public static final String MOD_ID = "li";

}
