package mod.ikuramod.LootTable;

import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static mod.ikuramod.Items.ItemSet.RICE_PRANT;

public class LootTableSet {
    @SubscribeEvent
    public void lootLoad(LootTableLoadEvent event) {
        if (!event.getName().equals(LootTableList.CHESTS_VILLAGE_BLACKSMITH)) {
            if (!event.getName().equals(LootTableList.CHESTS_SPAWN_BONUS_CHEST)) {
                return;
            }
        }
        LootPool main = event.getTable().getPool("main");
        main.addEntry(new LootEntryItem(RICE_PRANT, 100, 0, new LootFunction[0], new LootCondition[0], "ikuramod:loot_rice_prant"));
    }
}
