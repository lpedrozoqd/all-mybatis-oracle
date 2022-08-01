package edu.clarape.al.allmybatisoraclev1.tester.mybatis.v3;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;



public class MyBatisConfClient {
    private static SqlSessionFactory sessionFact = null;
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("driver", "oracle.jdbc.driver.OracleDriver");
        properties.setProperty("url", "jdbc:oracle:thin:@localhost:1521/orcl");
        properties.setProperty("user", "appall");
        properties.setProperty("password", "r3b3qu1t4");

        MyDSFactory myDS = new MyDSFactory();
        myDS.setProperties(properties);
        DataSource ds = myDS.getDataSource();

        TransactionFactory myTrans = new JdbcTransactionFactory();
        Environment environment = new Environment("development", myTrans, ds);
        Configuration myConfig = new Configuration(environment);
        myConfig.addMapper(ProductsMapper.class);

        sessionFact = new SqlSessionFactoryBuilder().build(myConfig);

        try (SqlSession session = sessionFact.openSession()){
            int numeroProductos = session.selectOne("getCantidadProductos");
            System.out.println("***Cantidad productos: " + numeroProductos);
        } 
    }
}
