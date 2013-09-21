/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session.accommodation;

import entity.accommodation.RoomEntity;
import entity.common.helper.CustomerHelper;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author apple
 */
public interface RoomReservationManagerBeanLocal {

    void blockRoom(String hotel, String roomType, int number);

    double checkRate(RoomEntity r) throws ParseException;

    int computeDate(Calendar date1, Calendar date2);

    void memberCreateReservation(String email);

    void nonMemberCreateReservation(CustomerHelper ch);

    ArrayList searchRoom(Date checkinDate, Date checkoutDate);

    void unblockRoom();
    
}
