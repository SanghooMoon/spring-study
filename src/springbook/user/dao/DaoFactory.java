package springbook.user.dao;

public class DaoFactory {
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

    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    private ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }

}
