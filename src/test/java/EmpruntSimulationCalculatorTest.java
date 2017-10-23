import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class EmpruntSimulationCalculatorTest {

    EmpruntSimulationCalculator empruntSimulationCalculator;

    @Before
    public void setUp() {
        empruntSimulationCalculator = new EmpruntSimulationCalculator();
    }

    @Test
    public void calculerMensualite_should_return_1434_71() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(12), 120);
        BigDecimal expected = BigDecimal.valueOf(1434.71);

        //WHEN
        BigDecimal mensualite = empruntSimulationCalculator.calculerMensualite(emprunt).setScale(2, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(mensualite).isEqualTo(expected);
    }

    @Test
    public void calculerMensualite_should_return_717_35() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(50_000), BigDecimal.valueOf(12), 120);
        BigDecimal expected = BigDecimal.valueOf(717.35);

        // WHEN
        BigDecimal mensualite = empruntSimulationCalculator.calculerMensualite(emprunt).setScale(2, RoundingMode.HALF_DOWN);

        // THEN
        assertThat(mensualite).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculerMensualite_shouldThrowIllegalArgumentException_whenNombreDeMoisIsNegatif() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(12), -1);

        // WHEN
        empruntSimulationCalculator.calculerMensualite(emprunt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculerMensualite_shouldThrowIllegalArgumentException_whenTauxIsNegatif() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(-1), -1);

        // WHEN
        empruntSimulationCalculator.calculerMensualite(emprunt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculerMensualite_shouldThrowIllegalArgumentException_whenTauxIsSuperieur100() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(102), -1);

        // WHEN
        empruntSimulationCalculator.calculerMensualite(emprunt);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculerMensualite_shouldThrowIllegalArgumentException_whenTCapitalIsNegatif() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(-1000), BigDecimal.valueOf(12), -1);

        // WHEN
        empruntSimulationCalculator.calculerMensualite(emprunt);
    }

    @Test
    public void calculerCoutTotal_should_return_172165_14() {
        // GIVEN
        Emprunt emprunt = new Emprunt(BigDecimal.valueOf(100_000), BigDecimal.valueOf(12), 120);
        BigDecimal expected = new BigDecimal("172165.14");

        // WHEN
        BigDecimal coutTotal = empruntSimulationCalculator.calculerCoutTotal(emprunt).setScale(2, BigDecimal.ROUND_HALF_DOWN);

        // THEN
        assertThat(coutTotal).isEqualTo(expected);
    }
}
