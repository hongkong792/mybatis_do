package com.yy.mybatis.controller;




import com.yy.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.Reader;


/**
 * Created by vincent on 2017/11/26.
 */
public class MybatisFirst {

    public void findUserByIdTest() throws Exception{

        //mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        Reader reader=Resources.getResourceAsReader(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(reader);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        User user = (User)sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);

        // 释放资源
        sqlSession.close();


    }



}
