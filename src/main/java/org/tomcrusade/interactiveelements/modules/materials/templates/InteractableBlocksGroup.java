package org.tomcrusade.interactiveelements.modules.materials.templates;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import org.tomcrusade.interactiveelements.modules.ModItemGroup;
import org.tomcrusade.interactiveelements.utils.BlockSetting;

import static org.tomcrusade.interactiveelements.modules.ModItems.*;

public interface InteractableBlocksGroup {
  MaterialItem getItemButton();

  static BlockSetting getButtonDefaultSettings(BlockSetting defaultSetting) {
    BlockSetting setting = defaultSetting.clone();
    setting.hardness = 0.5f;
    setting.blastResistance = 0.5f;
    setting.hasNoCollision = true;
    setting.isBreakingRequiresTool = false;
    setting.pistonPushBehavior = PistonBehavior.DESTROY;
    return setting;
  }

  static MaterialItem generateButtonMaterialItem(String materialId, Block buttonBlock) {
    return new MaterialItem(
      materialId + "_button",
      new Item.Settings(),
      buttonBlock,
      new ModItemGroup[]{ITEM_GROUP_MOD_FUNCTIONAL, ITEM_GROUP_REDSTONE, ITEM_GROUP_BUILDING_BLOCKS},
      false
    );
  }

  MaterialItem getItemTrapdoor();

  static BlockSetting getTrapdoorDefaultSettings(BlockSetting defaultSetting) {
    BlockSetting setting = defaultSetting.clone();
    setting.hardness = 5.0f;
    setting.blastResistance = 5.0f;
    setting.isNonOpaque = true;
    setting.isBreakingRequiresTool = true;
    setting.allowSpawning = Blocks::never;
    return setting;
  }

  static MaterialItem generateTrapdoorMaterialItem(String materialId, Block block) {
    return new MaterialItem(
      materialId + "_trapdoor",
      new Item.Settings(),
      block,
      new ModItemGroup[]{ITEM_GROUP_MOD_FUNCTIONAL, ITEM_GROUP_REDSTONE, ITEM_GROUP_BUILDING_BLOCKS},
      false
    );
  }

  MaterialItem getItemDoor();

  static BlockSetting getDoorDefaultSettings(BlockSetting defaultSetting) {
    BlockSetting setting = defaultSetting.clone();
    setting.hardness = 5.0f;
    setting.blastResistance = 5.0f;
    setting.isNonOpaque = true;
    setting.isBreakingRequiresTool = true;
    setting.pistonPushBehavior = PistonBehavior.DESTROY;
    return setting;
  }

  MaterialItem getItemPressurePlate();

  static BlockSetting getPressurePlateDefaultSettings(BlockSetting defaultSetting) {
    BlockSetting setting = defaultSetting.clone();
    setting.hardness = 0.5f;
    setting.blastResistance = 0.5f;
    setting.isSolidBlock = true;
    setting.isBreakingRequiresTool = true;
    setting.noteblockInstrument = NoteBlockInstrument.BASEDRUM;
    setting.hasNoCollision = true;
    setting.pistonPushBehavior = PistonBehavior.DESTROY;
    return setting;
  }

  MaterialItem getItemCauldron();

  static BlockSetting getCauldronDefaultSettings(BlockSetting defaultSetting) {
    BlockSetting setting = defaultSetting.clone();
    setting.hardness = 2.0f;
    setting.blastResistance = 2.0f;
    setting.isBreakingRequiresTool = true;
    setting.isNonOpaque = true;
    return setting;
  }

  MaterialItem getItemBulb();

  static BlockSetting getBulbDefaultSettings(BlockSetting defaultSetting) {
    BlockSetting setting = defaultSetting.clone();
    setting.hardness = 3.0f;
    setting.blastResistance = 6.0f;
    setting.isBreakingRequiresTool = true;
    setting.solidBlockingValidator = Blocks::never;
    setting.luminanceCalculator = Blocks.createLightLevelFromLitBlockState(15);
    return setting;
  }
}
