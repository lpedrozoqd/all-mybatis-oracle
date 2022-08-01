package edu.clarape.al.allmybatisoraclev1.tester.mybatis.v3;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSource;

public class MyDSFactory implements DataSourceFactory{
    private Properties properties;

    @Override
    public void setProperties(Properties props) {
       this.properties = props;
        
    }

    @Override
    public DataSource getDataSource() {
        PooledDataSource ds = new PooledDataSource();
        ds.setDriver(properties.getProperty("driver"));
        ds.setUrl(properties.getProperty("url"));
        ds.setUsername(properties.getProperty("user"));
        ds.setPassword(properties.getProperty("password"));
        return ds;
    }
    
}
