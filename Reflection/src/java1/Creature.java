package java1;

import java.io.Serializable;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/21 22:14
 * @description：
 */

public class Creature<T> implements Serializable {

    private final static long serialVersionUID = -68497944707542120L;

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("呼吸");
    }

    private void eat(){
        System.out.println("吃东西");
    }
}
