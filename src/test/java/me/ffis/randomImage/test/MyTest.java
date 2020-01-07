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

}
