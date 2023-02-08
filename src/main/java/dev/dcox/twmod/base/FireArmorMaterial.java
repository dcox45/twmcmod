package dev.dcox.twmod.base;

import dev.dcox.twmod.TwMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public record FireArmorMaterial(String name, int durability, int[] protection, int enchantability,
                                SoundEvent equipSound, float toughness, float knockbackResistance,
                                Supplier<Ingredient> repairMat) implements ArmorMaterial {

    private static final int[] durabilityPerSlot = new int[] {13, 15, 16, 11};
    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return durabilityPerSlot[slot.getIndex()] * this. durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.protection[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairMat.get();
    }

    @Override
    public @NotNull String getName() {
        return TwMod.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness();
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}