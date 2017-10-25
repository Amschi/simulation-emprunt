import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

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
        assertThat(ligneTabAmortissement.getInteret()).isEqualTo(BigDecimal.valueOf(1000).setScale(2));
        assertThat(ligneTabAmortissement.getRemboursement()).isEqualTo(BigDecimal.valueOf(434.71));
        assertThat(ligneTabAmortissement.getCapitalRestant()).isEqualTo(BigDecimal.valueOf(99565.29));

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
        assertThat(ligneTabAmortissement.getInteret()).isEqualTo(BigDecimal.valueOf(995.65));
        assertThat(ligneTabAmortissement.getRemboursement()).isEqualTo(BigDecimal.valueOf(439.06));
        assertThat(ligneTabAmortissement.getCapitalRestant()).isEqualTo(BigDecimal.valueOf(99126.23));
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
        assertThat(ligneTabAmortissement.getInteret()).isEqualTo(BigDecimal.valueOf(991.26));
        assertThat(ligneTabAmortissement.getRemboursement()).isEqualTo(BigDecimal.valueOf(443.45));
        assertThat(ligneTabAmortissement.getCapitalRestant()).isEqualTo(BigDecimal.valueOf(98682.79).setScale(2));
    }
}
