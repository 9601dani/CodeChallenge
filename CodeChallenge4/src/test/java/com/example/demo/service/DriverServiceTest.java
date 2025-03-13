package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.DriverRequest;
import com.example.demo.exeption.NotSavedException;
import com.example.demo.exeption.NotUpdateException;
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;

public class DriverServiceTest {
    @InjectMocks
    private DriverService driverService;

    @Mock
    private DriverRepository driverRepository;

    DriverRequest request;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void testSaveDriver() {
        //Given
        request = new DriverRequest("test name", 20);

        // When
        Driver driver = new Driver(1, "test name", 20);
        when(this.driverRepository.save(any(Driver.class))).thenReturn(driver);

        // Then
        DriverDTO expected = new DriverDTO(driver);

        DriverDTO actual = this.driverService.saveDriver(request.name(), request.age());

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotSave() {
        //Given
        request = new DriverRequest("test name", 20);

        // When
        Driver driver = new Driver(1, "test name", 20);
        when(this.driverRepository.findByName("test name")).thenReturn(Optional.of(driver));

        // Then
        Exception exception = assertThrows(NotSavedException.class, () -> {
            this.driverService.saveDriver(request.name(), request.age());
        });

        String expectedMessage = "Duplicated name";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
        
    }

    @Test 
    void shouldFindAll() {
        //Given

        // When
        Driver driver = new Driver(1, "test name", 20);
        when(this.driverRepository.findAll()).thenReturn(List.of(driver));

        // Then
        List<DriverDTO> expected = List.of(new DriverDTO(driver));

        List<DriverDTO> actual = this.driverService.findAll();

        assertEquals(expected, actual);
    }

    @Test
    void shouldUpdateDriver() {
        // Given
        DriverRequest request = new DriverRequest("updated name", 25);
        Driver existingDriver = new Driver(1, "test name", 20);
    
        when(driverRepository.findById(1)).thenReturn(Optional.of(existingDriver));
        when(driverRepository.save(any(Driver.class))).thenReturn(existingDriver);
    
        // When
        DriverDTO updatedDriver = driverService.updateDriver(1, request);
    
        // Then
        assertNotNull(updatedDriver);
        assertEquals(1, updatedDriver.id());
        assertEquals("updated name", updatedDriver.name());
        assertEquals(25, updatedDriver.age());
        verify(driverRepository).save(any(Driver.class));
    }

    @Test
    void shouldDeleteADriver() {
        // Given
        Driver driver = new Driver(1, "test name", 25);

        // When
        when(this.driverRepository.findById(1)).thenReturn(Optional.of(driver));
        when(this.driverRepository.save(any(Driver.class))).thenReturn(driver);
        
        
        DriverDTO expected = new DriverDTO(driver);

        DriverDTO actual = this.driverService.deleteDriver(1);

        // Then
        assertEquals(expected, actual);


    }

    @Test
    void shouldNotFindIdToDelete() {

        // When
        when(this.driverRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(NotUpdateException.class, () -> {
            this.driverService.deleteDriver(1);
        });

        String expectedMessage = "Driver not found";
        String actualMessage = exception.getMessage();

        // Then
        assertEquals(expectedMessage, actualMessage);


    }
}
