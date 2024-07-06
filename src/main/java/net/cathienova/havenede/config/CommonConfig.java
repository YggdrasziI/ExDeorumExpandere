package net.cathienova.havenede.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
    public final ForgeConfigSpec.IntValue golden_mechanical_hammer_speed;
    public final ForgeConfigSpec.IntValue golden_mechanical_hammer_energyConsumption;
    public final ForgeConfigSpec.IntValue golden_mechanical_hammer_energyStorage;
    public final ForgeConfigSpec.IntValue diamond_mechanical_hammer_speed;
    public final ForgeConfigSpec.IntValue diamond_mechanical_hammer_energyConsumption;
    public final ForgeConfigSpec.IntValue diamond_mechanical_hammer_energyStorage;
    public final ForgeConfigSpec.IntValue netherite_mechanical_hammer_speed;
    public final ForgeConfigSpec.IntValue netherite_mechanical_hammer_energyConsumption;
    public final ForgeConfigSpec.IntValue netherite_mechanical_hammer_energyStorage;
    public final ForgeConfigSpec.IntValue creative_mechanical_hammer_speed;
    public final ForgeConfigSpec.IntValue creative_mechanical_hammer_energyConsumption;
    public final ForgeConfigSpec.IntValue creative_mechanical_hammer_energyStorage;
    public final ForgeConfigSpec.DoubleValue golden_mechanical_sieve_speed;
    public final ForgeConfigSpec.IntValue golden_mechanical_sieve_energyConsumption;
    public final ForgeConfigSpec.IntValue golden_mechanical_sieve_energyStorage;
    public final ForgeConfigSpec.DoubleValue diamond_mechanical_sieve_speed;
    public final ForgeConfigSpec.IntValue diamond_mechanical_sieve_energyConsumption;
    public final ForgeConfigSpec.IntValue diamond_mechanical_sieve_energyStorage;
    public final ForgeConfigSpec.DoubleValue netherite_mechanical_sieve_speed;
    public final ForgeConfigSpec.IntValue netherite_mechanical_sieve_energyConsumption;
    public final ForgeConfigSpec.IntValue netherite_mechanical_sieve_energyStorage;
    public final ForgeConfigSpec.DoubleValue creative_mechanical_sieve_speed;
    public final ForgeConfigSpec.IntValue creative_mechanical_sieve_energyConsumption;
    public final ForgeConfigSpec.IntValue creative_mechanical_sieve_energyStorage;

    public CommonConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Golden Mechanical Hammer").push("golden_mechanical_hammer");
        golden_mechanical_hammer_speed = builder
                .comment("Adjust the speed of the mechanical hammer. Each value increases the hammer's efficiency by 0.1. For example, a Diamond Hammer takes 5 seconds to crush; setting the value to 10 will make it take 4 seconds.")
                .defineInRange("golden_mechanical_hammer_speed", 10, 0, Integer.MAX_VALUE);
        golden_mechanical_hammer_energyConsumption = builder
                .comment("The amount of FE/t a tick consumed by the mechanical hammer when crushing a block.")
                .defineInRange("golden_mechanical_hammer_energyConsumption", 40, 1, Integer.MAX_VALUE);
        golden_mechanical_hammer_energyStorage = builder
                .comment("The amount of FE the golden mechanical hammer can store.")
                .defineInRange("golden_mechanical_hammer_energyStorage", 60000, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Diamond Mechanical Hammer").push("diamond_mechanical_hammer");
        diamond_mechanical_hammer_speed = builder
                .comment("Adjust the speed of the mechanical hammer. Each value increases the hammer's efficiency by 0.1. For example, a Diamond Hammer takes 5 seconds to crush; setting the value to 10 will make it take 4 seconds.")
                .defineInRange("diamond_mechanical_hammer_speed", 25, 0, Integer.MAX_VALUE);
        diamond_mechanical_hammer_energyConsumption = builder
                .comment("The amount of FE/t a tick consumed by the mechanical hammer when crushing a block.")
                .defineInRange("diamond_mechanical_hammer_energyConsumption", 60, 1, Integer.MAX_VALUE);
        diamond_mechanical_hammer_energyStorage = builder
                .comment("The amount of FE the diamond mechanical hammer can store.")
                .defineInRange("diamond_mechanical_hammer_energyStorage", 100000, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Netherite Mechanical Hammer").push("netherite_mechanical_hammer");
        netherite_mechanical_hammer_speed = builder
                .comment("Adjust the speed of the mechanical hammer. Each value increases the hammer's efficiency by 0.1. For example, a Diamond Hammer takes 5 seconds to crush; setting the value to 10 will make it take 4 seconds.")
                .defineInRange("netherite_mechanical_hammer_speed", 50, 0, Integer.MAX_VALUE);
        netherite_mechanical_hammer_energyConsumption = builder
                .comment("The amount of FE/t a tick consumed by the mechanical hammer when crushing a block.")
                .defineInRange("netherite_mechanical_hammer_energyConsumption", 100, 1, Integer.MAX_VALUE);
        netherite_mechanical_hammer_energyStorage = builder
                .comment("The amount of FE the netherite mechanical hammer can store.")
                .defineInRange("netherite_mechanical_hammer_energyStorage", 150000, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Creative Mechanical Hammer").push("creative_mechanical_hammer");
        creative_mechanical_hammer_speed = builder
                .comment("Adjust the speed of the mechanical hammer. Each value increases the hammer's efficiency by 0.1. For example, a Diamond Hammer takes 5 seconds to crush; setting the value to 10 will make it take 4 seconds.")
                .defineInRange("creative_mechanical_hammer_speed", 1000, 0, Integer.MAX_VALUE);
        creative_mechanical_hammer_energyConsumption = builder
                .comment("The amount of FE/t a tick consumed by the mechanical hammer when crushing a block.")
                .defineInRange("creative_mechanical_hammer_energyConsumption", 1000, 1, Integer.MAX_VALUE);
        creative_mechanical_hammer_energyStorage = builder
                .comment("The amount of FE the creative mechanical hammer can store.")
                .defineInRange("creative_mechanical_hammer_energyStorage", 500000, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Golden Mechanical Sieve").push("golden_mechanical_sieve");
        golden_mechanical_sieve_speed = builder
                .comment("Adjust the speed of the mechanical sieve. The speed of Mechanical Sieve is 0.01.")
                .defineInRange("golden_mechanical_sieve_speed", 0.015f, 0.01f, Double.MAX_VALUE);
        golden_mechanical_sieve_energyConsumption = builder
                .comment("The amount of FE/t a tick consumed by the mechanical sieve when sifting.")
                .defineInRange("golden_mechanical_sieve_energyConsumption", 40, 1, Integer.MAX_VALUE);
        golden_mechanical_sieve_energyStorage = builder
                .comment("The amount of FE the golden mechanical sieve can store.")
                .defineInRange("golden_mechanical_sieve_energyStorage", 60000, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Diamond Mechanical Sieve").push("diamond_mechanical_sieve");
        diamond_mechanical_sieve_speed = builder
                .comment("Adjust the speed of the mechanical sieve. The speed of Mechanical Sieve is 0.01.")
                .defineInRange("diamond_mechanical_sieve_speed", 0.03f, 0.01f, Double.MAX_VALUE);
        diamond_mechanical_sieve_energyConsumption = builder
                .comment("The amount of FE/t a tick consumed by the mechanical sieve when sifting.")
                .defineInRange("diamond_mechanical_sieve_energyConsumption", 60, 1, Integer.MAX_VALUE);
        diamond_mechanical_sieve_energyStorage = builder
                .comment("The amount of FE the diamond mechanical sieve can store.")
                .defineInRange("diamond_mechanical_sieve_energyStorage", 100000, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Netherite Mechanical Sieve").push("netherite_mechanical_sieve");
        netherite_mechanical_sieve_speed = builder
                .comment("Adjust the speed of the mechanical sieve. The speed of Mechanical Sieve is 0.01.")
                .defineInRange("netherite_mechanical_sieve_speed", 0.05f, 0.01f, Double.MAX_VALUE);
        netherite_mechanical_sieve_energyConsumption = builder
                .comment("The amount of FE/t a tick consumed by the mechanical sieve when sifting.")
                .defineInRange("netherite_mechanical_sieve_energyConsumption", 100, 1, Integer.MAX_VALUE);
        netherite_mechanical_sieve_energyStorage = builder
                .comment("The amount of FE the netherite mechanical sieve can store.")
                .defineInRange("netherite_mechanical_sieve_energyStorage", 150000, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Creative Mechanical Sieve").push("creative_mechanical_sieve");
        creative_mechanical_sieve_speed = builder
                .comment("Adjust the speed of the mechanical sieve. The speed of Mechanical Sieve is 0.01.")
                .defineInRange("creative_mechanical_sieve_speed", 0.5f, 0.01f, Double.MAX_VALUE);
        creative_mechanical_sieve_energyConsumption = builder
                .comment("The amount of FE/t a tick consumed by the mechanical sieve when sifting.")
                .defineInRange("creative_mechanical_sieve_energyConsumption", 1000, 1, Integer.MAX_VALUE);
        creative_mechanical_sieve_energyStorage = builder
                .comment("The amount of FE the creative mechanical sieve can store.")
                .defineInRange("creative_mechanical_sieve_energyStorage", 500000, 1, Integer.MAX_VALUE);
        builder.pop();
    }
}
