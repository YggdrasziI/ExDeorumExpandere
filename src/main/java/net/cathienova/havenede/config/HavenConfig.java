package net.cathienova.havenede.config;

import net.cathienova.havenede.HavenEDE;
import net.minecraftforge.fml.config.ModConfig;

public class HavenConfig {
    public static int golden_mechanical_hammer_speed;
    public static int golden_mechanical_hammer_energyConsumption;
    public static int golden_mechanical_hammer_energyStorage;
    public static int diamond_mechanical_hammer_speed;
    public static int diamond_mechanical_hammer_energyConsumption;
    public static int diamond_mechanical_hammer_energyStorage;
    public static int netherite_mechanical_hammer_speed;
    public static int netherite_mechanical_hammer_energyConsumption;
    public static int netherite_mechanical_hammer_energyStorage;
    public static int creative_mechanical_hammer_speed;
    public static int creative_mechanical_hammer_energyConsumption;
    public static int creative_mechanical_hammer_energyStorage;

    public static double golden_mechanical_sieve_speed;
    public static int golden_mechanical_sieve_energyConsumption;
    public static int golden_mechanical_sieve_energyStorage;
    public static double diamond_mechanical_sieve_speed;
    public static int diamond_mechanical_sieve_energyConsumption;
    public static int diamond_mechanical_sieve_energyStorage;
    public static double netherite_mechanical_sieve_speed;
    public static int netherite_mechanical_sieve_energyConsumption;
    public static int netherite_mechanical_sieve_energyStorage;
    public static double creative_mechanical_sieve_speed;
    public static int creative_mechanical_sieve_energyConsumption;
    public static int creative_mechanical_sieve_energyStorage;

    public static void bake(ModConfig config) {
        golden_mechanical_hammer_speed = HavenEDE.c_config.golden_mechanical_hammer_speed.get();
        golden_mechanical_hammer_energyConsumption = HavenEDE.c_config.golden_mechanical_hammer_energyConsumption.get();
        golden_mechanical_hammer_energyStorage = HavenEDE.c_config.golden_mechanical_hammer_energyStorage.get();
        diamond_mechanical_hammer_speed = HavenEDE.c_config.diamond_mechanical_hammer_speed.get();
        diamond_mechanical_hammer_energyConsumption = HavenEDE.c_config.diamond_mechanical_hammer_energyConsumption.get();
        diamond_mechanical_hammer_energyStorage = HavenEDE.c_config.diamond_mechanical_hammer_energyStorage.get();
        netherite_mechanical_hammer_speed = HavenEDE.c_config.netherite_mechanical_hammer_speed.get();
        netherite_mechanical_hammer_energyConsumption = HavenEDE.c_config.netherite_mechanical_hammer_energyConsumption.get();
        netherite_mechanical_hammer_energyStorage = HavenEDE.c_config.netherite_mechanical_hammer_energyStorage.get();
        creative_mechanical_hammer_speed = HavenEDE.c_config.creative_mechanical_hammer_speed.get();
        creative_mechanical_hammer_energyConsumption = HavenEDE.c_config.creative_mechanical_hammer_energyConsumption.get();
        creative_mechanical_hammer_energyStorage = HavenEDE.c_config.creative_mechanical_hammer_energyStorage.get();
        golden_mechanical_sieve_speed = HavenEDE.c_config.golden_mechanical_sieve_speed.get();
        golden_mechanical_sieve_energyConsumption = HavenEDE.c_config.golden_mechanical_sieve_energyConsumption.get();
        golden_mechanical_sieve_energyStorage = HavenEDE.c_config.golden_mechanical_sieve_energyStorage.get();
        diamond_mechanical_sieve_speed = HavenEDE.c_config.diamond_mechanical_sieve_speed.get();
        diamond_mechanical_sieve_energyConsumption = HavenEDE.c_config.diamond_mechanical_sieve_energyConsumption.get();
        diamond_mechanical_sieve_energyStorage = HavenEDE.c_config.diamond_mechanical_sieve_energyStorage.get();
        netherite_mechanical_sieve_speed = HavenEDE.c_config.netherite_mechanical_sieve_speed.get();
        netherite_mechanical_sieve_energyConsumption = HavenEDE.c_config.netherite_mechanical_sieve_energyConsumption.get();
        netherite_mechanical_sieve_energyStorage = HavenEDE.c_config.netherite_mechanical_sieve_energyStorage.get();
        creative_mechanical_sieve_speed = HavenEDE.c_config.creative_mechanical_sieve_speed.get();
        creative_mechanical_sieve_energyConsumption = HavenEDE.c_config.creative_mechanical_sieve_energyConsumption.get();
        creative_mechanical_sieve_energyStorage = HavenEDE.c_config.creative_mechanical_sieve_energyStorage.get();
    }
}
