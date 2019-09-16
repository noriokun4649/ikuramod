package mod.ikuramod.Blocks;


import mod.ikuramod.TileEntity.TileEntityKama;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

import static mod.ikuramod.IkuraMod.MODID;
import static mod.ikuramod.IkuraMod.instance;

public class BlockKama extends BaseMukiBlock implements ITileEntityProvider {
    private static boolean keepInventory = false;
    public static final AxisAlignedBB KAMA_BLOCK_AABB = new AxisAlignedBB(0D, 0D, 0D, 1D, 0.75D, 1D);

    public BlockKama(Material materialIn) {
        super(materialIn);
        this.setUnlocalizedName("block_kama");
        this.setRegistryName(new ResourceLocation(MODID, "block_kama"));
    }

    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double r = 0.4D + rand.nextDouble();
        double t = rand.nextDouble() * Math.PI;
        double d0 = pos.getX() + 0.5D + r * Math.sin(t);
        double d1 = pos.getY() + 1.0D + rand.nextDouble();
        double d2 = pos.getZ() + 0.5D + r * Math.cos(t);
        double d3 = Math.sin(t) / 64.0D;
        double d4 = 0.03D;
        double d5 = Math.cos(t) / 64.0D;
        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0, d1, d2, d3, d4, d5);
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_) {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, KAMA_BLOCK_AABB);
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if (!keepInventory) {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityKama) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityKama) tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return KAMA_BLOCK_AABB;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        playerIn.openGui(instance, 3, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityKama();
    }
}
