package altxria.examplemod.mixin;

import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableContainer;
import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableGui;
import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableScreen;
import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.player.inventory.menu.MenuAbstract;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import static altxria.examplemod.ExampleMod.LOGGER;

@Mixin(value = Player.class, remap = false)
public abstract class PlayerMixinEnchantmentTableScreen implements EnchantmentTableScreen {

	@Shadow public ContainerInventory inventory;
	@Shadow public MenuAbstract craftingInventory;

	@Override
	public void examplemod$displayEnchantmentTableBlockScreen(EnchantmentTableTileEntity tileEntity) {
		this.craftingInventory = new EnchantmentTableContainer(this.inventory, tileEntity);

		Minecraft.getMinecraft().displayScreen(
			new EnchantmentTableGui(this.inventory, tileEntity)
		);
	}
}
