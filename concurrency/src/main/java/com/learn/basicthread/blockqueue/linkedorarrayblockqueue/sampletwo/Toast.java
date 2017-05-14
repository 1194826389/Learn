package com.learn.basicthread.blockqueue.linkedorarrayblockqueue.sampletwo;

import com.sun.corba.se.impl.oa.toa.TOA;

/**
 * Created by hechao on 2017/5/14.
 */
public class Toast {
    public enum Status {DRY,BUTTERED,JAMMED};
    private Status status = Status.DRY;
    private final int id;
    public Toast(int idn) {
        id = idn;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}
