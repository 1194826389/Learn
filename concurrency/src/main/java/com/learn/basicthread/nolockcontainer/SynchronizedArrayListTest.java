package com.learn.basicthread.nolockcontainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hechao on 2017/5/16.
 */
public class SynchronizedArrayListTest extends ListTest {
    SynchronizedArrayListTest(int nReaders, int nWriters) {
        super("Synched ArrayList", nReaders, nWriters);
    }

    @Override
    List<Integer> containerInitializer() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < containerSize; i++) {
            list.add(i);
        }
        return Collections.synchronizedList(list);
    }
}
