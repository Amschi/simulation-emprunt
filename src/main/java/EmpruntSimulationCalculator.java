import java.math.BigDecimal;
import java.math.RoundingMode;


public class EmpruntSimulationCalculator {
    
    public BigDecimal calculerMensualite(Emprunt emprunt) {

        validerEmprunt(emprunt);

        BigDecimal dividende = emprunt.getCapital().multiply(emprunt.getTauxMensuel());
        BigDecimal diviseur = BigDecimal.ONE.subtract(BigDecimal.ONE.divide((BigDecimal.ONE.add(emprunt.getTauxMensuel())).pow(emprunt.getNombreDeMois()), 10, RoundingMode.HALF_DOWN));
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

