package com.learn.basicthread.nolockcontainer.mapcompare;

import java.util.*;

/**
 * Created by hechao on 2017/5/17.
 */
public class SynchronizedHashMapTest extends MapTest{
    SynchronizedHashMapTest(int nReaders, int nWriters) {
        super("Synched HashMap", nReaders, nWriters);
    }



    @Override
    Map<Integer, Integer> containerInitializer() {
        List<Integer> keyList = new ArrayList<Integer>();
        List<Integer> valueList = new ArrayList<Integer>();
        for (int i = 0; i < containerSize; i++) {
            keyList.add(i);
        }
        for (int i = 0; i < containerSize; i++) {
            valueList.add(i);
        }
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < containerSize; i++) {
            map.put(keyList.get(i), valueList.get(i));
        }
        return Collections.synchronizedMap(map);
    }
}
