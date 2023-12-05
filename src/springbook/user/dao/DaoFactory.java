package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    public UserDao userDao() {
//        return new UserDao(connectionMaker());
        UserDao userdao = new UserDao();
        userdao.setConnectionMaker(connectionMaker());
        return userdao;
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
//        return new LocalDBConnectionMaker();
//        return new ProductionDBConnectionMaker();
    }

}
