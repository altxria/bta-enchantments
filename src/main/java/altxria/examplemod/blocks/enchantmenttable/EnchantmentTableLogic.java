package altxria.examplemod.blocks.enchantmenttable;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import static altxria.examplemod.ExampleMod.LOGGER;

public class EnchantmentTableLogic extends BlockLogic {

	public EnchantmentTableLogic(Block<?> block) {
		super(block, Material.stone);
	}

	@Override
	public boolean onBlockRightClicked(World world, int x, int y, int z, Player player, Side side, double xHit, double yHit) {
		Container enchantTable = (EnchantmentTableTileEntity)world.getTileEntity(x, y, z);
		if (!world.isClientSide) {
			((altxria.examplemod.blocks.enchantmenttable.EnchantmentTableScreen) player).examplemod$displayEnchantmentTableBlockScreen((EnchantmentTableTileEntity) enchantTable);
		}
		return super.onBlockRightClicked(world, x, y, z, player, side, xHit, yHit);
	}

	public void displayGui(Player player, Container inventory) {

	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean isCubeShaped() {
		return false;
	}
}
