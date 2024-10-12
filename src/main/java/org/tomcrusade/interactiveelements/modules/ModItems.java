package org.tomcrusade.interactiveelements.modules;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.text.Text;

public class ModItems {
  public static final ModItemGroup ITEM_GROUP_MOD_FUNCTIONAL = new ModItemGroup("functional", new Item(new Item.Settings()), Text.translatable(""));
  public static final ModItemGroup ITEM_GROUP_FUNCTIONAL = new ModItemGroup(ItemGroups.FUNCTIONAL);
  public static final ModItemGroup ITEM_GROUP_REDSTONE = new ModItemGroup(ItemGroups.REDSTONE);
  public static final ModItemGroup ITEM_GROUP_BUILDING_BLOCKS = new ModItemGroup(ItemGroups.BUILDING_BLOCKS);

  public void register() {
    ITEM_GROUP_MOD_FUNCTIONAL.registerItems();
    ITEM_GROUP_FUNCTIONAL.registerItems();
    ITEM_GROUP_REDSTONE.registerItems();
    ITEM_GROUP_BUILDING_BLOCKS.registerItems();
  }
}
