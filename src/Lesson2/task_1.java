//Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
//        результат после каждой итерации запишите в лог-файл.

package Lesson2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;
public class task_1 {

    static int[] bubbleSort(int[] arr) throws IOException {
        Logger logger = Logger.getLogger(task_1.class.getName());
//        ConsoleHandler info = new ConsoleHandler();
        FileHandler info = new FileHandler("log.txt", true);
        SimpleFormatter sf = new SimpleFormatter();
        info.setFormatter(sf);
//        XMLFormatter xf = new XMLFormatter();
//        info.setFormatter(xf);
        logger.addHandler(info);
        boolean flag = false;

        while(!flag) {
            //System.out.println(Arrays.toString(arr));
            logger.info(Arrays.toString(arr));
            flag = true;
            for (int i = 0; i < arr.length; i++) {
                if (i + 1 < arr.length && arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    flag = false;
                }
            }

        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        System.out.print(Arrays.toString(bubbleSort(new int[]{6,2,3,1,45,6,10,7,4,7,4,8})));
    }
}
