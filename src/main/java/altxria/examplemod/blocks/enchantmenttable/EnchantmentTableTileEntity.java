package altxria.examplemod.blocks.enchantmenttable;

import com.mojang.nbt.tags.CompoundTag;
import com.mojang.nbt.tags.ListTag;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.container.Container;
import org.jetbrains.annotations.Nullable;

import static altxria.examplemod.ExampleMod.MOD_ID;

public class EnchantmentTableTileEntity extends TileEntity implements Container {

	// 0: Item to enchant, 1: Lapis/Catalyst
	private ItemStack[] contents = new ItemStack[2];
	public int tickCount;
	public int[] enchantmentCosts = new int[3];

	public void updateEnchantmentCosts() {
		ItemStack stack = this.getItem(0);

		if (stack != null && stack.stackSize > 0) {
			java.util.Random rand = new java.util.Random();

			for (int i = 0; i < 3; i++) {
				enchantmentCosts[i] = rand.nextInt(8) + 1 + (i * 5);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				enchantmentCosts[i] = 0;
			}
		}
	}

	@Override
	public void tick() {
		super.tick();
		tickCount++;
	}

	@Override
	public int getContainerSize() {
		return 2;
	}

	@Override
	public @Nullable ItemStack getItem(int i) {
		return contents[i];
	}

	@Override
	public @Nullable ItemStack removeItem(int i, int count) {
		if (this.contents[i] != null) {
			ItemStack itemstack;
			if (this.contents[i].stackSize <= count) {
				itemstack = this.contents[i];
				this.contents[i] = null;
				this.setChanged();
				return itemstack;
			} else {
				itemstack = this.contents[i].splitStack(count);
				if (this.contents[i].stackSize == 0) {
					this.contents[i] = null;
				}
				this.setChanged();
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public void setItem(int i, @Nullable ItemStack itemStack) {
		this.contents[i] = itemStack;
		if (itemStack != null && itemStack.stackSize > this.getMaxStackSize()) {
			itemStack.stackSize = this.getMaxStackSize();
		}
		this.setChanged();
	}

	@Override
	public String getNameTranslationKey() {
		return "container" + MOD_ID + ".enchantment";
	}

	public void readFromNBT(CompoundTag nbttagcompound) {
		super.readFromNBT(nbttagcompound);
		ListTag nbttaglist = nbttagcompound.getList("Items");
		this.contents = new ItemStack[this.getContainerSize()];

		for(int i = 0; i < nbttaglist.tagCount(); ++i) {
			CompoundTag nbttagcompound1 = (CompoundTag)nbttaglist.tagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;
			if (j >= 0 && j < this.contents.length) {
				this.contents[j] = ItemStack.readItemStackFromNbt(nbttagcompound1);
			}
		}

	}

	public void writeToNBT(CompoundTag nbttagcompound) {
		super.writeToNBT(nbttagcompound);
		ListTag nbttaglist = new ListTag();

		for(int i = 0; i < this.contents.length; ++i) {
			if (this.contents[i] != null) {
				CompoundTag nbttagcompound1 = new CompoundTag();
				nbttagcompound1.putByte("Slot", (byte)i);
				this.contents[i].writeToNBT(nbttagcompound1);
				nbttaglist.addTag(nbttagcompound1);
			}
		}

		nbttagcompound.putList("Items", nbttaglist);
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public void setChanged() {
		if (this.worldObj != null) {
			this.worldObj.updateTileEntityChunkAndSendToPlayer(this.x, this.y, this.z, this);
		}
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.worldObj.getTileEntity(this.x, this.y, this.z) != this) {
			return false;
		}
		return player.distanceToSqr((double)this.x + 0.5, (double)this.y + 0.5, (double)this.z + 0.5) <= 64.0;
	}

	@Override
	public void sortContainer() {

	}
}
