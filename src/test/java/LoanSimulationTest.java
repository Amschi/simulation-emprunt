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
        assertThat(loanSimulation.getAnualRate()).isEqualTo(rate);
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
    public void should_return_total_loan_payment_with_param_US2 () {
        // GIVEN
        double monthlyPayment = 1434.71;
        int nbMonths = 120;
        double result = 172165.2;
        // WHEN

        // THEN
        assertThat(loanSimulation.calculateLoanCost(monthlyPayment, nbMonths)).isEqualTo(result);
    }


    public void name () {

        // GIVEN
        double monthlyPayment = 1434.71;
        int nbMonths = 120;
        double result = 172165.2;
        String expectedDisplay = "Months || Interest || Repayment || Capital \n"
                + "---- || --- || ---- || 100000\n"
                + "1 || 1000 || 434.71 || 99565.29\n"
                + "2 || 995.65 || 439.06 || 99126.23\n";

        // WHEN

        // THEN
        assertThat(loanSimulation.displaySpreadingCost()).isEqualTo(expectedDisplay);
    }

    @Test
    public void should_return_interest_of_the_first_months () {
        // GIVEN
        double monthlyRate = 0.01;
        double interestResult = 1000;
        int capital = 100000;
        // WHEN

        // THEN
        assertThat(loanSimulation.calculateInterest(monthlyRate, capital)).isEqualTo(interestResult);
    }

    @Test
    public void should_return_interest_of_the_second_months () {
        // GIVEN
        double monthlyRate = 0.01;
        double interestResult = 995.65;
        int capital = 100000;
        // WHEN

        // THEN
        assertThat(loanSimulation.calculateInterest(monthlyRate, capital)).isEqualTo(interestResult);
    }

}
