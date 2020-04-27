package io.github.elementera.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.*;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.resource.language.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LanguageOptionsScreen.class)
@Environment(EnvType.CLIENT)
public class LanguageOptionsScreenMixin extends GameOptionsScreen {
    public LanguageOptionsScreenMixin(Screen parent, GameOptions options) {
        super(parent, options, new TranslatableText("options.language", new Object[0]));
    }
    public void tick() {}

    /**
     * @author baka4n
     */
    @Inject(at=@At("RETURN"), method = "init()V")
    protected void init(CallbackInfo info) {
    }
    /**
     * @author baka4n
     */
    @Inject(method = "render", at=@At("RETURN"))
    public void render(MatrixStack matrixStack, int mouseY, int i, float f, CallbackInfo info) {
        textRenderer.draw(matrixStack, I18n.translate("mouseX") + ": " + mouseY, 5, 5, 0xFFFFFFFF);
        textRenderer.draw(matrixStack, I18n.translate("mouseY") + ": " + i, 5, 5 + textRenderer.fontHeight, 0xFFFFFFFF);
    }

}
