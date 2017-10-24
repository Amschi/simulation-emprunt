import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LigneTabAmortissementCalculateurTest {

    TabAmortissementCalculateur tabAmortissementCalculateur;
    LigneTabAmortissement ligneTabAmortissement;

    @Before
    public void setUp() {
        tabAmortissementCalculateur = new TabAmortissementCalculateur();
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(12), 120);
        ligneTabAmortissement = new LigneTabAmortissement(emprunt, 0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
    }


    @Test
    public void calculerInteret_should_return_1000() {
        // GIVEN
        BigDecimal expected = BigDecimal.valueOf(1000);

        // WHEN
        BigDecimal interet = tabAmortissementCalculateur.calculerInteret(ligneTabAmortissement).setScale(0, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(interet).isEqualTo(expected);
    }

    @Test
    public void calculerRemboursement_should_return_434_71() {
        // GIVEN
        BigDecimal expected = BigDecimal.valueOf(434.71);

        // WHEN
        BigDecimal remboursement = tabAmortissementCalculateur.calculerRemboursement(ligneTabAmortissement).setScale(2, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(remboursement).isEqualTo(expected);
    }

    @Test
    public void calculerCapitalRestant_should_return_99565_29() {
        // GIVEN
        BigDecimal expected = BigDecimal.valueOf(99565.29);

        // WHEN
        BigDecimal capitalRestant = tabAmortissementCalculateur.calculerCapitalRestant(ligneTabAmortissement).setScale(2, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(capitalRestant).isEqualTo(expected);
    }


}
