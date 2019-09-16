package mod.ikuramod.Items;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static mod.ikuramod.Blocks.BlockSet.BLOCKINE;
import static mod.ikuramod.Blocks.BlockSet.BLOCKSOY;

public class ItemSet {
    public static Item RICE;
    public static Item RICE_PRANT;
    public static Item IKURA;
    public static Item FRESH_SALMON_FILLET;
    public static Item BAKED_SALMON_FILLET;
    public static Item IKURA_RICE_DON;
    public static Item IKURA_GUNKAN;
    public static Item SALMON_FLAKES;
    public static Item SALMON_FLAKES_ON_RICE;
    public static Item SOY;
    public static Item SOY_SAUCE;
    public static Item FRESH_RICE;

    public ItemSet() {
        RICE = new Rice();
        RICE_PRANT = new RicePrant(BLOCKINE, Blocks.FARMLAND);
        IKURA = new Ikura();
        FRESH_SALMON_FILLET = new FreshSalmonFillet();
        BAKED_SALMON_FILLET = new BakedSalmonFillet();
        IKURA_RICE_DON = new IkuraRiceDon();
        IKURA_GUNKAN = new IkuraGunkan();
        SALMON_FLAKES = new SalmonFlakes();
        SALMON_FLAKES_ON_RICE = new SalmonFlakesRiceDon();
        SOY = new Soy(2, 2.0F, BLOCKSOY, Blocks.FARMLAND);
        SOY_SAUCE = new SoySauce();
        FRESH_RICE = new FreshRice();
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(RICE);
        event.getRegistry().register(RICE_PRANT);
        event.getRegistry().register(IKURA);
        event.getRegistry().register(IKURA_GUNKAN);
        event.getRegistry().register(IKURA_RICE_DON);
        event.getRegistry().register(FRESH_SALMON_FILLET);
        event.getRegistry().register(BAKED_SALMON_FILLET);
        event.getRegistry().register(SALMON_FLAKES);
        event.getRegistry().register(SALMON_FLAKES_ON_RICE);
        event.getRegistry().register(SOY);
        event.getRegistry().register(SOY_SAUCE);
        event.getRegistry().register(FRESH_RICE);
    }
}
