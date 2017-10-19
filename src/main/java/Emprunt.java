import java.math.BigDecimal;
import static java.lang.Math.pow;


public class Emprunt {
    private static final Integer NB_MOIS_PAR_AN = 12;
    private static final Integer POURCENTAGE = 100;



    public BigDecimal calculerMensualite(BigDecimal capital, BigDecimal tauxAnnuel, Integer nombreDeMois) {
        BigDecimal tauxMensuel = tauxAnnuel.divide(BigDecimal.valueOf(NB_MOIS_PAR_AN * POURCENTAGE));
        BigDecimal mensualite = (capital.multiply(tauxMensuel)) / (1 - (pow(1 + tauxMensuel, -nombreDeMois)));
        return mensualite;
    }


    public BigDecimal calculerCoutTotal(BigDecimal capital, BigDecimal tauxAnnuel, Integer nombreDeMois) {
        BigDecimal coutTotal = calculerMensualite(capital, tauxAnnuel, nombreDeMois).multiply(BigDecimal.valueOf(nombreDeMois));
        return coutTotal;
    }
}
