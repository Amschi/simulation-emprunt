package emprunt;

import java.math.BigDecimal;


public class EmpruntSimulationCalculator {

    public BigDecimal calculerMensualite(Emprunt emprunt) {

        validerEmprunt(emprunt);

        BigDecimal dividende = emprunt.getCapital().multiply(emprunt.getTauxMensuel());
        BigDecimal diviseur = BigDecimal.ONE.subtract(BigDecimal.ONE.divide((BigDecimal.ONE.add(emprunt.getTauxMensuel())).pow(emprunt.getNombreDeMois()),20, BigDecimal.ROUND_HALF_EVEN));
        return dividende.divide(diviseur, 20, BigDecimal.ROUND_HALF_EVEN);
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

