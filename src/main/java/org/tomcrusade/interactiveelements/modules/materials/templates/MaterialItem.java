package org.tomcrusade.interactiveelements.modules.materials.templates;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.tomcrusade.interactiveelements.modules.ModItemGroup;

import static org.tomcrusade.interactiveelements.InteractiveElements.MOD_ID;

public class MaterialItem {

    public final Identifier id;
    public final Item item;
    public final Block block;

    public MaterialItem(
            String name,
            Item.Settings itemSetting,
            Block block,
            ModItemGroup[] groups,
            boolean isTechnicalBlock
    ) {
        this.id = Identifier.of(MOD_ID, name);
        if (block == null) {
            this.block = null;
            this.item = new Item(itemSetting);
            return;
        }
        this.block = block;
        Registry.register(Registries.BLOCK, this.id, block);
        if (isTechnicalBlock) {
            this.item = null;
        } else {
            this.item = new BlockItem(block, itemSetting);
            Registry.register(Registries.ITEM, this.id, this.item);
        }
        if (this.item != null) {
            for (ModItemGroup group : groups) {
                group.add(this);
            }
        }
    }
}
