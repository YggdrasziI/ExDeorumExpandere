package net.yggdraszil.edexpandere.menu.mechanicalhammers;

import net.yggdraszil.edexpandere.block.mechanicalhammers.NetheriteMechanicalHammerBlockEntity;
import net.yggdraszil.edexpandere.config.ExpandereConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.Nullable;
import thedarkcolour.exdeorum.ExDeorum;
import thedarkcolour.exdeorum.client.screen.RedstoneControlWidget;

public class NetheriteMechanicalHammerScreen extends AbstractContainerScreen<NetheriteMechanicalHammerMenu> {
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ExDeorum.ID, "textures/gui/container/mechanical_hammer.png");

    public static final int RECIPE_CLICK_AREA_POS_X = 80;
    public static final int RECIPE_CLICK_AREA_POS_Y = 34;
    public static final int RECIPE_CLICK_AREA_WIDTH = 23;
    public static final int RECIPE_CLICK_AREA_HEIGHT = 16;

    private @Nullable RedstoneControlWidget redstoneControlWidget;

    public NetheriteMechanicalHammerScreen(NetheriteMechanicalHammerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);

        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();

        this.redstoneControlWidget = new RedstoneControlWidget(this.menu, BACKGROUND_TEXTURE, this.leftPos + this.imageWidth, this.topPos + 3);
        this.addRenderableWidget(this.redstoneControlWidget);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float pPartialTick, int pMouseX, int pMouseY) {
        int left = this.leftPos;
        int top = this.topPos;
        graphics.blit(BACKGROUND_TEXTURE, left, top, 0, 0, this.imageWidth, this.imageHeight);

        //Energy Bar
        int energy = Mth.floor(54.0F * ((float)this.menu.getEnergy() / (float) ExpandereConfig.netherite_mechanical_hammer_energyStorage));
        graphics.blit(BACKGROUND_TEXTURE, left + 10, top + 15 + 54 - energy, this.imageWidth, 70 - energy, 12, energy);

        //Progress Bar
        int progress = Mth.ceil(23.0F * ((float)this.menu.getProgress() / (float) NetheriteMechanicalHammerBlockEntity.TOTAL_PROGRESS));
        graphics.blit(BACKGROUND_TEXTURE, left + RECIPE_CLICK_AREA_POS_X, top + RECIPE_CLICK_AREA_POS_Y, this.imageWidth, 0, progress, 16);
    }

    @Override
    public void render(GuiGraphics graphics, int mx, int my, float pPartialTick) {
        this.renderBackground(graphics);
        super.render(graphics, mx, my, pPartialTick);
        this.renderTooltip(graphics, mx, my);

        int rx = mx - this.leftPos;
        int ry = my - this.topPos;

        if (9 <= rx && rx < 23 && 14 <= ry && ry < 70) {
            MutableComponent energyTooltip = Component.translatable("gui.edexpandere.energy_label")
                    .append(Component.translatable("item.edexpandere.energy_display", this.menu.getEnergy(), ExpandereConfig.netherite_mechanical_hammer_energyStorage))
                    .append(" FE");
            graphics.renderTooltip(Minecraft.getInstance().font, energyTooltip, mx, my);
        }
    }
}
