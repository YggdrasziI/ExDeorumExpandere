package net.cathienova.havenede.menu.mechanicalsieves;

import net.cathienova.havenede.block.mechanicalsieves.DiamondMechanicalSieveBlockEntity;
import net.cathienova.havenede.config.HavenConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.Nullable;
import thedarkcolour.exdeorum.client.screen.RedstoneControlWidget;

public class DiamondMechanicalSieveScreen extends AbstractContainerScreen<DiamondMechanicalSieveMenu> {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("exdeorum", "textures/gui/container/mechanical_sieve.png");
    public static final int RECIPE_CLICK_AREA_POS_X = 51;
    public static final int RECIPE_CLICK_AREA_POS_Y = 42;
    public static final int RECIPE_CLICK_AREA_WIDTH = 21;
    public static final int RECIPE_CLICK_AREA_HEIGHT = 14;
    private @Nullable RedstoneControlWidget redstoneControlWidget;

    public DiamondMechanicalSieveScreen(DiamondMechanicalSieveMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 173;
        this.inventoryLabelY += 7;
    }

    protected void init() {
        super.init();
        this.redstoneControlWidget = new RedstoneControlWidget(this.menu, BACKGROUND_TEXTURE, this.leftPos + this.imageWidth, this.topPos + 3);
        this.addRenderableWidget(this.redstoneControlWidget);
    }

    public @Nullable RedstoneControlWidget getRedstoneControlWidget() {
        return this.redstoneControlWidget;
    }

    protected void renderBg(GuiGraphics graphics, float partialTick, int mX, int mY) {
        int left = this.leftPos;
        int top = this.topPos;
        graphics.blit(BACKGROUND_TEXTURE, left, top, 0, 0, this.imageWidth, this.imageHeight);
        int energy = Mth.floor(54.0F * ((float) this.menu.prevEnergy / (float) HavenConfig.diamond_mechanical_sieve_energyStorage));
        graphics.blit(BACKGROUND_TEXTURE, left + 10, top + 22 + 54 - energy, this.imageWidth, 68 - energy, 12, energy);
        int progress = Math.min(21, (int) (((DiamondMechanicalSieveBlockEntity) this.menu.machine).getLogic().getProgress() * 22.0F));
        graphics.blit(BACKGROUND_TEXTURE, left + 51, top + 42, this.imageWidth, 0, progress, 14);
    }

    public void render(GuiGraphics graphics, int mx, int my, float partialTicks) {
        this.renderBackground(graphics);
        super.render(graphics, mx, my, partialTicks);
        this.renderTooltip(graphics, mx, my);
        int rx = mx - this.leftPos;
        int ry = my - this.topPos;
        if (9 <= rx && rx < 23 && 21 <= ry && ry < 77) {
            MutableComponent energyTooltip = Component.translatable("gui.havenede.energy_label").append(Component.translatable("item.havenede.energy_display", this.menu.prevEnergy, HavenConfig.diamond_mechanical_sieve_energyStorage)).append(" FE");
            graphics.renderTooltip(Minecraft.getInstance().font, energyTooltip, mx, my);
        }
    }
}
