import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;


public class EmpruntTest {

    Emprunt emprunt;
    BigDecimal mensualite;


    @Before
    public void setUp() throws Exception {
        emprunt = new Emprunt();
    }


    @Test
    public void calculerMensualite_should_return_1434() {
        // GIVEN
        BigDecimal result = BigDecimal.valueOf(1434.71);
        BigDecimal capital = BigDecimal.valueOf(100000);
        BigDecimal tauxAnnuel = BigDecimal.valueOf(12);
        int nombreDeMois = 120;
        //WHEN
        mensualite = emprunt.calculerMensualite(capital, tauxAnnuel, nombreDeMois);

        // THEN
        assertThat(mensualite).isEqualTo(result);
    }

    @Test
    public void should_return_monthly_payment_of_717_US1() {
        // GIVEN
        BigDecimal result = BigDecimal.valueOf(717.35);
        BigDecimal capital = BigDecimal.valueOf(50000);
        BigDecimal tauxAnnuel = BigDecimal.valueOf(12);
        int nombreDeMois = 120;

        //WHEN
        mensualite = emprunt.calculerMensualite(capital, tauxAnnuel, nombreDeMois);

        // THEN
        assertThat(mensualite).isEqualTo(result);
    }

    @Test
    public void should_return_total_loan_cost_with_param_US2() {
        // GIVEN
        BigDecimal result = BigDecimal.valueOf(172165.13808310477);
        BigDecimal capital = BigDecimal.valueOf(100000);
        BigDecimal tauxAnnuel = BigDecimal.valueOf(12);
        int nombreDeMois = 120;

        // WHEN
        BigDecimal coutTotal = emprunt.calculerCoutTotal(capital, tauxAnnuel, nombreDeMois);

        // THEN
        assertThat(coutTotal).isEqualTo(result);
    }


}
