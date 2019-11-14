package noobanidus.mods.mysticalmachinery.init;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import noobanidus.mods.mysticalmachinery.MysticalMachinery;
import noobanidus.mods.mysticalmachinery.recipes.KilnRecipe;
import static noobanidus.mods.mysticalmachinery.MysticalMachinery.REGISTRY;
import java.util.function.Supplier;

public class ModRecipes {
  public static final IRecipeType<KilnRecipe> KILN_TYPE = IRecipeType.register(new ResourceLocation(MysticalMachinery.MODID, "kiln").toString());

  public static final RegistryObject<IRecipeSerializer<KilnRecipe>> KILN_SERIALIZER = REGISTRY.registerRecipeSerializer("kiln", KilnRecipe.Serializer::new);

  public static void load () {

  }
}
