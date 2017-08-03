package com.learn.hadoop;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;

/**
 * 用流的方式来操作hfds的文件
 *
 * Created by hechao on 2017/7/31.
 */
public class HdfsStreamAccess {
    private FileSystem fs;

    @Before
    public void init() throws Exception {


        Configuration conf = new Configuration();
//        conf.set("fs.defaultFS","hdfs://CM3:9000");

        // 拿到一个文件系统操作的客户端实例对象
        // 可以直接传入 uri和用户身份
        fs = FileSystem.get(new URI("hdfs://CM3:9000"),conf,"root");//最后一个参数为用户名

    }

    /**
     * 通过流的方式上传文件到hdfs
     * @throws Exception
     */
    @Test
    public void testUpload() throws Exception {

        FSDataOutputStream outputStream = fs.create(new Path("/good"),true);

        FileInputStream inputStream = new FileInputStream("/Users/hechao/Documents/Learn/BigData/src/main/resources/test2.txt");

        IOUtils.copy(inputStream,outputStream);
    }

    @Test
    public void testDownLoadFileToLocal() throws Exception{

        //先获取一个文件的输入流----针对hdfs上的
        FSDataInputStream in = fs.open(new Path("/good"));

        //再构造一个文件的输出流----针对本地的
        FileOutputStream out = new FileOutputStream(new File("/Users/hechao/Documents/Learn/BigData/src/main/resources/test.txt"));

        //再将输入流中数据传输到输出流
        IOUtils.copy(in, out);
    }

    @Test
    public void testRandomAccess() throws Exception{
        //先获取一个文件的输入流----针对hdfs上的
        FSDataInputStream in = fs.open(new Path("/good"));


//        //可以将流的起始偏移量进行自定义
//        in.seek(2);

        //再构造一个文件的输出流----针对本地的
        FileOutputStream out = new FileOutputStream(new File("/Users/hechao/Documents/Learn/BigData/src/main/resources/test.txt"));

        IOUtils.copyLarge(in,out,4L,6L);


    }

    /**
     * 显示hdfs上文件的内容
     */
    @Test
    public void testCat() throws Exception{

        FSDataInputStream in = fs.open(new Path("/wordcount/input/a.file"));
        IOUtils.copyLarge(in, System.out, new byte[1024]);
    }



}
