package org.tomcrusade.interactiveelements.modules;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.tomcrusade.interactiveelements.modules.materials.templates.MaterialItem;

import java.util.ArrayList;
import java.util.List;

import static org.tomcrusade.interactiveelements.InteractiveElements.MOD_ID;

public class ModItemGroup {
  public final RegistryKey<ItemGroup> key;
  public final ItemGroup itemGroup;
  private final List<MaterialItem> materialItems;

  public ModItemGroup(RegistryKey<ItemGroup> itemGroupKey) {
    this.key = itemGroupKey;
    this.itemGroup = Registries.ITEM_GROUP.get(itemGroupKey);
    this.materialItems = new ArrayList<>();

  }

  public ModItemGroup(String keySuffix, Item itemForIcon, Text displayName){
    this.key = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "item_group_" + keySuffix));
    this.materialItems = new ArrayList<>();
    this.itemGroup = FabricItemGroup.builder()
      .icon(() -> new ItemStack(itemForIcon))
      .displayName(displayName)
      .build();
    Registry.register(Registries.ITEM_GROUP, this.key, this.itemGroup);
  }

  public void add(MaterialItem item) {
    this.materialItems.add(item);
  }

  public void registerItems() {
    ItemGroupEvents.modifyEntriesEvent(this.key).register((itemGroup) -> {
      for(MaterialItem materialItem : this.materialItems) {
        if (materialItem.item != null) {
          itemGroup.add(materialItem.item.asItem());
        }
      }
    });
  }
}
