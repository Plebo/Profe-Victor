package org.springframework.samples.petclinic.vet;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.assertj.core.util.Lists;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Test class for the {@link VetController}
 */
@RunWith(SpringRunner.class)
@WebMvcTest(VetController.class)
public class VetControllerTests {
    
    private static final int TEST_VET_ID = 30;
    private Vets vets1;
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VetRepository vets;

    @Before
    public void setup() {
        /*Vet james = new Vet();
        
        james.setFirstName("James");
        james.setLastName("Carter");
        james.setTelephone("9612594528");
        james.setBusiness_hours("12:13");        
        james.setId(30); 
        */
         vets1 = new Vets();                
        vets1.getVetList().addAll(this.vets.findAll());
        
    }
    
    @Test
    public void testShowVetList() throws Exception {
        mockMvc.perform(get("/vets.html"))
            .andExpect(status().isOk())
           .andExpect(model().attribute("vets", hasProperty("vetList", is(vets1))))
 /*           .andExpect(model().attribute("vets", hasProperty("firstName", is("James"))))
            .andExpect(model().attribute("vets", hasProperty("telephone", is("9612594528"))))
            .andExpect(model().attribute("vets", hasProperty("business_hours", is("12:13"))))            
*/
.andExpect(view().name("/vetList.html"));
    }


}
