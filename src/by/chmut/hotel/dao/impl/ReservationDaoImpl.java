package by.chmut.hotel.dao.impl;

import by.chmut.hotel.dao.AbstractDao;
import by.chmut.hotel.dao.ReservationDao;
import by.chmut.hotel.bean.Reservation;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl extends AbstractDao implements ReservationDao {

    private static final String saveQuery = "INSERT INTO Reservation (user_id, room_id, date) " +
            "VALUES (?,?,now())";
    private static final String getQuery = "SELECT * FROM Reservation WHERE id=?";
    private static final String getQueryUserId = "SELECT * FROM Reservation WHERE user_id=?";
    private static final String getQueryByDate = "SELECT * FROM Reservation WHERE date>=? AND date<=?;";
    private static final String updateQuery = "UPDATE Reservation SET room_id=? WHERE id=?";
    private static final String deleteQuery = "DELETE FROM Reservation WHERE id=?";


    private Reservation setFromResultSet(ResultSet rs) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(rs.getInt(1));
        reservation.setUserId(rs.getInt(2));
        reservation.setRoomId(rs.getInt(3));
        reservation.setDate(rs.getDate(4).toLocalDate());
        return reservation;
    }

    @Override
    public List<Reservation> getByUserId(Serializable userId) throws SQLException {
        List<Reservation> list = new ArrayList<>();
        PreparedStatement psGetByUserId = prepareStatement(getQueryUserId);
        psGetByUserId.setInt(1, (int) userId);
        ResultSet rs = psGetByUserId.executeQuery();
        while (rs.next()) {
            list.add(setFromResultSet(rs));
        }
        close(rs);
        return list;
    }
    @Override
    public List<Reservation> getByDate(LocalDate startDate, LocalDate endDate) throws SQLException {
        List<Reservation> list = new ArrayList<>();
        PreparedStatement psGetByDate = prepareStatement(getQueryByDate);
        psGetByDate.setDate(1, java.sql.Date.valueOf(startDate));
        psGetByDate.setDate(2, java.sql.Date.valueOf(endDate));
        ResultSet rs = psGetByDate.executeQuery();
        while (rs.next()) {
            list.add(setFromResultSet(rs));
        }
        close(rs);
        return list;
    }

    @Override
    public Reservation save(Reservation reservation) throws SQLException {
        PreparedStatement psReservation = prepareStatement(saveQuery, Statement.RETURN_GENERATED_KEYS);
        psReservation.setInt(1, reservation.getUserId());
        psReservation.setInt(2, reservation.getRoomId());
        psReservation.executeUpdate();
        ResultSet rs = psReservation.getGeneratedKeys();
        if (rs.next()) {
            reservation.setId(rs.getInt(1));
        }
        close(rs);
        reservation.setDate(LocalDate.now());
        return reservation;
    }

    @Override
    public Reservation get(Serializable id) throws SQLException {
        PreparedStatement psGetReservation = prepareStatement(getQuery);
        psGetReservation.setInt(1, (int) id);
        ResultSet rs = psGetReservation.executeQuery();
        if (rs.next()) {
            return setFromResultSet(rs);
        }
        return null;
    }


    @Override
    public void update(Reservation reservation) throws SQLException {
        PreparedStatement psUpdateReservation = prepareStatement(updateQuery);
        psUpdateReservation.setInt(2, reservation.getId());
        psUpdateReservation.setInt(1, reservation.getRoomId());
//        psUpdateReservation.setDate(2, java.sql.Date.valueOf(reservation.getCheckIn()));
//        psUpdateReservation.setDate(3, java.sql.Date.valueOf(reservation.getCheckOut()));
        psUpdateReservation.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        PreparedStatement psDelete = prepareStatement(deleteQuery);
        psDelete.setInt(1, (int) id);
        return psDelete.executeUpdate();
    }


}
