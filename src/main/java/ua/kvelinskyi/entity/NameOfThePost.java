package ua.kvelinskyi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "name_of_the_post", schema = "polyclinicbase")
public class NameOfThePost {
    private int id;
    private String position;
    private int rowNumber;
    private List<User> userList = new ArrayList<>();

    public NameOfThePost() {
    }

    public NameOfThePost(int id, String position, int rowNumber, List<User> userList) {
        this.id = id;
        this.position = position;
        this.rowNumber = rowNumber;
        this.userList = userList;
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
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "row_number")
    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "nameOfThePost")
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "NameOfThePost{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", rowNumber=" + rowNumber +
                ", userList=" + userList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameOfThePost that = (NameOfThePost) o;
        return id == that.id &&
                rowNumber == that.rowNumber &&
                Objects.equals(position, that.position) &&
                Objects.equals(userList, that.userList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, rowNumber, userList);
    }
}
