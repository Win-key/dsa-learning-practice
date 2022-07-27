package GFG;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class FormatHeaders {

    public static void main(String[] args) {
        String header = "organization_uuid";
        printFormat(header);
        header = "Requested By";
        printFormat(header);
        header = "order_";
        printFormat(header);

        header = "_order_";
        printFormat(header);

        header = "cancer_stage_biomarkers";
        printFormat(header);

        header = "       ";
        printFormat(header);

        header = "";
        printFormat(header);

        header = "abcd";
        printFormat(header);

        header = "_abcd";
        printFormat(header);

        header = " abcd";
        printFormat(header);
    }

    public static void printFormat(String header) {
        System.out.println("before : " + header);
        header = format2(header);
        System.out.println("after : " +header);
    }

    public static String format2(String input) {
        input = input.replaceAll("\\_", " ");
        Optional<String> optional = Arrays.stream(input.split(" "))
                .filter(s -> Objects.nonNull(s) && !s.equals(""))
                .map(s -> (""+s.charAt(0)).toUpperCase() + s.substring(1))
                .reduce((left, right) -> left + " " + right);
        return optional.isEmpty() ? "" : optional.get();
    }

    public static String format(String input) {
        Objects.requireNonNull(input);
        char[] cAr = input.toCharArray();
        char p = '_';
        int i = 0;
        for (; i < cAr.length; i++) {
            char c = cAr[i];
            if(p == '_' && c >= 'a' && c <= 'z') {
                cAr[i] = (char) (c - 32);
                if( i > 0)  cAr[i - 1] = ' ';
            }
            p = c;
        }
        if(p == '_')  cAr[i - 1] = ' ';

        return new String(cAr).trim();
    }



}
