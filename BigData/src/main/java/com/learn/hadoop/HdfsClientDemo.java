package com.learn.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;


/**
 * 客户端去操作hdfs时，是有一个用户身份的
 * 默认情况下，hdfs客户端api会从jvm中获取一个参数来作为自己的用户身份：-DHADOOP_USER_NAME=hadoop
 *
 * 也可以在构造客户端fs对象时，通过参数传递进去
 * Created by hechao on 2017/7/30.
 */
public class HdfsClientDemo {

    private FileSystem fs;

    @Before
    public void init() throws Exception {


        Configuration conf = new Configuration();
//        conf.set("fs.defaultFS","hdfs://CM3:9000");

        // 拿到一个文件系统操作的客户端实例对象
        // 可以直接传入 uri和用户身份
        fs = FileSystem.get(new URI("hdfs://CM3:9000"),conf,"root");//最后一个参数为用户名

    }

    @Test
    public void testUpload() throws Exception {
        fs.copyFromLocalFile(new Path("/Users/hechao/Documents/Learn/BigData/src/main/resources/test1.txt"),new Path("/"));
        fs.close();
    }

    @Test
    public void testMkdir() throws Exception {
        boolean mkdirs = fs.mkdirs(new Path("/testmkdir/aaa/bbb"));
        System.out.println(mkdirs);
    }

    @Test
    public void testdeleteMkdir() throws Exception {
        boolean flag = fs.delete(new Path("/testmkdir/aaa/"),true);
        System.out.println(flag);
    }

    /**
     * 递归列出指定目录下的文件
     * @throws Exception
     */
    @Test
    public void testLs() throws Exception {
        RemoteIterator<LocatedFileStatus> listfiles = fs.listFiles(new Path("/"),true);
        while (listfiles.hasNext()) {
            LocatedFileStatus fileStatus = listfiles.next();
            System.out.println("blocksize: " + fileStatus.getBlockSize());
            System.out.println("owner: " + fileStatus.getOwner());
            System.out.println("Replication: " + fileStatus.getReplication());
            System.out.println("Permission: " + fileStatus.getPermission());
            System.out.println("filenae: " + fileStatus.getPath());
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            for (BlockLocation bl : blockLocations) {
                System.out.println("block-length: " + bl.getLength() + "--" + "block-offset:" + bl.getOffset());
                String[] hosts = bl.getHosts();
                for (String host : hosts) {
                    System.out.println(host);
                }

            }
            System.out.println("-----------------------------");
        }
    }

    @Test
    public void testLs2() throws Exception {
        FileStatus[] fileStatusesList = fs.listStatus(new Path("/"));
        for (FileStatus file : fileStatusesList) {
            System.out.println("name: " + file.getPath().getName());
            System.out.println(file.isFile() ? "file":"directory");
        }
    }


    @Test
    public void testDownload() throws Exception {
        fs.copyToLocalFile(new Path("/test1.txt"),new Path("/Users/hechao/Documents/Learn/BigData/src/main/resources/"));
        fs.close();
    }


}
