package Enum;

import java.lang.annotation.Annotation;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/16 19:27
 * @description：
 */

public class Enum1 {
    public static void main(String[] args) {
//        Season1 spring = Season1.Spring;
//        //不重写toString()默认打印枚举类的名字 Spring
//        System.out.println(spring.toString());
//
//        Season1[] season1 = Season1.values();
//        for (int i = 0; i < season1.length; i++) {
//            System.out.println(season1[i]);
//
//        }
//
//        System.out.println(Season1.valueOf("Summer"));

        Class clazz = Season1.class;
        System.out.println(clazz);
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length ; i++) {
            System.out.println(annotations[i]);
        }


//        Thread.State[] states = Thread.State.values();
//        for (int i = 0; i < states.length; i++) {
//            System.out.println(states[i]);
//        }
    }
}

@MyAnnotation("Hi")
enum Season1 implements Info {

    Autumn("秋天", "秋暖花开") {
        @Override
        public void show() {

        }
    },
    Spring("春天", "春暖花开") {
        @Override
        public void show() {

        }
    } //enum关键字
    //枚举类对象最先提供，多个对象,隔开，最后一个分号
    //枚举类对象分别实现抽象接口
    ,
    Summer("夏天", "夏暖花开") {
        @Override
        public void show() {

        }
    },
    Winter("冬天", "冬暖花开") {
        @Override
        public void show() {

        }
    };

    private final String seasonName;
    private final String seasonDesc;

    @MyAnnotation
    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


//    @Override
//    public String toString() {
//        return "Season:{ SeasonName : \" " + seasonName +
//                "\", SeansonDesc : \"" + seasonDesc +
//                "\"}";
//    }
}