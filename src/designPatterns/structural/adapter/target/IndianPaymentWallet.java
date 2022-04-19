package designPatterns.structural.adapter.target;

public class IndianPaymentWallet implements Wallet {

    private int usersWalletBalance;

    public IndianPaymentWallet(int usersWalletBalance) {
        this.usersWalletBalance = usersWalletBalance;
    }

    @Override
    public boolean pay(double paymentInRupee) {
        if(paymentInRupee > usersWalletBalance) {
            System.out.printf("Insufficient fund for Payment rupee %.2f \n", paymentInRupee);
            return false;
        }
        System.out.printf("Payment successful for rupee %.2f \n", paymentInRupee);
        usersWalletBalance -= paymentInRupee;
        return true;
    }
}
