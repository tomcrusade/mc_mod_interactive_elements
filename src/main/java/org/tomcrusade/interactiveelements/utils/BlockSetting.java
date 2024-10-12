package org.tomcrusade.interactiveelements.utils;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.BlockSoundGroup;

import java.lang.reflect.Method;
import java.util.function.ToIntFunction;

public class BlockSetting implements Cloneable  {
  public MapColor mapColor = MapColor.CLEAR;
  public float blastResistance = 0.5f;
  public float hardness = 0.5f;
  public Boolean isNonOpaque = false; // It means that block may not block view of what's behind it
  public Boolean isBreakingRequiresTool = false;
  public PistonBehavior pistonPushBehavior = PistonBehavior.NORMAL;
  public BlockSoundGroup sound = BlockSoundGroup.INTENTIONALLY_EMPTY;
  public Boolean hasNoCollision = false; // It means that block can be passed through
  public Boolean isSolidBlock = false; // It means it cannot be water loggable
  public AbstractBlock.TypedContextPredicate<EntityType<?>> allowSpawning;
  public AbstractBlock.ContextPredicate solidBlockingValidator;
  public ToIntFunction<BlockState> luminanceCalculator;
  public NoteBlockInstrument noteblockInstrument;

  public AbstractBlock.Settings asMinecraftBlockSetting() {
    AbstractBlock.Settings blockSetting = AbstractBlock.Settings.create();
    blockSetting.mapColor(mapColor);
    blockSetting.strength(hardness, blastResistance);
    if (isNonOpaque) {
      blockSetting.nonOpaque();
    }
    if (isBreakingRequiresTool) {
      blockSetting.requiresTool();
    }
    blockSetting.pistonBehavior(pistonPushBehavior);
    blockSetting.sounds(sound);
    if (hasNoCollision) {
      blockSetting.noCollision();
    }
    if (isSolidBlock) {
      blockSetting.solid();
    }
    if (allowSpawning != null) {
      blockSetting.allowsSpawning(allowSpawning);
    }
    if (solidBlockingValidator != null) {
      blockSetting.solidBlock(solidBlockingValidator);
    }
    if (luminanceCalculator != null) {
      blockSetting.luminance(luminanceCalculator);
    }
    if (noteblockInstrument != null) {
      blockSetting.instrument(noteblockInstrument);
    }
    return blockSetting;
  }

  @Override
  public BlockSetting clone() {
    try {
      return (BlockSetting) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
