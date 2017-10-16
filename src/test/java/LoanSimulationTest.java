import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Test;




public class LoanSimulationTest {

    float capital;
    float rate;
    int nbMonths;

    LoanSimulation loanSimulation = new LoanSimulation(capital, rate, nbMonths);




    @Test
    public void should_return_capital_entered_by_clients () {

        //GIVEN


        //WHEN


        //THEN
        assertThat(loanSimulation.getCapital()).isEqualTo(capital);

    }


    @Test
    public void should_return_rate_entered_by_clients () {
        // GIVEN

        // WHEN

        // THEN
        assertThat(loanSimulation.getRate()).isEqualTo(rate);
    }

    @Test
    public void should_return_months_entered_by_clients () {
        // GIVEN

        // WHEN

        // THEN
        assertThat(loanSimulation.getNbMonths()).isEqualTo(nbMonths);
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
        assertThat(loanSimulation.calculateMonthlyPayment(capital,rate,nbMonths)).isEqualTo(result);
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
        assertThat(loanSimulation.calculateMonthlyPayment(capital,rate,nbMonths)).isEqualTo(result);
    }

    @Test
    public void name () {
        // GIVEN
        double monthlyPayment = 1434.71;
        int nbMonths = 120;
        double result = 172165.2;
        // WHEN

        // THEN
        assertThat(loanSimulation.calculateLoanCost(monthlyPayment, nbMonths)).isEqualTo(result);
    }






}
