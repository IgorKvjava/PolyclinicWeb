package ua.kvelinskyi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "polyclinicbase")
public class User {
    private int id;
    private String login;
    private String password;
    private String userName;
    private String enabled;
    private List<Form39> form39List;
    private List<PhoneBook> phoneBookList;
    private int role;
    private InformationDoctor informationDoctor;
    private NameOfThePost nameOfThePost;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String login, String password, String userName
            , String enabled, List<Form39> form39List, List<PhoneBook> phoneBookList
            , int role, InformationDoctor informationDoctor, NameOfThePost nameOfThePost) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.enabled = enabled;
        this.form39List = form39List;
        this.phoneBookList = phoneBookList;
        this.role = role;
        this.informationDoctor = informationDoctor;
        this.nameOfThePost = nameOfThePost;
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
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "enabled")
    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
    @Basic
    @Column(name = "role")
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    //TODO reed getPhoneBookEntityList mappedBy = "user"!!! == class PhoneBook public void setUser(User user)  this.user = user!!!;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    public List<PhoneBook> getPhoneBookList() {
        return phoneBookList;
    }

    public void setPhoneBookList(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    public List<Form39> getForm39List() {
        return form39List;
    }

    public void setForm39List(List<Form39> form39List) {
        this.form39List = form39List;
    }

    @ManyToOne
    @JoinColumn(name = "information_doctor_id")
    public InformationDoctor getInformationDoctor() {
        return informationDoctor;
    }

    public void setInformationDoctor(InformationDoctor informationDoctor) {
        this.informationDoctor = informationDoctor;
    }

    @ManyToOne
    @JoinColumn(name = "row_number")
    public NameOfThePost getNameOfThePost() {
        return nameOfThePost;
    }

    public void setNameOfThePost(NameOfThePost nameOfThePost) {
        this.nameOfThePost = nameOfThePost;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", enabled='" + enabled + '\'' +
                ", form39List=" + form39List +
                ", phoneBookList=" + phoneBookList +
                ", role=" + role +
                ", informationDoctor=" + informationDoctor +
                ", nameOfThePost=" + nameOfThePost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (role != user.role) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (enabled != null ? !enabled.equals(user.enabled) : user.enabled != null) return false;
        if (form39List != null ? !form39List.equals(user.form39List) : user.form39List != null) return false;
        if (phoneBookList != null ? !phoneBookList.equals(user.phoneBookList) : user.phoneBookList != null)
            return false;
        if (informationDoctor != null ? !informationDoctor.equals(user.informationDoctor) : user.informationDoctor != null)
            return false;
        return nameOfThePost != null ? nameOfThePost.equals(user.nameOfThePost) : user.nameOfThePost == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (form39List != null ? form39List.hashCode() : 0);
        result = 31 * result + (phoneBookList != null ? phoneBookList.hashCode() : 0);
        result = 31 * result + role;
        result = 31 * result + (informationDoctor != null ? informationDoctor.hashCode() : 0);
        result = 31 * result + (nameOfThePost != null ? nameOfThePost.hashCode() : 0);
        return result;
    }
}
