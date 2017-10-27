package emprunt;

import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Emprunt {

    public static final BigDecimal TAUX_MIN = BigDecimal.ZERO;
    public static final BigDecimal TAUX_MAX = new BigDecimal(100);

    private BigDecimal capital;
    private BigDecimal tauxAnnuel;
    private BigDecimal tauxMensuel;
    private Integer nombreDeMois;
    private static final Integer NB_MOIS_PAR_AN = 12;
    private static final Integer POURCENTAGE = 100;

    public Emprunt(BigDecimal capital, BigDecimal tauxAnnuel, Integer nombreDeMois) {
        this.capital = capital;
        this.tauxAnnuel = tauxAnnuel;
        this.nombreDeMois = nombreDeMois;
    }

    public BigDecimal getTauxMensuel() {
        return tauxAnnuel.divide(BigDecimal.valueOf(NB_MOIS_PAR_AN * POURCENTAGE), 10, RoundingMode.HALF_DOWN);
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public BigDecimal getTauxAnnuel() {
        return tauxAnnuel;
    }

    public Integer getNombreDeMois() {
        return nombreDeMois;
    }


    public Boolean isValid() {
        return (nombreDeMois > 0 && tauxAnnuel.compareTo(TAUX_MIN) >= 0 && tauxAnnuel.compareTo(TAUX_MAX) < 0) && (capital.compareTo(BigDecimal.ZERO) > 0);

    }
}