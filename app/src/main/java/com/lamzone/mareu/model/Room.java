package com.lamzone.mareu.model;




public class Room {

    private int id;
    private String roomName;
    private String roomImgUrl;

    public Room (int id, String roomName, String roomImgUrl){
        this.id = id;
        this.roomName = roomName;
        this.roomImgUrl = roomImgUrl;
    }

    //private static final List<Room> DUMMY_ROOMS = Arrays.asList(
    //        new Room(1,"Salle A","https://ibb.co/qRHZN9c"),
    //        new Room(2,"Salle B","https://ibb.co/qY0FJvX"),
    //        new Room(3,"Salle C","https://ibb.co/pdNShPs"),
    //        new Room(4,"Salle D","https://ibb.co/TvN3mzv")
    //);
//
    //static public List<String> getRoom(){
    //    List<String> roomList = new ArrayList<>();
    //    for (Room room : DUMMY_ROOMS){
    //        roomList.add(room.getRoomName());
    //    }
    //    return roomList;
    //}


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomImgUrl() {
        return roomImgUrl;
    }

    public void setRoomImgUrl(String roomImgUrl) {
        this.roomImgUrl = roomImgUrl;
    }
}
