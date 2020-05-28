package com.lamzone.mareu.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {

    private int id;
    private String roomName;

    public Room (int id, String roomName){
        this.id = id;
        this.roomName = roomName;
    }

    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room(1,"Salle A"),
            new Room(2,"Salle B"),
            new Room(3,"Salle C"),
            new Room(4,"Salle D"),
            new Room(5,"Salle E")
    );

    static public List<String> getRoom(){
        List<String> roomList = new ArrayList<>();
        for (Room room : DUMMY_ROOMS){
            roomList.add(room.getRoomName());
        }
        return roomList;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }


}
