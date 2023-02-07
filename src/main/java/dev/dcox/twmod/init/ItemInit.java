package dev.dcox.twmod.init;

import dev.dcox.twmod.TwMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
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


    public static final RegistryObject<Item> first_food =
            ITEMS.register("first_food", () -> new Item(new Item.Properties().food(Foods.first_food)));

    public static class Foods {
        public static final FoodProperties first_food =
                new FoodProperties.Builder()
                        .nutrition(4)
                        .saturationMod(0.3f)
                        .alwaysEat()
                        .meat()
                        .fast()
                        .effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600),
                                0.9f).build();
    }
}
