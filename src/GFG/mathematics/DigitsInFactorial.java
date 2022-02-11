package GFG.mathematics;

import java.util.stream.IntStream;

public class DigitsInFactorial {

    public static void main(String[] args) {
        IntStream.range(1, 100).forEach(DigitsInFactorial::digitsInFactorial);
    }


    // ceil of log(n)+log(n-1)+log(n-2)+....+log(1)
    public static int digitsInFactorial(int N){
        // code here
        double x = 0;
        for(int i = 1; i <= N; i++) {
            x += Math.log10(i);
        }
        return (int)(x+1);
    }
}
