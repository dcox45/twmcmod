package dev.dcox.twmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.HalfTransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class FirestoneBlock extends Block {
    public FirestoneBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public void stepOn(Level p_153777_, BlockPos p_153778_, BlockState p_153779_, Entity p_153780_) {
        if (!p_153780_.isSteppingCarefully() && p_153780_ instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity)p_153780_)) {
            p_153780_.hurt(DamageSource.HOT_FLOOR, 1.0F);
        }

        super.stepOn(p_153777_, p_153778_, p_153779_, p_153780_);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isClientSide) {

            fireUpBlocks(level, pos);
        }
    }

    private static void fireUpBlocks(ServerLevel level, BlockPos pos) {
        int radius = 1;

        while (radius < 10) {
            for (Direction direction : Direction.values()) {
                BlockPos newPos = pos.relative(direction, radius);
                BlockState blockstate = level.getBlockState(newPos);
                if (blockstate.getBlock().isFlammable(blockstate, level, newPos, direction)) {
                    level.setBlockAndUpdate(newPos, BaseFireBlock.getState(level, newPos));

                }

            }
            ++radius;
        }

    }

    private static BlockPos randomPointOnSphere(BlockPos start, float radius, RandomSource random) {
        double u = random.nextDouble();
        double v = random.nextDouble();
        double theta = 2 * Math.PI * u;
        double phi = Math.acos(2 * v - 1);
        double x = radius * Math.sin(phi) * Math.cos(theta);
        double y = radius * Math.sin(phi) * Math.sin(theta);
        double z = radius * Math.cos(phi);
        return start.offset(x, y, z);
    }
}
