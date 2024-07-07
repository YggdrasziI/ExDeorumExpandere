package net.cathienova.havenede.networking.packet;

import net.cathienova.havenede.block.mechanicalsieves.CreativeMechanicalSieveBlockEntity;
import net.cathienova.havenede.block.mechanicalsieves.DiamondMechanicalSieveBlockEntity;
import net.cathienova.havenede.block.mechanicalsieves.GoldenMechanicalSieveBlockEntity;
import net.cathienova.havenede.block.mechanicalsieves.NetheriteMechanicalSieveBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import thedarkcolour.exdeorum.blockentity.helper.EnergyHelper;

import java.util.function.Supplier;

public class SieveDataSyncPacket {
    private final int energy;
    private final float progress;
    private final BlockPos pos;

    public SieveDataSyncPacket(int energy, float progress, BlockPos pos) {
        this.energy = energy;
        this.progress = progress;
        this.pos = pos;
    }

    public SieveDataSyncPacket(FriendlyByteBuf buf) {
        this.energy = buf.readInt();
        this.progress = buf.readFloat();
        this.pos = buf.readBlockPos();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(energy);
        buf.writeFloat(progress);
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof GoldenMechanicalSieveBlockEntity blockEntity) {
                blockEntity.getLogic().setProgress(progress);
                blockEntity.getEnergyHelper().setStoredEnergy(energy);
            } else if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof CreativeMechanicalSieveBlockEntity blockEntity) {
                blockEntity.getLogic().setProgress(progress);
                blockEntity.getEnergyHelper().setStoredEnergy(energy);
            } else if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof DiamondMechanicalSieveBlockEntity blockEntity) {
                blockEntity.getLogic().setProgress(progress);
                blockEntity.getEnergyHelper().setStoredEnergy(energy);
            } else if (Minecraft.getInstance().level.getBlockEntity(pos) instanceof NetheriteMechanicalSieveBlockEntity blockEntity) {
                blockEntity.getLogic().setProgress(progress);
                blockEntity.getEnergyHelper().setStoredEnergy(energy);
            }
        });
        return true;
    }
}
