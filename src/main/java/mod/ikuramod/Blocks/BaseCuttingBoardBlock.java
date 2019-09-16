package mod.ikuramod.Blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BaseCuttingBoardBlock extends BaseMukiBlock {
    public static final AxisAlignedBB MANAITA_BLOCK_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.1875D, 0.9375D, 0.0625D, 0.8125D);
    public static final AxisAlignedBB MANAITA_BLOCK_AABB2 = new AxisAlignedBB(0.1875D, 0.0D, 0.0625D, 0.8125D, 0.0625D, 0.9375D);

    public BaseCuttingBoardBlock(Material materialIn) {
        super(materialIn);
        this.setHardness(1.5F);
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
        switch (state.getValue(FACING)) {
            case NORTH:
            default:
                addCollisionBoxToList(pos, entityBox, collidingBoxes, MANAITA_BLOCK_AABB);
                break;
            case SOUTH:
                addCollisionBoxToList(pos, entityBox, collidingBoxes, MANAITA_BLOCK_AABB);
                break;
            case WEST:
                addCollisionBoxToList(pos, entityBox, collidingBoxes, MANAITA_BLOCK_AABB2);
                break;
            case EAST:
                addCollisionBoxToList(pos, entityBox, collidingBoxes, MANAITA_BLOCK_AABB2);
                break;
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

        switch (state.getValue(FACING)) {
            case NORTH:
            default:
                return MANAITA_BLOCK_AABB;
            case SOUTH:
                return MANAITA_BLOCK_AABB;
            case WEST:
                return MANAITA_BLOCK_AABB2;
            case EAST:
                return MANAITA_BLOCK_AABB2;
        }
    }

}
