import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;

import javax.tools.JavaCompiler;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.shiro.util.StringUtils;



public class MainApplication {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        String test = "{ \"a\" : \"b\",\"c\": 5}";
        ObjectMapper objectMapper = new ObjectMapper();
        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5," +
                        "  \"owners\" : [\"John\", \"Jack\", \"Jill\"]," +
                        "  \"nestedObject\" : { \"field\" : \"value\" } }";

        try{
            //从自定义json 读取
            //Test t = mapper.readValue(test,Test.class);

            //从reader读取
            //Reader reader = new StringReader(test);
            //Test t = mapper.readValue(reader,Test.class);

            //从file读取
            //File file = new File("xxx.json");
            //Test t = mapper.readValue(file, Test.class);

            //从url里读取
            // URL url = new URL("file:data/car.json");
            //Test t = objectMapper.readValue(url, Test.class);

            //从Json数组字符串读取对象
            //String jsonArray = "[{\"a\":\"ford\"}, {\"a\":\"Fiat\"}]";
            //Test[] t = mapper.readValue(jsonArray, Test[].class);

            //从JSON数组字符串中读取对象列表 List
            //List<Test> t = mapper.readValue(jsonArray, new TypeReference<List <Test>>(){});

            /*
            //从JSON字符串中读取映射为map
            String jsonObject = "{ \"a\" : \"ford\",\"c\": 5}";
            Map<String, Object> t = mapper.readValue(jsonObject, new TypeReference<Map<String, Object>>(){});

            System.out.println("a is : " + t.get("a"));
            //System.out.println("c is : " + t.getC());
            System.out.println(t.toString());

            //JsonNode
            JsonNode jsonNode = mapper.readValue(jsonObject,JsonNode.class);
            System.out.println(jsonNode);
            */


            /*
                JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);

                JsonNode brandNode = jsonNode.get("brand");
                //asText() 与 textValue
                String brand = brandNode.asText();
                System.out.println("brand = " + brand);

                JsonNode doorsNode = jsonNode.get("doors");
                int doors = doorsNode.asInt();
                System.out.println("doors = " + doors);

                JsonNode array = jsonNode.get("owners");
                JsonNode jsonNode1 = array.get(1);
                String john = jsonNode1.asText();
                System.out.println("john  = " + john);

                JsonNode child = jsonNode.get("nestedObject");
                JsonNode childField = child.get("field");
                String field = childField.asText();
                System.out.println("field = " + field);
             */

            String text = "{\"sql\":\"SELECT a.id as id FROM list_315 a\"}" ;
            String text1 = "[\"a\" , \"b\" ]";
            JsonNode jsonNode = mapper.readTree(text1);
            //打断点
            //JsonNode jsonNode1 = jsonNode.findPath(test);
            if(jsonNode.isArray()){
                System.out.println("text is array");
            }else if(jsonNode.isObject()){
                System.out.println("text is Object");
            }else
                System.out.println("啥也不是");

            int[] a = {1,2,3,4,5};
            List<String> b = new ArrayList<>();
            b.add("a");
            b.add("b");
            System.out.println(b);

            String Url = "http://dl.ppt123.net/pptbj/201203/2012032616594705.jpg";
            System.out.println(Url.substring(Url.lastIndexOf("/") + 1));


            Test t = new Test();
            System.out.println(t.splitUrl(Url));




        }catch (IOException e){
            e.printStackTrace();
        }
    }



    public static class Test{
        private String a = null;
        private int c = 0;

        public String getA() {return this.a;};
        public void  setA(String a){this.a = a;};

        public int getC() { return c; }

        public void setC(int c) { this.c = c;}

        public Test(){};

        @Override
        public String toString(){
            return "a : " + a + ", " + "c : " + c;
        }
    /*
        public Test (String a , int c){
            this.a = a;
            this.c = c;
        }

     */

        public String splitUrl(String url) {
            String str = url.replaceAll("http://", "");
            return str.split("/")[0];//IP
        }
    }

    public  static class Car {
        private String brand = null;
        private int doors = 0;

        public Car(){};

        public String getBrand() { return this.brand; }
        public void   setBrand(String brand){ this.brand = brand;}

        public int  getDoors() { return this.doors; }
        public void setDoors (int doors) { this.doors = doors; }
    }
}
