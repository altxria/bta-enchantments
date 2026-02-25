package altxria.examplemod.blocks.enchantmenttable;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.util.helper.MathHelper;

public class BookModel extends ModelBase {
	public Cube coverRight = new Cube(0, 0);
	public Cube coverLeft = new Cube(16, 0);
	public Cube pagesRight = new Cube(0, 10);
	public Cube pagesLeft = new Cube(12, 10);
	public Cube flippingPageRight = new Cube(24, 10);
	public Cube flippingPageLeft = new Cube(24, 10);
	public Cube bookSpine = new Cube(12, 0);

	public BookModel() {
		coverRight.addBox(-6.0F, -5.0F, 0.0F, 6, 10, 0);
		coverLeft.addBox(0.0F, -5.0F, 0.0F, 6, 10, 0);
		pagesRight.addBox(0.0F, -4.0F, -0.99F, 5, 8, 1);
		pagesLeft.addBox(0.0F, -4.0F, -0.01F, 5, 8, 1);
		flippingPageRight.addBox(0.0F, -4.0F, 0.0F, 5, 8, 0);
		flippingPageLeft.addBox(0.0F, -4.0F, 0.0F, 5, 8, 0);
		bookSpine.addBox(-1.0F, -5.0F, 0.0F, 2, 10, 0);

		coverRight.setRotationPoint(0.0F, 0.0F, -1.0F);
		coverLeft.setRotationPoint(0.0F, 0.0F, 1.0F);

		bookSpine.yRot = (float) Math.PI / 2.0F;
	}

	@Override
	public void render(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbYaw, limbPitch, headYaw, headPitch, scale);
		coverRight.render(scale);
		coverLeft.render(scale);
		bookSpine.render(scale);
		pagesRight.render(scale);
		pagesLeft.render(scale);
		flippingPageRight.render(scale);
		flippingPageLeft.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		float f = (MathHelper.sin(limbSwing * 0.02F) * 0.1F + 1.25F) * headYaw;

		coverRight.yRot = ((float) Math.PI + f);
		coverLeft.yRot = -f;
		pagesRight.yRot = f;
		pagesLeft.yRot = -f;

		flippingPageRight.yRot = f - f * 2.0F * limbYaw;
		flippingPageLeft.yRot = f - f * 2.0F * limbPitch;

		float newX = MathHelper.sin(f);
		pagesRight.x = newX;
		pagesLeft.x = newX;
		flippingPageRight.x = newX;
		flippingPageLeft.x = newX;
	}
}
