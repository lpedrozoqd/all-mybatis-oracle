package edu.clarape.al.allmybatisoraclev1.tester.mybatis.v3;

import org.apache.ibatis.annotations.Select;

public interface ProductsMapper {
    @Select("select count(1) as cant from productos")
    public Integer getCantidadProductos();
    
}

