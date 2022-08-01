package edu.clarape.al.allmybatisoraclev1.tester.mybatis.v4;

import org.apache.ibatis.session.SqlSessionFactory;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisDynamicSQL {
    private static SqlSessionFactory factory = null;
    public static void main(String[] args) throws IOException {
        System.out.println("========================");
        System.out.println(">>>ALL-MYBATIS-ORACLE-V4");
        System.out.println("**1- Iniciando");

        String resource = "mybatis-config-v4.xml";
        Reader reader = null;
        SqlSession session = null;

        reader = Resources.getResourceAsReader(resource);
        factory = new SqlSessionFactoryBuilder().build(reader);

        reader.close();
        try{
            session = factory.openSession();
            Book book = session.selectOne("getBook",1);
            System.out.println("**2- Respuesta de Book consultado " + book.toString());
            List<Book> books = session.selectList("getBook");
            System.out.println("");
            System.out.println("");
            for (Book bookIter : books) {
                System.out.println(bookIter);
            }

        } finally  {
            if (session != null){
                session.close();
                System.out.println("**N- finalizando");
            }
        }
        
    }
}
