package com.course.lessons;

import com.course.other.Account;
import com.course.other.Human;
import com.course.other.Printer;

import java.util.ArrayList;
import java.util.HashMap;

public class LessonFive {

    public static void main(String[] args) {
        //key word static
        Human.handCount = 3;
        Human human = new Human("Tom", "Cruz");
        Human human2 = new Human("Tom", "Cruz");

        human.getCount();
        human2.getCount();

        System.out.println(human.toString());
        System.out.println(human2.toString());

        System.out.println(human.equals(human2));
        System.out.println(human2.equals(human));


        System.out.println(human.hashCode());
        System.out.println(human2.hashCode());


        //Generics
        Account<String> account = new Account<>("33");
        Account<Integer> account2 = new Account<>(33);

        System.out.println(account.getId());
        System.out.println(account2.getId());


        String[] people = {"Tom", "Alice", "Sam"};
        Integer[] numbers = {23, 32, 5674, 234};
        Printer printer = new Printer();
        printer.print(people);
        printer.print(numbers);

        //Collection
        int[] nums = new int[5];
        nums[0] = 5;

//        ArrayList<Integer> arrayList = new ArrayList<>();
//        ArrayList<Integer> arrayList2 = new ArrayList<>();
//        arrayList.add(5);
//        arrayList.remove(5);
//        arrayList.addAll(arrayList2);
//        System.out.println(arrayList.contains(5));
//        System.out.println(arrayList.indexOf(5));

        Account<String> acc = new Account<>("33");


        HashMap<String, Account<String>> dictionary = new HashMap<>();


        dictionary.put(acc.getId(), acc);


        Account<String> getMyAcc = dictionary.get("33");

        System.out.println(dictionary.get("33"));
    }
}
