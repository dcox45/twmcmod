package dev.dcox.twmod.init;

import dev.dcox.twmod.TwMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TwMod.MODID);

    public static final RegistryObject<Block> firstBlock =
            BLOCKS.register("first_block", () -> new Block(BlockBehaviour.Properties.of(Material.BAMBOO).friction(0.1f)));
}
