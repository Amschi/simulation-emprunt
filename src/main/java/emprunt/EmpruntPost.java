package emprunt;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class EmpruntPost {

    @NotNull
    @Min(0)
    private BigDecimal capital;


    @NotNull
    @Min(0)
    @Max(100)
    private BigDecimal tauxAnnuel;

    @NotNull
    @Min(0)
    @Max(1000)
    private Integer nombreDeMois;

    public BigDecimal getCapital() {
        return capital;
    }

    public BigDecimal getTauxAnnuel() {
        return tauxAnnuel;
    }


    public Integer getNombreDeMois() {
        return nombreDeMois;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public void setTauxAnnuel(BigDecimal tauxAnnuel) {
        this.tauxAnnuel = tauxAnnuel;
    }


    public void setNombreDeMois(Integer nombreDeMois) {
        this.nombreDeMois = nombreDeMois;
    }


}