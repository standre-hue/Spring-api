package frey.house.ega.controller;

import frey.house.ega.dto.CompteDto;
import frey.house.ega.model.Compte;
import frey.house.ega.servicesImplementations.CompteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Calendar;

@RestController
@RequestMapping("/comptes")
public class CompteController {



    private final CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(this.compteService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        CompteDto compteDto = this.compteService.findById(id);
        return new ResponseEntity<CompteDto>(compteDto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody CompteDto compteDto) {

        if (compteDto == null){
            return new ResponseEntity<>("Données requises manquantes!", HttpStatus.BAD_REQUEST);
        }
        CompteDto createdCompte = this.compteService.save(compteDto);
        return new ResponseEntity<>(createdCompte, HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CompteDto compteDto,
                                    @PathVariable("id") Long id) {
        if (compteDto == null) {
            return new ResponseEntity<>("Données requises manquantes!", HttpStatus.BAD_REQUEST);
        }
        CompteDto updated = this.compteService.update(compteDto, id);
        return new ResponseEntity<CompteDto>(updated, HttpStatus.OK);
    }












}