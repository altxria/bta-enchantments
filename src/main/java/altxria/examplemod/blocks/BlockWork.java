package altxria.examplemod.blocks;

import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableLogic;
import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableTileEntity;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;

import static altxria.examplemod.ExampleMod.MOD_ID;
import static altxria.examplemod.ExampleMod.newID;

public class BlockWork {
	public static Block<?> ENCHANTMENT_TABLE;

	public void initBlocks() {
		ENCHANTMENT_TABLE = new BlockBuilder(MOD_ID)
			.setHardness(0.5F)
			.build("enchantment.table", "enchantment_table", newID(), (b -> new EnchantmentTableLogic(b)));

		ENCHANTMENT_TABLE.withEntity(EnchantmentTableTileEntity::new);
		EntityHelper.createTileEntity(EnchantmentTableTileEntity.class, NamespaceID.getTemp(MOD_ID, "enchantment_table_book"));
	}
}
