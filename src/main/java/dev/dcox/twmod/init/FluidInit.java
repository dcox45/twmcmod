package dev.dcox.twmod.init;

import dev.dcox.twmod.TwMod;
import dev.dcox.twmod.base.FluidRegistryContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TwMod.MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, TwMod.MODID);

    public static final FluidRegistryContainer NAPALM = new FluidRegistryContainer(
            "napalm_fluid",
            FluidType.Properties.create().canSwim(true).canDrown(true).canPushEntity(true).supportsBoating(true).viscosity(3),
            () -> FluidRegistryContainer.createExtension(
                    new FluidRegistryContainer.ClientExtensions(
                            TwMod.MODID,
                            "napalm_fluid"
                    ).tint(0x26050e)
                            .fogColor(105f, 54f, 68f)
            ), new FluidRegistryContainer.AdditionalProperties().slopeFindDistance(4),
            BlockBehaviour.Properties.copy(Blocks.LAVA),
            new Item.Properties().stacksTo(1)
    );
}
