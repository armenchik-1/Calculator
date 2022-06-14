import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.forLanguageTag("eng"));
        Integer i1 = null;
        Integer i2 = null;
        Double d1 = null;
        Double d2 = null;
        String action = null;
        String[] arr = null;

        while (true) {
            i1 = null;
            i2 = null;
            d1 = null;
            d2 = null;
            arr = scanner.nextLine().split("\\s");
            for (int i = 0, k = 0; i < arr.length; i++, k++) {
                if (k == 0) {
                    try {
                        i1 = Integer.valueOf(arr[i]);
                    } catch (Exception e) {
                        d1 = Double.valueOf(arr[i]);
                    }
                } else if (k % 2 == 1) {
                    action = arr[i];
                } else if (k % 2 == 0) {
                    try {
                        i2 = Integer.valueOf(arr[i]);
                    } catch (Exception e) {
                        d2 = Double.valueOf(arr[i]);
                    }
                }
            }

            if (i1 == null && i2 == null) {
                calc(d1, action, d2);
            } else if (i1 != null && i2 == null) {
                calc(i1, action, d2);
            } else if (i1 == null && i2 != null) {
                calc(d1, action, i2);
            } else {
                calc(i1, action, i2);
            }
        }
    }

    public static void calc(Object a, String action, Object b) {
        if (a instanceof Integer && b instanceof Integer) {
            Integer aI = (Integer) a;
            Integer bI = (Integer) b;
            if(action.equals("/") && aI % bI != 0) {
                Double aD2 = Double.valueOf(aI.toString());
                Double bD2 = Double.valueOf(bI.toString());

                operationWithDouble(aD2,action,bD2);
            } else {
                operationWithInteger(aI, action, bI);
            }

        } else {
            Double aD = Double.valueOf(a.toString());
            Double bD = Double.valueOf(b.toString());
            operationWithDouble(aD,action,bD);

        }
    }

    public static void operationWithInteger(Integer aI, String action, Integer bI){
        System.out.print("Ответ: ");
        switch (action) {
            case "+":
                System.out.println((aI + bI));
                break;
            case "-":
                System.out.println((aI - bI));
                break;
            case "*":
                System.out.println((aI * bI));
                break;
            case "/":
                System.out.println((aI / bI));
                break;
            default:
                System.out.println("Вы ввели некорректные данные. Повторите попытку:");
                break;
        }
    }

    public static void operationWithDouble(Double aD, String action, Double bD) {
        System.out.print("Ответ: ");
        switch (action) {
            case "+":
                System.out.println(aD + bD);
                break;
            case "-":
                System.out.println(aD - bD);
                break;
            case "*":
                System.out.println(aD * bD);
                break;
            case "/":
                System.out.println(aD / bD);
                break;
            default:
                System.out.println("Вы ввели некорректные данные. Повторите попытку:");
                break;
        }
    }
}
