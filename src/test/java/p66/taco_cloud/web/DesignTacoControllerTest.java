package p66.taco_cloud.web;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import p66.taco_cloud.Ingredient;
import p66.taco_cloud.data.IngredientRepository;

@WebMvcTest(DesignTacoController.class)
public class DesignTacoControllerTest {

    @MockitoBean
    private IngredientRepository ingredientRepo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldDisplayDesignForm() throws Exception {

        mockMvc.perform(get("/design"))
                .andExpect(status().isOk())
                .andExpect(view().name("design"))
                .andExpect(model().attributeExists("taco"))
                .andExpect(model().attributeExists("tacoOrder"))
                .andExpect(model().attributeExists("wrap"))
                .andExpect(model().attributeExists("protein"))
                .andExpect(model().attributeExists("veggies"))
                .andExpect(model().attributeExists("cheese"))
                .andExpect(model().attributeExists("sauce"))
                .andExpect(content().string(
                        containsString("Design your taco!")));
    }
}