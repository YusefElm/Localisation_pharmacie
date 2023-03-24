package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Garde;
import com.example.localisation_pharmacie.service.GardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/gardes")
public class GardeController {



    @Autowired
    private GardeService gardeService;
    @PostMapping("/save")
    public void save(@RequestBody Garde garde) {
         gardeService.save(garde);
    }

    @GetMapping("/")
    public List<Garde> findAll() {
        return gardeService.findAll();
    }

    @GetMapping("/id/{id}")
    public Garde findById(@PathVariable int id) {
        return gardeService.findById(id);
    }


    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Garde gardeinfo) {
        gardeService.update(id, gardeinfo);
    }
    @DeleteMapping("/")
    public void delete(@PathVariable int id) {
        Garde garde=gardeService.findById(id);
        gardeService.delete(garde);
    }


}
