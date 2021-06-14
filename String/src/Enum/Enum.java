package Enum;

import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/16 19:09
 * @description：枚举类的使用
 *
 * 需要定义多个常量时，强烈建议使用枚举类
 * 如果枚举类只有一个对象，则可以作为单例模式的实现
 *
 */

public class Enum {




}


class Season{
    private final String seasonName;
    private final String seasonDesc;

    public Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public static Season Spring = new Season("春天" , "春暖花开");
    public static Season Summer = new Season("夏天" , "夏暖花开");
    public static Season Autumn = new Season("秋天" , "秋暖花开");
    public static Season Winter = new Season("冬天" , "冬暖花开");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season:{ SeasonName : \" " + seasonName +
        "\", SeansonDesc : \"" + seasonDesc +
        "\"}";
    }



}