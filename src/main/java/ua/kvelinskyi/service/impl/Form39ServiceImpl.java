package ua.kvelinskyi.service.impl;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kvelinskyi.entity.Form39;
import ua.kvelinskyi.repository.Form39Repository;
import ua.kvelinskyi.service.Form39Service;

import java.sql.Date;
import java.util.List;

@Service
public class Form39ServiceImpl implements Form39Service {
    @Autowired
    Form39Repository form39Repository;
    private Logger log;
    //TODO Autowired Logger
    @Autowired
    public void setLog(Logger log) {
        this.log = log;
    }

    @Override
    public Form39 addForm39(Form39 form39) {
        return form39Repository.save(form39);
    }

    @Override
    public List<Form39> dateNowIsPresent(Date date, Integer idDoc) {
        return form39Repository.findByDateNowAndIdDoctor(date, idDoc);
    }

    @Override
    public List<Form39> dataForm39ByTimeIntervalAndIdDoc(Date dateStart, Date dateEnd, Integer idDoc) {
        log.info("class Form39ServiceImpl - dateStart = " + dateStart +" dateEnd = " + dateEnd);
        return form39Repository.findByDateNowBetweenAndIdDoctorOrderByNumDay(dateStart, dateEnd, idDoc);
    }

    @Override
    public List<Form39> dataForm39ByTimeInterval(Date dateStart, Date dateEnd) {
        return form39Repository.findByDateNowBetween(dateStart, dateEnd);
    }
}
