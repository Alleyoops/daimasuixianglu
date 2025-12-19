package com.leetcode.other;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main extends Pattern implements IPrint {
    public static void main(String[] args) {
//        test(1,2);
//        Main m = new Main("iii");
//        Main.test();
//        m.print(1, 2);
//        m.print();
//        System.out.println(m.hashCode());
//        String s1 = "abc";
//        String s2 = new String("abc");
//        String s3 = s2.intern();
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        divide(1, 0);
//        System.out.println(add(1));
//        List<Integer> list1 = new ArrayList<>();
//        for (int i = 0; i < 9; i++) {
//            list1.add(i);
//        }
//        List<Integer> list2 = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list2.add(i);
//        }
        //计时器
//        long start = System.nanoTime();
//        list1.add(10);
//        long end = System.nanoTime();
//        System.out.println(end - start);
//        long start2 = System.nanoTime();
//        list2.add(11);
//        long end2 = System.nanoTime();
//        System.out.println(end2 - start2);
//        long start3 = System.nanoTime();
//        list2.add(12);
//        long end3 = System.nanoTime();
//        System.out.println(end3 - start3);
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(1, 2);
//        map.put(2, 2);
//        map.put(3, 3);
//        System.out.println(map.hashCode());
//        HashMap<Integer, Integer> map2 = new HashMap<>();
//        map2.put(1, 2);
//        map2.put(2, 2);
//        map2.put(3, 3);
//        System.out.println(map2.hashCode());
//        System.out.println(map.equals(map2));
//        System.out.println(map==map2);
//        map.put(null, null);
//        System.out.println(map.get(null));
        new myThread(()-> System.out.println("新线程哦~")).start();
        ArrayList<Integer> list = new ArrayList<>();
    }

    private static void test() {
    }

    @Override
    public void print(int a, int b) {
        System.out.println(a + b + "newAns");
    }

    @Override
    public void print() {
        System.out.println("抽象");
        super.print(666);
    }

    Main(String string) {
        System.out.println(string);
    }

    //    public static void divide(int a, int b) {
//        if (b == 0) {
//            try {
//                throw new Exception("除数不能为零！"); // 抛出异常
//            } catch (Exception e) {
//                e.printStackTrace();
//                e.getMessage();
//            }
//        }
//        System.out.println("end");
//    }
    public static <T> String add(T a) {
        return a.toString();
    }

}
class myThread extends Thread{
    public myThread(Runnable task) {
        super(task);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(this.getName());
    }
}
