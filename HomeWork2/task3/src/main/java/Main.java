import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };
        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)
     */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();

        for (Person person : RAW_DATA) {
            System.out.println(person.id + " - " + person.name);
        }

        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();



        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться Key: Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */
        System.out.println("Задача 1");
        System.out.println("Отсортированное множество:");

        getSortMapPerson(RAW_DATA).forEach((k, v) -> System.out.println("Key: " + k + "\nValue: " + v));
        System.out.println();

        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */

        System.out.println("Задача 2");
        System.out.println("Пары чисел, которые дают в сумме переданное в метод число:");
        System.out.println(Arrays.toString(getFirstPairSum(new int[]{3, 4, 2, 7}, 10)));
        System.out.println();

        /*
        Task3
            Реализовать функцию нечеткого поиска

                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */
        System.out.println("Задача 3");
        System.out.println("Результаты нечеткого поиска:");
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
    }

    //Убрать дубликаты, сгруппировать по имени, отсортировать по имени и id
    public static Map<String, Long> getSortMapPerson(Person[] persons) {
        if (persons != null) {
            return Arrays.stream(persons)
                    .filter(e -> Objects.nonNull(e.getName()))
                    .distinct()
                    .sorted(Comparator.comparing(Person::getName))
                    .sorted(Comparator.comparing(Person::getId))
                    .collect(groupingBy(Person::getName, counting()));
        }
        return new HashMap<>();
    }

    //Ищем первые два числа в массиве, дающие сумарно переданоое значение в параметре summa
    public static int[] getFirstPairSum(int[] arr, int s) {
        if (arr != null) {
            return Arrays.stream(arr).flatMap(a1 -> Arrays.stream(arr)
                            .flatMap(a2 -> a1 + a2 == s ? IntStream.of(a1, a2) : IntStream.empty())
                            .findFirst().stream())
                    .toArray();
        }
        return new int[]{0, 0};
    }

    //Реализация алгоритма нечеткого поиска.
    static boolean fuzzySearch(String expression, String text){
        if(expression != null && text != null){
            //Проверка строк на идентичность
            if(expression.equals(text)){
                return true;
            }
            else {
                //Реализация поиска
                Queue<Character> characterQueue = new ArrayDeque<>();
                for (Character c : expression.toCharArray()){
                    characterQueue.offer(c);
                }
                for (Character c : text.toCharArray()){
                    if(!characterQueue.isEmpty() && c == characterQueue.element()){ characterQueue.remove();}
                }
                return characterQueue.isEmpty();
            }
        }
        else {
            if(expression == null){
                System.out.println("Искомая строка == null");
            }
            if(text == null){
                System.out.println("Текст == null");
            }
            return false;
        }
    }
}
