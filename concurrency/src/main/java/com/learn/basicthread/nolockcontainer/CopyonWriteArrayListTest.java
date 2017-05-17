package com.learn.basicthread.nolockcontainer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by hechao on 2017/5/16.
 */
public class CopyonWriteArrayListTest extends ListTest {
    CopyonWriteArrayListTest(int nReaders, int nWriters) {
        super("CopyOnWriteArrayList", nReaders, nWriters);
    }

    @Override
    List<Integer> containerInitializer() {
        List<Integer> list = new CopyOnWriteArrayList<Integer>();
        for (int i = 0; i < containerSize; i++) {
            list.add(i);
        }
        return list;
    }
}
