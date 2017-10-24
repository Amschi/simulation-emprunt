import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TabAmortissementCalculateurTest {

    TabAmortissementCalculateur tabAmortissementCalculateur;

    @Before
    public void setUp() {
        tabAmortissementCalculateur = new TabAmortissementCalculateur();
    }


    @Test
    public void calculerInteret_should_return_1000() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(12), 120);
        BigDecimal expected = BigDecimal.valueOf(1000);

        // WHEN
        BigDecimal interet = tabAmortissementCalculateur.calculerInteret(emprunt).setScale(0, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(interet).isEqualTo(expected);
    }

    @Test
    public void calculerRemboursement_should_return_434_71() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(12), 120);
        BigDecimal expected = BigDecimal.valueOf(434.71);

        // WHEN
        BigDecimal remboursement = tabAmortissementCalculateur.calculerRemboursement(emprunt).setScale(2, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(remboursement).isEqualTo(expected);
    }

    @Test
    public void calculerCapitalRestant_should_return_99565_29() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(12), 120);
        BigDecimal expected = BigDecimal.valueOf(99565.29);

        // WHEN
        BigDecimal capitalRestant = tabAmortissementCalculateur.calculerCapitalRestant(emprunt).setScale(2, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(capitalRestant).isEqualTo(expected);
    }


}
