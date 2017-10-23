import java.math.BigDecimal;

public class Emprunt {

    public static final BigDecimal TAUX_MIN = BigDecimal.ZERO;
    public static final BigDecimal TAUX_MAX = new BigDecimal(100);

    private BigDecimal capital;
    private BigDecimal tauxAnnuel;
    private Integer nombreDeMois;

    public Emprunt(BigDecimal capital, BigDecimal tauxAnnuel, Integer nombreDeMois) {
        this.capital = capital;
        this.tauxAnnuel = tauxAnnuel;
        this.nombreDeMois = nombreDeMois;
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
        return (nombreDeMois > 0 &&
                tauxAnnuel.compareTo(TAUX_MIN) >= 0 &&
                tauxAnnuel.compareTo(TAUX_MAX) < 0) &&
                (capital.compareTo(BigDecimal.ZERO) > 0);

    }
}