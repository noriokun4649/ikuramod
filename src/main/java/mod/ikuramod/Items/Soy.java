package mod.ikuramod.Items;

import mod.ikuramod.IkuraMod;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.util.ResourceLocation;

import static mod.ikuramod.IkuraMod.MODID;

public class Soy extends ItemSeedFood {
    public Soy(int healAmount, float saturation, Block crops, Block soil) {
        super(healAmount, saturation, crops, soil);
        this.setUnlocalizedName("Soy");
        this.setCreativeTab(IkuraMod.IKURAMODTAB);
        this.setRegistryName(new ResourceLocation(MODID, "Soy"));
    }
}
