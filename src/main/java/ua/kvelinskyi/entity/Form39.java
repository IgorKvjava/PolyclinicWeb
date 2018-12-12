package ua.kvelinskyi.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "form39", schema = "polyclinicbase")
public class Form39 {
    private int id;
    private int idDoctor;
    private Date dateNow;
    private int numDay;
    private int numberVisitsAll;
    private int ofVillagers;
    private int childrenVisitsAll;
    private int childrenVisitsVillagers;
    private int adultsVisitsDisease;
    private int adultsVisitsDiseaseVillagers;
    private int childrenVisitsDisease;
    private int childrenVisitsDiseaseVillagers;
    private int visitsHomeAll;
    private int visitsHomeVillagers;
    private int childrenVisitsHomeAll;
    private int childrenVisitsHomeVillagers;
    private int childrenPatronage;
    private int childrenPatronageVillagers;
    private User user;


    public Form39() {
    }

    public Form39(int idDoctor, Date dateNow, int numDay, int numberVisitsAll, int ofVillagers,
                  int childrenVisitsAll, int childrenVisitsVillagers, int adultsVisitsDisease,
                  int adultsVisitsDiseaseVillagers, int childrenVisitsDisease,
                  int childrenVisitsDiseaseVillagers, int visitsHomeAll, int visitsHomeVillagers,
                  int childrenVisitsHomeAll, int childrenVisitsHomeVillagers, int childrenPatronage,
                  int childrenPatronageVillagers) {
        this.idDoctor = idDoctor;
        this.dateNow = dateNow;
        this.numDay = numDay;
        this.numberVisitsAll = numberVisitsAll;
        this.ofVillagers = ofVillagers;
        this.childrenVisitsAll = childrenVisitsAll;
        this.childrenVisitsVillagers = childrenVisitsVillagers;
        this.adultsVisitsDisease = adultsVisitsDisease;
        this.adultsVisitsDiseaseVillagers = adultsVisitsDiseaseVillagers;
        this.childrenVisitsDisease = childrenVisitsDisease;
        this.childrenVisitsDiseaseVillagers = childrenVisitsDiseaseVillagers;
        this.visitsHomeAll = visitsHomeAll;
        this.visitsHomeVillagers = visitsHomeVillagers;
        this.childrenVisitsHomeAll = childrenVisitsHomeAll;
        this.childrenVisitsHomeVillagers = childrenVisitsHomeVillagers;
        this.childrenPatronage = childrenPatronage;
        this.childrenPatronageVillagers = childrenPatronageVillagers;
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
    @Column(name = "id_doctor")
    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }
    @Basic
    @Column(name = "date_now")
    public Date getDateNow() {
        return dateNow;
    }

    public void setDateNow(Date dateNow) {
        this.dateNow = dateNow;
    }
    @Basic
    @Column(name = "num_day")
    public int getNumDay() {
        return numDay;
    }

    public void setNumDay(int numDay) {
        this.numDay = numDay;
    }
    @Basic
    @Column(name = "number_visits_all")
    public int getNumberVisitsAll() {
        return numberVisitsAll;
    }

    public void setNumberVisitsAll(int numberVisitsAll) {
        this.numberVisitsAll = numberVisitsAll;
    }
    @Basic
    @Column(name = "of_villagers")
    public int getOfVillagers() {
        return ofVillagers;
    }

    public void setOfVillagers(int ofVillagers) {
        this.ofVillagers = ofVillagers;
    }
    @Basic
    @Column(name = "children_visits_all")
    public int getChildrenVisitsAll() {
        return childrenVisitsAll;
    }

    public void setChildrenVisitsAll(int childrenVisitsAll) {
        this.childrenVisitsAll = childrenVisitsAll;
    }
    @Basic
    @Column(name = "children_visits_villagers")
    public int getChildrenVisitsVillagers() {
        return childrenVisitsVillagers;
    }

    public void setChildrenVisitsVillagers(int childrenVisitsVillagers) {
        this.childrenVisitsVillagers = childrenVisitsVillagers;
    }
    @Basic
    @Column(name = "adults_visits_disease")
    public int getAdultsVisitsDisease() {
        return adultsVisitsDisease;
    }

    public void setAdultsVisitsDisease(int adultsVisitsDisease) {
        this.adultsVisitsDisease = adultsVisitsDisease;
    }
    @Basic
    @Column(name = "adults_visits__disease_villagers")
    public int getAdultsVisitsDiseaseVillagers() {
        return adultsVisitsDiseaseVillagers;
    }

    public void setAdultsVisitsDiseaseVillagers(int adultsVisitsDiseaseVillagers) {
        this.adultsVisitsDiseaseVillagers = adultsVisitsDiseaseVillagers;
    }
    @Basic
    @Column(name = "children_visits__disease")
    public int getChildrenVisitsDisease() {
        return childrenVisitsDisease;
    }

    public void setChildrenVisitsDisease(int childrenVisitsDisease) {
        this.childrenVisitsDisease = childrenVisitsDisease;
    }
    @Basic
    @Column(name = "children_visits__disease_villagers")
    public int getChildrenVisitsDiseaseVillagers() {
        return childrenVisitsDiseaseVillagers;
    }

    public void setChildrenVisitsDiseaseVillagers(int childrenVisitsDiseaseVillagers) {
        this.childrenVisitsDiseaseVillagers = childrenVisitsDiseaseVillagers;
    }
    @Basic
    @Column(name = "visits_home_all")
    public int getVisitsHomeAll() {
        return visitsHomeAll;
    }

    public void setVisitsHomeAll(int visitsHomeAll) {
        this.visitsHomeAll = visitsHomeAll;
    }
    @Basic
    @Column(name = "visits_home_villagers")
    public int getVisitsHomeVillagers() {
        return visitsHomeVillagers;
    }

    public void setVisitsHomeVillagers(int visitsHomeVillagers) {
        this.visitsHomeVillagers = visitsHomeVillagers;
    }
    @Basic
    @Column(name = "children_visits_home_all")
    public int getChildrenVisitsHomeAll() {
        return childrenVisitsHomeAll;
    }

    public void setChildrenVisitsHomeAll(int childrenVisitsHomeAll) {
        this.childrenVisitsHomeAll = childrenVisitsHomeAll;
    }
    @Basic
    @Column(name = "children_visits_home_villagers")
    public int getChildrenVisitsHomeVillagers() {
        return childrenVisitsHomeVillagers;
    }

    public void setChildrenVisitsHomeVillagers(int childrenVisitsHomeVillagers) {
        this.childrenVisitsHomeVillagers = childrenVisitsHomeVillagers;
    }
    @Basic
    @Column(name = "children_patronage")
    public int getChildrenPatronage() {
        return childrenPatronage;
    }

    public void setChildrenPatronage(int childrenPatronage) {
        this.childrenPatronage = childrenPatronage;
    }
    @Basic
    @Column(name = "children_patronage_villagers")
    public int getChildrenPatronageVillagers() {
        return childrenPatronageVillagers;
    }

    public void setChildrenPatronageVillagers(int childrenPatronageVillagers) {
        this.childrenPatronageVillagers = childrenPatronageVillagers;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
 //           , foreignKey = @ForeignKey(name = "id_user_key"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Form39{" +
                "id=" + id +
                ", idDoctor=" + idDoctor +
                ", dateNow=" + dateNow +
                ", numDay=" + numDay +
                ", numberVisitsAll=" + numberVisitsAll +
                ", ofVillagers=" + ofVillagers +
                ", childrenVisitsAll=" + childrenVisitsAll +
                ", childrenVisitsVillagers=" + childrenVisitsVillagers +
                ", adultsVisitsDisease=" + adultsVisitsDisease +
                ", adultsVisitsDiseaseVillagers=" + adultsVisitsDiseaseVillagers +
                ", childrenVisitsDisease=" + childrenVisitsDisease +
                ", childrenVisitsDiseaseVillagers=" + childrenVisitsDiseaseVillagers +
                ", visitsHomeAll=" + visitsHomeAll +
                ", visitsHomeVillagers=" + visitsHomeVillagers +
                ", childrenVisitsHomeAll=" + childrenVisitsHomeAll +
                ", childrenVisitsHomeVillagers=" + childrenVisitsHomeVillagers +
                ", childrenPatronage=" + childrenPatronage +
                ", childrenPatronageVillagers=" + childrenPatronageVillagers +
               // ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Form39 form39 = (Form39) o;

        if (adultsVisitsDisease != form39.adultsVisitsDisease) return false;
        if (adultsVisitsDiseaseVillagers != form39.adultsVisitsDiseaseVillagers) return false;
        if (childrenPatronage != form39.childrenPatronage) return false;
        if (childrenPatronageVillagers != form39.childrenPatronageVillagers) return false;
        if (childrenVisitsAll != form39.childrenVisitsAll) return false;
        if (childrenVisitsDisease != form39.childrenVisitsDisease) return false;
        if (childrenVisitsDiseaseVillagers != form39.childrenVisitsDiseaseVillagers) return false;
        if (childrenVisitsHomeAll != form39.childrenVisitsHomeAll) return false;
        if (childrenVisitsHomeVillagers != form39.childrenVisitsHomeVillagers) return false;
        if (childrenVisitsVillagers != form39.childrenVisitsVillagers) return false;
        if (id != form39.id) return false;
        if (idDoctor != form39.idDoctor) return false;
        if (numDay != form39.numDay) return false;
        if (numberVisitsAll != form39.numberVisitsAll) return false;
        if (ofVillagers != form39.ofVillagers) return false;
        if (visitsHomeAll != form39.visitsHomeAll) return false;
        if (visitsHomeVillagers != form39.visitsHomeVillagers) return false;
        if (dateNow != null ? !dateNow.equals(form39.dateNow) : form39.dateNow != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idDoctor;
        result = 31 * result + (dateNow != null ? dateNow.hashCode() : 0);
        result = 31 * result + numDay;
        result = 31 * result + numberVisitsAll;
        result = 31 * result + ofVillagers;
        result = 31 * result + childrenVisitsAll;
        result = 31 * result + childrenVisitsVillagers;
        result = 31 * result + adultsVisitsDisease;
        result = 31 * result + adultsVisitsDiseaseVillagers;
        result = 31 * result + childrenVisitsDisease;
        result = 31 * result + childrenVisitsDiseaseVillagers;
        result = 31 * result + visitsHomeAll;
        result = 31 * result + visitsHomeVillagers;
        result = 31 * result + childrenVisitsHomeAll;
        result = 31 * result + childrenVisitsHomeVillagers;
        result = 31 * result + childrenPatronage;
        result = 31 * result + childrenPatronageVillagers;
        return result;
    }
}
