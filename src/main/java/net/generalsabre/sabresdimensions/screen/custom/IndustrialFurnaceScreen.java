package net.generalsabre.sabresdimensions.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.generalsabre.sabresdimensions.SabresDimensions;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class IndustrialFurnaceScreen extends HandledScreen<IndustrialFurnaceScreenHandler> {

    private static final Identifier GUI_TEXTURE =
            Identifier.of(SabresDimensions.MOD_ID, "textures/gui/industrial_furnace/industrial_furnace_gui.png");
    private static final Identifier ARROW_TEXTURE =
            Identifier.of(SabresDimensions.MOD_ID,"textures/gui/industrial_furnace/burn_progress.png");
    private static final Identifier BURN_TEXTURE =
            Identifier.of(SabresDimensions.MOD_ID, "textures/gui/industrial_furnace/lit_progress");

    public IndustrialFurnaceScreen(IndustrialFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(ARROW_TEXTURE, x + 79, y + 35, 0, 0,
                    handler.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    private void renderFlameProgress(DrawContext context, int x, int y){
        int i = handler.getBurnProgress() + 1;
        if(handler.isBurning()){
            //context.drawGuiTexture(BURN_TEXTURE, 14, 14, 0, 14 - i, x + 56, y + 36 + 14 - i, 14, i);
            context.drawGuiTexture(BURN_TEXTURE, 16, 16, 0, 16 - i , x + 56, y + 36 + 14 - i, 14, i);

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
        renderFlameProgress(context, x, y);

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
