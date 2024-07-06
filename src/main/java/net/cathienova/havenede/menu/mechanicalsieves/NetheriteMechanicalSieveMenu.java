package net.cathienova.havenede.menu.mechanicalsieves;

import net.cathienova.havenede.block.mechanicalsieves.NetheriteMechanicalSieveBlockEntity;
import net.cathienova.havenede.menu.ModMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import thedarkcolour.exdeorum.menu.AbstractMachineMenu;

public class NetheriteMechanicalSieveMenu extends AbstractMachineMenu<NetheriteMechanicalSieveBlockEntity> {
    private static final ResourceLocation EMPTY_SLOT_MESH = new ResourceLocation("exdeorum", "item/empty_slot_mesh");
    private static final int NUM_SLOTS = 22;

    public NetheriteMechanicalSieveMenu(int containerId, Inventory playerInventory, FriendlyByteBuf data) {
        this(containerId, playerInventory, (NetheriteMechanicalSieveBlockEntity) readPayload(playerInventory, data));
    }

    public NetheriteMechanicalSieveMenu(int containerId, Inventory playerInventory, NetheriteMechanicalSieveBlockEntity sieve) {
        super(ModMenu.NETHERITE_MECHANICAL_SIEVE.get(), containerId, playerInventory, sieve);
        this.addSlot(sieve.inventory.createSlot(0, 26, 30));
        this.addSlot(sieve.inventory.createSlot(1, 26, 53).setBackground(InventoryMenu.BLOCK_ATLAS, EMPTY_SLOT_MESH));

        for (int r = 0; r < 4; ++r) {
            for (int c = 0; c < 5; ++c) {
                this.addSlot(sieve.inventory.createSlot(2 + r * 5 + c, 80 + c * 18, 15 + r * 18));
            }
        }

        this.addPlayerSlots(playerInventory, 91);
    }

    public ItemStack quickMoveStack(Player player, int clickedSlot) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = (Slot) this.slots.get(clickedSlot);
        if (slot.hasItem()) {
            ItemStack clickedStack = slot.getItem();
            stack = clickedStack.copy();
            if (clickedSlot > 1 && clickedSlot < 22) {
                if (!this.moveItemStackTo(clickedStack, 22, 58, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (clickedSlot < 2) {
                if (!this.moveItemStackTo(clickedStack, 22, 58, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.machine.getLogic().isValidInput(clickedStack)) {
                if (!this.moveItemStackTo(clickedStack, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.machine.getLogic().isValidMesh(clickedStack)) {
                if (!this.moveItemStackTo(clickedStack, 1, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (clickedSlot < 49) {
                if (!this.moveItemStackTo(clickedStack, 49, 58, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (clickedSlot < 58 && !this.moveItemStackTo(clickedStack, 22, 49, false)) {
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
}
