package org.tomcrusade.interactiveelements;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InteractiveElementsClient implements ClientModInitializer {
    public static final String MOD_ID = "interactiveelements";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Interactive Elements Client");
    }
}
