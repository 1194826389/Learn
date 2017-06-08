package com.learn.hashmap;

import java.util.*;

/**
 * Created by hechao on 2017/5/22.
 */
public class test {
    private static int k = 0;
    public static void main(String[] args) {


        HashMap

        int j = 0;
        int n = 0;
        for (int i = 0; i < 100; i++){
            //System.out.println(i);
            j = j++;// 注意j
            k = ++k;
            n = ++n;
        }
        System.out.println("n:="+n);  // 100
        System.out.println("j:="+j);  // 0
        System.out.println("k:="+k);  // 0
//
//        // TODO Auto-generated method stub
//        List<String> src = new ArrayList<String>();
//        src.add("111");
//        src.add("222");
//        src.add("333");
//        src.add("444");
//        List<String> dest1  =   new  ArrayList<String>();
//        dest1.add("111dadf");
//        dest1.add("222asdfa");
//        dest1.add("333asdfa");
//        dest1.add("444asdfa");
//
//        System.out.println(src.hashCode());
//        System.out.println(dest1.hashCode());
//        Collections.copy(dest1, src);
//        System.out.println(src.hashCode());
//        System.out.println(dest1.hashCode());

//        HashMap<String,Integer> map = new HashMap<String, Integer>();
//        map.put("语文", 1);
//        map.put("数学", 2);
//        map.put("英语", 3);
//        map.put("历史", 4);
//        map.put("政治", 5);
//        map.put("地理", 6);
//        map.put("生物", 7);
//        map.put("化学", 8);
//        for(Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//
//        Collections.synchronizedMap()
//        Map<String, String> map = new LinkedHashMap<String, String>(16,0.75F,true);
//        map.put("apple", "苹果");
//        map.put("watermelon", "西瓜");
//        map.put("banana", "香蕉");
//        map.put("peach", "桃子");
//
//        map.get("banana");
//        map.get("peach");
//        map.get("apple");
//        map.get("watermelon");
//
//        Iterator iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }
//        String s = " Hello";
//        s += "World ";
////        s.trim();
//        stringToDateType(s);
////        System.out.printf(s);
//        Object
        Object o1 = new test(); //during compile time o1 is of type Object
        //during runtime o1 is of type MethodOverrideVsOverload
        Object o2 = new test(); //during compile time o2 is of type Object
        //during runtime o2 is of type MethodOverrideVsOverload

        test o3 = new test(); //o3 is of type MethodOverrideVsOverload
        // during both compile time and runtime
        test o4 = new test(); //o4 is of type MethodOverrideVsOverload
        // during both compile time and runtime

        if(o1.equals(o2)){
            System.out.println("objects o1 and o2 are equal");
        }

        if(o3.equals(o4)){
            System.out.println("objects o3 and o4 are equal");
        }

    }


    @Override
    public boolean equals( Object other ) {
        System.out.println("MethodOverrideVsOverload equals method reached" );
        return true;
    }
}


