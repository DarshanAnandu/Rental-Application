package com.olik.backend.api;

import com.olik.backend.model.Rent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rents")
public class RentController {
    public final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping
    public Rent rentProduct(@RequestBody Rent rent) {
        return rentService.rentProduct(rent);
    }
}
