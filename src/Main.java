import OwnCollectionsFramework.ArrayList.ArrayList;
import OwnCollectionsFramework.LinkedList.LinkedList;

import java.util.Collections;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("array list sort");

        ArrayList<Integer> integerArray = new ArrayList<>();
        integerArray.add((int) (Math.random() * 6));
        integerArray.add((int) (Math.random() * 6));
        integerArray.add((int) (Math.random() * 6));
        integerArray.add((int) (Math.random() * 6));
        integerArray.add((int) (Math.random() * 6));

        for (int i = 0; i< integerArray.length(); i++) {
            System.out.println(integerArray.get(i));
        }

        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);

        ArrayList.bubbleSort(integerArray, comparator);

        for (int i = 0; i< integerArray.length(); i++) {
            System.out.println(integerArray.get(i));
        }

        System.out.println("linked list sort");

        LinkedList<Integer> integerLinked = new LinkedList<>();
        integerLinked.add((int) (Math.random() * 6));
        integerLinked.add((int) (Math.random() * 6));
        integerLinked.add((int) (Math.random() * 6));
        integerLinked.add((int) (Math.random() * 6));
        integerLinked.add((int) (Math.random() * 6));
        integerLinked.add((int) (Math.random() * 6));

        for (int i = 0; i< integerLinked.length(); i++) {
            System.out.println(integerLinked.get(i));
        }

        LinkedList.bubbleSort(integerLinked, comparator);

        for (int i = 0; i< integerLinked.length(); i++) {
            System.out.println(integerLinked.get(i));
        }




    }

}