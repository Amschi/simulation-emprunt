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
    public void calculerLigne_should_return_1_ligne() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100000), BigDecimal.valueOf(12), 120);

        // WHEN
        TabAmortissement tabAmortissement = tabAmortissementCalculateur.calculer(emprunt);

        // THEN
        LigneTabAmortissement ligneTabAmortissement = tabAmortissement.getLigneTabAmortissements().get(0);
        assertThat(ligneTabAmortissement.getMois()).isEqualTo(1);
        assertThat(ligneTabAmortissement.getInteret().setScale(0)).isEqualTo(BigDecimal.valueOf(1000));
        assertThat(ligneTabAmortissement.getRemboursement().setScale(2, RoundingMode.HALF_EVEN)).isEqualTo(BigDecimal.valueOf(434.71));
        assertThat(ligneTabAmortissement.getCapitalRestant().setScale(2, RoundingMode.HALF_EVEN)).isEqualTo(BigDecimal.valueOf(99565.29));

    }


    @Test
    public void calculerLigne_should_return_2_lignes() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100000), BigDecimal.valueOf(12), 120);
        // WHEN
        TabAmortissement tabAmortissement = tabAmortissementCalculateur.calculer(emprunt);
        // THEN
        LigneTabAmortissement ligneTabAmortissement = tabAmortissement.getLigneTabAmortissements().get(1);
        assertThat(ligneTabAmortissement.getMois()).isEqualTo(2);
        assertThat(ligneTabAmortissement.getInteret().setScale(2, RoundingMode.HALF_EVEN)).isEqualTo(BigDecimal.valueOf(995.65));
        assertThat(ligneTabAmortissement.getRemboursement().setScale(2, RoundingMode.HALF_EVEN)).isEqualTo(BigDecimal.valueOf(439.06));
        assertThat(ligneTabAmortissement.getCapitalRestant().setScale(2, RoundingMode.HALF_EVEN)).isEqualTo(BigDecimal.valueOf(99126.23));
    }

    @Test
    public void calculerLigne_should_return_3_lignes() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100000), BigDecimal.valueOf(12), 120);
        // WHEN
        TabAmortissement tabAmortissement = tabAmortissementCalculateur.calculer(emprunt);
        // THEN
        LigneTabAmortissement ligneTabAmortissement = tabAmortissement.getLigneTabAmortissements().get(2);
        assertThat(ligneTabAmortissement.getMois()).isEqualTo(3);
        assertThat(ligneTabAmortissement.getInteret().setScale(2, RoundingMode.HALF_EVEN)).isEqualTo(BigDecimal.valueOf(991.26));
        assertThat(ligneTabAmortissement.getRemboursement().setScale(2, RoundingMode.HALF_EVEN)).isEqualTo(BigDecimal.valueOf(443.45).setScale(2, RoundingMode.HALF_EVEN));
        assertThat(ligneTabAmortissement.getCapitalRestant().setScale(2, RoundingMode.HALF_EVEN)).isEqualTo(BigDecimal.valueOf(98682.79));
    }

}
