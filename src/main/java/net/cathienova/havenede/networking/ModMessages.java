package net.cathienova.havenede.networking;

import net.cathienova.havenede.HavenEDE;
import net.cathienova.havenede.networking.packet.HammerDataSyncPacket;
import net.cathienova.havenede.networking.packet.SieveDataSyncPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    public static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(HavenEDE.MOD_ID, "main"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(SieveDataSyncPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(SieveDataSyncPacket::new)
                .encoder(SieveDataSyncPacket::toBytes)
                .consumerMainThread(SieveDataSyncPacket::handle)
                .add();

        net.messageBuilder(HammerDataSyncPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(HammerDataSyncPacket::new)
                .encoder(HammerDataSyncPacket::toBytes)
                .consumerMainThread(HammerDataSyncPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static <MSG> void sendToClients(MSG message) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), message);
    }
}
