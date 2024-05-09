
package com.jee.dao;

import java.sql.Connection;

public class DataBase {
    protected DataSource ds;
    protected Connection cnx;
    public DataBase() {

    }
    public DataBase(DataSource ds) {
            setDs(ds);

    }
    public DataSource getDs() {
            return ds;
    }
    public void setDs(DataSource ds) {
            this.ds=ds;
            this.cnx=this.ds.getConnection();
    }
    public Connection getConnection(){
        return cnx;
    }
}
