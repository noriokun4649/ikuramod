package mod.ikuramod.Gui;

import mod.ikuramod.Container.ContainerKonro;
import mod.ikuramod.TileEntity.TileEntityKonro;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

import static mod.ikuramod.IkuraMod.MODID;

public class GuiKonro extends GuiContainer {
    private TileEntityKonro tileEntity;
    private static final ResourceLocation GUITEXTURE = new ResourceLocation(MODID, "textures/gui/konro.png");

    public GuiKonro(EntityPlayer player, TileEntityKonro tileEnttiy) {
        super(new ContainerKonro(player, tileEnttiy));
        this.tileEntity = tileEnttiy;
        this.ySize = 108;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        int k = (width - xSize) / 2;
        int l = (height - ySize) / 2;
        if (button.id == 1) {
            this.drawTexturedModalRect(k + 45, l + 20, 0, 109, 84, 48);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String kamado = "コンロ";
        fontRenderer.drawString(kamado, this.xSize / 2 - fontRenderer.getStringWidth(kamado) / 2, 6, 4210752);
    }

    @Override
    public void initGui() {
        int k = (width - xSize) / 2;
        int l = (height - ySize) / 2;
        this.buttonList.add(new GuiButton(1, k + 60, l + 70, 60, 20, "コンロをON"));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(GUITEXTURE);
        int k = (width - xSize) / 2;
        int l = (height - ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
    }
}
