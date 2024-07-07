package net.cathienova.havenede.networking.packet;

import net.cathienova.havenede.block.mechanicalhammers.*;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class HammerDataSyncPacket {
    private final int energy;
    private final int progress;
    private final BlockPos pos;

    public HammerDataSyncPacket(int energy, int progress, BlockPos pos) {
        this.energy = energy;
        this.progress = progress;
        this.pos = pos;
    }

    public HammerDataSyncPacket(FriendlyByteBuf buf) {
        this.energy = buf.readInt();
        this.progress = buf.readInt();
        this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(energy);
        buf.writeInt(progress);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof GoldenMechanicalHammerBlockEntity blockEntity) {
                blockEntity.setProgress(progress);
                blockEntity.energy.setStoredEnergy(energy);
            }
            else if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof DiamondMechanicalHammerBlockEntity blockEntity) {
                blockEntity.setProgress(progress);
                blockEntity.energy.setStoredEnergy(energy);
            }
            else if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof NetheriteMechanicalHammerBlockEntity blockEntity) {
                blockEntity.setProgress(progress);
                blockEntity.energy.setStoredEnergy(energy);
            }
            else if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof CreativeMechanicalHammerBlockEntity blockEntity) {
                blockEntity.setProgress(progress);
                blockEntity.energy.setStoredEnergy(energy);
            }
        });
        return true;
    }
}
