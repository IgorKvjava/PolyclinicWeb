package ua.kvelinskyi.entity;

import javax.persistence.*;

@Entity
@Table(name = "phone_books", schema = "polyclinicbase")
public class PhoneBook {
    private int id;
    private int idUser;
    private String suname;
    private String fistName;
    private String middleName;
    private String phoneMobile;
    private String phoneHome;
    private String address;
    private String eMail;
    private User user;

    public PhoneBook() {
    }

    public PhoneBook(int idUser, String suname, String fistName, String middleName,
                     String phoneMobile, String phoneHome, String address, String eMail) {
        this.idUser = idUser;
        this.suname = suname;
        this.fistName = fistName;
        this.middleName = middleName;
        this.phoneMobile = phoneMobile;
        this.phoneHome = phoneHome;
        this.address = address;
        this.eMail = eMail;
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
    @Column(name = "id_user")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "suname")
    public String getSuname() {
        return suname;
    }

    public void setSuname(String suname) {
        this.suname = suname;
    }

    @Basic
    @Column(name = "fist_name")
    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    @Basic
    @Column(name = "middle_name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "phone_mobile")
    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    @Basic
    @Column(name = "phone_home")
    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "e_mail")
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }



    @ManyToOne
    @JoinColumn(name = "user_id")
//            , foreignKey = @ForeignKey(name = "id_user_key_"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", suname='" + suname + '\'' +
                ", fistName='" + fistName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                ", phoneHome='" + phoneHome + '\'' +
                ", address='" + address + '\'' +
                ", eMail='" + eMail + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneBook that = (PhoneBook) o;

        if (id != that.id) return false;
        if (idUser != that.idUser) return false;
        if (suname != that.suname) return false;
        if (fistName != that.fistName) return false;
        if (middleName != that.middleName) return false;
        if (phoneMobile != null ? !phoneMobile.equals(that.phoneMobile) : that.phoneMobile != null) return false;
        if (phoneHome != null ? !phoneHome.equals(that.phoneHome) : that.phoneHome != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (eMail != null ? !eMail.equals(that.eMail) : that.eMail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idUser;
        result = 31 * result + (suname != null ? suname.hashCode() : 0);
        result = 31 * result + (fistName != null ? fistName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (phoneMobile != null ? phoneMobile.hashCode() : 0);
        result = 31 * result + (phoneHome != null ? phoneHome.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        return result;
    }
}
