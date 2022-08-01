package edu.clarape.al.allmybatisoraclev1.tester.mybatis.v5;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import edu.clarape.al.allmybatisoraclev1.tester.mybatis.v4.Book;

public interface BookMapper {
   @Select("SELECT * FROM BOOK WHERE ID= #{ID}") 
   public Book getBookById(Long id);

   @Select("SELECT * FROM BOOK WHERE AUTHOR= #{author}") 
   public Book getBookByAuthor(String author);

   @Insert("INSERT INTO BOOK(AUTHOR,TITLE,PUBLISHED,REMARK) " 
         + "VALUES (#{author},#{title},#{published},#{remark})") 
   public void insertBook(String author,String title, int published, String remark);

}
