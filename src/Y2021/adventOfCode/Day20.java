package Y2021.adventOfCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class Day20 extends BaseClass {

    public static void main(String[] args) {
        new Day20().execute();
    }

    @Override
    public void execute() {
        String data = input.get(0);
        int[] algo = IntStream.range(0, data.length()).map(i -> data.charAt(i) == '#' ? 1 : 0).toArray();

        // Refactoring litLights to lights as we toggle between ON / OFF lights
        Set<Light> lights = new HashSet<>(input.size());
        for (int i = 2; i < input.size(); i++) {
            String s = input.get(i);
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '#')
                    lights.add(new Light(i-2, j));
            }
        }

        for (int i = 0; i < 50; i++) {
            if(i == 2) {
                print("Part A : " + lights.size());
            }

            lights = imageProcessing(lights, algo, i%2 == 0);
        }

        print("Part B : " + lights.size());

        print(lights);

    }


    /**
     * Initially all the infinite lights will be OFF (.)
     * After the first step, all the infinite lights will be ON
     *
     * The idea is
     *  when infinite lights are OFF, add the ON lights to the set
     *  when infinite lights are ON, take the lights that are OFF in set
     *
     * since state infinite ON/OFF elements cannot be stored, but their respective finite OFF/ON can be tracked.
     *
     * algo[binary] == 0 is considered to add in {@link Set}
     *      when toggle == true means all infinite lights are OFF
     *
     * algo[binary] == 1 is considered to add in {@link Set}
     *      when toggle == false means all infinite lights are ON
     *
     *
     * @param lights
     * @param algo
     * @param toggle
     * @return
     */
    private Set<Light> imageProcessing(Set<Light> lights, int[] algo, boolean toggle) {
        int minR = lights.stream().map(Light::getR).sorted().min(Integer::compareTo).get();
        int maxR = lights.stream().map(Light::getR).sorted().max(Integer::compareTo).get();
        int minC = lights.stream().map(Light::getC).sorted().min(Integer::compareTo).get();
        int maxC = lights.stream().map(Light::getC).sorted().max(Integer::compareTo).get();

        Set<Light> updated = new HashSet<>(lights.size() * 2);
        for (int i = minR - 2; i < maxR + 2; i++) {
            for (int j = minC - 2; j < maxC + 2 ; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = -1; k <= 1 ; k++) {
                    for (int l = -1; l <= 1; l++) {
                        Light pxl = new Light(k+i, l+j);
                        if(lights.contains(pxl) == toggle) {
                            sb.append('1');
                        } else {
                            sb.append('0');
                        }
                    }
                }
                if(algo[Integer.parseInt(sb.toString(), 2)] == (toggle ? 0 : 1)) {
                    updated.add(new Light(i, j));
                }
            }
        }
        return updated;
    }

    private void print(Set<Light> lights) {
        int minR = lights.stream().map(Light::getR).sorted().min(Integer::compareTo).get();
        int maxR = lights.stream().map(Light::getR).sorted().max(Integer::compareTo).get();
        int minC = lights.stream().map(Light::getC).sorted().min(Integer::compareTo).get();
        int maxC = lights.stream().map(Light::getC).sorted().max(Integer::compareTo).get();
        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC ; j++) {
                if(lights.contains(new Light(i, j))) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }

        System.out.print("\n");

    }

    static class Light {
        int r;
        int c;

        public Light(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Light light = (Light) o;
            return r == light.r && c == light.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

}
