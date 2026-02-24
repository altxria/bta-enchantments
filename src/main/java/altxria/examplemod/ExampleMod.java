package altxria.examplemod;

import altxria.examplemod.blocks.BlockWork;
import altxria.examplemod.item.CoolItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;

public class ExampleMod implements ModInitializer, GameStartEntrypoint {

	public static final String MOD_ID = "examplemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// item work
	ItemBuilder GlobalItemBuilder = new ItemBuilder(ExampleMod.MOD_ID);
	public static Item CoolItem;
	public static int currentItemBlockID = 5000;

	public static int newID() {
		return currentItemBlockID++;
	}
	// end item work

	@Override
	public void onInitialize() {
		new BlockWork().initBlocks();
		LOGGER.info("ExampleMod initialized.");
	}

	@Override
	public void beforeGameStart() {}

	@Override
	public void afterGameStart() {
		CoolItem = GlobalItemBuilder
			.build(new CoolItem("CoolItem", ExampleMod.MOD_ID + ":CoolItem", newID()));

	}
}

