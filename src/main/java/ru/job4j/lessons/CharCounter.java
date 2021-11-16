package ru.job4j.lessons;

public class CharCounter {

    public static String charCounter(String original) {
        char[] chars = original.toCharArray();
        int counter = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                counter++;
            } else {
                result.append(Integer.toString(counter))
                        .append(chars[i - 1])
                        .append(" ");
                counter = 1;
            }
            if (i == chars.length - 1) {
                result.append(Integer.toString(counter)).append(chars[i]);
            }

        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(charCounter("aabccdffca"));
    }
}
