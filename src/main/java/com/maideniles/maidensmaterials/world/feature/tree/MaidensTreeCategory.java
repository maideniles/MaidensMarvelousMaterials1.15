package com.maideniles.maidensmaterials.world.feature.tree;

import com.google.common.collect.ImmutableList;


import com.maideniles.maidensmaterials.world.gen.decorator.tree.leaf.MaidenLeavesVineTreeDecorator;
import com.maideniles.maidensmaterials.world.gen.decorator.tree.mushroom.MushroomTreeDecorator;
import com.maideniles.maidensmaterials.world.gen.decorator.tree.trunk.MaidenTrunkVineTreeDecorator;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredRandomFeatureList;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraftforge.common.IPlantable;

public class MaidensTreeCategory {


    public MaidensTreeCategory(Feature<TreeFeatureConfig> feature, BlockState trunk, BlockState leaves, int baseHeight, int maxHeight, float treesPerChunk, boolean vinesInWorldgen, IPlantable sapling) {
        // Create base configuration
        TreeFeatureConfig.Builder configBuilder = new TreeFeatureConfig.Builder(
                new SimpleBlockStateProvider(trunk),
                new SimpleBlockStateProvider(leaves),
                new BlobFoliagePlacer(2, 0))
                .baseHeight(baseHeight)
                .heightRandA(maxHeight - baseHeight)
                .foliageHeight(3)
                .ignoreVines()
                .decorators(ImmutableList.of(new BeehiveTreeDecorator(0.01f)))
                .setSapling(sapling);


        // Create configured feature with these settings
        this.base = feature.withConfiguration(configBuilder.build());

        // Add vines to the settings then use these modified settings to create a version with vines
        this.vines = feature.withConfiguration(configBuilder
                .decorators(ImmutableList.of(new MushroomTreeDecorator(0.25f), new BeehiveTreeDecorator(0.01f), new MaidenTrunkVineTreeDecorator(), new MaidenLeavesVineTreeDecorator()))
                .build());

        int baseTreesPerChunk = MathHelper.floor(treesPerChunk);



        this.mushrooms = feature.withConfiguration(configBuilder
                .decorators(ImmutableList.of(new MushroomTreeDecorator(0.25f)))
                .build());
        // If VinesInWorldgen == true, Alternate between base version and vines version in the world gen placer
        // (uses a ternary expression instead of an if statement)
        this.worldgen = (vinesInWorldgen ?
                Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(
                        ImmutableList.of(new ConfiguredRandomFeatureList<>(this.vines, 0.5f)), // This specifies to replace the base tree with vines tree 50% of the time
                        this.base
                ))
                : this.base)
                .withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(baseTreesPerChunk, treesPerChunk - baseTreesPerChunk, 1)));
    }


    public final ConfiguredFeature<TreeFeatureConfig, ?> mushrooms;
    public final ConfiguredFeature<TreeFeatureConfig, ?> base;
    public final ConfiguredFeature<TreeFeatureConfig, ?> vines;
    public final ConfiguredFeature<?, ?> worldgen;
}
