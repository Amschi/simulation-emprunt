package emprunt;

import java.math.BigDecimal;

public class EmpruntPost {


    private BigDecimal capital;
    private BigDecimal tauxAnnuel;
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