package calc;

public class RomanNum {
    private String romStrVal1;
    private String romStrVal2;
    private int romIntVal1;
    private int romIntVal2;
    private int resultInt;
    private String resultStr;
    private String sign = "";
    private final String[] romanLetters = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    RomanNum(String value1, String value2, String value3) {
        this.romStrVal1 = value1.toUpperCase();
        this.romStrVal2 = value2.toUpperCase();
        this.romIntVal1 = convertToInt(romStrVal1);
        this.romIntVal2 = convertToInt(romStrVal2);

        switch (value3) {
            case "+": sum();
                break;
            case "-": sub();
                break;
            case "*": mul();
                break;
            case "/": div();
                break;
        }
    }

    private int convertToInt(String romStrVal){
        char[] charVal = romStrVal.toCharArray();
        int[] intVal = new int[charVal.length];
        for (int i = 0; i < charVal.length; i++) {
            switch (charVal[i]) {
                case 'I':
                    intVal[i] = 1;
                    break;
                case 'V':
                    intVal[i] = 5;
                    break;
                case 'X':
                    intVal[i] = 10;
                    break;

                default:
                    System.out.println("Ошибка! введены арабские и римские цифры одновременно! или не корректный ввод римских цыфр!");
                    System.exit(0);
                    break;
            }
        }
        int result = intVal[0];
        for (int i = 0; i < intVal.length && intVal.length > i + 1; i++) {
            if (intVal[i] >= intVal[i+1]) {
                result += intVal[i+1];
            } else if (intVal[i] < intVal[i+1]) {
                result += intVal[i+1] - 2;
            }
        }
        return result;
    }

    private String convertToRomes(int num, int remainder) {
        remainder = num % 10;
        if (remainder != 0) {
            try {
                return convertToRomes(num - remainder, 0) + romanLetters[remainder - 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                sign = "-";
                return convertToRomes(num - remainder, 0) + romanLetters[(remainder + 1) * -1];
            }
        }

        if (num > 0) {
            num -= 10;
            return convertToRomes(num,0) + "X";
        } else if (num < 0) {
            num += 10;
            return convertToRomes(num,0) + "X";
        }   else {
            return sign;
        }
    }

    public void sum() {
        resultInt = romIntVal1 + romIntVal2;
        resultStr = convertToRomes(resultInt, resultInt);
    }

    public void sub() {
        resultInt = romIntVal1 - romIntVal2;
        resultStr = convertToRomes(resultInt, resultInt);
    }

    public void div() {
            resultInt = romIntVal1 / romIntVal2;
            resultStr = convertToRomes(resultInt, resultInt);
    }

    public void mul() {
        resultInt = romIntVal1 * romIntVal2;
        resultStr = convertToRomes(resultInt, resultInt);
    }

    public String getStringResult() {
        return resultStr;
    }
}
