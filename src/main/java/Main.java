public class Main {
    public static void main(String[] args) {

    MonthlyPayment monthlyPayment = new MonthlyPayment(50000, 12f, 120);
    double result = monthlyPayment.calculateMonthlyPayment(50000,12f,120);

    System.out.println(result);
    }
}
