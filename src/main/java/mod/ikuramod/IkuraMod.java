package mod.ikuramod;

import mod.ikuramod.Blocks.BlockSet;
import mod.ikuramod.Drop.DropSet;
import mod.ikuramod.Gui.GuiHandler;
import mod.ikuramod.Items.ItemSet;
import mod.ikuramod.LootTable.LootTableSet;
import mod.ikuramod.Model.ModelSet;
import mod.ikuramod.TileEntity.TileEntityDai;
import mod.ikuramod.TileEntity.TileEntityKama;
import mod.ikuramod.TileEntity.TileEntityKamado;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static mod.ikuramod.Items.ItemSet.IKURA;

@Mod(modid = IkuraMod.MODID, name = IkuraMod.NAME, version = IkuraMod.VERSION)
public class IkuraMod {
    public static final String MODID = "ikuramod";
    public static final String NAME = "IkuraMod";
    public static final String VERSION = "1.0";

    @Mod.Instance(MODID)
    public static IkuraMod instance;

    public static CreativeTabs IKURAMODTAB;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        IKURAMODTAB = new CreativeTabs("IkuraModTab") {
            public ItemStack getTabIconItem() {
                return new ItemStack(IKURA);
            }
        };
        GameRegistry.registerTileEntity(TileEntityDai.class, "TileEntityDai");
        GameRegistry.registerTileEntity(TileEntityKamado.class, "TileEntityKamado");
        GameRegistry.registerTileEntity(TileEntityKama.class, "TileEntityKama");
        MinecraftForge.EVENT_BUS.register(new LootTableSet());
        MinecraftForge.EVENT_BUS.register(new DropSet());
        MinecraftForge.EVENT_BUS.register(new BlockSet());
        MinecraftForge.EVENT_BUS.register(new ItemSet());
        MinecraftForge.EVENT_BUS.register(new ModelSet());
        NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
