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
    private List<Form39> form39List = new ArrayList<>();
    private List<PhoneBook> phoneBookList = new ArrayList<>();
    private int role;
    private InformationDoctor informationDoctor;
    private NameOfThePost nameOfThePost;



    public User() {
    }

    public User(String login, String password, String userName, String enabled,
                List<Form39> form39List, List<PhoneBook> phoneBookList, int role,
                InformationDoctor informationDoctor, NameOfThePost nameOfThePost) {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "information_doctor_id")
    public InformationDoctor getInformationDoctor() {
        return informationDoctor;
    }

    public void setInformationDoctor(InformationDoctor informationDoctor) {
        this.informationDoctor = informationDoctor;
    }
    @ManyToOne(fetch = FetchType.LAZY)
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
        return id == user.id &&
                role == user.role &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(enabled, user.enabled) &&
                Objects.equals(form39List, user.form39List) &&
                Objects.equals(phoneBookList, user.phoneBookList) &&
                Objects.equals(informationDoctor, user.informationDoctor) &&
                Objects.equals(nameOfThePost, user.nameOfThePost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, userName, enabled, form39List, phoneBookList, role, informationDoctor, nameOfThePost);
    }
}
