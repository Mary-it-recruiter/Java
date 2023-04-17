//3*дополнительно. К калькулятору из предыдущего дз добавить логирование.
//        1 + 3 = 4
//        4 + 3 = 7

package Lesson2;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class task_3 {
    static float calc(float a, char o, float b){
        return switch (o) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> 0;
        };
    }
    static String getResult(float a, char o, float b){
        StringBuilder res = new StringBuilder();
        return res.append(a).append(" ").append(o).append(" ").append(b).append(" = ").append(calc(a,o,b)).toString();
    }
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Lesson2.task_3.class.getName());
        FileHandler info;
        try {
            info = new FileHandler("log_calc.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SimpleFormatter sf = new SimpleFormatter();
        info.setFormatter(sf);
        logger.addHandler(info);

        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите a: ");
            float a = scan.nextFloat();
            System.out.print("Введите знак: ");
            String o = scan.next();
            System.out.print("Введите b: ");
            float b = scan.nextFloat();
            String result = getResult(a, o.toCharArray()[0], b);

            logger.info(result);
        }catch (InputMismatchException e){
            logger.info("Неверный ввод!");
        }

    }

}
