import java.math.BigDecimal;

public class Emprunt {

    private  BigDecimal capital;
    private  BigDecimal tauxAnnuel;
    private  Integer nombreDeMois;

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


    public void isValid () {
        if (nombreDeMois <= 0) {
            throw new IllegalArgumentException("Nombre de mois doit etre positif");
        }
        if (tauxAnnuel.compareTo(BigDecimal.ZERO) < 0 ) {
            throw new IllegalArgumentException("Taux annuel doit etre supérieur à 0");
        }
        if (tauxAnnuel.compareTo(new BigDecimal( 100 )) >=100) {
            throw new IllegalArgumentException("Taux annuel doit etre inférieur à 99");
        }
        if (capital.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Capital doit etre positif");
        }
    }
}