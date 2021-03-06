package com.maideniles.maidensmaterials.world.feature.tree;

import java.util.Random;
import java.util.Set;

import com.maideniles.maidensmaterials.init.ModBlocks;

import net.minecraft.block.Blocks;
import net.minecraft.block.CocoaBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class PalmTreeFeature extends MaidensTreeFeature {
    public PalmTreeFeature() {
        super(ModBlocks.sparklingSand.get());
    }

    @Override
    public boolean place(IWorldGenerationReader world, Random rand, BlockPos pos,
            Set<BlockPos> logs, Set<BlockPos> leaves, MutableBoundingBox box,
            TreeFeatureConfig config) {
        // Setting the height of the tree
        int height = config.baseHeight + rand.nextInt(config.heightRandA);
        int i = rand.nextInt(3) + 10;

        // This tests/checks if the tree is able to grow, if not then we exit
        if (!this.ensureGrowable(world, pos, height, config)) {
            return false;
        } else {

            // Sets the leaf type for the tree
            //  this.SetLeafType(world, pos, rand);

            // Sets the direction the tree may sway
            Direction direction = Direction.Plane.HORIZONTAL.random(rand);
            int xPos = pos.getX();
            int zPos = pos.getZ();
            int top = 0;

            // Generate the trunk of the tree
            for (int block = 0; block <= height; block++) {
                int yPos = pos.getY() + block;

                // Move the logs to make the tree sway in a certain direction
                if (yPos > pos.getY() && yPos <= (pos.getY() + (height - 3))) {
                    if (rand.nextInt(10) == 1) {
                        xPos += direction.getXOffset();
                        zPos += direction.getZOffset();
                    }
                }

                BlockPos blockpos = new BlockPos(xPos, yPos, zPos);

                if (isAirOrLeaves(world, blockpos)) {
                    this.placeLogAt(logs, world, blockpos, box, rand, config);
                    top = yPos;
                }


            }

            BlockPos topBlock = new BlockPos(xPos, top, zPos);
            this.placeLeafAt(leaves, world, topBlock.add(0, 1, 0), box, rand, config);

            // Generate the leaves at the top of the tree
            for (Direction side : Direction.Plane.HORIZONTAL) {
                leafLayer1(logs, leaves, world, topBlock, rand, side, box, config);

            }
        }

        return true;
    }

    // Generate the lowest leaf layer where the crops will grow
    private void leafLayer1 (Set <BlockPos> logs, Set<BlockPos> leaves, IWorldGenerationReader worldIn, BlockPos pos, Random random, Direction
            side, MutableBoundingBox box, TreeFeatureConfig config)
    {
        //Change k, i, or j to offset the structure
        int k = -5;
        int i = -4;
        int j = -6;



        this.setBlockState(worldIn, pos.add(i + 4, j + 7, k + 5), ModBlocks.palmLog.get().getDefaultState());

        this.setBlockState(worldIn, pos.add(i + 5, j + 8, k + 5), ModBlocks.palmLog.get().getDefaultState());



        this.setBlockState(worldIn, pos.add(i + 1, j + 6, k + 2), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 1, j + 6, k + 8), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 1, j + 7, k + 2), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 1, j + 7, k + 8), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 1, j + 8, k + 2), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 1, j + 9, k + 5), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 2, j + 8, k + 5), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 2, j + 8, k + 7), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 2, j + 9, k + 3), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 2, j + 9, k + 5), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 3, j + 7, k + 4), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 3, j + 7, k + 6), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 3, j + 8, k + 4), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 3, j + 8, k + 5), config.trunkProvider, config, logs, box, random);
        this.setBlockState(worldIn, pos.add(i + 3, j + 8, k + 6), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 3, j + 9, k + 4), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 3, j + 9, k + 5), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 3, j + 9, k + 6), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 3, j + 10, k + 4), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 3, j + 10, k + 6), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 4, j + 5, k + 0), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 4, j + 5, k + 10), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 6, k + 0), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 4, j + 6, k + 10), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 4, j + 7, k + 1), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 4, j + 7, k + 5), config.trunkProvider, config, logs, box, random);


        if(random.nextInt(10) == 0) {

            this.setBlockState(worldIn, pos.add(i + 3, j + 7, k + 5), ModBlocks.coconutNut.get().getDefaultState());
        }
        if(random.nextInt(10) == 0) {

            this.setBlockState(worldIn, pos.add(i + 4, j + 7, k + 4), ModBlocks.coconutNut.get().getDefaultState());
        }

        if(random.nextInt(10) == 0) {
            this.setBlockState(worldIn, pos.add(i + 5, j + 7, k + 5),ModBlocks.coconutNut.get().getDefaultState());
        }

        if(random.nextInt(10) == 0){

            this.setBlockState( worldIn, pos.add(i+4, j+7, k+6), ModBlocks.coconutNut.get().getDefaultState());

        }

        this.setBlockState(worldIn, pos.add(i + 4, j + 7, k + 9), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 4, j + 8, k + 1), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 4, j + 8, k + 3), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 8, k + 4), config.trunkProvider, config, logs, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 8, k + 5), config.trunkProvider, config, logs, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 8, k + 6), config.trunkProvider, config, logs, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 8, k + 7), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 4, j + 8, k + 9), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 4, j + 9, k + 2), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 9, k + 3), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 9, k + 4), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 9, k + 5), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 9, k + 6), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 9, k + 7), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 4, j + 9, k + 8), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 4, j + 10, k + 5), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 5, j + 7, k + 4), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 5, j + 7, k + 6), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 5, j + 8, k + 4), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 5, j + 8, k + 5), config.trunkProvider, config, logs, box, random);
        this.setBlockState(worldIn, pos.add(i + 5, j + 8, k + 6), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 5, j + 9, k + 4), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 5, j + 9, k + 5), config.leavesProvider, config, leaves, box, random);
        this.setBlockState(worldIn, pos.add(i + 5, j + 9, k + 6), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 5, j + 10, k + 4), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 5, j + 10, k + 6), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 6, j + 8, k + 3), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 6, j + 8, k + 5), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 6, j + 9, k + 5), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 6, j + 9, k + 7), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 7, j + 6, k + 2), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 7, j + 6, k + 8), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 7, j + 7, k + 2), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 7, j + 7, k + 8), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 7, j + 8, k + 8), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 7, j + 9, k + 5), config.leavesProvider, config, leaves, box, random);



        this.setBlockState(worldIn, pos.add(i + 8, j + 7, k + 5), config.leavesProvider, config, leaves, box, random);

        this.setBlockState(worldIn, pos.add(i + 8, j + 8, k + 5), config.leavesProvider, config, leaves, box, random);
    }

    // Hacky Method to make porting it easier. Preferably use loops.
    private void setBlockState(IWorldGenerationReader world, BlockPos pos, BlockStateProvider stateProvider, TreeFeatureConfig config, Set<BlockPos> changedBlocks, MutableBoundingBox box, Random rand) {
        if (stateProvider == config.leavesProvider) {
            this.placeLeafAt(changedBlocks, world, pos, box, rand, config);
        } else {
            this.placeLogAt(changedBlocks, world, pos, box, rand, config);
        }
    }

    // Just as the title says, this sets a log block in the world
    private void placeLogAt (Set<BlockPos> logs, IWorldGenerationReader world, BlockPos pos, MutableBoundingBox
            box, Random rand, TreeFeatureConfig config)
    {
        this.func_227216_a_(world, rand, pos, logs, box, config);
    }

    // Just as the title says, this sets a leaf block in the world
    private void placeLeafAt (Set<BlockPos> leaves, IWorldGenerationReader world, BlockPos pos, MutableBoundingBox box, Random rand, TreeFeatureConfig config)
    {
        if (isAirOrLeaves(world, pos)) {
            this.func_227219_b_(world, rand, pos, leaves, box, config);
        }
    }

    // To test if the tree can grow we first check if there is available space and then if the blocks underneath can sustain our tree
    protected boolean ensureGrowable (IWorldGenerationReader worldIn, BlockPos treePos, int height, TreeFeatureConfig config)
    {
        return this.isSpaceAt(worldIn, treePos, height) && this.ensureViableBlockUnderneath(treePos, worldIn, config);
    }

    // Check if there is space for the tree to grow
    private boolean isSpaceAt (IWorldGenerationReader worldIn, BlockPos pos,int height)
    {
        boolean flag = true;
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        // Obviously we don't want the tree to grow in the void or above the build limit
        if (y >= 1 && y + height + 1 <= 256) {

            // Extra math in case our tree is taller than expected
            for (int yPos = y; yPos <= y + 1 + height; yPos++) {
                int b0 = 1;
                if (yPos == y) b0 = 0;
                if (yPos >= y + 1 + height - 2) b0 = 2;

                // Use mutable blocks to test if the location is available
                BlockPos.Mutable mutable = new BlockPos.Mutable();


                // We check each position for future blocks
                for (int xPos = x - b0; xPos <= x + b0 && flag; xPos++) {
                    for (int zPos = z - b0; zPos <= z + b0 && flag; zPos++) {
                        if (yPos >= 0 && yPos < 256) {

                            // We check if our future blocks can be placed in their respective location
                            if (!AbstractTreeFeature.canBeReplacedByLogs(worldIn, mutable.setPos(xPos, yPos, zPos))) {

                                // If a block is in the way we immediately exit the function and return false (ie: tree will not grow)
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            return flag;
        }

        //Tree was either in void or above build limit
        else {
            return false;
        }
    }

    // Check if the tree can generate on the block underneath
    private boolean ensureViableBlockUnderneath (BlockPos pos, IWorldGenerationReader worldIn, TreeFeatureConfig config)
    {
        // If the block underneath is considered to be a dirt or sand variant then we allow the tree to generate
        if ((isSoil(worldIn, pos.down(), config.getSapling()) || worldIn.hasBlockState(pos.down(), (state) -> state.isIn(BlockTags.SAND)))) {
            // I don't want to set sand to dirt
            if (isSoil(worldIn, pos.down(), config.getSapling())) {
                this.setDirtAt(worldIn, pos.down(), pos);
            }
            return true;
        } else {
            return false;
        }
    }

    private void placeCocoa(IWorldGenerationReader worldIn, int age, BlockPos pos, Direction side) {
        this.setBlockState(worldIn, pos, ModBlocks.coconutNut.get().getDefaultState().with(CocoaBlock.AGE, Integer.valueOf(age)).with(CocoaBlock.HORIZONTAL_FACING, side));
    }
}
