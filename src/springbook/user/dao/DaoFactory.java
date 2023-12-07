package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class DaoFactory {
    public DaoFactory() {

    }
    //    public UserDao userDao() {
//        return new UserDao(new DConnectionMaker());
//    }
//
//    public AccountDao accountDao() {
//        return new AccountDao(new DConnectionMaker());
//    }
//
//    public MessageDao messageDao() {
//        return new MessageDao(new DConnectionMaker());
//    }

//    @Bean
//    public UserDao userDao() {
////        return new UserDao(connectionMaker());
//        UserDao userdao = new UserDao();
//        userdao.setConnectionMaker(connectionMaker());
//        return userdao;
//    }

    @Bean
    public UserDao userDao() {
//        return new UserDao(connectionMaker());
        UserDao userdao = new UserDao();
        userdao.setDataSource(dataSource());
        return userdao;
    }


//    public AccountDao accountDao() {
//        return new AccountDao(connectionMaker());
//    }

//    public MessageDao messageDao() {
//        return new MessageDao(connectionMaker());
//    }

//    @Bean
//    public ConnectionMaker connectionMaker() {
//        return new DConnectionMaker();
////        return new LocalDBConnectionMaker();
////        return new ProductionDBConnectionMaker();
//    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/sys");
        dataSource.setUsername("root");
        dataSource.setPassword("shmoon");

        return dataSource;
    }

}
