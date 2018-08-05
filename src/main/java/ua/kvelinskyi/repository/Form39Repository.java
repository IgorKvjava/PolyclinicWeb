package ua.kvelinskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kvelinskyi.entity.Form39;

import java.sql.Date;
import java.util.List;

public interface Form39Repository extends JpaRepository<Form39, Integer> {

    List<Form39> findByDateNowAndIdDoctor(Date date, Integer idDoc);
    List<Form39> findByDateNowBetweenAndIdDoctorOrderByNumDay(Date dateStart, Date dateEnd, Integer idDoc);
    List<Form39> findByDateNowBetween(Date dateStart, Date dateEnd);

}
