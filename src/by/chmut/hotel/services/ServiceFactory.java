package by.chmut.hotel.services;

import by.chmut.hotel.services.impl.ReservationServiceImpl;
import by.chmut.hotel.services.impl.RoomServiceImpl;
import by.chmut.hotel.services.impl.UserServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final UserService userService= new UserServiceImpl();
    private final RoomService roomService = new RoomServiceImpl();
    private final ReservationService reservationService = new ReservationServiceImpl();

    private ServiceFactory() {}


    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }

    public RoomService getRoomService() {
        return roomService;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }
}
