/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.accommodation.helper;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nirvana
 */
public class HotelRoomHelper {
    private long hotelId;
    private long roomId;
    private String hotelName;
    private String roomType;
    private double rate;
    private String hotelDescription;
    private String typeDescription;
    private Collection<String> items;
    private Collection<String> services;

    public HotelRoomHelper(long hotelId, long roomId, String hotelName, String roomType, 
            double rate, String hotelDescription, String typeDescription, Collection<String> items, Collection<String> services) {
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.rate = rate;
        this.hotelDescription = hotelDescription;
        this.typeDescription = typeDescription;
        this.items = items;
        this.services = services;
    }

    
    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public Collection<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }

    public Collection<String> getServices() {
        return services;
    }

    public void setServices(ArrayList<String> services) {
        this.services = services;
    }
    
    
    
}
