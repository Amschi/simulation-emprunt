import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class EmpruntSimulationCalculatorTest {

    Emprunt emprunt;
    EmpruntSimulationCalculator empruntSimulationCalculator;
    BigDecimal mensualite;


    @Before
    public void setUp() throws Exception {
        empruntSimulationCalculator = new EmpruntSimulationCalculator();
    }


    @Test
    public void calculerMensualite_should_return_1434() {
        // GIVEN
        emprunt = new Emprunt(BigDecimal.valueOf(100000), BigDecimal.valueOf(12), 120);
        BigDecimal result = BigDecimal.valueOf(1434.71);

        //WHEN
        mensualite = empruntSimulationCalculator.calculerMensualite(emprunt).setScale(2, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(mensualite).isEqualTo(result);
    }

    @Test
    public void calculerMensualite_should_return_717_15() {
        // GIVEN
        emprunt = new Emprunt(BigDecimal.valueOf(50000), BigDecimal.valueOf(12), 120);
        BigDecimal result = BigDecimal.valueOf(717.35);

        //WHEN
        mensualite = empruntSimulationCalculator.calculerMensualite(emprunt).setScale(2, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(mensualite).isEqualTo(result);
    }

    @Test
    public void calculerCoutTotal_should_return_172165_14() {
        // GIVEN
        emprunt = new Emprunt(BigDecimal.valueOf(100000), BigDecimal.valueOf(12), 120);
        BigDecimal result = new BigDecimal("172165.14");

        // WHEN
        BigDecimal coutTotal = empruntSimulationCalculator.calculerCoutTotal(emprunt).setScale(2, BigDecimal.ROUND_HALF_DOWN);

        // THEN
        assertThat(coutTotal).isEqualTo(result);
    }


}
