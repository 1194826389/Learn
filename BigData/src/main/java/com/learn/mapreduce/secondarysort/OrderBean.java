package com.learn.mapreduce.secondarysort;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by hechao on 2017/8/8.
 */
public class OrderBean implements WritableComparable<OrderBean> {


    private Text itemid;
    private DoubleWritable amount;


    public OrderBean() {}

    public void set(Text itemid,DoubleWritable amount) {
        this.itemid = itemid;
        this.amount = amount;
    }


    @Override
    public int compareTo(OrderBean o) {
        // 如果返回1，则为升序，如果返回-1则为降序，所以按照id升序。
        int cmp = this.itemid.compareTo(o.getItemid());
        if (cmp == 0) {
            // 如果id相等，则比较amout，按照amout降序
            cmp = -this.amount.compareTo(o.getAmount());
        }

        return cmp;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(itemid.toString());
        out.writeDouble(amount.get());
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.itemid = new Text(in.readUTF());
        this.amount = new DoubleWritable(in.readDouble());
    }

    @Override
    public String toString() {
        return itemid.toString() + "\t" + amount.get();
    }

    public Text getItemid() {
        return itemid;
    }

    public void setItemid(Text itemid) {
        this.itemid = itemid;
    }

    public DoubleWritable getAmount() {
        return amount;
    }

    public void setAmount(DoubleWritable amount) {
        this.amount = amount;
    }
}
