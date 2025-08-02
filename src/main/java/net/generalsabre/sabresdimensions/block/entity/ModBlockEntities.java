package net.generalsabre.sabresdimensions.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.generalsabre.sabresdimensions.block.ModBlocks;
import net.generalsabre.sabresdimensions.block.entity.custom.AlloyFurnaceBlockEntity;
import net.generalsabre.sabresdimensions.block.entity.custom.CrusherBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.BlockEntityType.Builder;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<AlloyFurnaceBlockEntity> ALLOY_FURNACE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(SabresDimensions.MOD_ID,"alloy_furnace_be"),
                    BlockEntityType.Builder.create(AlloyFurnaceBlockEntity::new, ModBlocks.ALLOY_FURNACE).build(null));
    public static final BlockEntityType<CrusherBlockEntity> CRUSHER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(SabresDimensions.MOD_ID, "crusher_be"),
                    BlockEntityType.Builder.create(CrusherBlockEntity::new, ModBlocks.CRUSHER).build(null));


    public static void registerBlockEntities(){
        SabresDimensions.LOGGER.info("Registering Mod Block Entities for " + SabresDimensions.MOD_ID);
    }

}
