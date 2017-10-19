public class LoanSimulation {
    private static final double NB_MONTHS_BY_YEAR = 12;
    private static final double POURCENTAGE = 100;


    public double calculateMonthlyPayment(float capital, float annualRate, int nbMonths) {

        if (capital <= 0) {
            return 0;
        }

        if (annualRate <=0){
            return  0;

        }
        else {
            double monthlyRate = annualRate / (NB_MONTHS_BY_YEAR * POURCENTAGE);
            double monthlyPayment = (capital * monthlyRate) / (1 - (Math.pow(1 + monthlyRate, -nbMonths)));
            return monthlyPayment;
        }
    }

    public double calculateLoanCost(float capital, float annualRate, int nbMonths) {
        double totalCoast = calculateMonthlyPayment(capital, annualRate, nbMonths) * nbMonths;
        return totalCoast;
    }
}
