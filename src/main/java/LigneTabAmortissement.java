import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class LigneTabAmortissement {


    private final Integer mois;
    private final BigDecimal interet;
    private final BigDecimal remboursement;
    private final BigDecimal capitalRestant;


    public LigneTabAmortissement(Integer mois, BigDecimal interet, BigDecimal remboursement, BigDecimal capitalRestant) {
        this.mois = mois;
        this.interet = interet;
        this.remboursement = remboursement;
        this.capitalRestant = capitalRestant;
    }


    public Integer getMois() {
        return mois;
    }

    public BigDecimal getInteret() {
        return interet;
    }

    public BigDecimal getRemboursement() {
        return remboursement;
    }

    public BigDecimal getCapitalRestant() {
        return capitalRestant;
    }

    @Override
    public String toString() {
        return + mois + "||" + interet.setScale(2, RoundingMode.HALF_EVEN) + "||" + remboursement.setScale(2, RoundingMode.HALF_EVEN) + "||" + capitalRestant.setScale(2, RoundingMode.HALF_EVEN) + "\n" ;
    }
}
