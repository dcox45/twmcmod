package dev.dcox.twmod.init;

import dev.dcox.twmod.TwMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TwMod.MODID);

    public static final RegistryObject<Item> FIRST_ITEM =
              ITEMS.register("first_item", () -> new Item(new Item.Properties()));





    public static final RegistryObject<BlockItem> firstBlockItem =
            ITEMS.register("first_block", () -> new BlockItem(BlockInit.firstBlock.get(), new Item.Properties()));
}
