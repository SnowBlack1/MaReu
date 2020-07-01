package com.lamzone.mareu.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {

    private String roomName;

    private Room(String roomName) {
        this.roomName = roomName;
    }

    private String getRoomName() {
        return roomName;
    }

    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room("Salle A"),
            new Room("Salle B"),
            new Room("Salle C"),
            new Room("Salle D"),
            new Room("Salle E")
    );

    static public List<String> getRoom() {
        List<String> roomList = new ArrayList<>();
        for (Room room : DUMMY_ROOMS) {
            roomList.add(room.getRoomName());
        }
        return roomList;
    }
}
