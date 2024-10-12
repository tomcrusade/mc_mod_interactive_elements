package org.tomcrusade.interactiveelements.modules.materials.templates;

import net.minecraft.block.BlockSetType;

import java.util.HashMap;

public abstract class Material {

    protected HashMap<MaterialBlockTypes, MaterialItem> items;
    private BlockSetType blockSetType;
    public final String ID;
    public final String NAME;

    public Material(String id, String name) {
        this.ID = id;
        this.NAME = name;
    }

    protected void setBlockSetType(MaterialConfig config) {
        this.blockSetType = new BlockSetType(
          this.NAME,
          config.canOpenByHand,
          config.canOpenByWindCharge,
          config.canButtonBeActivatedByArrows,
          config.pressurePlateSensitivity,
          config.soundType,
          config.soundOfDoorClose,
          config.soundOfDoorOpen,
          config.soundOfTrapdoorClose,
          config.soundOfTrapdoorOpen,
          config.soundOfPressurePlateClickOff,
          config.soundOfPressurePlateClickOn,
          config.soundOfButtonClickOff,
          config.soundOfButtonClickOn
        );
    }

    public BlockSetType getBlockSetType() {
        return blockSetType;
    }
}
