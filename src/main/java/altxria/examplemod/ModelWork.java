package altxria.examplemod;

import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableModel;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.Side;
import turniplabs.halplibe.util.ModelEntrypoint;

import static altxria.examplemod.ExampleMod.LOGGER;
import static altxria.examplemod.ExampleMod.MOD_ID;
import static altxria.examplemod.blocks.BlockWork.*;

public class ModelWork implements ModelEntrypoint {

	@Override
	public void initBlockModels(BlockModelDispatcher blockModelDispatcher) {
		LOGGER.warn("TESTMOD: initializing block models");
		EnchantmentTableModel enchantmentModel = new EnchantmentTableModel((Block) ENCHANTMENT_TABLE);
		enchantmentModel.setTex(0, MOD_ID + ":block/enchantment_table_top", Side.TOP);
		enchantmentModel.setTex(0, MOD_ID + ":block/enchantment_table_side", Side.NORTH, Side.EAST, Side.SOUTH, Side.WEST);
		enchantmentModel.setTex(0, MOD_ID + ":block/enchantment_table_bottom", Side.BOTTOM);
		blockModelDispatcher.addDispatch(ENCHANTMENT_TABLE, enchantmentModel);
	}

	@Override
	public void initItemModels(ItemModelDispatcher itemModelDispatcher) {

	}

	@Override
	public void initEntityModels(EntityRenderDispatcher entityRenderDispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher tileEntityRenderDispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher blockColorDispatcher) {

	}
}
