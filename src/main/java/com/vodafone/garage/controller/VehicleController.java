package com.vodafone.garage.controller;

import com.vodafone.garage.common.exceptions.GarageLimitExceedException;
import com.vodafone.garage.entity.abstracts.model.dto.VehicleDTO;
import com.vodafone.garage.entity.concretes.Vehicle;
import com.vodafone.garage.results.DataResult;
import com.vodafone.garage.results.ErrorDataResult;
import com.vodafone.garage.service.abstracts.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;


    @GetMapping("/getAll")
    public DataResult<List<Vehicle>> getAll() {
        return vehicleService.getAll();
    }

    @PostMapping("/add")
    public DataResult<Vehicle> addVehicle(@RequestBody VehicleDTO vehicleDto) throws GarageLimitExceedException {
        return vehicleService.addVehicle(vehicleDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        vehicleService.deleteById(id);
    }

    @GetMapping("/count")
    public DataResult<Long> getCountOfProductList() {
        return vehicleService.getTotalCount();
    }

    @GetMapping("/size")
    public DataResult<Integer> getGarageSize() {
        return vehicleService.getTotalSizeOfVehicles();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<>(validationErrors, "Validation errors");
        return errors;
    }

    @ExceptionHandler(GarageLimitExceedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleGarageException
            (GarageLimitExceedException exceptions) {
        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>("The limit of garage exceeds");
        return errors;
    }
}
