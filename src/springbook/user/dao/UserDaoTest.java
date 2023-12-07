package springbook.user.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        ConnectionMaker connectionMaker = new DConnectionMaker();
//        UserDao dao = new UserDao(connectionMaker);

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

//        UserDao dao = new DaoFactory().userDao();
        // 스프링의 애플리케이션 컨텍스트에 등록된 Bean은 동일한 Object를 반환한다.
        UserDao dao = context.getBean("userDao", UserDao.class);

        System.out.println(dao);

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
