package net.yggdraszil.edexpandere.datagen;

import net.yggdraszil.edexpandere.EDExpandere;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output)
    {
        super(output, EDExpandere.MOD_ID);
    }

    @Override
    protected void start()
    {
    }
}
