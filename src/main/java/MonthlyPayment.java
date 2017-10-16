import java.math.*;

public class MonthlyPayment {


    private float capital;
    private float rate;
    private int nbMonths;

    public MonthlyPayment (float capital, float rate, int nbMonths) {
            this.capital = capital;
            this.rate = rate;
            this.nbMonths = nbMonths;
    }



    public float getCapital() {
        return capital;
    }

    public float getRate() {
        return rate;
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


}
