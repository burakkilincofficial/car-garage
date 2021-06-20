package com.vodafone.garage.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.vodafone.garage.entity.abstracts.model.VehicleType;
import com.vodafone.garage.entity.abstracts.model.dto.VehicleDTO;
import com.vodafone.garage.results.SuccessDataResult;
import com.vodafone.garage.service.abstracts.VehicleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = VehicleController.class)
@EnableWebMvc
public class VehicleControllerTest {

    private static final String OWNER = "Kerem Karaca";
    private static final String BASE_URL = "/api/vehicles";
    private static final String BANK_ACCOUNT = "/bank-account";
    private static final String SLASH = "/";
    private static final String ADD = "/add";


    private static final Long BANK_ACCOUNT_ID = 1L;
    private static final String ACCOUNT_NUMBER = "669-7788";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;
    @InjectMocks
    private VehicleController vehicleController;
    @MockBean
    private VehicleService vehicleService;
    @Autowired
    private WebApplicationContext wac;

    public VehicleControllerTest() {
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(vehicleController).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void addVehicle() throws Exception {
        VehicleDTO vehicleDTO = VehicleDTO
                .builder()
                .vehicleLicense("12")
                .vehicleColor("red")
                .vehicleType(VehicleType.CAR)
                .vehicleYear(1212)
                .id(15)
                .build();

        SuccessDataResult successDataResult = new SuccessDataResult();


        when(vehicleService.addVehicle(vehicleDTO)).thenReturn(successDataResult);
        mockMvc.perform(post(BASE_URL + ADD)
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(vehicleDTO)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public String asJsonString(final Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
