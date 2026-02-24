package altxria.examplemod;

import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableTileEntity;
import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableTileEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import net.minecraft.core.block.entity.TileEntityDispatcher;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import static altxria.examplemod.ExampleMod.LOGGER;
import static altxria.examplemod.ExampleMod.MOD_ID;

public class Client implements ClientStartEntrypoint, ClientModInitializer {

	@Override
	public void onInitializeClient() {

	}

	@Override
	public void beforeClientStart() {
		try {
			TextureRegistry.initializeAllFiles(MOD_ID, TextureRegistry.blockAtlas, false);
			TextureRegistry.initializeAllFiles(MOD_ID, TextureRegistry.itemAtlas, false);
		} catch (URISyntaxException | IOException e) {
			LOGGER.error(MOD_ID + " failed its texture initialization. Uh oh!");
		}
	}

	@Override
	public void afterClientStart() {

	}
}
