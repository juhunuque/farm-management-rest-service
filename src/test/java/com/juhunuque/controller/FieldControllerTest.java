package com.juhunuque.controller;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FieldControllerTest {

    @Autowired
    private FieldController fieldController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(fieldController).isNotNull();
    }

    @Test
    public void shouldReturnSuccessfulStatus() throws Exception{
        this.mockMvc.perform(get("/field/v1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void whenFindByFieldName_thenReturnField() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fieldName", "Germany");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
        //Then
        .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void whenFindByFieldName_thenReturnEmpty() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fieldName", "Country that doesn't exist");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", is(0)));
    }

    @Test
    public void whenFindByFieldCropType_thenReturnField() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fieldCropType", "CROPTYPECATEGORY1");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void whenFindByFieldCropType_thenReturnEmpty() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fieldCropType", "Fake Crop Type");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", is(0)));
    }

    @Test
    public void whenFindByCoordinates_thenReturnField() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fieldLatitude", "52.520566");
        field.put("fieldLongitude", "13.420360");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void whenFindByCoordinates_thenReturnEmpty() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fieldLatitude", "48.864847");
        field.put("fieldLongitude", "2.361470");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", is(0)));
    }

    @Test
    public void whenFindByUserSpecialization_thenReturnField() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("userSpecialization", "SPECIALISATION1");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void whenFindByUserSpecialization_thenReturnEmpty() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("userSpecialization", "Fake specialisation");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", is(0)));
    }

    @Test
    public void whenFindByUserName_thenReturnField() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("userName", "Carlos");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void whenFindByUserName_thenReturnEmpty() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("userName", "Pepito");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", is(0)));
    }

    @Test
    public void whenFindByFcCloudinessInformation_thenReturnField() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fcCloudinessInformation", "Cloud Dummy 4");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void whenFindByFcCloudinessInformation_thenReturnEmpty() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fcCloudinessInformation", "Fake cloudiness information");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", is(0)));
    }

    @Test
    public void whenFindByFcTemperature_thenReturnField() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fcTemperature", 23);

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void whenFindByFcTemperature_thenReturnEmpty() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fcTemperature", 50);

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", is(0)));
    }

    @Test
    public void whenFindByFcVegetationInformation_thenReturnField() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fcCloudinessInformation", "Cloud Dummy 4");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void whenFindByFcVegetationInformation_thenReturnEmpty() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fcCloudinessInformation", "Fake cloud entry");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", is(0)));
    }

    @Test
    public void whenFindByBetweenDates_thenReturnField() throws Exception{
        String todayDate = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());

        // Given
        JSONObject field = new JSONObject();
        field.put("fcDateFrom", todayDate);
        field.put("fcDateTo", todayDate);

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", greaterThan(0)));
    }

    @Test
    public void whenFindByBetweenDates_thenReturnEmpty() throws Exception{
        // Given
        JSONObject field = new JSONObject();
        field.put("fcDateFrom", "2019-01-01");
        field.put("fcDateTo", "2019-01-04");

        // When
        this.mockMvc.perform(post("/field/v1/find")
                .contentType(MediaType.APPLICATION_JSON)
                .content(field.toJSONString()))
                .andExpect(status().isOk())
                //Then
                .andExpect(jsonPath("$.length()", is(0)));
    }
}
