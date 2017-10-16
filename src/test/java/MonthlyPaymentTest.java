import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Before;
import org.junit.Test;




public class MonthlyPaymentTest {

    float capital;
    float rate;
    int nbMonths;

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
    public void should_return_monthly_payment_of_1434_with_param_US1 () {
        // GIVEN
        double result = 1434.71;
        float capital = 100000f;
        float rate = 12f;
        int nbMonths = 120;
        // WHEN

        // THEN
        assertThat(monthlyPayment.calculateMonthlyPayment(capital,rate,nbMonths)).isEqualTo(result);
    }

    @Test
    public void should_return_monthly_payment_of_717_with_param_US1 () {
        // GIVEN
        double result = 717.35;
        float capital = 50000f;
        float rate = 12f;
        int nbMonths = 120;
        // WHEN

        // THEN
        assertThat(monthlyPayment.calculateMonthlyPayment(capital,rate,nbMonths)).isEqualTo(result);
    }

    @Test
    public void name () {
        // GIVEN

        // WHEN

        // THEN
        assertThat(monthlyPayment.calculateMonthlyPayment(capital,rate,nbMonths)).isEqualTo(result);
    }






}
