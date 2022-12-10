package general;

import Aoc.input.DataReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseReader {

    private static Map<String, Integer> mem = new HashMap<>();
    public static void main(String[] args) throws Exception {
        List<String> data = DataReader.readInput("/Theme votes - Form Responses 1.csv");
        data.stream().skip(1).forEach(ResponseReader::countResponse);

        System.out.println(mapToResponseCount());
    }

    private static List<ResponseCount> mapToResponseCount() {
        List<ResponseCount> result = new ArrayList<>(mem.size());
        mem.forEach((k,v) -> result.add(new ResponseCount(v, k)));
        return result.stream().sorted(Comparator.comparing(ResponseCount::getCount).reversed()).collect(Collectors.toList());
    }

    private static void countResponse(String response) {
        StringBuilder sb = new StringBuilder();

        response = response.substring(response.indexOf("\"")+1, response.lastIndexOf("\""));

        int n = response.length();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if(response.charAt(i) == '(') {
                flag = false;
                String value = sb.toString().trim();
                mem.put(value, mem.getOrDefault(value, 0) + 1);
            }
            if(response.charAt(i) == ',' && response.charAt(i-1) == ')') {
                flag = true;
                sb.setLength(0);
                i++;
            }
            if(flag)
                sb.append(response.charAt(i));
        }
    }

    static class ResponseCount {
        int count;
        String response;

        public int getCount() {
            return count;
        }

        public ResponseCount(int count, String response) {
            this.count = count;
            this.response = response;
        }

        @Override
        public String toString() {
            return "{" +
                    "'response' : '" + response + "' , 'count' :" + count +
                    '}';
        }
    }
}
