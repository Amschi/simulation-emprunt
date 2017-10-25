import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TabAmortissementCalculateur {

    EmpruntSimulationCalculator empruntSimulationCalculator = new EmpruntSimulationCalculator();

    public TabAmortissement calculer(Emprunt emprunt) {
        TabAmortissement tabAmortissement = new TabAmortissement();

        BigDecimal capitalRestantDu = emprunt.getCapital();
        for (int i = 0; i < emprunt.getNombreDeMois(); i++) {
            BigDecimal mensualite = empruntSimulationCalculator.calculerMensualite(emprunt);
            BigDecimal interet = calculerInteret(capitalRestantDu, emprunt.getTauxMensuel());
            BigDecimal remboursement = calculerRemboursement(mensualite, interet);

            LigneTabAmortissement ligneTabAmortissement = new LigneTabAmortissement(i + 1, calculerInteret(capitalRestantDu, emprunt.getTauxMensuel()), calculerRemboursement(mensualite, interet), calculerCapitalRestant(capitalRestantDu, remboursement));
            tabAmortissement.getLigneTabAmortissements().add(ligneTabAmortissement);
            capitalRestantDu = capitalRestantDu.subtract(tabAmortissement.getLigneTabAmortissements().get(i).getRemboursement());
        }
        return tabAmortissement;
    }


    public BigDecimal calculerInteret(BigDecimal capitalRestantDu, BigDecimal tauxMensuel) {
        return capitalRestantDu.multiply(tauxMensuel).setScale(2, RoundingMode.HALF_DOWN);
    }

    public BigDecimal calculerRemboursement(BigDecimal mensualite, BigDecimal interet) {
        return mensualite.subtract(interet).setScale(2, RoundingMode.HALF_DOWN);
    }

    public BigDecimal calculerCapitalRestant(BigDecimal capitalRestantDu, BigDecimal remboursement) {
        return capitalRestantDu.subtract(remboursement);
    }

}

