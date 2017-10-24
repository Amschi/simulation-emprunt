import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TabAmortissement {

    public static final String HEADER_TAB_LIST = "Mois || Interet || Remboursement || Capital restant \n";


    TabAmortissementCalculateur tabAmortissementCalculateur = new TabAmortissementCalculateur();

    private List<Emprunt> tabAmortissementCalculateurList = new ArrayList<Emprunt>();


    public String affichageTabAmortissement(Emprunt emprunt) {

        String tabAmortissement = HEADER_TAB_LIST;
        String month = "1";

        BigDecimal interet = tabAmortissementCalculateur.calculerInteret(emprunt).setScale(0);
        BigDecimal remboursement = tabAmortissementCalculateur.calculerRemboursement(emprunt).setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal capitalRestant = tabAmortissementCalculateur.calculerCapitalRestant(emprunt).setScale(2, RoundingMode.HALF_DOWN);


        for (int i = 1; i <= emprunt.getNombreDeMois(); i++) {

            tabAmortissement += "" + i + " || " + interet + " || " + remboursement + " || " + capitalRestant + "\n";

        }
        return tabAmortissement;
    }
}
