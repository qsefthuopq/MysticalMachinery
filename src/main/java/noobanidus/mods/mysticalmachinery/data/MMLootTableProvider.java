package noobanidus.mods.mysticalmachinery.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import epicsquid.mysticallib.data.DeferredBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootParameterSet;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.ValidationResults;
import net.minecraftforge.fml.RegistryObject;
import noobanidus.mods.mysticalmachinery.MysticalMachinery;
import noobanidus.mods.mysticalmachinery.blocks.MachineFrameBlock;
import noobanidus.mods.mysticalmachinery.init.ModBlocks;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings("ConstantConditions")
public class MMLootTableProvider extends LootTableProvider {
  public MMLootTableProvider(DataGenerator dataGeneratorIn) {
    super(dataGeneratorIn);
  }

  @Override
  public String getName() {
    return "Mystical Machinery Loot Table Provider";
  }

  @Override
  protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
    return ImmutableList.of(Pair.of(Blocks::new, LootParameterSets.BLOCK));
  }

  @Override
  protected void validate(Map<ResourceLocation, LootTable> map, ValidationResults validationresults) {
  }

  public static class Blocks extends DeferredBlockLootTableProvider {
    @Override
    protected void addTables() {
      self(ModBlocks.KILN);
      self(ModBlocks.COOKIE_GENERATOR);

      for (RegistryObject<MachineFrameBlock> block : ModBlocks.MACHINE_FRAMES.values()) {
        self(block);
      }

      self(ModBlocks.STORED_HEAT_GENERATOR);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
      return MysticalMachinery.REGISTRY.getBlocks().stream().map(Supplier::get).collect(Collectors.toList());
    }
  }
}
