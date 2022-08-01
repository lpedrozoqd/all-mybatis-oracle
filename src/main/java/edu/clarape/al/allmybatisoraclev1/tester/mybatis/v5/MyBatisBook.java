package edu.clarape.al.allmybatisoraclev1.tester.mybatis.v5;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.clarape.al.allmybatisoraclev1.tester.mybatis.v4.Book;

public class MyBatisBook {
    private static SqlSessionFactory factory = null;
    public static void main(String[] args) throws IOException {
        System.out.println("========================");
        System.out.println(">>>ALL-MYBATIS-ORACLE-V5");
        System.out.println("**1- Iniciando");

        String resource = "mybatis-config-v5.xml";
        Reader reader = null;
        SqlSession session = null;

        reader = Resources.getResourceAsReader(resource);
        factory = new SqlSessionFactoryBuilder().build(reader);
        factory.getConfiguration().addMapper(BookMapper.class);
        reader.close();
        try{
            session = factory.openSession();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
            Book book = session.selectOne("getBookById",2L);
            System.out.println("**2- Ejecutando consulta basada en xml: " + book.toString());

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
            List<Book> books = session.selectList("getBookByAuthor","Leonel Pedrozo".toUpperCase() );
            for (Book bookIter : books) {
                System.out.println("**3- Libro: " + bookIter.toString());
            }

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>");

            Book newBook = new Book("El amor vuelve!","Elías Pedrozo",2500,"Clarape Books");
            session.update("insertBook",newBook);
            session.commit();


        } finally  {
            if (session != null){
                session.close();
                System.out.println("**N- finalizando");
            }
        }
        
    }
}
