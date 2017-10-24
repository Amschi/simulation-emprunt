import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class LigneTabAmortissement {

    TabAmortissementCalculateur tabAmortissementCalculateur;
    private Integer mois;
    private BigDecimal interet;
    private BigDecimal remboursement;
    private BigDecimal capitalRestant;
    public Emprunt emprunt;


    public LigneTabAmortissement(Emprunt emprunt, Integer mois, BigDecimal interet, BigDecimal remboursement, BigDecimal capitalRestant) {
        this.emprunt = emprunt;
        this.mois = mois;
        this.interet = interet;
        this.remboursement = remboursement;
        this.capitalRestant = capitalRestant;
    }


    public Emprunt getEmprunt() { return emprunt; }

    public Integer getMois() {
        return mois;
    }

    public BigDecimal getInteret() { return interet; }

    public BigDecimal getRemboursement() {
        return remboursement;
    }

    public BigDecimal getCapitalRestant() {
        return capitalRestant;
    }
}
