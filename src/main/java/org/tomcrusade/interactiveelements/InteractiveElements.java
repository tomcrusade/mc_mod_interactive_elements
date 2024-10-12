package org.tomcrusade.interactiveelements;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tomcrusade.interactiveelements.modules.materials.TinMaterialSet;

public class InteractiveElements implements ModInitializer {
    public static final String MOD_ID = "interactiveelements";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        TinMaterialSet tinMaterialSet = new TinMaterialSet();
        LOGGER.info("Initializing Interactive Elements Server");
    }
}
