package altxria.examplemod.blocks.enchantmenttable;

import net.minecraft.core.block.entity.TileEntity;

public class EnchantmentTableTileEntity extends TileEntity {
	public float pageFlip;
	public float pageFlipPrev;
	public float pageFlipReal;
	public float pageFlipPrevReal;
	public float bookRotation;
	public float bookRotationPrev;
	public float bookRotationReal;
	public int tickCount;

	@Override
	public void tick() {
		super.tick();
		tickCount++;

		this.bookRotationPrev = this.bookRotationReal;
		this.pageFlipPrev = this.pageFlipReal;

		this.bookRotationReal += 0.02F;
	}


}
