package Optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/1/24 17:04
 * @description：
 */

public class OptionalTest {

    @Test
    public void test1(){
        Girl girl = new Girl();
//        girl = null;
        Optional<Girl> girl1 = Optional.of(girl);//不可以为空


    }

    @Test
    public void test2(){
        Girl girl = new Girl();
//        girl = null;
        Optional<Girl> girl1 = Optional.ofNullable(girl);//可以为空\

        Girl girl2 = girl1.orElse(new Girl("郑秀妍"));
        System.out.println(girl1.toString());
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();//空指针异常，girlName没有赋值
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    public String getGirlName1(Boy boy){
        if(boy != null){
            Girl girl = boy.getGirl();
            if(girl != null){
                return girl.getName();
            }
        }
        return null;
    }

    public String getGirlName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);

        //boy为空返回
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("郑秀妍")));

        Girl girl = boy1.getGirl();

        //boy不为空，girl为空返回
        Optional<Girl> girlOptional = Optional.ofNullable(girl);

        Girl girl1 = girlOptional.orElse(new Girl("李先彬"));



        return girl1.getName();
    }

    @Test
    public void test4(){
        Boy boy = null;
        //boy = new Boy();
        String name = getGirlName2(boy);
        System.out.println(name);
    }
}
