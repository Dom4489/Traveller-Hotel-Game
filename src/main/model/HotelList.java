package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HotelList {
    private LinkedList hotelList;
    public static final int MAX_SIZE = 10; // Maximum size of the list
    public static final String NOT_IN_LIST = "The hotel you entered could not be found within your list";
    public static final String MAX_SIZE_REACHED = "You have added the maximum amount of hotels one list can hold";
    private String listName; // Name of your list

    public HotelList(String name) {
        hotelList = new LinkedList<Hotel>();
        this.listName = name;
    }

    // REQUIRES: there is not already the same hotel in list
    // MODIFIES: this
    // EFFECTS: if the list is not maxed out, adds hotel to list and returns true,
    // otherwise returns false
    public Boolean addHotelToList(Hotel hotel) {
        if (hotelList.size() < MAX_SIZE) {
            hotelList.add(hotel);
            System.out.println("Success");
            return true;
        } else {
            System.out.println(MAX_SIZE_REACHED);
            return false;
        }
    }
    // REQUIRES: the list is not empty
    // MODIFIES: this
    // EFFECTS: removes the hotel in the list that matches the given name

    public String removeHotelFromList(String name) {
        for (int i = 0; i < hotelList.size(); i++) {
            Hotel obj = (Hotel) hotelList.get(i);
            if (obj.getName().equals(name)) {
                hotelList.remove(i);
                System.out.println("success");
                return obj.getName();
            }
        }
        return NOT_IN_LIST;
    }

    // REQUIRES: the list is not empty
    // EFFECTS: returns the name of the list
    public String getListName() {

        return listName;
    }

    // MODIFIES: this
    //EFFECTS: changes the name of the list
    public String setListName(String newName) {
        this.listName = newName;
        System.out.println("success");
        return listName;
    }

    // EFFECTS: returns the number of items in the list

    public int length() {
        return hotelList.size();
    }

    // EFFECTS: returns true if the list is full, false otherwise
    public String listFull() {
        if (hotelList.size() == MAX_SIZE) {
            return "yes";
        } else {
            return "no";
        }
    }

    // EFFECTS: returns true if the list is empty, false otherwise
    public String listEmpty() {
        if (hotelList.size() == 0) {
            return "yes";
        } else {
            return "no";
        }
    }


    // EFFECTS: returns a list of the hotel names
    public List getHotelListNames() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < hotelList.size(); i++) {
            Hotel obj = (Hotel) hotelList.get(i);
            String hotelName = obj.getName();
            result.add(hotelName);
        }
        return result;
    }

    //EFFECTS: returns the total prices of all the hotels in the list per day
    public int getTotalHotelPrices() {
        int result = 0;
        for (int i = 0; i < hotelList.size(); i++) {
            Hotel obj = (Hotel) hotelList.get(i);
            int hotelPrice = obj.getPricePerNight();
            result += hotelPrice;
        }
        return result;
    }
}
