package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.DriverRequest;
import com.example.demo.model.Driver;
import com.example.demo.service.DriverService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DriverController.class)
public class DriverControllerTest {

    @MockitoBean
    private DriverService driverService;

    @Autowired
    private MockMvc mockMvc;

    private DriverDTO driverDTO;
    private List<DriverDTO> list;

    @BeforeEach 
    void setUp(){
        driverDTO = new DriverDTO(new Driver(1,"test name", 20));
        list = List.of(driverDTO);
    }

    @Test
    void testHelloWorld() throws Exception{
        mockMvc.perform(get("/api/driver"))
            .andExpect(status().isOk());
    }

    @Test
    void testSave() throws Exception{
       // DriverRequest request = new DriverRequest("test name", 20);
        String json = "{\"name\": \"test name\", \"age\": 20}";

        when(driverService.saveDriver("test name", 20)).thenReturn(driverDTO);

        mockMvc.perform(post("/api/driver/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isOk());
    }

    @Test
    void testShouldFindAll() throws Exception {
        when(driverService.saveDriver("test name", 20)).thenReturn(driverDTO);

        mockMvc.perform(get("/api/driver/all"))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdate() throws Exception {
        int driverId = 1;
        String json = "{\"name\": \"updated name\", \"age\": 25}";

        when(driverService.updateDriver(eq(driverId), any(DriverRequest.class))).thenReturn(driverDTO);

        mockMvc.perform(put("/api/driver/update/{id}", driverId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isOk());
    }
    
}
