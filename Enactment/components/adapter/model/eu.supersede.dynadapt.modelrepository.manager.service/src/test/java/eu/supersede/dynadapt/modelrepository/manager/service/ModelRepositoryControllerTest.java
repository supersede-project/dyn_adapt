package eu.supersede.dynadapt.modelrepository.manager.service;

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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import eu.supersede.dynadapt.modelrepository.manager.service.Application;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    
    /**
     * This test creates a new base model using an UML file and escaping
     * the \"\ character properly by changing it to \'\
     * @throws Exception
     */
<<<<<<< HEAD
    @Test
    public void createAndGetBaseModel() throws Exception {
    	File f = new File("");
		List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath() + "/src/test/java/eu/supersede/dynadapt/modelrepository/manager/service/MonitoringSystemBaseModel.uml"), StandardCharsets.UTF_8);
		String content = "";
		for (String s : lines) content += s + "\n";
		content = content.replace("\"","'");
		
		JsonArray array = new JsonArray();
		JsonObject model = new JsonObject();
		model.addProperty("name", "googleplay_api_googleplay_tool");
        model.addProperty("authorId", "service-test");
        model.addProperty("creationDate", "2016-10-13 12:54:21.0");
        model.addProperty("lastModificationDate", "2016-10-20 16:22:01.0");
        model.addProperty("fileExtension", ".aspect");
        model.addProperty("systemId", "MonitoringReconfiguration");
        model.addProperty("featureId", "GooglePlay");
        model.addProperty("modelContent", content);
        array.add(model);
        
		JsonObject json = new JsonObject();
		json.addProperty("sender", "Adapter");
		json.addProperty("timeStamp", "2016-10-20T20:10:30:201");
		json.add("modelInstances", array);
		
		mockMvc.perform(post("/models/AdaptabilityModel")
				.content(json.toString())
				.contentType(contentType))
				.andExpect(status().isCreated());
    }
    
=======
>>>>>>> multimodel-saver-loader
    /*@Test
    public void createAndGetBaseModel() throws Exception {
    	File f = new File("");
		List<String> lines = Files.readAllLines(Paths.get(f.getAbsolutePath() + "/src/test/java/eu/supersede/dynadapt/modelrepository/manager/service/MonitoringSystemBaseModel.uml"), StandardCharsets.UTF_8);
		String content = "";
		for (String s : lines) content += s + "\n";
		content = content.replace("\"","'");
		
		JsonArray array = new JsonArray();
		JsonObject model = new JsonObject();
		model.addProperty("name", "googleplay_api_googleplay_tool");
        model.addProperty("authorId", "service-test");
        model.addProperty("creationDate", "2016-10-13 12:54:21.0");
        model.addProperty("lastModificationDate", "2016-10-20 16:22:01.0");
        model.addProperty("fileExtension", ".aspect");
        model.addProperty("systemId", "MonitoringReconfiguration");
        model.addProperty("featureId", "GooglePlay");
        model.addProperty("modelContent", content);
        array.add(model);
        
		JsonObject json = new JsonObject();
		json.addProperty("sender", "Adapter");
		json.addProperty("timeStamp", "2016-10-20T20:10:30:201");
		json.add("modelInstances", array);
		
		mockMvc.perform(post("/models/AdaptabilityModel")
				.content(json.toString())
				.contentType(contentType))
				.andExpect(status().isCreated());
    }*/
    
    @Test
    public void listModels() throws Exception {
    	mockMvc.perform(get("/models/AdaptabilityModel"))
    			.andExpect(status().isOk());
    }
    
    /*@Test
    public void getModel() throws Exception {
    	mockMvc.perform(get("/models/AdaptabilityModel/1"))
    			.andExpect(status().isOk());
    }*/
    
    /*@Test
    public void createModel() throws Exception {
    	mockMvc.perform(post("/models/AdaptabilityModel")
    			.content(new JsonObject().toString())
    			.contentType(contentType))
    			.andExpect(status().isCreated());
    }*/
    
    /*@Test
    public void updateModel() throws Exception {
    	mockMvc.perform(put("/models/AdaptabilityModel/1")
    			.content(new JsonObject().toString())
    			.contentType(contentType))
    			.andExpect(status().isOk());
    }*/
    
    /*@Test
    public void deleteModel() throws Exception {
    	mockMvc.perform(delete("/models/AdaptabilityModel/1"))
    			.andExpect(status().isOk())
    			.andExpect(jsonPath("$.error", is("DELETE")));
    }*/

}