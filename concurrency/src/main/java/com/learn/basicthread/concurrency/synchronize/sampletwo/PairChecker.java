package com.learn.basicthread.concurrency.synchronize.sampletwo;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

/**
 * Created by hechao on 2017/5/9.
 */
public class PairChecker  implements Runnable {
    private PairManager pm;
    public PairChecker(PairManager pm) {
        this.pm = pm;
    }
    @Override
    public void run() {
        while (true) {
            pm.checkCount.incrementAndGet();
            pm.getPair().checkState();
        }
    }

}
