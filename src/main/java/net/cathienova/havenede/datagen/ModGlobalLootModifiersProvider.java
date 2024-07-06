package net.cathienova.havenede.datagen;

import net.cathienova.havenede.HavenEDE;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output)
    {
        super(output, HavenEDE.MOD_ID);
    }

    @Override
    protected void start()
    {
    }
}
