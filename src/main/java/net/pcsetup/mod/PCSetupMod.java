package net.pcsetup.mod;

import net.fabricmc.api.ModInitializer;
import net.pcsetup.mod.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PCSetupMod implements ModInitializer {

	public static final String MOD_ID = "pcsetup";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		LOGGER.info("[PCSetup] Computer parts have entered the world!");
	}
}
