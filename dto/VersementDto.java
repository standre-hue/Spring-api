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
public class VersementDto {

    private Integer id;
    private Date dateVersement;
    private BigDecimal montant;
    private CompteDto compteCible;

}
