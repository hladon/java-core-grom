package lesson15.lesson15hw.hw2;

import java.util.Date;
import java.util.Objects;

public class Room {
    private long id;
    private int price;
    private int persons;
    private Date dateAvailableFrom;
    private String hotelName;
    private String cityName;

    public Room(long id, int price, int persons, Date dateAvailableFrom, String hotelName, String cityName) {
        super();
        this.id = id;
        this.price = price;
        this.persons = persons;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotelName = hotelName;
        this.cityName = cityName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public long getId() {
        return id;
    }

    public int getPersons() {
        return persons;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return price == room.price &&
                persons == room.persons &&
                Objects.equals(hotelName, room.hotelName) &&
                Objects.equals(cityName, room.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, persons, hotelName, cityName);
    }
}