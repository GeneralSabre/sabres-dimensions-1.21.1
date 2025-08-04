package net.generalsabre.sabresdimensions.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IngotPressScreen extends HandledScreen<IngotPressScreenHandler> {

    private static final Identifier GUI_TEXTURE =
            Identifier.of(SabresDimensions.MOD_ID, "textures/gui/ingot_press/molding_machine_gui.png");
    private static final Identifier ARROW_TEXTURE =
            Identifier.of(SabresDimensions.MOD_ID,"textures/gui/ingot_press/mm_progress_arrow.png");
    private static final Identifier LIGHT_TEXTURE =
            Identifier.of(SabresDimensions.MOD_ID, "textures/gui/ingot_press/light_on.png");

    public IngotPressScreen(IngotPressScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(ARROW_TEXTURE, x + 67, y + 37, 0, 0,
                    handler.getScaledArrowProgress(), 12, 38, 12);
        }
    }

    private void renderLightFlashing(DrawContext context, int x, int y) {
        if(handler.isPowered()){
            context.drawTexture(LIGHT_TEXTURE,x+81,y+25,0,0,
                    10,10,10,10);
            context.drawTexture(LIGHT_TEXTURE,x+81,y+50,0,0,
                    10,10,10,10);
        }
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
        renderLightFlashing(context, x, y);

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
