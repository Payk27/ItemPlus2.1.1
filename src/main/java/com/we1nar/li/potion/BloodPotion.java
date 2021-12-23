package com.we1nar.li.potion;

import com.we1nar.li.init.InitPotionsEffect;
import com.we1nar.li.reference.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



@Mod.EventBusSubscriber
public class BloodPotion extends Potion
{
    private final ResourceLocation icon;
    public BloodPotion() {
        super(true,0xff0000);
        setRegistryName("li","bloodpotion");
        InitPotionsEffect.mpotion.add(this);
        setPotionName("effect.li.bloodpotion");
        this.icon = new ResourceLocation(Reference.MODID, "textures/potions/bloodpotion.png");
    }

    @SubscribeEvent
    public static void onEntityLivingTick(LivingEvent.LivingUpdateEvent event)
    {
        if (event.getEntityLiving() instanceof EntityLiving) {
            EntityLiving entity = (EntityLiving) event.getEntityLiving();
            if ((entity.getActivePotionEffect(InitPotionsEffect.bloodPotion)) != null) {
                if (entity.ticksExisted % 10 == 0) {
                       entity.attackEntityFrom(DamageSource.MAGIC, 1f+entity.getActivePotionEffect(InitPotionsEffect.bloodPotion).getAmplifier());
                }
            }
        }
    }
    @Override
    public boolean hasStatusIcon() {
        return false;
        }
    @SideOnly(Side.CLIENT)
    @Override
    public void renderInventoryEffect(int x, int y, PotionEffect potionEffect, Minecraft mc) {
        if (mc.currentScreen != null) {
            mc.getTextureManager().bindTexture(this.icon);
            Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
        }
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void renderHUDEffect(int x, int y, PotionEffect potionEffect, Minecraft mc, float alpha) {
        mc.getTextureManager().bindTexture(this.icon);
        Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
    }
    @SubscribeEvent
    public static void onEffect(PotionEvent.PotionAddedEvent event) {
        PotionEffect neweffect = event.getPotionEffect();
        PotionEffect oldeffect = event.getOldPotionEffect();
        if (oldeffect != null) {
            //Для твоей задачи нужно повысить уровень эффекта, а не понизить, поэтому модификация эффекта подойдет.
            oldeffect.combine(
                    new PotionEffect(
                            neweffect.getPotion(),
                            Math.max(oldeffect.getDuration(), neweffect.getDuration()),
                            oldeffect.getAmplifier() + neweffect.getAmplifier()));
        }
    }
}
