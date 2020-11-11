package calc;

import java.util.Scanner;

public class Parser {

    static String[] pars(String input) {
        String[] parsedInput = input.split(" ");
        if (parsedInput.length != 3) {
            Scanner inputAgain = new Scanner(System.in);
            System.out.println("Неверный формат ввода данных. Введите выражение, разделяя каждый символ пробелом");
            input = inputAgain.nextLine();
            return pars(input);
        } else {
            return parsedInput;
        }
    }
}
