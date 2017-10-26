import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class TabAmortissement {

    public List<LigneTabAmortissement> getLigneTabAmortissements() {
        return ligneTabAmortissements;
    }

    private List<LigneTabAmortissement> ligneTabAmortissements = new ArrayList<>();

    public static final String HEADER_TAB_LIST = "Mois || Interet || Remboursement || Capital restant \n";


    public String affichageTabAmortissement() {
        String tabAmortissementString = HEADER_TAB_LIST;

       for (int i = 0; i < ligneTabAmortissements.size(); i++) {
            LigneTabAmortissement ligneTabAmortissement = ligneTabAmortissements.get(i);
            tabAmortissementString += ligneTabAmortissement;
       }
        return tabAmortissementString;
    }
}
