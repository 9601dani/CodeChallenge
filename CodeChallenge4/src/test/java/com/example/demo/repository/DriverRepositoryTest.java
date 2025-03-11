package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.model.Driver;

public class DriverRepositoryTest {

    @Mock
    private DriverRepository driverRepository;
    private Driver driver;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShouldSaveADriver(){
        Driver driverExpected = new Driver(1,"test name", 20);

        driver = new Driver(null, "test name", 20);

        when(this.driverRepository.save(driver)).thenReturn(driverExpected);
        Driver actualDriver = this.driverRepository.save(driver);

        String expectedName = "test name";
        assertNotNull(actualDriver);
        assertEquals(expectedName, actualDriver.getName());
        assertEquals(expectedName, actualDriver);
    }

    @Test 
    void testShouldListAll(){
        Driver driverExpected = new Driver(1, "test name",20);

        driver = new Driver(null, "test name", 20);

        when(this.driverRepository.save(driver)).thenReturn(driverExpected);
        when(this.driverRepository.findAll()).thenReturn(List.of(driverExpected));
        this.driverRepository.save(driver);

        List<Driver> expectedList = List.of(driverExpected);
        List<Driver> actualList = this.driverRepository.findAll();

        assertEquals(expectedList, actualList);
    }

    @Test
    void testShouldUpdateDriver(){
        Driver driverExpected = new Driver(1,"other name", 20);

        driver = new Driver(1, "test name", 20);

        when(this.driverRepository.save(driver)).thenReturn(driverExpected);
        Driver actualDriver = this.driverRepository.save(driver);

        String expectedName = "other name";
        assertNotNull(actualDriver);
        assertEquals(expectedName, actualDriver.getName());
        assertEquals(driverExpected, actualDriver);
    }
    
}
