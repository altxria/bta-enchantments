package altxria.examplemod.mixin;

import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableTileEntity;
import altxria.examplemod.blocks.enchantmenttable.EnchantmentTableTileEntityRenderer;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(value = TileEntityRenderDispatcher.class, remap = false)
public abstract class TileEntityRenderDispatcherMixin {

	@Shadow
	private Map<Class<?>, TileEntityRenderer<?>> renderers;

	@Inject(method = "<init>", at = @At("TAIL"))
	private void injectCustomRenderers(CallbackInfo ci) {
		EnchantmentTableTileEntityRenderer renderer = new EnchantmentTableTileEntityRenderer();
		renderer.setRenderDispatcher((TileEntityRenderDispatcher)(Object)this);
		this.renderers.put(EnchantmentTableTileEntity.class, renderer);
	}
}
