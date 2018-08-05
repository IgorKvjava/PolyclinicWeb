package ua.kvelinskyi.service;

import ua.kvelinskyi.entity.Form39;

import java.sql.Date;
import java.util.List;

public interface Form39Service {

    Form39 addForm39(Form39 form39);
    List<Form39> dateNowIsPresent(Date date, Integer idDoc);
    List<Form39> dataForm39ByTimeIntervalAndIdDoc(Date dateStart, Date dateEnd, Integer idDoc);
    List<Form39> dataForm39ByTimeInterval(Date dateStart, Date dateEnd);
}
