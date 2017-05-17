package com.learn.basicthread.nolockcontainer.mapcompare;



import java.util.Map;

/**
 * Created by hechao on 2017/5/17.
 */
public abstract class MapTest extends Tester<Map<Integer,Integer>>{
    MapTest(String testId, int nReaders, int nWriters) {
        super(testId, nReaders, nWriters);
    }

    class Reader extends TestTask {
        long result = 0;

        @Override
        void test() {
            for (int i = 0; i < readOrWriterCycles; i++) {
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

        long result = 0;
        @Override
        void test() {
            for (int i = 0; i < readOrWriterCycles; i++) {
                for (int index = 0; index < containerSize; index++) {
                    testContainer.put(index,writeData[index]);
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
