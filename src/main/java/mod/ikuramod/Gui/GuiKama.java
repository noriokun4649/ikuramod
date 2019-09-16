package mod.ikuramod.Gui;

import mod.ikuramod.Container.ContainerKama;
import mod.ikuramod.TileEntity.TileEntityKama;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;

public class GuiKama extends GuiContainer {
    private TileEntityKama tileEntity;
    private static final ResourceLocation GUITEXTURE = new ResourceLocation(MODID, "textures/gui/kama.png");

    public GuiKama(EntityPlayer player, TileEntityKama tileEnttiy) {
        super(new ContainerKama(player, tileEnttiy));
        this.tileEntity = tileEnttiy;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String kamado = "かまど(単体)";
        fontRenderer.drawString(kamado, this.xSize / 2 - fontRenderer.getStringWidth(kamado) / 2, 6, 4210752);
        fontRenderer.drawString("インベントリ", 8, this.ySize - 96 + 2, 4210752);
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
