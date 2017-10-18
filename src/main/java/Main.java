public class Main {
    public static void main(String[] args) {

    LoanSimulation monthlyPayment = new LoanSimulation();
    double resultMonthlyPayment = monthlyPayment.calculateMonthlyPayment(50000,12f,120);
    double resultTotalLoan = monthlyPayment.calculateLoanCost(resultMonthlyPayment, 120);

    System.out.println("Vos mensualités sont de"+" "+ +resultMonthlyPayment+" "+ "pour un cout total de" +" "+resultTotalLoan);
    
    
    }
}
