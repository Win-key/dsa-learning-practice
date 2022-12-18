package Aoc.Y2022;

import Aoc.input.BaseClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Day13 extends BaseClass {

    public static void main(String[] args) {
        new Day13().execute();
    }

    @Override
    public void execute() {
        var queue = new ArrayDeque<>(input);
        List<Pair> pairs = new ArrayList<>(input.size()/3);
        while (!queue.isEmpty()) {
            pairs.add(Pair.build(queue));
        }

        // part 1
        int total = 0;
        for (int i = 0; i < pairs.size(); i++) {
            if(pairs.get(i).compare()) {
                total += (i + 1);
            }
        }
        print(total);

        // part 2
        List<Element> elements = new ArrayList<>();
        for (Pair pair : pairs) {
            elements.add(pair.left);
            elements.add(pair.right);
        }
        Element div1 = Element.build("[[2]]");
        Element div2 = Element.build("[[6]]");
        elements.add(div1);
        elements.add(div2);
        elements.sort(Element::compare);
        total = 1;
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).equals(div1)
                    || elements.get(i).equals(div2)) {
                total *= (i + 1);
            }
        }
        print(total);
    }

    static class Pair {
        private Element left;
        private Element right;
        public boolean compare() {
            int compare = left.compare(right);
            return compare <= 0;
        }

        public static Pair build(Queue<String> list) {
            Pair pair = new Pair();
            pair.left = Element.build(list.poll());
            pair.right = Element.build(list.poll());
            list.poll();
            return pair;
        }

    }

    interface Element {
        int compare(Element element);
        static Element build(String expression) {
            ListElement input = new ListElement();
            expression = expression.substring(1, expression.length() - 1);
            int size = expression.length();
            for (int pos = 0; pos < size; pos++) {
                char c = expression.charAt(pos);
                if(c == '[') {
                    int openPos = pos++, open = 1;
                    while (open > 0) {
                        c = expression.charAt(pos++);
                        open += c == '[' ? 1 : 0;
                        open += c == ']' ? -1 : 0;
                    }
                    input.add(build(expression.substring(openPos, pos)));
                }
                if(c >= '0' && c <= '9') {
                    StringBuilder sb = new StringBuilder();
                    try {
                        while (c >= '0' && c <= '9') {
                            sb.append(c);
                            c = ++pos < size ? expression.charAt(pos) : '\0';
                        }
                        input.add(Integer.valueOf(sb.toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    pos--;
                }
            }
            return input;
        }
    }

    static class SingleElement implements Element {

        private Integer value;

        @Override
        public String toString() {
            return value.toString();
        }

        public SingleElement(Integer value) {
            this.value = value;
        }

        @Override
        public int compare(Element element) {
            if(element instanceof ListElement) {
                var thisList = ListElement.convert(this);
                return thisList.compare(element);
            }
            return compare(value, ((SingleElement)element).value);
        }

        private int compare(Integer a, Integer b) {
            return a - b ;
        }

    }

    static class ListElement implements Element {

        private List<Element> values = new ArrayList<>();

        public ListElement add(Integer value) {
            values.add(new SingleElement(value));
            return this;
        }

        public ListElement add(Element element) {
            values.add(element);
            return this;
        }

        @Override
        public int compare(Element element) {
            ListElement listElement = convert(element);
            List<Element> left = values;
            List<Element> right = listElement.values;
            int i = 0;
            while (i < left.size() && i < right.size()) {
                int compare = left.get(i).compare(right.get(i));
                if(compare != 0) {
                    return compare;
                }
                i++;
            }
            return left.size() - right.size();
        }

        @Override
        public String toString() {
            var sb = new StringBuilder();
            values.forEach(e -> sb.append(',').append(e.toString()));
            return sb.toString();
        }

        public static ListElement convert(Element element) {
            if(element instanceof SingleElement) {
                return new ListElement().add(((SingleElement) element).value);
            }
            return (ListElement) element;
        }
    }

}
