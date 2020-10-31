import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Alexandr Makhorkin
 * @version 1.0
 * Класс для измерения времени выполнения методов интерфейса List
 */
public class Timer {

    /**
     * Создает список определенного размера
     * @param list объект List
     * @param size размер создаваемого списка
     */
    private static void create(List list, int size){
        list.clear();

        for (int i = 0; i < size; i++) {
            list.add(0);
        }
    }

    /**
     * Измеряет время, в течение которого вызывется метод add определенное количество раз.
     * При этом элементы добавляются в середину списка
     * @param list объект List
     * @param iterations количество вызовов метода
     * @return время выполнения
     */
    public static long addMiddleTime(List<Integer> list, int iterations){
        Timer.create(list, iterations);

        int middleIndex = list.size()/2;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            list.add(middleIndex++, 0);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }


    /**
     * Измеряет время, в течение которого вызывется метод add определенное количество раз.
     * При этом элементы добавляются в конец списка
     * @param list объект List
     * @param iterations количество вызовов метода
     * @return время выполнения
     */
    public static long addTailTime(List<Integer> list, int iterations){
        Timer.create(list, iterations);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            list.add(0);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }


    /**
     * Измеряет время, в течение которого вызывется метод add определенное количество раз.
     * При этом элементы добавляются в начало списка
     * @param list объект List
     * @param iterations количество вызовов метода
     * @return время выполнения
     */
    public static long addHeadTime(List<Integer> list, int iterations){
        Timer.create(list, iterations);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            list.add(0, 0);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }


    /**
     * Измеряет время, в течение которого вызывется метод remove определенное количество раз.
     * При этом элементы удаляются из середины списка
     * @param list объект List
     * @param iterations количество вызовов метода
     * @return время выполнения
     */
    public static long removeMiddleTime(List<Integer> list, int iterations){
        Timer.create(list, iterations);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            list.remove(list.size()/2);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }


    /**
     * Измеряет время, в течение которого вызывется метод remove определенное количество раз.
     * При этом элементы удаляются из конца списка
     * @param list объект List
     * @param iterations количество вызовов метода
     * @return время выполнения
     */
    public static long removeTailTime(List<Integer> list, int iterations){
        Timer.create(list, iterations);


        int index = iterations-1;

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            list.remove(index--);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }


    /**
     * Измеряет время, в течение которого вызывется метод remove определенное количество раз.
     * При этом элементы удаляются из начала списка
     * @param list объект List
     * @param iterations количество вызовов метода
     * @return время выполнения
     */
    public static long removeHeadTime(List<Integer> list, int iterations){
        Timer.create(list, iterations);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            list.remove(0);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }



    /**
     * Измеряет время, в течение которого вызывется метод get определенное количество раз.
     * @param list объект List
     * @param iterations количество вызовов метода
     * @return время выполнения
     */
    public static long getTime(List<Integer> list, int iterations){
        Timer.create(list, iterations);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Формирует таблицу с информацией о времени выполнения при вызове основных методов интерфейса List определенное количество раз.
     * @param iterations количестов вызовов для всех методов
     */
    public static void formTable(int iterations){
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        String leftAlignFormat = "| %-15s | %-10d |  %-13s |  %-14s |%n";

        System.out.format("+-----------------+------------+----------------+-----------------+%n");
        System.out.format("|     Method      | Iterations | ArrayList time | LinkedList time |%n");
        System.out.format("+-----------------+------------+----------------+-----------------+%n");
        System.out.format(leftAlignFormat, "add (middle)", iterations, Timer.addMiddleTime(arrayList, iterations)+ " ms",
                Timer.addMiddleTime(linkedList, iterations) + " ms");
        System.out.format(leftAlignFormat, "add (tail)", iterations, Timer.addTailTime(arrayList, iterations)+ " ms",
                Timer.addTailTime(linkedList, iterations) + " ms");
        System.out.format(leftAlignFormat, "add (head)", iterations, Timer.addHeadTime(arrayList, iterations)+ " ms",
                Timer.addHeadTime(linkedList, iterations) + " ms");
        System.out.format(leftAlignFormat, "get", iterations, Timer.getTime(arrayList, iterations)+ " ms",
                Timer.getTime(linkedList, iterations) + " ms");
        System.out.format(leftAlignFormat, "remove (middle)", iterations, Timer.removeMiddleTime(arrayList, iterations)+ " ms",
                Timer.removeMiddleTime(linkedList, iterations) + " ms");
        System.out.format(leftAlignFormat, "remove (tail)", iterations, Timer.removeTailTime(arrayList, iterations)+ " ms",
                Timer.removeTailTime(linkedList, iterations) + " ms");
        System.out.format(leftAlignFormat, "remove (head)", iterations, Timer.removeHeadTime(arrayList, iterations)+ " ms",
                Timer.removeHeadTime(linkedList, iterations) + " ms");
        System.out.format("+-----------------+------------+----------------+-----------------+%n");
    }

    /**
     * Формирует таблицу с информацией о времени выполнения при вызове основных методов интерфейса List определенное количество раз.
     * @param addIt количество вызовов метода add
     * @param getIt количество вызовов метода get
     * @param removeIt количество вызовов метода remove
     */
    public static void formTable(int addIt, int getIt, int removeIt){
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        String leftAlignFormat = "| %-15s | %-10d |  %-13s |  %-14s |%n";

        System.out.format("+-----------------+------------+----------------+-----------------+%n");
        System.out.format("|     Method      | Iterations | ArrayList time | LinkedList time |%n");
        System.out.format("+-----------------+------------+----------------+-----------------+%n");
        System.out.format(leftAlignFormat, "add (middle)", addIt, Timer.addMiddleTime(arrayList, addIt)+ " ms",
                Timer.addMiddleTime(linkedList, addIt) + " ms");
        System.out.format(leftAlignFormat, "add (tail)", addIt, Timer.addTailTime(arrayList, addIt)+ " ms",
                Timer.addTailTime(linkedList, addIt) + " ms");
        System.out.format(leftAlignFormat, "add (head)", addIt, Timer.addHeadTime(arrayList, addIt)+ " ms",
                Timer.addHeadTime(linkedList, addIt) + " ms");
        System.out.format(leftAlignFormat, "get", getIt, Timer.getTime(arrayList, getIt)+ " ms",
                Timer.getTime(linkedList, getIt) + " ms");
        System.out.format(leftAlignFormat, "remove (middle)", removeIt, Timer.removeMiddleTime(arrayList, removeIt)+ " ms",
                Timer.removeMiddleTime(linkedList, removeIt) + " ms");
        System.out.format(leftAlignFormat, "remove (tail)", removeIt, Timer.removeTailTime(arrayList, removeIt)+ " ms",
                Timer.removeTailTime(linkedList, removeIt) + " ms");
        System.out.format(leftAlignFormat, "remove (head)", removeIt, Timer.removeHeadTime(arrayList, removeIt)+ " ms",
                Timer.removeHeadTime(linkedList, removeIt) + " ms");
        System.out.format("+-----------------+------------+----------------+-----------------+%n");
    }

}
