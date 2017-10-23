import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TableauDamortissementTest {


    Emprunt emprunt;
    TabAmortissement tableauDamortissement;
    BigDecimal interet;


    @Before
    public void setUp() throws Exception {
        tableauDamortissement = new TabAmortissement();
    }

    @Test
    public void calculerInteret_should_return_1000() {
        // GIVEN
        emprunt = new Emprunt(BigDecimal.valueOf(100000), BigDecimal.valueOf(12), 120);
        BigDecimal result = BigDecimal.valueOf(1000);

        //WHEN
        interet = tableauDamortissement.calculerInteret(emprunt).setScale(2, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(interet).isEqualTo(result);
    }


}
