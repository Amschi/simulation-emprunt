import javafx.beans.binding.DoubleExpression;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.pow;


public class EmpruntSimulationCalculator {
    private static final Integer NB_MOIS_PAR_AN = 12;
    private static final Integer POURCENTAGE = 100;


    public BigDecimal calculerMensualite(Emprunt emprunt) {

        emprunt.isValid();

        BigDecimal tauxMensuel = emprunt.getTauxAnnuel().divide(BigDecimal.valueOf(NB_MOIS_PAR_AN * POURCENTAGE), 10, RoundingMode.HALF_DOWN);

        BigDecimal dividende = emprunt.getCapital().multiply(tauxMensuel);
        BigDecimal diviseur = BigDecimal.ONE.subtract(BigDecimal.ONE.divide((BigDecimal.ONE.add(tauxMensuel)).pow(emprunt.getNombreDeMois()), 10, RoundingMode.HALF_DOWN));
        BigDecimal mensualite = dividende.divide(diviseur, 10, RoundingMode.HALF_DOWN);

        return mensualite;
    }


    public BigDecimal calculerCoutTotal(Emprunt emprunt) {

        emprunt.isValid();

        BigDecimal coutTotal = calculerMensualite(emprunt).multiply(BigDecimal.valueOf(emprunt.getNombreDeMois()));
        return coutTotal;


    }

}

