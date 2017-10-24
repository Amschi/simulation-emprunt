import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TabAmortissementTest {

    TabAmortissement tabAmortissement;

    @Before
    public void setUp() {
        tabAmortissement = new TabAmortissement();
    }


    @Test
    public void affichageTabAmortissement_should_return_premiere_ligne_tableau() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(12), 120);
        String expectedAffichage = "Mois || Interet || Remboursement || Capital restant \n"
                                    + "1 || 1000 || 434.71 || 99565.29\n";

        // WHEN
        String affichageTabAmortissement = tabAmortissement.affichageTabAmortissement(emprunt);

        // THEN
        assertThat(affichageTabAmortissement).isEqualTo(expectedAffichage);
    }

    @Test
    public void name() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(12), 120);
        String expectedAffichage = "Mois || Interet || Remboursement || Capital restant \n"
                                    + "1 || 1000 || 434.71 || 99565.29\n"
                                    + "2 || 995.65 || 439.06 || 99126.23\n";

        // WHEN
        String affichageTabAmortissement = tabAmortissement.affichageTabAmortissement(emprunt);

        // THEN
        assertThat(affichageTabAmortissement).isEqualTo(expectedAffichage);
    }

}
