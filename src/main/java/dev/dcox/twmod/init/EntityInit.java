package dev.dcox.twmod.init;

import dev.dcox.twmod.TwMod;
import dev.dcox.twmod.entities.Firesnake;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TwMod.MODID);
    public static final RegistryObject<EntityType<Firesnake>> FIRESNAKE =
            ENTITIES.register("firesnake", () -> EntityType.Builder.of(
                    Firesnake::new, MobCategory.CREATURE)
                    .fireImmune()
                    .immuneTo(Blocks.LAVA)
                    .sized(1, 1)
                    .build(TwMod.MODID + ":firesnake")
            );
}
