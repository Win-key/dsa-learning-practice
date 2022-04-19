package designPatterns.structural.adapter;

import designPatterns.structural.adapter.target.IndianPaymentWallet;
import designPatterns.structural.adapter.target.Wallet;

public class DollarToRupeeAdapter implements Wallet {

    private IndianPaymentWallet wallet;
    private double todayDollarValue;

    public DollarToRupeeAdapter(IndianPaymentWallet wallet, double todayDollarValue) {
        this.wallet = wallet;
        this.todayDollarValue = todayDollarValue;
    }

    @Override
    public boolean pay(double paymentInDollar) {
        return wallet.pay(paymentInDollar * todayDollarValue);
    }
}
