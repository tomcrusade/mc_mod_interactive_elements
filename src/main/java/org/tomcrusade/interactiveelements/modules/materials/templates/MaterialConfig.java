package org.tomcrusade.interactiveelements.modules.materials.templates;

import net.minecraft.block.BlockSetType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;

public class MaterialConfig {
  public boolean canOpenByHand;
  public boolean canOpenByWindCharge;
  public boolean canButtonBeActivatedByArrows;
  public BlockSetType.ActivationRule pressurePlateSensitivity;
  public BlockSoundGroup soundType;
  public SoundEvent soundOfDoorClose;
  public SoundEvent soundOfDoorOpen;
  public SoundEvent soundOfTrapdoorClose;
  public SoundEvent soundOfTrapdoorOpen;
  public SoundEvent soundOfPressurePlateClickOff;
  public SoundEvent soundOfPressurePlateClickOn;
  public SoundEvent soundOfButtonClickOff;
  public SoundEvent soundOfButtonClickOn;
}
