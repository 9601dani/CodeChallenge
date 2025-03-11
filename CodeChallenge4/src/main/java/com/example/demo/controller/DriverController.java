package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.DriverRequest;
import com.example.demo.service.DriverService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/driver")
@AllArgsConstructor
@Getter
@Setter
public class DriverController {
    
    private final DriverService driverService;

    @GetMapping("")
    public String helloWorld() {
        return "Hello World from Api!";
    }

    @PostMapping("/save")
    public ResponseEntity<DriverDTO> save(@RequestBody DriverRequest request){
        DriverDTO driverDTO = this.driverService.saveDriver(request.name(), request.age());
        return ResponseEntity.status(HttpStatus.OK).body(driverDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DriverDTO>> findAll() {
        List<DriverDTO> listDriver = this.driverService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listDriver);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<DriverDTO> putMethodName(@PathVariable Integer id, @RequestBody DriverRequest request) {
        DriverDTO driverDTO = this.driverService.updateDriver(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(driverDTO);
    }
    
    
    
}
