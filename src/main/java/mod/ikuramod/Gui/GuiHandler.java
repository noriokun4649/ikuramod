package mod.ikuramod.Gui;


import mod.ikuramod.Container.ContainerDai;
import mod.ikuramod.Container.ContainerKama;
import mod.ikuramod.Container.ContainerKamado;
import mod.ikuramod.Container.ContainerKonro;
import mod.ikuramod.TileEntity.TileEntityDai;
import mod.ikuramod.TileEntity.TileEntityKama;
import mod.ikuramod.TileEntity.TileEntityKamado;
import mod.ikuramod.TileEntity.TileEntityKonro;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (!world.isBlockLoaded(new BlockPos(x, y, z)))
            return null;
        TileEntity tileentity = world.getTileEntity(new BlockPos(x, y, z));
        if (tileentity instanceof TileEntityDai) {
            return new ContainerDai(player, (TileEntityDai) tileentity);
        }
        if (tileentity instanceof TileEntityKama) {
            return new ContainerKama(player, (TileEntityKama) tileentity);
        }
        if (tileentity instanceof TileEntityKamado) {
            return new ContainerKamado(player, (TileEntityKamado) tileentity);
        }
        if (tileentity instanceof TileEntityKonro) {
            return new ContainerKonro(player, (TileEntityKonro) tileentity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (!world.isBlockLoaded(new BlockPos(x, y, z)))
            return null;
        TileEntity tileentity = world.getTileEntity(new BlockPos(x, y, z));
        if (tileentity instanceof TileEntityDai) {
            return new GuiDai(player, (TileEntityDai) tileentity);
        }
        if (tileentity instanceof TileEntityKama) {
            return new GuiKama(player, (TileEntityKama) tileentity);
        }
        if (tileentity instanceof TileEntityKamado) {
            return new GuiKamado(player, (TileEntityKamado) tileentity);
        }
        if (tileentity instanceof TileEntityKonro) {
            return new GuiKonro(player, (TileEntityKonro) tileentity);
        }
        return null;
    }
}

