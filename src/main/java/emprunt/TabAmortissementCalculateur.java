package emprunt;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TabAmortissementCalculateur {

    EmpruntSimulationCalculator empruntSimulationCalculator = new EmpruntSimulationCalculator();

    public TabAmortissement calculer(Emprunt emprunt) {
        TabAmortissement tabAmortissement = new TabAmortissement();

        BigDecimal capitalRestantDu = emprunt.getCapital();
        for (int i = 0; i < emprunt.getNombreDeMois(); i++) {
            BigDecimal mensualite = empruntSimulationCalculator.calculerMensualite(emprunt);
            BigDecimal interet = calculerInteret(capitalRestantDu, emprunt.getTauxMensuel());
            BigDecimal remboursement = calculerRemboursement(mensualite, interet);

            LigneTabAmortissement ligneTabAmortissement = new LigneTabAmortissement(i + 1, calculerInteret(capitalRestantDu, emprunt.getTauxMensuel()).setScale(20, RoundingMode.HALF_EVEN), calculerRemboursement(mensualite, interet).setScale(20, RoundingMode.HALF_EVEN), calculerCapitalRestant(capitalRestantDu, remboursement).setScale(20, RoundingMode.HALF_EVEN));
            tabAmortissement.getLigneTabAmortissements().add(ligneTabAmortissement);
            capitalRestantDu = capitalRestantDu.subtract(tabAmortissement.getLigneTabAmortissements().get(i).getRemboursement());
        }
        return tabAmortissement;
    }


    public BigDecimal calculerInteret(BigDecimal capitalRestantDu, BigDecimal tauxMensuel) {
        return capitalRestantDu.multiply(tauxMensuel);
    }

    public BigDecimal calculerRemboursement(BigDecimal mensualite, BigDecimal interet) {
        return mensualite.subtract(interet);
    }

    public BigDecimal calculerCapitalRestant(BigDecimal capitalRestantDu, BigDecimal remboursement) {
        return capitalRestantDu.subtract(remboursement);
    }

}

