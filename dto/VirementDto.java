package frey.house.ega.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VirementDto {

    private Long id;
    private CompteDto compteDebite;
    private CompteDto compteCredite;
    private BigDecimal montant;
    private Date dateExecution;
}
