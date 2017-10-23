import java.math.BigDecimal;
import java.math.RoundingMode;


public class EmpruntSimulationCalculator {

    private static final Integer NB_MOIS_PAR_AN = 12;
    private static final Integer POURCENTAGE = 100;


    public BigDecimal calculerMensualite(Emprunt emprunt) {

        validerEmprunt(emprunt);

        BigDecimal tauxMensuel = emprunt.getTauxAnnuel().divide(BigDecimal.valueOf(NB_MOIS_PAR_AN * POURCENTAGE), 10, RoundingMode.HALF_DOWN);
        BigDecimal dividende = emprunt.getCapital().multiply(tauxMensuel);
        BigDecimal diviseur = BigDecimal.ONE.subtract(BigDecimal.ONE.divide((BigDecimal.ONE.add(tauxMensuel)).pow(emprunt.getNombreDeMois()), 10, RoundingMode.HALF_DOWN));
        return dividende.divide(diviseur, 10, RoundingMode.HALF_DOWN);

    }

    public BigDecimal calculerCoutTotal(Emprunt emprunt) {
        validerEmprunt(emprunt);
        return calculerMensualite(emprunt).multiply(BigDecimal.valueOf(emprunt.getNombreDeMois()));
    }

    private void validerEmprunt(Emprunt emprunt) {
        if (!emprunt.isValid()) {
            throw new IllegalArgumentException("Données d'emprunt non valides");
        }
    }

}

