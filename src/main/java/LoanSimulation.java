import java.math.*;

public class LoanSimulation {
    private static final double nbMonthsByYear = 12;
    private static final double pourcentage = 100;


    public double calculateMonthlyPayment(float capital, float annualRate, int nbMonths) {

        double monthlyRate = annualRate / (nbMonthsByYear * pourcentage);
        double monthlyPayment = (capital * monthlyRate) / (1 - (Math.pow(1 + monthlyRate, -nbMonths)));
        return monthlyPayment;
    }


    public double calculateLoanCost(double monthlyPayment, int nbMonths) {
        return monthlyPayment * nbMonths;
    }
}
