package altxria.examplemod.blocks.enchantmenttable;

import net.minecraft.core.InventoryAction;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemArmor;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.player.inventory.menu.MenuAbstract;
import net.minecraft.core.player.inventory.slot.Slot;

import static altxria.examplemod.ExampleMod.LOGGER;

import java.util.Collections;
import java.util.List;

public class EnchantmentTableContainer extends MenuAbstract {
	public final EnchantmentTableTileEntity tileEntity;
	public final ContainerInventory playerInventory;

	public EnchantmentTableContainer(ContainerInventory playerInventory, EnchantmentTableTileEntity tileEntity) {
		this.playerInventory = playerInventory;
		this.tileEntity = tileEntity;

		this.addSlot(new Slot(tileEntity, 0, 15, 47) {
			@Override
			public boolean mayPlace(ItemStack itemstack) {
				if (itemstack.getItem().getKey().contains("item.tool") && !itemstack.getItem().getKey().contains("firestriker")) {
					return true;
				}
				if (itemstack.getItem().getKey().contains("item.armor")) {
					return true;
				}
				return false;
			}
		});

		this.addSlot(new Slot(tileEntity, 1, 35, 47) {
			@Override
			public boolean mayPlace(ItemStack itemstack) {
				if (itemstack.getDisplayName().equals("Lapis Lazuli")) {
					return true;
				}
				return false;
			}
		});

		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				this.addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
			}
		}

		for (int col = 0; col < 9; col++) {
			this.addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
		}
	}

	@Override
	public List<Integer> getMoveSlots(InventoryAction action, Slot slot, int target, Player player) {
		if (slot.index < 2) {
			return this.getSlots(0, 2, false);
		}

		if (action == InventoryAction.MOVE_ALL) {
			if (slot.index >= 2 && slot.index < 29) { // Main Inv
				return this.getSlots(2, 27, false);
			}
			if (slot.index >= 29) { // Hotbar
				return this.getSlots(29, 9, false);
			}
		}
		return this.getSlots(slot.index, 1, false);
	}

	@Override
	public List<Integer> getTargetSlots(InventoryAction action, Slot slot, int target, Player player) {
		if (slot.index < 2) {
			return this.getSlots(2, 36, false);
		}

		if (slot.index >= 2) {
			return this.getSlots(0, 2, false);
		}

		return Collections.emptyList();
	}

	@Override
	public boolean stillValid(Player player) {
		return this.tileEntity.stillValid(player);
	}
}
