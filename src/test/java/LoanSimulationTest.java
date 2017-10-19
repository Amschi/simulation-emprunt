import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.Before;
import org.junit.Test;


public class LoanSimulationTest {

    LoanSimulation loanSimulation;
    double monthlyPayment;


    @Before
    public void setUp() throws Exception {
        loanSimulation = new LoanSimulation();
    }


    @Test
    public void capital_entered_should_be_positive() {
        // GIVEN
        float capital = -100000f;
        float annualRate = 12f;
        int nbMonthsLoanDuration = 120;
        // WHEN
        monthlyPayment = loanSimulation.calculateMonthlyPayment(capital, annualRate, nbMonthsLoanDuration);
        // THEN
        assertThat(monthlyPayment).isEqualTo(0);
    }


    @Test
    public void annualRate_entered_should_be_positive() {
        // GIVEN
        float capital = 100000f;
        float annualRate = -12f;
        int nbMonthsLoanDuration = 120;
        // WHEN
        monthlyPayment = loanSimulation.calculateMonthlyPayment(capital, annualRate, nbMonthsLoanDuration);
        // THEN
        assertThat(monthlyPayment).isEqualTo(0);
    }






    @Test
    public void should_return_monthly_payment_of_1434_with_param_US1() {
        // GIVEN
        double result = 1434.709484025873;
        float capital = 100000f;
        float annualRate = 12f;
        int nbMonthsLoanDuration = 120;
        //WHEN
        monthlyPayment = loanSimulation.calculateMonthlyPayment(capital, annualRate, nbMonthsLoanDuration);

        // THEN
        assertThat(monthlyPayment).isEqualTo(result);
    }

    @Test
    public void should_return_monthly_payment_of_717_US1() {
        // GIVEN
        double result = 717.3547420129365;
        float capital = 50000f;
        float annualRate = 12f;
        int nbMonthsLoanDuration = 120;

        //WHEN
        monthlyPayment = loanSimulation.calculateMonthlyPayment(capital, annualRate, nbMonthsLoanDuration);

        // THEN
        assertThat(monthlyPayment).isEqualTo(result);
    }

    @Test
    public void should_return_total_loan_cost_with_param_US2() {
        // GIVEN
        double result = 172165.13808310477;
        float capital = 100000f;
        float annualRate = 12f;
        int nbMonthsLoanDuration = 120;

        // WHEN
        double totalLoanCost = loanSimulation.calculateLoanCost(capital, annualRate, nbMonthsLoanDuration);

        // THEN
        assertThat(totalLoanCost).isEqualTo(result);
    }


}
