package lection.lection_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // обычная реализация
/*        PlainInterface plainInterface = new PlainInterface() {
            @Override
            public String action(int x, int y) {
                return String.valueOf(x + y);
            }
        };
        System.out.println(plainInterface.action(5,3));*/
        // Реализация лямбда-выражений
        // PlainInterface plainInterface = (x,y) -> String.valueOf(x+y);
/*        PlainInterface plainInterface = (x,y) -> {
             return    String.valueOf(x+y);
        };

        PlainInterface plainInterface1 = (x,y) -> String.valueOf(Integer.compare(x,y));
        System.out.println(plainInterface1.action(5,3));*/

/*        List<String> list = Arrays.asList("Привет", "Мир");
        list = list.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
        for (String itm: list) {
            System.out.println(itm);
        }*/

        //List<String> list = Arrays.asList("Привет", "Мир");
       // list.stream().filter(str -> str.length() > 4).forEach(System.out::println);

        //Arrays.asList(1,10,3,7,5,8,8,9,1).stream().sorted().distinct().forEach(System.out::println);
        System.out.println(Arrays.asList(1,10,3,7,5,8,8,9,1).stream().sorted().distinct().findFirst().get());
        List<User> list = Arrays.asList(new User("Pavel", 24), new User("Roman", 21));
        list.stream().map(user -> new User(user.name, user.age - 5)).filter(user -> user.age >=17).forEach(System.out::println);
    }
}

