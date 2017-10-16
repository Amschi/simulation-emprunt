public class MonthlyPayment {


    private float capital = 100000;
    private float rate = 12f;
    private int nbMonths = 120;

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
}
