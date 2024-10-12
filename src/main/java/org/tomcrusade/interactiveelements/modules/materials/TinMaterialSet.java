package org.tomcrusade.interactiveelements.modules.materials;

import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import org.tomcrusade.interactiveelements.modules.ModItemGroup;
import org.tomcrusade.interactiveelements.modules.materials.templates.InteractableBlocksGroup;
import org.tomcrusade.interactiveelements.utils.BlockSetting;
import org.tomcrusade.interactiveelements.modules.materials.templates.MaterialBlockTypes;
import org.tomcrusade.interactiveelements.modules.materials.templates.Material;
import org.tomcrusade.interactiveelements.modules.materials.templates.MaterialConfig;
import org.tomcrusade.interactiveelements.modules.materials.templates.MaterialItem;

import java.util.HashMap;

import static org.tomcrusade.interactiveelements.modules.ModItems.*;

public class TinMaterialSet extends Material implements InteractableBlocksGroup {

  public TinMaterialSet() {
    super("tin", "Tin");

    MaterialConfig config = new MaterialConfig();
    config.canOpenByHand = true;
    config.canButtonBeActivatedByArrows = true;
    config.canOpenByWindCharge = true;
    config.pressurePlateSensitivity = BlockSetType.ActivationRule.EVERYTHING;
    config.soundType = BlockSoundGroup.METAL;
    config.soundOfDoorClose = SoundEvents.BLOCK_IRON_DOOR_CLOSE;
    config.soundOfDoorOpen = SoundEvents.BLOCK_IRON_DOOR_OPEN;
    config.soundOfTrapdoorClose = SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE;
    config.soundOfTrapdoorOpen = SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN;
    config.soundOfPressurePlateClickOff = SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF;
    config.soundOfPressurePlateClickOn = SoundEvents.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON;
    config.soundOfButtonClickOff = SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    config.soundOfButtonClickOn = SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON;
    this.setBlockSetType(config);

    this.items = new HashMap<>();

    BlockSetting materialSetting = new BlockSetting();
    materialSetting.sound = BlockSoundGroup.METAL;
    materialSetting.mapColor = MapColor.OFF_WHITE;

    BlockSetting buttonItemSetting = InteractableBlocksGroup.getButtonDefaultSettings(materialSetting);
    buttonItemSetting.mapColor = MapColor.CLEAR;
    this.items.put(MaterialBlockTypes.BUTTON,
      InteractableBlocksGroup.generateButtonMaterialItem(
        this.ID,
        new ButtonBlock(this.getBlockSetType(), 5, buttonItemSetting.asMinecraftBlockSetting())
      )
    );

    BlockSetting trapdoorItemSetting = InteractableBlocksGroup.getTrapdoorDefaultSettings(materialSetting);
    trapdoorItemSetting.hardness = 3.5f;
    trapdoorItemSetting.blastResistance = 4.2f;
    this.items.put(MaterialBlockTypes.TRAPDOOR,
      InteractableBlocksGroup.generateTrapdoorMaterialItem(
        this.ID,
        new TrapdoorBlock(this.getBlockSetType(), trapdoorItemSetting.asMinecraftBlockSetting())
      )
    );

    BlockSetting doorItemSetting = InteractableBlocksGroup.getDoorDefaultSettings(materialSetting);
    doorItemSetting.hardness = 3.5f;
    doorItemSetting.blastResistance = 4.2f;
    this.items.put(MaterialBlockTypes.DOOR, new MaterialItem(
      this.ID + "_door",
      new Item.Settings(),
      new DoorBlock(this.getBlockSetType(), doorItemSetting.asMinecraftBlockSetting()),
      new ModItemGroup[]{ITEM_GROUP_MOD_FUNCTIONAL, ITEM_GROUP_REDSTONE, ITEM_GROUP_BUILDING_BLOCKS},
      false
    ));

    BlockSetting pressurePlateItemSetting = InteractableBlocksGroup.getPressurePlateDefaultSettings(materialSetting);
    this.items.put(MaterialBlockTypes.PRESSURE_PLATE, new MaterialItem(
      this.ID + "_pressure_plate",
      new Item.Settings(),
      new PressurePlateBlock(this.getBlockSetType(), pressurePlateItemSetting.asMinecraftBlockSetting()),
      new ModItemGroup[]{ITEM_GROUP_MOD_FUNCTIONAL, ITEM_GROUP_REDSTONE, ITEM_GROUP_BUILDING_BLOCKS},
      false
    ));

    BlockSetting cauldronItemSetting = InteractableBlocksGroup.getCauldronDefaultSettings(materialSetting);
    this.items.put(MaterialBlockTypes.CAULDRON, new MaterialItem(
      this.ID + "_cauldron",
      new Item.Settings(),
      new CauldronBlock(cauldronItemSetting.asMinecraftBlockSetting()),
      new ModItemGroup[]{ITEM_GROUP_MOD_FUNCTIONAL, ITEM_GROUP_FUNCTIONAL, ITEM_GROUP_REDSTONE},
      false
    ));

    BlockSetting bulbItemSetting = InteractableBlocksGroup.getBulbDefaultSettings(materialSetting);
    bulbItemSetting.blastResistance = 4.2f;
    this.items.put(MaterialBlockTypes.BULB, new MaterialItem(
      this.ID + "_bulb",
      new Item.Settings(),
      new BulbBlock(bulbItemSetting.asMinecraftBlockSetting()),
      new ModItemGroup[]{ITEM_GROUP_MOD_FUNCTIONAL, ITEM_GROUP_FUNCTIONAL, ITEM_GROUP_REDSTONE, ITEM_GROUP_BUILDING_BLOCKS},
      false
    ));
  }

  @Override
  public MaterialItem getItemButton() {
    return this.items.get(MaterialBlockTypes.BUTTON);
  }

  @Override
  public MaterialItem getItemTrapdoor() {
    return this.items.get(MaterialBlockTypes.TRAPDOOR);
  }

  @Override
  public MaterialItem getItemDoor() {
    return this.items.get(MaterialBlockTypes.DOOR);
  }

  @Override
  public MaterialItem getItemPressurePlate() {
    return this.items.get(MaterialBlockTypes.PRESSURE_PLATE);
  }

  @Override
  public MaterialItem getItemCauldron() {
    return this.items.get(MaterialBlockTypes.CAULDRON);
  }

  @Override
  public MaterialItem getItemBulb() {
    return this.items.get(MaterialBlockTypes.BULB);
  }
}
