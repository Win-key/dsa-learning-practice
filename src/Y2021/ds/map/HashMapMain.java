package Y2021.ds.map;

public class HashMapMain {

    public static void main(String[] args) {
        HashMap<String, String> customMap = new HashMap<>(2);
        customMap.put("I20033", "Winkey");
        customMap.put("I20033", "Venkatesh Rajendran");
        customMap.put("I20030", "Random guy");
        customMap.put("I20876", "MSD");
        customMap.put("I2086", "Gangly");

        System.out.println(customMap);
    }
}
