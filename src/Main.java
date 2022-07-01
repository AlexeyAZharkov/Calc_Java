import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String st = in.nextLine();
        in.close();
        String res = calc(st);
//        System.out.println(res);
        }
    public static String calc(String input) {

        String[] words = input.split("\\+");
        if (words.length == 2) check(words[0], "+", words[1]);
        String[] words1 = input.split("-");
        if (words1.length == 2) check(words1[0], "-", words1[1]);
        String[] words2 = input.split("\\*");
        if (words2.length == 2) check(words2[0], "*", words2[1]);
        String[] words3 = input.split("/");
        if (words3.length == 2) check(words3[0], "/", words3[1]);

//        for(String word : words)
//            System.out.println(word);

        return input;
    }

    public static void check(String left, String op, String right) {
        boolean le_str = false;
        boolean ri_str = false;
        int le = 0;
        int ri = 0;
        String res = "";

        try {
            le = Integer.parseInt(left.trim());
        } catch (NumberFormatException nfe) {
            le_str = true;
        }

        try {
            ri = Integer.parseInt(right.trim());
        } catch (NumberFormatException nfe) {
            ri_str = true;
        }

        if (le_str && ri_str) {
            res = calculate(romeToInt(left), op, romeToInt(right));
            res = intToRome(res);

        }
        if (!le_str && !ri_str) res = calculate(le, op, ri);
//        System.out.println("Error different");
        System.out.println(res);

    }

    public static String calculate(int left, String op, int right) {
        int result = 0;

        if (left > 10 || left < 1 || right > 10 || right < 1) System.out.println("Числа вне диап");
        switch (op) {
            case "+" -> result = left + right;
            case "-" -> result = left - right;
            case "*" -> result = left * right;
            case "/" -> result = left / right;
            default -> System.out.println("не выбран ни один из пунктов меню");
        }
        return Integer.toString(result);

    }
    public static int romeToInt(String rome) {
        int num = 0;

        switch (rome.toUpperCase().strip()) {
            case "I" -> num = 1;
            case "II" -> num = 2;
            case "III" -> num = 3;
            case "IV" -> num = 4;
            case "V" -> num = 5;
            case "VI" -> num = 6;
            case "VII" -> num = 7;
            case "VIII" -> num = 8;
            case "IX" -> num = 9;
            case "X" -> num = 10;
            default -> System.out.println("не выбран ни один из пунктов меню");
        }

        return num;

    }
    public static String intToRome(String st) {
        String res = "";
        int num = Integer.parseInt(st);
        if (num <= 0) System.out.println("Отрицат Римские");
        if (num == 100) return "C";
        int dec = num / 10;
        int ed = num % 10;

        switch (dec) {
            case 0 -> res = "";
            case 1 -> res = "X";
            case 2 -> res = "XX";
            case 3 -> res = "XXX";
            case 4 -> res = "XL";
            case 5 -> res = "L";
            case 6 -> res = "LX";
            case 7 -> res = "LXX";
            case 8 -> res = "LXXX";
            case 9 -> res = "XC";
            default -> System.out.println("не выбран ни один из пунктов меню");
        }
        switch (ed) {
            case 0 -> res += "";
            case 1 -> res += "I";
            case 2 -> res += "II";
            case 3 -> res += "III";
            case 4 -> res += "IV";
            case 5 -> res += "V";
            case 6 -> res += "VI";
            case 7 -> res += "VII";
            case 8 -> res += "VIII";
            case 9 -> res += "IX";
            default -> System.out.println("не выбран ни один из пунктов меню");
        }

        return res;

    }
}