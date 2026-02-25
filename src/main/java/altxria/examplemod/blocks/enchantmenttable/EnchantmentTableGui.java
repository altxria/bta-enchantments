package altxria.examplemod.blocks.enchantmenttable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.container.ScreenContainerAbstract;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import org.lwjgl.opengl.GL11;

import static altxria.examplemod.ExampleMod.MOD_ID;

public class EnchantmentTableGui extends ScreenContainerAbstract {
	private final EnchantmentTableTileEntity tileEntity;

	public EnchantmentTableGui(ContainerInventory inventory, EnchantmentTableTileEntity tileEntity) {
		super(new EnchantmentTableContainer(inventory, tileEntity));
		this.tileEntity = tileEntity;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f) {

		Minecraft mc = Minecraft.getMinecraft();
		String texturePath = "/assets/" + MOD_ID + "/textures/block/enchantment_table.png";
		mc.textureManager.bindTexture(mc.textureManager.loadTexture(texturePath));

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer() {
		this.font.drawString("Score:", 8, 6, 4210752);
		this.font.drawString("6969", 8, 18, 4210752);

		for (int i = 0; i < 3; i++) {
			int cost = tileEntity.enchantmentCosts[i];
			if (cost > 0) {
				String s = "Level " + cost;
				this.font.drawString(s, 60, 18 + (i * 15), 4210752);
			}
		}
	}
}
