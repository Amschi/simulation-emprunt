import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TabAmortissementCalculateur {

    EmpruntSimulationCalculator empruntSimulationCalculator = new EmpruntSimulationCalculator();

    public BigDecimal calculerInteret(Emprunt emprunt) {
        return emprunt.getCapital().multiply(emprunt.getTauxMensuel());
    }

    public BigDecimal calculerRemboursement(Emprunt emprunt) {
        return empruntSimulationCalculator.calculerMensualite(emprunt).subtract(calculerInteret(emprunt));
    }

    public BigDecimal calculerCapitalRestant(Emprunt emprunt) {
        return emprunt.getCapital().subtract(calculerRemboursement(emprunt));
    }

}

