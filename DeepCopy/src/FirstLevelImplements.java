/**
 * @author ：LeeChan
 * @date ：Created in 2020/12/27 14:14
 * @description：
 */

public class FirstLevelImplements implements Cloneable{
    int i;
    int j;
    SecondLevel sec;

    public  FirstLevelImplements(int i, int j, SecondLevel sec){
        this.i = i;
        this.j = j;
        this.sec = sec;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        //从父类继承拷贝 拷贝一个first对象
        Object clone = super.clone();
        //把该对象赋值给一个新的First对象
        FirstLevelImplements t = (FirstLevelImplements) clone;
        //将sec对象的拷贝 赋值给first的sec成员
        t.sec = (SecondLevel) sec.clone();

        return clone;


    }




}


class SecondLevel implements Cloneable{
    double j;
    ThirdLevel thirdLevel;
    public SecondLevel(double j , ThirdLevel third){
        this.j = j;
        this.thirdLevel = third;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        Object clone = super.clone();
        SecondLevel s = (SecondLevel) clone;
        s.thirdLevel = (ThirdLevel) thirdLevel.clone();
        return  clone;
    }
}



class ThirdLevel implements Cloneable{
    int k;
    public ThirdLevel(int k){
        this.k = k;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}