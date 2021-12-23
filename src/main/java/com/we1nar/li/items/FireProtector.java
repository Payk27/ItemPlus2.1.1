package com.we1nar.li.items;

import com.we1nar.li.init.InitItems;
import com.we1nar.li.main.Main;
import com.we1nar.li.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



@Mod.EventBusSubscriber
public class FireProtector extends Item implements IHasModel {
    public FireProtector() {
        this.setRegistryName("fireprotector");
        this.setUnlocalizedName("fireprotector");
        setCreativeTab(CreativeTabs.COMBAT);
        maxStackSize = 1;
        InitItems.ITEMS.add(this);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        pos = pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);
        hitX = pos.getX();
        hitY = pos.getY();
        hitZ = pos.getZ();
        if (!worldIn.isRemote)
            worldIn.createExplosion(player, hitX, hitY, hitZ, 3, true);
        return null;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }

    @SubscribeEvent
    public static void InMainHand(LivingEvent.LivingUpdateEvent event) {
        EntityLivingBase entityLivingBase = event.getEntityLiving();
        int x = event.getEntityLiving().getPosition().getX();
        int y = event.getEntityLiving().getPosition().getY();
        int z = event.getEntityLiving().getPosition().getZ();
        AxisAlignedBB axisAlignedBB = new AxisAlignedBB(x - 5, y - 20, z - 5, x + 5, y + 20, z + 5);
        if (entityLivingBase.getHeldItemMainhand().getItem() == InitItems.Fire_Protector) {
            for (Entity entity : entityLivingBase.world.getEntitiesWithinAABBExcludingEntity(entityLivingBase, axisAlignedBB)) {
                entity.motionY+=0.07;
            }
        }
    }
}
