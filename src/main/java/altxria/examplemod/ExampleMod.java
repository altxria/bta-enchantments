package altxria.examplemod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class ExampleMod implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint {

	public static final String MOD_ID = "examplemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// item work
	ItemBuilder GenericItemBuilder = new ItemBuilder(ExampleMod.MOD_ID);
	public static Item CoolItem;
	private static int currentItemID = 30000;

	private static int newItemID() {
		return currentItemID++;
	}
	// end item work

	@Override
	public void onInitialize() {
		LOGGER.info("ExampleMod initialized.");
	}

	@Override
	public void onRecipesReady()
	{

	}

	@Override
	public void initNamespaces() {}

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {
		CoolItem = GenericItemBuilder
			.build(new CoolItem("CoolItem", ExampleMod.MOD_ID + ":CoolItem", newItemID()));
	}
}

