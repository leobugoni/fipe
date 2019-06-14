package io.github.leobugoni;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
public class CustomErrorControllerTest extends ControllerIntegration{

    @Test
    public void testErrorRoute() throws Exception {
        final MvcResult result = getMockMvc()
                .perform(get("/error"))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }
}
