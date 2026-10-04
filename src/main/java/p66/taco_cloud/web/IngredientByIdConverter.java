package p66.taco_cloud.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import p66.taco_cloud.Ingredient;
import p66.taco_cloud.data.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepo;

   public IngredientByIdConverter(IngredientRepository ingredientRepo) {
       this.ingredientRepo = ingredientRepo;
   }
       @Override
       public Ingredient convert(String id) {
            return ingredientRepo.findById(id).orElse(null);

        }


}
