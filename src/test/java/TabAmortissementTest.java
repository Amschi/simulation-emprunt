import emprunt.Emprunt;
import emprunt.TabAmortissement;
import emprunt.TabAmortissementCalculateur;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TabAmortissementTest {


    TabAmortissement tabAmortissement;
    TabAmortissementCalculateur tabAmortissementCalculateur;

    @Before
    public void setUp() {
        tabAmortissement = new TabAmortissement();
        tabAmortissementCalculateur = new TabAmortissementCalculateur();

    }

    @Test
    public void affichageTabAmortissement_should_return_tableauAmortissement() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(12), 120);
        String expectedAffichage = "Mois || Interet || Remboursement || Capital restant \n" + "1 || 1000.00 || 434.71 || 99565.29";

        //WHEN
        tabAmortissement = tabAmortissementCalculateur.calculer(emprunt);

        String affichageTabAmortissement = tabAmortissement.affichageTabAmortissement();

        //THEN
        assertThat(affichageTabAmortissement).isEqualTo(expectedAffichage);
    }

}
