package com.maideniles.maidensmaterials.block.vase;


import com.maideniles.maidensmaterials.init.ModBlocks;
import com.maideniles.maidensmaterials.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;

import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockClayVaseMagenta extends Block {

    private static final VoxelShape SHAPE = Block.makeCuboidShape(4.8, 0, 4.8, 11.2, 6.0, 11.2);


    public BlockClayVaseMagenta(Properties properties) {
        super(Properties.create(Material.ROCK).hardnessAndResistance(2.5F).sound(SoundType.STONE));
        this.setDefaultState(this.getDefaultState());
    }



    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext selectionContext)
    {  return SHAPE;

    }

    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader reader, BlockPos pos)
    {
        return SHAPE;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack blossom = player.getHeldItem(handIn);

        if (!worldIn.isRemote()) {



            if (blossom.getItem() == ModItems.CRABAPPLE_BLOSSOMS.get()){

             //   System.out.println("RED FLOWER!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseRedFlower.get().getDefaultState());
            }

            if (blossom.getItem() == ModItems.POINCIANA_BLOSSOMS.get()){

             //   System.out.println("ORANGE FLOWER!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseOrangeFlower.get().getDefaultState());
            }

            if (blossom.getItem() == ModItems.LABURNUM_BLOSSOMS.get()){

             //   System.out.println("YELLOW FLOWER!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseYellowFlower.get().getDefaultState());
            }

            if (blossom.getItem() == ModItems.JADE_BLOSSOMS.get()){

           //     System.out.println("GREEN FLOWER!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseGreenFlower.get().getDefaultState());
            }

            if (blossom.getItem() == ModItems.PAULOWNIA_BLOSSOMS.get()){

            //    System.out.println("CYAN FLOWER!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseCyanFlower.get().getDefaultState());
            }

            if (blossom.getItem() == ModItems.WISTERIA_BLOSSOMS.get()){

            //    System.out.println("BLUE FLOWER!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseBlueFlower.get().getDefaultState());
            }

            if (blossom.getItem() == ModItems.JACARANDA_BLOSSOMS.get()){

            //    System.out.println("PURPLE FLOWER!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVasePurpleFlower.get().getDefaultState());
            }

            if (blossom.getItem() == ModItems.DOGWOOD_BLOSSOMS.get()){

            //    System.out.println("PINK FLOWER!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVasePinkFlower.get().getDefaultState());
            }

            if (blossom.getItem() == ModItems.SILVERBELL_BLOSSOMS.get()){

            //    System.out.println("WHITE FLOWER!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseWhiteFlower.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.crabappleSapling.get())){

            //    System.out.println("RED SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseRedSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.poincianaSapling.get())){

           //     System.out.println("ORANGE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseOrangeSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.laburnumSapling.get())){

           //     System.out.println("YELLOW SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseYellowSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.jadeSapling.get())){

           //     System.out.println("GREEN SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseGreenSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.paulowniaSapling.get())){

            //    System.out.println("CYAN SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseCyanSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.wisteriaSapling.get())){

            //    System.out.println("BLUE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseBlueSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.jacarandaSapling.get())){

           //     System.out.println("PURPLE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVasePurpleSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.dogwoodSapling.get())){

           //     System.out.println("PINK SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVasePinkSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.silverbellSapling.get())){

          //      System.out.println("WHITE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.MagentaVaseWhiteSapling.get().getDefaultState());
            }
            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.appleSapling.get())){

           //     System.out.println("APPLE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.magentaVaseAppleSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.pearSapling.get())){

          //      System.out.println("APPLE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.magentaVasePearSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.peachSapling.get())){

          //      System.out.println("APPLE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.magentaVasePeachSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.plumSapling.get())){

           //     System.out.println("APPLE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.magentaVasePlumSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.orangeSapling.get())){

           //    System.out.println("APPLE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.magentaVaseOrangeFruitSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.grapefruitSapling.get())){

            //    System.out.println("APPLE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.magentaVaseGrapeFruitSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.lemonSapling.get())){

           //     System.out.println("APPLE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.magentaVaseLemonSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.limeSapling.get())){

           //     System.out.println("APPLE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.magentaVaseLimeFruitSapling.get().getDefaultState());
            }

            if (blossom.getItem() == Item.getItemFromBlock(ModBlocks.cherrySapling.get())){

           //     System.out.println("APPLE SAPLING!");
                worldIn.setBlockState(pos, ModBlocks.magentaVaseCherrySapling.get().getDefaultState());
            }

        }




        return ActionResultType.SUCCESS;
    }



}


