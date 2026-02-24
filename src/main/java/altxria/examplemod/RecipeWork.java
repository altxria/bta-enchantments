package altxria.examplemod;

import altxria.examplemod.blocks.BlockWork;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static altxria.examplemod.ExampleMod.MOD_ID;

public class RecipeWork implements RecipeEntrypoint {

	@Override
	public void onRecipesReady() {
		RecipeBuilder.Shaped(MOD_ID)
			.setShape(
				" B ",
				"ODO",
				"OOO"
			)
			.addInput('B', Items.BOOK)
			.addInput('O', Blocks.OBSIDIAN)
			.addInput('D', Blocks.BLOCK_DIAMOND)
			.create("enchantment_table", BlockWork.ENCHANTMENT_TABLE.getDefaultStack());
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);

		RecipeNamespace modNamespace = new RecipeNamespace();
		modNamespace.register("workbench", Registries.RECIPES.WORKBENCH);
		Registries.RECIPES.register(MOD_ID, modNamespace);
	}
}
