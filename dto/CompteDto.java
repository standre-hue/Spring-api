package frey.house.ega.dto;

import frey.house.ega.model.Compte;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompteDto {

    private Long id;
    private String numero;
    private LocalDate dateCreation;
    private BigDecimal solde;

    @Enumerated(EnumType.STRING)
    private Compte.TypeCompte type;

    private ClientDto proprietaire;

    public enum TypeCompte {
        EPARGNE, COURANT}
}
