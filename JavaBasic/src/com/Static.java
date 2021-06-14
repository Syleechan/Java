package com;

/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/11 11:36
 * @description：
 */

public class Static {
    static int temp = 1;
    public static void main(String []args){
        temp++;
        System.out.println(methodAdd(1,2));

        Student student = new Student(20,"male");
        //静态方法不能实例化
        //访问静态方法通过Class + . + method 来访问静态方法
        int a = Student.getId();

    }

    public static int methodAdd(int a, int b){
        temp++;
        return a + b + temp;
    }

    public int methodAdd(int a, int b, int c){
        return a + b;
    }

    static class Student{
        int age;
        String sex;
        static  int id = 9527;
        public Student(int age, String male){
            this.age = age;
            this.sex = male;

        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setMale(String male) {
            this.sex = male;
        }

        public String getMale() {
            return sex;
        }

        static int getId() {
            return id;
        }
    }

}
