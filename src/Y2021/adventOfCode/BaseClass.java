package Y2021.adventOfCode;

import Y2021.adventOfCode.input.DataReader;

import java.util.Arrays;
import java.util.List;

public abstract class BaseClass {

    List<String> input;

    protected BaseClass(){
        try {
            this.input = DataReader.readInput( "/"+getClass().getSimpleName().toLowerCase() + ".txt");
        } catch (Exception ignored) {}
    }

    public abstract void execute();

    public void print(Object o) {
        if(o instanceof Object[]) {
            System.out.println(Arrays.toString((Object[]) o));
        } else {
            System.out.println(o);
        }
    }

}
