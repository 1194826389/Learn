package com.learn.basicthread.nolockcontainer;

import java.util.List;

/**
 * Created by hechao on 2017/5/16.
 */
public abstract class ListTest extends Tester<List<Integer>> {
    ListTest(String testId, int nReaders, int nWriters) {
        super(testId, nReaders, nWriters);
    }

    class Reader extends TestTask {
        long result = 0;

        @Override
        void test() {
            for (long i = 0; i < readOrWriterCycles; i++) {
                for (int index = 0; index < containerSize; index++) {
                    result += testContainer.get(index);
                }
            }
        }

        @Override
        void putResults() {
            readResult += result;
            readTime += duration;
        }
    }

    class Writer extends TestTask {

        @Override
        void test() {
            for (long i = 0; i < readOrWriterCycles; i++) {
                for (int index = 0; index < containerSize; index++) {
                    testContainer.set(index,writeData[index]);
                }
            }
        }

        @Override
        void putResults() {
            writeTime += duration;
        }
    }

    @Override
    void startReadersAndWriters() {
        for (int i = 0; i < nReaders; i++) {
            exec.execute(new Reader());
        }

        for (int i = 0; i < nWriters; i++) {
            exec.execute(new Writer());
        }
    }
}
