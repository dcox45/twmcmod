package dev.dcox.twmod.entities;

import dev.dcox.twmod.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.animal.frog.FrogAi;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Firesnake extends Animal {
    public Firesnake(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
         Firesnake firesnake = EntityInit.FIRESNAKE.get().create(level);
        if (firesnake != null) {
            return firesnake;
        } else {
            return null;
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));

        this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.1D));

        this.goalSelector.addGoal(3, new PanicGoal(this, 1.25D));

    }

    public static AttributeSupplier.Builder getFiresnakeAttributes() {

        return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE);

    }

    public static boolean canSpawn(EntityType<Firesnake> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random){
       return  checkAnimalSpawnRules(entityType, level, spawnType, pos, random)
               //&& level.getBlockState(pos).is(Tags.Blocks.NETHERRACK);
        ;
       // ^ can add spawn conditions as an && here
    }

}
