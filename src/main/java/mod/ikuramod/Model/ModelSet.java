package mod.ikuramod.Model;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static mod.ikuramod.Blocks.BlockSet.*;
import static mod.ikuramod.IkuraMod.MODID;
import static mod.ikuramod.Items.ItemSet.*;

public class ModelSet {
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(RICE, 0, new ModelResourceLocation("ikuramod:rice"));
        ModelLoader.setCustomModelResourceLocation(RICE_PRANT, 0, new ModelResourceLocation("ikuramod:riceprant"));
        ModelLoader.setCustomModelResourceLocation(IKURA, 0, new ModelResourceLocation("ikuramod:ikura"));
        ModelLoader.setCustomModelResourceLocation(IKURA_GUNKAN, 0, new ModelResourceLocation("ikuramod:ikuragunkan"));
        ModelLoader.setCustomModelResourceLocation(IKURA_RICE_DON, 0, new ModelResourceLocation("ikuramod:ikuraricedon"));
        ModelLoader.setCustomModelResourceLocation(FRESH_SALMON_FILLET, 0, new ModelResourceLocation("ikuramod:freshsalmonfillet"));
        ModelLoader.setCustomModelResourceLocation(BAKED_SALMON_FILLET, 0, new ModelResourceLocation("ikuramod:bakedsalmonfillet"));
        ModelLoader.setCustomModelResourceLocation(SALMON_FLAKES, 0, new ModelResourceLocation("ikuramod:salmonflakes"));
        ModelLoader.setCustomModelResourceLocation(SALMON_FLAKES_ON_RICE, 0, new ModelResourceLocation("ikuramod:salmonflakesricedon"));
        ModelLoader.setCustomModelResourceLocation(SOY, 0, new ModelResourceLocation("ikuramod:soy"));
        ModelLoader.setCustomModelResourceLocation(SOY_SAUCE, 0, new ModelResourceLocation("ikuramod:soysauce"));
        ModelLoader.setCustomModelResourceLocation(FRESH_RICE, 0, new ModelResourceLocation("ikuramod:freshrice"));

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BLOCKINE), 0, new ModelResourceLocation(new ResourceLocation(MODID, "blockine"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BLOCKSOY), 0, new ModelResourceLocation(new ResourceLocation(MODID, "blocksoy"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(CUTTING_BOARD), 0, new ModelResourceLocation(new ResourceLocation(MODID, "block_cb"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(VERY_CUTTING_BOARD), 0, new ModelResourceLocation(new ResourceLocation(MODID, "block_very_cb"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(KAMADO), 0, new ModelResourceLocation(new ResourceLocation(MODID, "kamado"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(KAMA), 0, new ModelResourceLocation(new ResourceLocation(MODID, "block_kama"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(DAI), 0, new ModelResourceLocation(new ResourceLocation(MODID, "block_dai"), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(KONRO), 0, new ModelResourceLocation(new ResourceLocation(MODID, "block_konro"), "inventory"));


    }
}
