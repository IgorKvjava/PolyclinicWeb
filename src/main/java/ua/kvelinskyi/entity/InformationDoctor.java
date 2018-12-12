package ua.kvelinskyi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "information_doctor", schema = "polyclinicbase")
public class InformationDoctor {
    private int id;
    private String specialtyOfDoctor;
    private String room;
    private List<User> usersList = new ArrayList<>();

    public InformationDoctor() {
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "specialty_of_doctor")
    public String getSpecialtyOfDoctor() {
        return specialtyOfDoctor;
    }

    public void setSpecialtyOfDoctor(String specialtyOfDoctor) {
        this.specialtyOfDoctor = specialtyOfDoctor;
    }

    @Basic
    @Column(name = "room")
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "informationDoctor")
    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
}
