package mod.ikuramod.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static mod.ikuramod.IkuraMod.MODID;

public class BlockSet {
    public static Block BLOCKSOY;
    public static Block BLOCKINE;
    public static Block CUTTING_BOARD;
    public static Block VERY_CUTTING_BOARD;
    public static Block KAMADO;
    public static Block KAMA;
    public static Block DAI;
    public static Block KONRO;

    public BlockSet() {
        BLOCKINE = new BlockIne();
        BLOCKSOY = new BlockSoy();
        CUTTING_BOARD = new BlockCuttingBoard(Material.WOOD);
        VERY_CUTTING_BOARD = new BlockVeryCuttingBoard(Material.WOOD);
        KAMADO = new BlockKamado(false).setRegistryName(new ResourceLocation(MODID, "block_kamado"));
        KAMA = new BlockKama(Material.WOOD);
        DAI = new BlockDai(Material.WOOD);
        KONRO = new BlockKonro(Material.WOOD);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(CUTTING_BOARD).setRegistryName(MODID, "block_cb"));
        event.getRegistry().register(new ItemBlock(VERY_CUTTING_BOARD).setRegistryName(MODID, "block_very_cb"));
        event.getRegistry().register(new ItemBlock(KAMADO).setRegistryName(MODID, "block_kamado"));
        event.getRegistry().register(new ItemBlock(KAMA).setRegistryName(MODID, "block_kama"));
        event.getRegistry().register(new ItemBlock(DAI).setRegistryName(MODID, "block_dai"));
        event.getRegistry().register(new ItemBlock(KONRO).setRegistryName(MODID, "block_konro"));
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(BLOCKINE);
        event.getRegistry().register(BLOCKSOY);
        event.getRegistry().register(CUTTING_BOARD);
        event.getRegistry().register(VERY_CUTTING_BOARD);

        event.getRegistry().register(KAMA);
        event.getRegistry().register(DAI);
        event.getRegistry().register(KAMADO);
        event.getRegistry().register(KONRO);

    }
}
