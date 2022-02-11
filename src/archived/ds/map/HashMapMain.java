package archived.ds.map;

public class HashMapMain {

    public static void main(String[] args) {
        HashMap<String, String> stringHashMap = new HashMap<>(2);
        stringHashMap.put("I20033", "Winkey");
        stringHashMap.put("I20033", "Venkatesh Rajendran");
        stringHashMap.put("I20030", "Random guy");
        stringHashMap.put("I20876", "MSD");
        stringHashMap.put("I2086", "Gangly");


        System.out.println(stringHashMap.containsKey("I20033"));
        System.out.println(stringHashMap.remove("I20030"));
        System.out.println(stringHashMap);

        HashMap<Integer, Integer> integerHashMap = new HashMap<>(2);
        integerHashMap.put(1,1000);
        integerHashMap.put(2,2000);
        integerHashMap.put(3,3000);
        integerHashMap.put(12,2020);

        System.out.println(integerHashMap.containsKey(2));
        System.out.println(integerHashMap);
        System.out.println(integerHashMap.remove(12));
        System.out.println(integerHashMap);
    }
}
