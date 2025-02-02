package tallestred.piglinproliferation.common.blockentities;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import tallestred.piglinproliferation.PiglinProliferation;
import tallestred.piglinproliferation.common.blocks.PPBlocks;
import tallestred.piglinproliferation.common.blocks.PiglinSkullBlock;

public class PPBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PiglinProliferation.MODID);
    public static final RegistryObject<BlockEntityType<PiglinSkullBlockEntity>> PIGLIN_SKULL = BLOCK_ENTITIES.register("piglin_head", () -> BlockEntityType.Builder.of(PiglinSkullBlockEntity::new, PPBlocks.PIGLIN_BRUTE_HEAD.get(), PPBlocks.PIGLIN_BRUTE_HEAD_WALL.get(), PPBlocks.ZOMBIFIED_PIGLIN_HEAD.get(), PPBlocks.ZOMBIFIED_PIGLIN_HEAD_WALL.get(), PPBlocks.PIGLIN_ALCHEMIST_HEAD.get(), PPBlocks.PIGLIN_ALCHEMIST_HEAD_WALL.get(), PPBlocks.PIGLIN_TRAVELLER_HEAD.get(), PPBlocks.PIGLIN_TRAVELLER_HEAD_WALL.get()).build(null));
}
