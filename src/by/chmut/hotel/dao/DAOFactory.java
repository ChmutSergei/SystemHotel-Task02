package by.chmut.hotel.dao;

import by.chmut.hotel.dao.impl.ReservationDaoImpl;
import by.chmut.hotel.dao.impl.RoomDaoImpl;
import by.chmut.hotel.dao.impl.UserDaoImpl;

public class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private final ReservationDao reservationDao = new ReservationDaoImpl();
    private final RoomDao roomDao = new RoomDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

    public ReservationDao getReservationDao() {
        return reservationDao;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

}
