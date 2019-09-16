package mod.ikuramod.Blocks;


import mod.ikuramod.TileEntity.TileEntityKamado;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

import static mod.ikuramod.IkuraMod.instance;

public class BlockKamado extends BaseMukiBlock implements ITileEntityProvider {
    private final boolean isBurning;
    private static boolean keepInventory = false;

    public BlockKamado(boolean isBurning) {
        super(Material.ROCK);
        this.setUnlocalizedName("block_kamado");
        this.isBurning = isBurning;
    }

    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (isBurning) {
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
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        playerIn.openGui(instance, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        if (!keepInventory) {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityKamado) {
                InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityKamado) tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }
        super.breakBlock(worldIn, pos, state);
    }


    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityKamado();
    }
}
