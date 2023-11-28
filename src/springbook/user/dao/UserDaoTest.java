package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ConnectionMaker connectionMaker = new DConnectionMaker();
//        UserDao dao = new UserDao(connectionMaker);

        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("shmoon");
        user.setName("문상후");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + "등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + "조회 성공");
    }

}
