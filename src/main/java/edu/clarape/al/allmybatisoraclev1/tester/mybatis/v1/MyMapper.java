package edu.clarape.al.allmybatisoraclev1.tester.mybatis.v1;

import org.apache.ibatis.annotations.Select;

public interface MyMapper {
    @Select("select a.BANNER from v$version a")
    public String getOraDBVersion();
    
}
