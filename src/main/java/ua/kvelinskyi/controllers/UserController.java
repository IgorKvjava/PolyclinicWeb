package ua.kvelinskyi.controllers;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kvelinskyi.entity.Form39;
import ua.kvelinskyi.entity.User;
import ua.kvelinskyi.service.impl.Form39ServiceImpl;
import ua.kvelinskyi.service.impl.UserServiceImpl;

import java.sql.Date;
import java.util.List;

@Controller
public class UserController {
    private Logger log;

    @Autowired
    public void setLog(Logger log) {
        this.log = log;
    }

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    Form39ServiceImpl form39ServiceImpl;
    @Autowired
    ControllerHelper controllerHelper;

    //DATE_FORMAT = "yyyy-MM-dd"
    private Integer dayOfDate(Date date) {
        String datePars = date.toString();
        String[] stringList = datePars.split("-");
        return Integer.parseInt(stringList[2]);
    }

    private Date getCurrentDate() {
        return new Date((new java.util.Date()).getTime());
    }

    private Boolean isValidationDataForForm39(Form39 form39) {
        Boolean bool = true;
        log.info("class UserController - col(1) " + form39.getNumberVisitsAll()
                + " >= " + (form39.getAdultsVisitsDisease() + form39.getChildrenVisitsDisease()
                + form39.getVisitsHomeAll()));
        if (form39.getNumberVisitsAll() >= (form39.getAdultsVisitsDisease()
                + form39.getChildrenVisitsDisease() + form39.getVisitsHomeAll())) {
            if ((form39.getNumberVisitsAll() >= form39.getChildrenVisitsVillagers())
                    && (form39.getNumberVisitsAll() >= (form39.getAdultsVisitsDiseaseVillagers()
                    + form39.getChildrenVisitsDiseaseVillagers() + form39.getVisitsHomeVillagers()))
                    && (form39.getOfVillagers() >= form39.getChildrenVisitsDisease())) {

                if ((form39.getChildrenVisitsVillagers() <= form39.getChildrenVisitsAll())
                        && (form39.getVisitsHomeAll() >= form39.getVisitsHomeVillagers())
                        && (form39.getChildrenVisitsHomeAll() <= form39.getVisitsHomeAll())
                        && (form39.getChildrenVisitsHomeVillagers() <= form39.getVisitsHomeVillagers())
                        && (form39.getChildrenPatronage() >= form39.getChildrenPatronageVillagers())) {
                    bool = false;
                }
            }

        }
        return bool;
    }

    //empty page for form 39
    @RequestMapping("/user/form39")
    public ModelAndView doForm39(Authentication loggedUser) {
        log.info("class UserController - page /user/form39");
        Date currentDate = getCurrentDate();
        Form39 form39 = new Form39();
        return controllerHelper.modelForPageCompleteForm39(form39, currentDate, dayOfDate(currentDate)
                , userServiceImpl.getUserIdByLogin(loggedUser.getName()), "user/form39", "Введіть коректно дані");
    }

    //save new form 39 to DB
    @RequestMapping("/user/form39/{id}")
    public ModelAndView doEditForm39(@PathVariable Integer id, Form39 form39) {
        log.info("class UserController - /user/form39/{id}");
        Date dateForNewField = form39.getDateNow();
        log.info("class UserController - dateForNewField = " + dateForNewField);
        List<Form39> listForm39ByDateNow = form39ServiceImpl.dateNowIsPresent(dateForNewField, id);
        log.info("class UserController - check is empty(listForm39ByDateNow) size = " + listForm39ByDateNow.size());
        if (listForm39ByDateNow.isEmpty()) {
            //set id 0 else IdDoctor=(current id user), form39 update
            form39.setId(0);
            form39.setNumDay(dayOfDate(dateForNewField));
            form39.setIdDoctor(id);
            form39.setUser(new User(id));
            if (isValidationDataForForm39(form39)) {
                return controllerHelper.modelForPageCompleteForm39(form39, form39.getDateNow(), form39.getNumDay()
                        , id, "user/form39", "Дані введено невірно");
            }
            form39ServiceImpl.addForm39(form39);
            log.info("class UserController - (form 39 saved) id = " + form39.getId());
        }
        List<Form39> form39List = form39ServiceImpl.dateNowIsPresent(dateForNewField, id);
        return controllerHelper.modelForPageForm39(form39List, dateForNewField, dateForNewField, "user/form39Data");
    }

    //viewing form 39 by current date
    @RequestMapping("/user/form39Data")
    public ModelAndView doViewForm39Data(Authentication loggedUser) {
        log.info("class UserController - /user/form39Data");
        Date currentDate = getCurrentDate();
        List<Form39> listForm39ByDateNow = form39ServiceImpl.dateNowIsPresent
                (currentDate, userServiceImpl.getUserIdByLogin(loggedUser.getName()));
        return controllerHelper.modelForPageForm39(listForm39ByDateNow, currentDate, currentDate, "user/form39Data");
    }

    //viewing form 39 by time Interval
    @RequestMapping("/user/form39Data/timeInterval")
    public ModelAndView doViewForm39DataByTimeInterval(Authentication loggedUser,
                                                       @RequestParam("dateStart") Date dateStart,
                                                       @RequestParam("dateEnd") Date dateEnd) {
        log.info("class UserController - /user/form39Data/timeInterval");
        List<Form39> listForm39 = form39ServiceImpl.dataForm39ByTimeIntervalAndIdDoc(dateStart,
                dateEnd, userServiceImpl.getUserIdByLogin(loggedUser.getName()));
        return controllerHelper.modelForPageForm39(listForm39, dateStart, dateEnd, "user/form39Data");
    }

    //TODO generate  ERROR PAGE 500
    @RequestMapping("/zzz")
    public ResponseEntity<String> gggg() {
        int e = 1 / 0;
        return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
