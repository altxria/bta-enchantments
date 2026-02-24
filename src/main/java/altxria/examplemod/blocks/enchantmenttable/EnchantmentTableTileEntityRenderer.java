package altxria.examplemod.blocks.enchantmenttable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.render.tessellator.Tessellator;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import org.lwjgl.opengl.GL11;

import static altxria.examplemod.ExampleMod.LOGGER;
import static altxria.examplemod.ExampleMod.MOD_ID;

public class EnchantmentTableTileEntityRenderer extends TileEntityRenderer<EnchantmentTableTileEntity> {
	public BookModel modelBook = new BookModel();

	@Override
	public void doRender(Tessellator tessellator, EnchantmentTableTileEntity tileEntity, double x, double y, double z, float partialTick) {
		float time = (float)tileEntity.tickCount + partialTick;

		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y + 0.90, z + 0.5);

		float bob = (float)Math.sin(time * 0.1f) * 0.05f;
		GL11.glTranslatef(0.0f, bob, 0.0f);

		float rotation = time * 2.0f;
		GL11.glRotatef(-rotation, 0.0f, 1.0f, 0.0f);
		GL11.glRotatef(80.0f, 0.0f, 0.0f, 1.0f);

		Minecraft mc = Minecraft.getMinecraft();
		String texturePath = "/assets/" + MOD_ID + "/textures/block/book.png";
		mc.textureManager.bindTexture(mc.textureManager.loadTexture(texturePath));

		modelBook.render(time, 0.0f, 0.0f, 1.0f, 0.0f, 0.0625f);

		GL11.glPopMatrix();
	}
}
