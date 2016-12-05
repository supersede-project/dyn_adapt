package eu.supersede.dynadapt.modelrepository.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ModelRepositoryControllerTest {


    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void getModel() throws Exception {
    	mockMvc.perform(get("/models/1"))
    			.andExpect(status().isOk())
    			.andExpect(jsonPath("$.status", is("GET")));
    }
    
    @Test
    public void createModel() throws Exception {
    	mockMvc.perform(post("/models")
    			.content(new JsonObject().toString())
    			.contentType(contentType))
    			.andExpect(status().isCreated())
    			.andExpect(jsonPath("$.status", is("POST")));
    }
    
    @Test
    public void updateModel() throws Exception {
    	mockMvc.perform(put("/models/1")
    			.content(new JsonObject().toString())
    			.contentType(contentType))
    			.andExpect(status().isOk())
    			.andExpect(jsonPath("$.status", is("PUT")));
    }
    
    @Test
    public void deleteModel() throws Exception {
    	mockMvc.perform(delete("/models/1"))
    			.andExpect(status().isOk())
    			.andExpect(jsonPath("$.status", is("DELETE")));
    }

}