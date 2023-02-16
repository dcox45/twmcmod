package dev.dcox.twmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FuelRefiner extends Block {

    private static final VoxelShape SHAPE = makeShape();

    public FuelRefiner(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState blockstate, BlockGetter level, BlockPos blockpos, CollisionContext ctx) {
        return SHAPE;
    }

    public static VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 1, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.15625, 0.1875, -0.046875, 0.8125, 0.8125, 0), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.1875, 0.75, 0.375, 0, 0.8125, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.1875, 0.75, 0.375, -0.125, 1.125, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0, 0, 1, 1, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.1875, 0.75, 0.5, 0, 0.8125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.1875, 0.75, 0.5, -0.125, 1.125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.1875, 0.75, 0.625, 0, 0.8125, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.1875, 0.75, 0.625, -0.125, 1.125, 0.6875), BooleanOp.OR);

        return shape;
    }
}
