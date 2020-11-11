package calc;

import java.util.Scanner;

public class Main {
    private static boolean arabicNumbers = true;

    public static void main(String[] args){
        Scanner inputVal = new Scanner(System.in);

        System.out.println("Введите выражение, состоящее из двух Арабских или Римских целых чисел от 1 до 10 и знака операции с пробелом (напр. 2 + 2 ): ");
        String input = inputVal.nextLine();
        while (!input.isEmpty()) {
            String[] parsedInput = Parser.pars(input);

            try {
                int num1 = Integer.parseInt(parsedInput[0]);
                int num2 = Integer.parseInt(parsedInput[2]);
            } catch (NumberFormatException e) {
                arabicNumbers = false;
            }

            if (arabicNumbers) {
                ArabicNum value = new ArabicNum(parsedInput[0], parsedInput[2], parsedInput[1]);
                System.out.println("Результат: " + ArabicNum.result);
            } else {
                RomanNum value = new RomanNum(parsedInput[0], parsedInput[2], parsedInput[1]);
                System.out.println("Результат: " + value.getStringResult());
            }

            System.out.println();
            System.out.print("Введите следующее выражение: ");
            input = inputVal.nextLine();
        }
    }
}
