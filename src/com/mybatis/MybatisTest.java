package com.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.mybatis.mapper.FilterTableMapper;
import com.mybatis.model.FilterTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * @author zjp
 * @since 2017-03-18.
 */
@Component
public class MybatisTest
{
    @Autowired
    private FilterTableMapper filterTableMapper;

    public void insert(ApplicationContext context)
    {
        FilterTable table = new FilterTable();
        table.setCode("dsfdf");
        table.setName("jjojk");
        table.setVri(234.4253);
        // filterTableMapper = (FilterTableMapper) context.getBean("filterTableMapper");
        filterTableMapper.insert(table);
    }

    public static void main(String[] args) throws SQLException
    {
        String path = Paths.get(MybatisTest.class.getPackage().getName().replace(".", "/"), "applicationContext.xml")
                .toString();
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        DruidDataSource source = (DruidDataSource) context.getBean("dataSource");
        // source.init();   可省略 ，报错是mysql链接库太老？
        MybatisTest ttttt = (MybatisTest) context.getBean("mybatisTest");
        ttttt.insert(context);

    }
}
