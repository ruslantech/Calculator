package calc;

public class ArabicNum {

    static int result;

    ArabicNum(String value1, String value2, String value3) {
        int num1 = Integer.parseInt(value1);
        int num2 = Integer.parseInt(value2);
        try {
            if (num1 > 10 || num2 > 10) {
                throw new Exception("Ошибка! Числа должны быть меньше или равно 10!");
            } else if (num1 < 1 || num2 < 1) {
                throw new Exception("Ошибка! Числа должны быть больше или равно 1!");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }

        switch (value3) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
    }
}

