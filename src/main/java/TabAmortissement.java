import java.math.BigDecimal;
import java.math.RoundingMode;

public class TabAmortissement {


    public BigDecimal calculerInteret(Emprunt emprunt) {

        BigDecimal interet = emprunt.getCapital().multiply(emprunt.getTauxAnnuel().divide(taux mensuel)
        return  interet;
    }
}
