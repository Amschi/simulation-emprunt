import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TabAmortissementCalculateur {

    EmpruntSimulationCalculator empruntSimulationCalculator = new EmpruntSimulationCalculator();


    public BigDecimal calculerInteret(LigneTabAmortissement ligneTabAmortissement) {
        return ligneTabAmortissement.emprunt.getCapital().multiply(ligneTabAmortissement.emprunt.getTauxMensuel());
    }

    public BigDecimal calculerRemboursement(LigneTabAmortissement ligneTabAmortissement) {
        return empruntSimulationCalculator.calculerMensualite(ligneTabAmortissement.emprunt).subtract(calculerInteret(ligneTabAmortissement));
    }

    public BigDecimal calculerCapitalRestant(LigneTabAmortissement ligneTabAmortissement) {
        return ligneTabAmortissement.emprunt.getCapital().subtract(calculerRemboursement(ligneTabAmortissement));
    }

}

