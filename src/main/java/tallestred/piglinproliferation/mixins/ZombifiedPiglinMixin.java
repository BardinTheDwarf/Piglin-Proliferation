package tallestred.piglinproliferation.mixins;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import tallestred.piglinproliferation.PPEvents;
import tallestred.piglinproliferation.capablities.TransformationSourceListener;

import java.util.UUID;

@Mixin(ZombifiedPiglin.class)
public abstract class ZombifiedPiglinMixin extends Zombie {
    @Shadow
    @javax.annotation.Nullable
    private UUID persistentAngerTarget;

    public ZombifiedPiglinMixin(Level p_34274_) {
        super(p_34274_);
    }


    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_34297_, DifficultyInstance p_34298_, MobSpawnType p_34299_, @Nullable SpawnGroupData p_34300_, @Nullable CompoundTag p_34301_) {
        SpawnGroupData dataGroup = super.finalizeSpawn(p_34297_, p_34298_, p_34299_, p_34300_, p_34301_);
        RandomSource randomSource = level.getRandom();
        TransformationSourceListener tSource = PPEvents.getTransformationSourceListener(this);
        if (p_34299_ != MobSpawnType.CONVERSION) {
            tSource.setTransformationSource("piglin");
            float bruteChance = 0.015F;
            if (randomSource.nextFloat() < bruteChance) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_AXE));
                tSource.setTransformationSource("piglin_brute");
                if (ModList.get().isLoaded("bigbrain")) {
                    Item buckler = ForgeRegistries.ITEMS.getValue(new ResourceLocation("bigbrain:buckler"));
                    this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(buckler));
                }
            }
            if (randomSource.nextFloat() < 0.10F) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
                tSource.setTransformationSource("piglin_alchemist");
            }
        }
        return dataGroup;
    }
}
