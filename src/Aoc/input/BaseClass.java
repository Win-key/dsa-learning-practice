package Aoc.input;

import java.util.Arrays;
import java.util.List;

public abstract class BaseClass {

    public List<String> input;

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
