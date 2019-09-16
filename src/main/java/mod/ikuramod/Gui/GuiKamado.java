package mod.ikuramod.Gui;

import mod.ikuramod.Container.ContainerKamado;
import mod.ikuramod.TileEntity.TileEntityKamado;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;

public class GuiKamado extends GuiContainer {
    private TileEntityKamado tileEntity;
    private static final ResourceLocation GUITEXTURE = new ResourceLocation(MODID, "textures/gui/kamado.png");

    public GuiKamado(EntityPlayer player, TileEntityKamado tileEnttiy) {
        super(new ContainerKamado(player, tileEnttiy));
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
        String kamado = "かまど";
        fontRenderer.drawString(kamado, this.xSize / 2 - fontRenderer.getStringWidth(kamado) / 2, 6, 4210752);
        fontRenderer.drawString("インベントリ", 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(GUITEXTURE);
        int i = (width - xSize) / 2;
        int j = (height - ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, xSize, ySize);

        //if (TileEntityFurnace.isBurning(this.tileFurnace)){
        int k = this.getBurnLeftScaled(13);
        this.drawTexturedModalRect(i + 140, j + 36 + 13 - k, 176, 12 - k, 14, k);
        //}

        int l = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(i + 103, j + 35, 176, 14, 1 + l, 16);

        int b = this.getWaterProgressScaled(53);
        this.drawTexturedModalRect(i + 44, j + 16 + 53 - b, 176, 32, 16, b);

        int c = this.getCookProgressScaled(13);
        this.drawTexturedModalRect(i + 66, j + 57 + 13 - c, 176, 83, 27, c);

    }

    private int getCookProgressScaled(int pixels) {
        int i = tileEntity.getField(2);
        int j = tileEntity.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }

    private int getBurnLeftScaled(int pixels) {
        int i = this.tileEntity.getField(1);
        if (i == 0) {
            i = 200;
        }
        return this.tileEntity.getField(0) * pixels / i;
    }

    private int getWaterProgressScaled(int pixels) {
        int wo = tileEntity.getField(4);
        return wo != 0 ? pixels / wo : 0;
    }

}
