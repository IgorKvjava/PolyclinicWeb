package ua.kvelinskyi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "information_doctor", schema = "polyclinicbase")
public class InformationDoctor {
    private int id;
    private String specialtyOfDoctor;
    private String room;
    private List<User> usersList;

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
    //@Fetch(value = FetchMode.SUBSELECT)
    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    @Override
    public String toString() {
        return "InformationDoctor{" +
                "id=" + id +
                ", specialtyOfDoctor='" + specialtyOfDoctor + '\'' +
                ", room='" + room + '\'' +
                ", usersList=" + usersList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InformationDoctor that = (InformationDoctor) o;

        if (id != that.id) return false;
        if (specialtyOfDoctor != null ? !specialtyOfDoctor.equals(that.specialtyOfDoctor) : that.specialtyOfDoctor != null)
            return false;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        return usersList != null ? usersList.equals(that.usersList) : that.usersList == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (specialtyOfDoctor != null ? specialtyOfDoctor.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (usersList != null ? usersList.hashCode() : 0);
        return result;
    }
}
