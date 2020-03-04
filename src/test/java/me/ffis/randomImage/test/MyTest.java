package me.ffis.randomImage.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

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
//        for (int j = 0; j < 100; j++) {
//            System.out.println(j + ":" + (j % 15));
//        }


        //获取Calendar对象
        Calendar start = Calendar.getInstance();
//        Calendar today = Calendar.getInstance();
        start.set(2020, Calendar.JANUARY, 1);
        System.out.println(start.getTime());
//        long day = (today.getTimeInMillis() - start.getTimeInMillis()) / (24 * 60 * 60 * 1000);
//        System.out.println(day);

        //获取Calendar对象
//        Calendar calendar = Calendar.getInstance();
        //获取今天在一年中的数字
//        int days = calendar.get(Calendar.DAY_OF_YEAR);
//        System.out.println(days);
//        System.out.println("-===-");
//        System.out.println(7 % 11);
    }

}
