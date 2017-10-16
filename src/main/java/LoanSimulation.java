import java.math.*;

public class LoanSimulation {


    private float capital;
    private float rate;
    private int nbMonths;

    public LoanSimulation(float capital, float rate, int nbMonths) {
            this.capital = capital;
            this.rate = rate;
            this.nbMonths = nbMonths;
    }



    public float getCapital() {
        return capital;
    }

    public float getAnualRate() {
        return rate;
    }


    public float getMonthlyRate() {
        return getAnualRate()/1200;
    }

    public int getNbMonths() {
        return nbMonths;
    }


    public double calculateMonthlyPayment(float capital, float rate, int nbMonths) {
        double monthlyPayment;
        double monthlyRate = rate/1200;

        monthlyPayment = (capital*monthlyRate) / (1 - (Math.pow(1 + monthlyRate, - nbMonths)));
        double result = Round.round(monthlyPayment, 2);
        return result;
    }


    public double calculateLoanCost(double monthlyPayment, int nbMonths) {
        return monthlyPayment * nbMonths;
    }

    public boolean displaySpreadingCost() {
         return true;
    }


    public double calculateInterest(double monthlyRate, double capital) {

        for(int i = 0; i < getNbMonths(); i++) {


            double interest = monthlyRate * capital;
            return interest;
        }
    }
}
