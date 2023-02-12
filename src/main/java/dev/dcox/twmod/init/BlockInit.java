package dev.dcox.twmod.init;

import com.mojang.datafixers.types.templates.Tag;
import dev.dcox.twmod.TwMod;
import dev.dcox.twmod.blocks.FirestoneBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TwMod.MODID);

    public static final RegistryObject<Block> firstBlock =
            register("first_block", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).friction(
                    0.4f).strength(5.0f, 6.0f).requiresCorrectToolForDrops()), new Item.Properties());

    public static final RegistryObject<Block> FIRESTONE_ORE =
            register("firestone_ore", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(
                    3.0f, 3.0f).requiresCorrectToolForDrops()), new Item.Properties());

    public static final RegistryObject<Block> HAZARDOUS_WASTE =
            register("hazwas_animated", () -> new Block(BlockBehaviour.Properties.of(Material.DIRT).strength(
                    2.0f, 3.0f)), new Item.Properties());

    public static final RegistryObject<FirestoneBlock> FIRESTONE_BLOCK =
            register("firestone_block", () -> new FirestoneBlock(BlockBehaviour.Properties.of(Material.AMETHYST).strength(
                    2.0f, 3.0f)), new Item.Properties());

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties ){
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }

    public static class Tags {
        public static final TagKey<Block> needs_firestone_tool = create("mineable/needs_firestone_tool");
        //public static final TagKey<Item> item_tag = ItemTags.create(new ResourceLocation("item_tag"));

        private static TagKey<Block> create(String location){
            return BlockTags.create(new ResourceLocation(TwMod.MODID, location));
        }

        //tw shows other tag create functions in vid
    }
}
