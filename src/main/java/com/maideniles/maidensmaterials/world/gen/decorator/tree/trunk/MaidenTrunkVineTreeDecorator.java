package com.maideniles.maidensmaterials.world.gen.decorator.tree.trunk;

import com.google.common.collect.ImmutableMap;
import com.maideniles.maidensmaterials.init.ModBlocks;
import com.maideniles.maidensmaterials.world.gen.decorator.tree.MaidensTreeDecoratorTypes;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.treedecorator.TreeDecorator;

public class MaidenTrunkVineTreeDecorator extends TreeDecorator {


    public MaidenTrunkVineTreeDecorator() {
        super(MaidensTreeDecoratorTypes.MAIDENS_TRUNK_VINE);

    }

    public <T> MaidenTrunkVineTreeDecorator(Dynamic<T> dynamic) {

        this();
    }




    public void func_225576_a_(IWorld p_225576_1_, Random p_225576_2_, List<BlockPos> p_225576_3_, List<BlockPos> p_225576_4_, Set<BlockPos> p_225576_5_, MutableBoundingBox p_225576_6_) {
        p_225576_3_.forEach((p_227433_5_) -> {

            Block vine = Blocks.VINE;
            if (!p_225576_3_.isEmpty())  {
                Block log = p_225576_1_.getBlockState(p_225576_3_.get(0)).getBlock();
                if (log == ModBlocks.crabappleLog.get()) {
                    vine = ModBlocks.crabappleVine.get();
                }
                if( log == ModBlocks.poincianaLog.get()) {
                    vine = ModBlocks.poincianaVine.get();
                }
                if( log == ModBlocks.laburnumLog.get()) {
                    vine = ModBlocks.laburnumVine.get();
                }
                if( log == ModBlocks.jadeLog.get()) {
                    vine = ModBlocks.jadeVine.get();
                }
                if( log == ModBlocks.paulowniaLog.get()) {
                    vine = ModBlocks.paulowniaVine.get();
                }
                if( log == ModBlocks.wisteriaLog.get()) {
                    vine = ModBlocks.wisteriaVine.get();
                }
                if( log == ModBlocks.jacarandaLog.get()) {
                    vine = ModBlocks.jacarandaVine.get();
                }
                if( log == ModBlocks.dogwoodLog.get()) {
                    vine = ModBlocks.dogwoodVine.get();
                }
                if( log == ModBlocks.silverbellLog.get()) {
                    vine = ModBlocks.silverbellVine.get();
                }
                if( log == ModBlocks.cedarLog.get()) {
                    vine = ModBlocks.cedarVine.get();
                }

            }


            if (p_225576_2_.nextInt(3) > 0) {
                BlockPos blockpos = p_227433_5_.west();
                if (AbstractTreeFeature.isAir(p_225576_1_, blockpos)) {
                    this.placeVine(p_225576_1_, blockpos, VineBlock.EAST, p_225576_5_, p_225576_6_,vine);
                }
            }

            if (p_225576_2_.nextInt(3) > 0) {
                BlockPos blockpos1 = p_227433_5_.east();
                if (AbstractTreeFeature.isAir(p_225576_1_, blockpos1)) {
                    this.placeVine(p_225576_1_, blockpos1, VineBlock.WEST, p_225576_5_, p_225576_6_,vine);
                }
            }

            if (p_225576_2_.nextInt(3) > 0) {
                BlockPos blockpos2 = p_227433_5_.north();
                if (AbstractTreeFeature.isAir(p_225576_1_, blockpos2)) {
                    this.placeVine(p_225576_1_, blockpos2, VineBlock.SOUTH, p_225576_5_, p_225576_6_,vine);
                }
            }

            if (p_225576_2_.nextInt(3) > 0) {
                BlockPos blockpos3 = p_227433_5_.south();
                if (AbstractTreeFeature.isAir(p_225576_1_, blockpos3)) {
                    this.placeVine(p_225576_1_, blockpos3, VineBlock.NORTH, p_225576_5_, p_225576_6_, vine);
                }
            }

        });
    }

    private void placeVine(IWorld iWorld, BlockPos blockpos3, BooleanProperty north, Set<BlockPos> posSet, MutableBoundingBox box, Block vine) {

        this.func_227423_a_(iWorld, blockpos3, vine.getDefaultState().with(north, Boolean.valueOf(true)), posSet, box);
    }


    public <T> T serialize(DynamicOps<T> p_218175_1_) {
        return (new Dynamic<>(p_218175_1_, p_218175_1_.createMap(ImmutableMap.of(p_218175_1_.createString("type"), p_218175_1_.createString(Registry.TREE_DECORATOR_TYPE.getKey(this.field_227422_a_).toString()))))).getValue();
    }

   }
