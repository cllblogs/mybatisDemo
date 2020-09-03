package com.cll.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2020/9/3.
 */
public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource="mybatis-config.xml";
        InputStream in=null;
        try {
            in = Resources.getResourceAsStream(resource);
            /*构建sqlsesionFactroy*/
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }


    }
    public static SqlSession getsession(){

        return sqlSessionFactory.openSession();
    }

}
