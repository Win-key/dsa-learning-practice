package Y2021.adventOfCode.input;

public class Test {

    public static void main(String[] args) throws Exception {
        double data = DataReader.readInput("/avg.txt").stream().mapToInt(Integer::parseInt).average().getAsDouble();
        System.out.println(data);
    }

}
