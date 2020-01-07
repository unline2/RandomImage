package me.ffis.randomImage.test;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by fanfan on 2020/01/06.
 */
public class MyTest {

    @Test
    public void test1() {
        ArrayList<String> list = new ArrayList<>();

        list.add("1");
        double v = Math.random() * list.size();

        //String s = list.get(0);

        System.out.println(v);
    }

    @Test
    public void test2() {
//        Calendar c = Calendar.getInstance();
//        Date time = c.getTime();
//        System.out.println(time);
//        int i = c.get(Calendar.DAY_OF_YEAR);
//        System.out.println(i);
//        c.add(Calendar.DAY_OF_YEAR, 1);
//        Date time1 = c.getTime();
//        System.out.println(time1);
//        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        for (int j = 1; j <= 20; j++) {
            System.out.println(j + ":" + (j % 11));
        }
//        System.out.println("-===-");
//        System.out.println(7 % 11);
    }

}
