package com.learn.basicthread.concurrency.learnvolatile.dao;

import com.learn.basicthread.concurrency.learnvolatile.model.Data;

/**
 * Created by hechao on 2017/5/7.
 */
public interface DataDao {
    Data insertData(Data data);
    Data getData(int id);
    Data updateData(Data data);
    void deleteData(int id);


    class DataDaoImpl implements DataDao {
        protected Data data;
        @Override
        public Data insertData(Data data) {
            this.data = data;
            return data;
        }

        @Override
        public Data getData(int id) {
            return this.data;
        }

        @Override
        public Data updateData(Data data) {
            this.data = data;
            return data;
        }

        @Override
        public void deleteData(int id) {
            this.data = null;
        }
    }

}
