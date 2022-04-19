package designPatterns.structural.adapter;

import designPatterns.structural.adapter.client.InternationalECommerce;
import designPatterns.structural.adapter.target.IndianPaymentWallet;
import designPatterns.structural.adapter.target.Wallet;

public class AppRunner {

    public static void main(String[] args) {
        InternationalECommerce eCommerce = new InternationalECommerce();

        IndianPaymentWallet myWallet = new IndianPaymentWallet(1000);
        Wallet myWalletAdapter = new DollarToRupeeAdapter(myWallet, 76.31 );

        eCommerce.payment(7, myWalletAdapter);

        eCommerce.payment(9, myWalletAdapter);

    }

}
