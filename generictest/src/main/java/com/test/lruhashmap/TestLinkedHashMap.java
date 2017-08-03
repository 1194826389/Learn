package com.test.lruhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hechao on 2017/6/25.
 */
public class TestLinkedHashMap {
    public static void main(String[] args) {

        LinkedHashMap<String, String> map = new LRULinkedHashMap<String, String>(16, 0.75f, true);
        map.put("a", "a"); //a  a
        map.put("b", "b"); //a  a b
        map.put("c", "c"); //a  a b c
        map.put("a", "a"); //   b c a
        map.put("d", "d"); //b  b c a d
        map.put("a", "a"); //   b c d a
        map.put("b", "b"); //   c d a b
        map.put("f", "f"); //c  c d a b f
        map.put("g", "g"); //c  c d a b f g

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.print(entry.getValue() + ", ");
        }
        System.out.println();

        map.get("d"); //c a b f g d
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.print(entry.getValue() + ", ");
        }
        System.out.println();

//
//        map.get("a"); //c b f g d a
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.print(entry.getValue() + ", ");
//        }
//        System.out.println();
//
//        map.get("c"); //b f g d a c
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.print(entry.getValue() + ", ");
//        }
//        System.out.println();
//
//        map.get("b"); //f g d a c b
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.print(entry.getValue() + ", ");
//        }
//        System.out.println();
//
//        map.put("h", "h"); //f  f g d a c b h
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.print(entry.getValue() + ", ");
//        }
//        System.out.println();
    }
}
