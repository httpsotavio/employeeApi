package com.Api.employeeApi.controllers;

import com.Api.employeeApi.dtos.employeeDto;
import com.Api.employeeApi.models.employeeModel;
import com.Api.employeeApi.services.employeeService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 1600)
@RequestMapping(value = "/employee")
public class employeeController {
    final employeeService employeeService;

    public employeeController(com.Api.employeeApi.services.employeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Object> saveEmployee(@RequestBody @Valid employeeDto employeeDto) {
        var employeeModel = new employeeModel();
        BeanUtils.copyProperties(employeeDto, employeeModel);
        employeeModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeModel));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getEmployeeByName(@PathVariable(value = "name") String name) {
        if (employeeService.existsByName(name)) {
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee(name));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


}
