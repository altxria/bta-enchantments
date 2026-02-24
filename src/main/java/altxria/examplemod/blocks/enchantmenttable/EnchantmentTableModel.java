package altxria.examplemod.blocks.enchantmenttable;

import net.minecraft.client.render.block.model.BlockModelStandard;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.phys.AABB;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL11;

import static altxria.examplemod.ExampleMod.MOD_ID;

public class EnchantmentTableModel extends BlockModelStandard<BlockLogic> {

	public EnchantmentTableModel(Block<BlockLogic> block) {
		super(block);
	}

	@Override
	public boolean render(Tessellator tessellator, int x, int y, int z) {
		AABB bounds = AABB.getPermanentBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
		return this.renderStandardBlock(tessellator, bounds, x, y, z, 1.0f, 1.0f, 1.0f);
	}

	// Inside EnchantmentTableModel
	@Override
	public void renderBlockOnInventory(Tessellator tessellator, int metadata, float brightness, float alpha, @Nullable Integer lightmapCoordinate) {
		AABB bounds = AABB.getTemporaryBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);

		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(1.0f, 1.0f, 1.0f, alpha);

		double bX = -0.5, bY = -0.5, bZ = -0.5;

		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		this.renderBottomFace(tessellator, bounds, bX, bY, bZ, TextureRegistry.getTexture(MOD_ID + ":block/enchantment_table_bottom"));

		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		this.renderTopFace(tessellator, bounds, bX, bY, bZ, TextureRegistry.getTexture(MOD_ID + ":block/enchantment_table_top"));

		tessellator.setNormal(0.0F, 0.0F, -1.0F);
		this.renderNorthFace(tessellator, bounds, bX, bY, bZ, TextureRegistry.getTexture(MOD_ID + ":block/enchantment_table_side"));

		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		this.renderSouthFace(tessellator, bounds, bX, bY, bZ, TextureRegistry.getTexture(MOD_ID + ":block/enchantment_table_side"));

		tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		this.renderWestFace(tessellator, bounds, bX, bY, bZ, TextureRegistry.getTexture(MOD_ID + ":block/enchantment_table_side"));

		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		this.renderEastFace(tessellator, bounds, bX, bY, bZ, TextureRegistry.getTexture(MOD_ID + ":block/enchantment_table_side"));

		tessellator.draw();
	}
}
