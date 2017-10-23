import java.math.BigDecimal;
import java.math.RoundingMode;

public class TabAmortissement {

    public static final String HEADER_TAB_LIST = "Mois || Interet || Remboursement || Capital restant \n";

    TabAmortissementCalculateur tabAmortissementCalculateur = new TabAmortissementCalculateur();




    public String affichageTabAmortissement(Emprunt emprunt) {
        String tabAmortissement = HEADER_TAB_LIST;
        String month = "1";

        BigDecimal interet = tabAmortissementCalculateur.calculerInteret(emprunt).setScale(0);
        BigDecimal remboursement = tabAmortissementCalculateur.calculerRemboursement(emprunt).setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal capitalRestant = tabAmortissementCalculateur.calculerCapitalRestant(emprunt).setScale(2, RoundingMode.HALF_DOWN);

        return tabAmortissement += " " + month +" || " + interet  + " || " + remboursement + " || " + capitalRestant + "\n";
    }
}
