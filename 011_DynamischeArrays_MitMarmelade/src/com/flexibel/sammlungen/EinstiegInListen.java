package com.flexibel.sammlungen;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     Verwendet wurde bisher schon der Objekttyp ArrayList.
 *     Passender Referenztyp ist List<> mit weiteren Methoden:
 *     List extends Collection
 *
 *     List: kann Duplikate enthalten und ist sortiert und kann nach Vorgaben sortiert werden.
 * </pre>
 */
public class EinstiegInListen {
    public static void main(String[] args) {
        List<Marmelade> marmeladeList = new ArrayList<>();
        marmeladeList.add(new Marmelade());
        marmeladeList.add(new Marmelade("A", "A", "A", "A", 10, null));
        marmeladeList.add(new Marmelade());
        marmeladeList.forEach(marmelade -> System.out.println(marmelade));
        marmeladeList.remove(2);
        System.out.println();
        marmeladeList.forEach(marmelade -> System.out.println(marmelade));

        System.out.println();

        List<String> namen = new ArrayList<>();
        namen.add("Justus");
        namen.add("Peter");
        namen.add(1, "Bob");
        namen.forEach(name -> System.out.print(name + " "));

        System.out.println();
        namen.set(0, "Tante Mathilda");
        namen.forEach(name -> System.out.print(name + " "));
        System.out.println();

        for (int i = 0; i < namen.size(); i++) {
            System.out.println(i + ": " + namen.get(i));
        }
        System.out.println();
        namen.add(1, "Justus");
        for (int i = 0; i < namen.size(); i++) {
            System.out.println(i + ": " + namen.get(i));
        }
    }
}
