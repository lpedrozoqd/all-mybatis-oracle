package edu.clarape.al.allmybatisoraclev1.tester.mybatis.v2;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class app_v2 {
    private static SqlSessionFactory factory = null;
    public static void main(String[] args) throws IOException {
        System.out.println("========================");
        System.out.println(">>>ALL-MYBATIS-ORACLE-V2");
        System.out.println("**1- Iniciando");

        String resource = "mybatis-config-v2.xml";
        Reader reader = null;
        SqlSession session = null;

        reader = Resources.getResourceAsReader(resource);
        factory = new SqlSessionFactoryBuilder().build(reader);

        reader.close();
        try{
            session = factory.openSession();
            String version = session.selectOne("getOraDBVersion");
            System.out.println("**2- Ejecutando consulta basada en xml: " + version);

        } finally  {
            if (session != null){
                session.close();
                System.out.println("**N- finalizando");
            }
        }
        
    }
}
