package designPatterns.structural.adapter.client;

import designPatterns.structural.adapter.target.Wallet;

public class InternationalECommerce {

    public void payment(double priceInDollar, Wallet wallet) {
        System.out.println("Initiating transaction for $"+ priceInDollar);
        if(wallet.pay(priceInDollar))
            System.out.println("Payment is successful for $"+ priceInDollar);
        else
            System.out.println("Payment is failed for $"+ priceInDollar);
    }


}
