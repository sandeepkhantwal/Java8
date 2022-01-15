package self.playground.java8;

import java.util.Optional;

public class OptionalPlay {
    public static void main(String... s) {
        optional();
    }

    private static void optional() {

        Optional<String> gender = Optional.of("male");
        /*System.out.println(gender.get());
        System.out.println(Optional.ofNullable(null));*/

        System.out.println(gender.map(x -> x.toUpperCase()));
        // Pre java-8 code
        /*Function func = new Function«String, String>0) {
            public String apply(String o) {
               return o. toUpperCase0);
            }
        };
        System.out.println(gender.map(func)):*/
        System.out.println(gender.filter(s -> s.equals("male")));
        System.out.println(Optional.empty().orElse("Sandeep"));
        System.out.println(gender.orElse("Sandeep"));
    }
}
