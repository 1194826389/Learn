package com.learn.basicthread.endmission.elegantlyendmission;

/**
 * Created by hechao on 2017/5/11.
 */
public class NeedsCleanup {
    private final int id;
    public NeedsCleanup(int ident) {
        this.id = ident;
        System.out.println("NeedsCleanup " + id);
    }

    public void cleanup() {
        System.out.println("Cleaning up " + id);
    }
}
