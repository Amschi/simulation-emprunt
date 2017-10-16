import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Before;
import org.junit.Test;




public class MonthlyPaymentTest {

    float capital = 100000;
    float rate = 12f;
    int nbMonths = 120;
    MonthlyPayment monthlyPayment = new MonthlyPayment(capital, rate, nbMonths);




    @Test
    public void should_return_capital_entered_by_clients () {

        //GIVEN


        //WHEN


        //THEN
        assertThat(monthlyPayment.getCapital()).isEqualTo(capital);

    }


    @Test
    public void should_return_rate_entered_by_clients () {
        // GIVEN


        // WHEN

        // THEN
        assertThat(monthlyPayment.getRate()).isEqualTo(rate);
    }

    @Test
    public void should_return_months_entered_by_clients () {
        // GIVEN

        // WHEN

        // THEN
        assertThat(monthlyPayment.getNbMonths()).isEqualTo(nbMonths);
    }

    @Test
    public void name () {
        // GIVEN
        double result = 1434.71;
        // WHEN

        // THEN
        assertThat(monthlyPayment.calculateMonthlyPayment(capital,rate,nbMonths)).isEqualTo(result);
    }



}
