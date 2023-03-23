package com.example.localisation_pharmacie.controller;

import com.example.localisation_pharmacie.entity.Pharmacie;

import com.example.localisation_pharmacie.service.PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pharmacie")
public class PharmacieController {



    @Autowired
    private PharmacieService pharmacieService;
    @GetMapping("byzoneid/id/{id}")
    public List<Pharmacie> findByZonesId(@PathVariable int id) {
        return pharmacieService.findByZoneId(id);
    }

    @GetMapping("/ville/{ville}/zone/{zone}")
    public List<Pharmacie> findPharmaciyByVilleAndZone(@PathVariable String ville,@PathVariable String zone) {
        return pharmacieService.findPharmaciyByVilleAndZone(ville, zone);
    }

    @GetMapping("/ville/{ville}/zone/{zone}/period/{period}")
    public List<Pharmacie> findPharmacyAvailableZonePer(@PathVariable String ville,@PathVariable String zone,@PathVariable String period) {
        return pharmacieService.findPharmacyAvailableZonePer(ville, zone, period);
    }


    @DeleteMapping("deletebyzid/id/{id}")
    public int deleteByZonesId(@PathVariable int id) {
        return pharmacieService.deleteByZoneId(id);
    }

    @PostMapping("/save")
    public Pharmacie save(@RequestBody Pharmacie o) {
        return pharmacieService.save(o);
    }

    @GetMapping("/")
    public List<Pharmacie> getAllPh() {
        return pharmacieService.findAll();
    }

    @GetMapping("/id/{id}")
    public Pharmacie getById(@PathVariable int id) {
        return pharmacieService.findById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Pharmacie pharmacieinfo) {
        pharmacieService.update(id, pharmacieinfo);
    }

    @DeleteMapping("/")
    public void delete(@PathVariable Pharmacie o) {
        pharmacieService.delete(o);
    }




    @DeleteMapping("/delete")
    public void delete(@PathVariable int id) {
        Pharmacie pharmacie=pharmacieService.findById(id);
        pharmacieService.delete(pharmacie);
    }



}
