import by.chmut.hotel.bean.User;
import by.chmut.hotel.dao.DAOFactory;
import by.chmut.hotel.dao.UserDao;
import by.chmut.hotel.dao.database.ConnectionManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoTest {
    private DAOFactory factory = DAOFactory.getInstance();
    private UserDao userDao = factory.getUserDao();

    public void initData() {}

    @Test
    public void fullTest() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        connection.setAutoCommit(true);

        int beforeSave = getAllUser().size();
        User newUser = userDao.save(new User(1,"Test","pass","Test",
                "LastTest","user","ch@mail.ru","375296242712",
                "Belarus","Minsk","sdas 12","223010"));
        int afterSave = getAllUser().size();
        Assert.assertNotSame(beforeSave, afterSave);

        newUser.setEmail("tas@m.m");
        userDao.update(newUser);

        User updatedUser = userDao.get(newUser.getId());
        Assert.assertEquals("Метод update не корректен","tas@m.m", updatedUser.getEmail());

        newUser.setTelephone("tas@m.m");
        userDao.update(newUser);

        updatedUser = userDao.get(newUser.getId());
        Assert.assertEquals("Метод update не корректен","tas@m.m", updatedUser.getTelephone());

        newUser.setCountry("USA");
        userDao.update(newUser);

        updatedUser = userDao.get(newUser.getId());
        Assert.assertEquals("Метод update не корректен","USA", updatedUser.getCountry());

        User testUser = userDao.getUserByLogin("Test");
        Assert.assertNotNull(testUser);

        userDao.delete(newUser.getId());

        afterSave = getAllUser().size();
        Assert.assertEquals(beforeSave, afterSave);

    }
    private List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        int count = 1;
        try {
            User user = userDao.get(count);
            while (user.getId()!=0) {
                users.add(user);
                count++;
                user = userDao.get(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
