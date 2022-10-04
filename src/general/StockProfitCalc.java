package general;

import utils.Utils;

public class StockProfitCalc {

    public static void main(String[] args) {
        int profit = solve(7, 1, 5, 3, 6, 4);
        Utils.print(profit);
        profit = solve(7, 6, 5, 4, 3, 1);
        Utils.print(profit);
    }
    // 7, 1, 5, 3, 6, 4
    public static int solve(int ... input) {
        int maxProfit = 0;
        int index = 0;
        for (int i = 1; i < input.length; i++, index++) {
            if(input[index] < input[i]) {
                maxProfit += (input[i] - input[index]);
            }
        }
        return maxProfit;
    }

}
