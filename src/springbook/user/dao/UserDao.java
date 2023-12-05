package springbook.user.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.domain.User;

import java.sql.*;

//public abstract class UserDao {
public class UserDao {
//    private static UserDao INSTANCE;
//
//    public static synchronized UserDao getInstance() {
//        if (INSTANCE == null) INSTANCE = new UserDao(??);
//        return INSTANCE;
//    }

//    private SimpleConnetionMacker simpleConnetionMacker;
    private ConnectionMaker connectionMaker;

//    DaoFactory daoFactory = new DaoFactory();
//    this.connectionMaker = daoFactory.connectionMaker();

//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
//    this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);

//    public UserDao(SimpleConnetionMacker simpleConnetionMacker) {
//        this.simpleConnetionMacker = simpleConnetionMacker;
//    }

//    public UserDao() {
//        connectionMaker = new DConnectionMaker();
//    }

//    public UserDao(ConnectionMaker connectionMaker) {
//        this.connectionMaker = connectionMaker;
//    }

    public void setConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    /**
     * main()을 이용한 DAO 테스트 코드
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        UserDao dao = new UserDao(new SimpleConnetionMacker());
        UserDao dao = new UserDao(new DConnectionMaker());

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

    /**
     * 중복을 제거하여 메서드로 추출(DB연결 관련)
     */
//    private Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mysql://localhost/sys", "root", "shmoon");
//    }

//    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    public void add(User user) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/sys", "root", "shmoon");
//        Connection c = getConnection();
//        Connection c = simpleConnetionMacker.makeNewConnection();
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User get(String id) throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/sys", "root", "shmoon");
//        Connection c = getConnection();
//        Connection c = simpleConnetionMacker.makeNewConnection();
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));    
        user.setPassword(rs.getString("password"));
        
        rs.close();
        ps.close();
        c.close();
        
        return user;
    }


}
