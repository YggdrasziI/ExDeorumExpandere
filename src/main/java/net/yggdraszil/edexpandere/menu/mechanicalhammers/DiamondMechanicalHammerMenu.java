package net.yggdraszil.edexpandere.menu.mechanicalhammers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ObjectHolder;
import net.yggdraszil.edexpandere.block.mechanicalhammers.DiamondMechanicalHammerBlockEntity;
import thedarkcolour.exdeorum.menu.AbstractMachineMenu;
import thedarkcolour.exdeorum.tag.EItemTags;

public class DiamondMechanicalHammerMenu extends AbstractMachineMenu<DiamondMechanicalHammerBlockEntity> {
    private static final ResourceLocation EMPTY_SLOT_HAMMER = new ResourceLocation("exdeorum", "item/empty_slot_hammer");
    private static final int NUM_SLOTS = 3;

    @ObjectHolder(registryName = "minecraft:menu", value = "edexpandere:diamond_mechanical_hammer")
    public static final MenuType<DiamondMechanicalHammerMenu> DIAMOND_MECHANICAL_HAMMER = null;

    public DiamondMechanicalHammerMenu(int containerId, Inventory playerInventory, FriendlyByteBuf data) {
        this(containerId, playerInventory, (DiamondMechanicalHammerBlockEntity) readPayload(playerInventory, data));
    }

    public DiamondMechanicalHammerMenu(int containerId, Inventory playerInventory, DiamondMechanicalHammerBlockEntity machine) {
        super(DIAMOND_MECHANICAL_HAMMER, containerId, playerInventory, machine);
        this.addSlot(machine.inventory.createSlot(0, 32, 35));
        this.addSlot(machine.inventory.createSlot(1, 56, 35).setBackground(InventoryMenu.BLOCK_ATLAS, EMPTY_SLOT_HAMMER));
        this.addSlot(machine.inventory.createSlot(2, 116, 35));
        this.addPlayerSlots(playerInventory, 84);
        this.addDataSlot(new ProgressDataSlot());
        this.addDataSlot(new EnergyDataSlot());
        this.addDataSlot(new RedstoneModeDataSlot());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int clickedSlot) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(clickedSlot);
        if (slot.hasItem()) {
            ItemStack clickedStack = slot.getItem();
            stack = clickedStack.copy();
            if (clickedSlot > 1 && clickedSlot < 3) {
                if (!this.moveItemStackTo(clickedStack, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (clickedSlot < 2) {
                if (!this.moveItemStackTo(clickedStack, 3, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (DiamondMechanicalHammerBlockEntity.isValidInput(clickedStack)) {
                if (!this.moveItemStackTo(clickedStack, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (clickedStack.is(EItemTags.HAMMERS)) {
                if (!this.moveItemStackTo(clickedStack, 1, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (clickedSlot < 30) {
                if (!this.moveItemStackTo(clickedStack, 30, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (clickedSlot < 39 && !this.moveItemStackTo(clickedStack, 3, 30, false)) {
                return ItemStack.EMPTY;
            }

            if (clickedStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (clickedStack.getCount() == stack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, clickedStack);
            this.broadcastChanges();
        }

        return stack;
    }

    private class ProgressDataSlot extends DataSlot {
        @Override
        public int get() {
            return DiamondMechanicalHammerMenu.this.machine.getProgress();
        }

        @Override
        public void set(int value) {
            DiamondMechanicalHammerMenu.this.machine.setProgress(value);
        }
    }

    private class EnergyDataSlot extends DataSlot {
        @Override
        public int get() {
            return DiamondMechanicalHammerMenu.this.machine.getEnergyStored();
        }

        @Override
        public void set(int value) {
            DiamondMechanicalHammerMenu.this.machine.energy.setStoredEnergy(value);
        }
    }

    private class RedstoneModeDataSlot extends DataSlot {
        @Override
        public int get() {
            return DiamondMechanicalHammerMenu.this.machine.getRedstoneMode();
        }

        @Override
        public void set(int value) {
            DiamondMechanicalHammerMenu.this.machine.setRedstoneMode(value);
        }
    }

    public int getProgress() {
        return this.machine.getProgress();
    }

    public int getEnergy() {
        return this.machine.getEnergyStored();
    }
}
