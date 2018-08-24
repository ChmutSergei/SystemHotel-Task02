import by.chmut.hotel.bean.Room;
import by.chmut.hotel.dao.DAOFactory;
import by.chmut.hotel.database.ConnectionManager;
import by.chmut.hotel.dao.RoomDao;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class RoomDaoTest {
    private DAOFactory factory = DAOFactory.getInstance();
    private RoomDao roomDao = factory.getRoomDao();

    public void initData() {}

    @Test
    public void fullTest() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        connection.setAutoCommit(true);
        int beforeSave = roomDao.getAllRoom().size();
        Room newRoom = roomDao.save(new Room(25,"Люкс",2,125.9,LocalDate.now(),
                LocalDate.now().plusDays(5), "as"));
        int afterSave = roomDao.getAllRoom().size();
        Assert.assertNotSame(beforeSave, afterSave);


        newRoom.setType("as");
        roomDao.update(newRoom);

        Room updatedRoom = roomDao.get(newRoom.getId());
        Assert.assertEquals("Метод update не корректен","as", updatedRoom.getType());
        newRoom.setBedType(2);
        roomDao.update(newRoom);

        updatedRoom = roomDao.get(newRoom.getId());
        Assert.assertEquals("Метод update не корректен",2, updatedRoom.getBedType());
        newRoom.setPrice(129.9);
        roomDao.update(newRoom);

        updatedRoom = roomDao.get(newRoom.getId());
        Assert.assertEquals(129.9,updatedRoom.getPrice(), 0);
        newRoom.setCheckIn(LocalDate.parse("2018-12-10"));
        roomDao.update(newRoom);

        updatedRoom = roomDao.get(newRoom.getId());
        Assert.assertEquals("Метод update не корректен",LocalDate.parse("2018-12-10"), updatedRoom.getCheckIn());

        newRoom.setCheckOut(LocalDate.parse("2018-12-12"));
        roomDao.update(newRoom);

        updatedRoom = roomDao.get(newRoom.getId());
        Assert.assertEquals("Метод update не корректен",LocalDate.parse("2018-12-12"), updatedRoom.getCheckOut());

        List<Room> rooms = roomDao.getRoomOnDateAndBedType(2, LocalDate.parse("2018-12-14"), LocalDate.parse("2018-12-16"));
        Assert.assertNotNull(rooms);

        roomDao.delete(newRoom.getId());

        afterSave = roomDao.getAllRoom().size();
        Assert.assertEquals(beforeSave, afterSave);

    }


}
