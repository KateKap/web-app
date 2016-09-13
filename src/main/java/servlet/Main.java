package java.servlet;

import java.io.Reader;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by Kate on 13.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        try {

            Reader reader = org.apache.ibatis.io.Resources.getResourceAsReader("configuration.xml");
            SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlSessionFactory.openSession();
            User user = (User) session.selectOne("userMapper.selectUser",1);
            System.out.println("ID: "+user.getId()+", Name: "+user.getName());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
