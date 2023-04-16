package frey.house.ega.controller;

import frey.house.ega.dto.CompteDto;
import frey.house.ega.dto.RetraitDto;
import frey.house.ega.dto.VirementDto;
import frey.house.ega.servicesImplementations.CompteService;
import frey.house.ega.servicesImplementations.RetraitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/retraits")
public class RetraitController {

    private final RetraitService retraitService;
    private final CompteService compteService;

    public RetraitController(RetraitService retraitService, CompteService compteService) {
        this.retraitService = retraitService;
        this.compteService = compteService;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(this.retraitService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        RetraitDto retraitDto = this.retraitService.findById(id);
        return new ResponseEntity<RetraitDto>(retraitDto, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> retrait(@RequestBody RetraitDto retraitDto) {

        if (retraitDto == null) {
            return new ResponseEntity<>("Données requises manquantes!", HttpStatus.BAD_REQUEST);
        }

        CompteDto compteDto = compteService.findById(retraitDto.getCompteCible().getId());
        if (compteDto == null) {
            return new ResponseEntity<>("Le compte n'existe pas!", HttpStatus.BAD_REQUEST);
        }

        if (retraitDto.getMontant().compareTo(BigDecimal.ZERO) < 0) {
            return new ResponseEntity<>("Le montant doit être supérieur à zéro!", HttpStatus.BAD_REQUEST);
        }

        if (compteDto.getSolde().compareTo(retraitDto.getMontant()) < 0) {
            return new ResponseEntity<>("Solde insuffisant!", HttpStatus.BAD_REQUEST);
        }

        compteDto.setSolde(compteDto.getSolde().subtract(retraitDto.getMontant()));
        compteService.update(compteDto, compteDto.getId());

        retraitDto.setCompteCible(compteDto);
        retraitDto.setDateRetrait(new Date());

        RetraitDto saved = retraitService.save(retraitDto);

        return new ResponseEntity<>("Retrait effectué avec succès!", HttpStatus.OK);
    }

}
