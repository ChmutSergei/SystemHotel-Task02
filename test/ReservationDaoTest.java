import by.chmut.hotel.bean.Reservation;
import by.chmut.hotel.dao.DAOFactory;
import by.chmut.hotel.dao.ReservationDao;
import by.chmut.hotel.dao.database.ConnectionManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReservationDaoTest {
    private DAOFactory factory = DAOFactory.getInstance();
    private ReservationDao reservationDao = factory.getReservationDao();

    public void initData() {}

    @Test
    public void fullTest() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        connection.setAutoCommit(true);
//        int beforeSave = reservationDao.getByDate(LocalDate.now(),LocalDate.now()).size();
//        Reservation newRes = reservationDao.save(new Reservation(1,3,6,LocalDate.now()));
//        int afterSave = reservationDao.getByDate(LocalDate.now(),LocalDate.now()).size();
//        Assert.assertNotSame(beforeSave, afterSave);
//
//        newRes.setRoomId(5);
//        reservationDao.update(newRes);
//
//        Reservation updatedRes = reservationDao.get(newRes.getId());
//        Assert.assertEquals("Метод update не корректен",5, updatedRes.getRoomId());


//        Reservation test = reservationDao.getByUserId(3);
//        Assert.assertNotNull(test);

//        reservationDao.delete(newRes.getId());
//
//        afterSave = reservationDao.getByDate(LocalDate.now(),LocalDate.now()).size();
//        Assert.assertEquals(beforeSave, afterSave);
    }
}
