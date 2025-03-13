package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DriverDTO;
import com.example.demo.dto.DriverRequest;
import com.example.demo.exeption.NotSavedException;
import com.example.demo.exeption.NotUpdateException;
import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Service
@AllArgsConstructor
@Getter
@Setter
public class DriverService {
    private DriverRepository driverRepository;

    public DriverDTO saveDriver(String name, Integer age){
        Optional<Driver> nDriver = this.driverRepository.findByName(name);

        if(nDriver.isPresent()){
            throw new NotSavedException("Duplicated name");
        }

        Driver d = new Driver(null, name, age);

        Driver saved = this.driverRepository.save(d);

        return new DriverDTO(saved);
    }

    public DriverDTO updateDriver (Integer id, DriverRequest driver){
        Optional<Driver> nDriver = this.driverRepository.findById(id);

        if (nDriver.isEmpty()){
            throw new NotUpdateException("Driver not exist");
        }

        Driver d = nDriver.get();

        d.setName(driver.name());
        d.setAge(driver.age());

        this.driverRepository.save(d);

        return new DriverDTO(d);
    }

    public List<DriverDTO> findAll(){
        List<Driver> driver = this.driverRepository.findAll();

        return driver.stream().map(DriverDTO::new).toList();
    }

    public DriverDTO deleteDriver(Integer id) {
        Optional<Driver> driverOptional = this.driverRepository.findById(id);

        if(driverOptional.isEmpty()) {
            throw new NotUpdateException("Driver not found");
        }

        Driver driver = driverOptional.get();

        Driver driverDeleted = this.driverRepository.save(driver);

        return new DriverDTO(driverDeleted);
    } 


}
