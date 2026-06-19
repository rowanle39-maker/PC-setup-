package net.pcsetup.mod.block;

import java.util.function.Function;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.pcsetup.mod.PCSetupMod;

public class ModBlocks {

	public static final Block MONITOR = registerBlock("monitor",
			settings -> new Block(settings),
			FabricBlockSettings.create().mapColor(MapColor.BLACK).strength(2.0f).nonOpaque()
	);

	public static final Block PC_CASE = registerBlock("pc_case",
			settings -> new Block(settings),
			FabricBlockSettings.create().mapColor(MapColor.BLACK).strength(3.0f)
	);

	public static final Block KEYBOARD = registerBlock("keyboard",
			settings -> new Block(settings),
			FabricBlockSettings.create().mapColor(MapColor.BLACK).strength(1.5f).nonOpaque()
	);

	public static final Block MOUSE = registerBlock("mouse",
			settings -> new Block(settings),
			FabricBlockSettings.create().mapColor(MapColor.BLACK).strength(1.0f).nonOpaque()
	);

	private static Block registerBlock(String name, Function<net.minecraft.block.AbstractBlock.Settings, Block> factory, net.minecraft.block.AbstractBlock.Settings settings) {
		RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(PCSetupMod.MOD_ID, name));
		Block block = factory.apply(settings.registryKey(blockKey));
		Registry.register(Registries.BLOCK, blockKey, block);

		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PCSetupMod.MOD_ID, name));
		Item.Settings itemSettings = new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey();
		BlockItem blockItem = new BlockItem(block, itemSettings);
		Registry.register(Registries.ITEM, itemKey, blockItem);

		return block;
	}

	public static void registerModBlocks() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
			entries.add(MONITOR);
			entries.add(PC_CASE);
			entries.add(KEYBOARD);
			entries.add(MOUSE);
		});
	}
}
