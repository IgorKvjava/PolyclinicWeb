package ua.kvelinskyi.controllers;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import ua.kvelinskyi.entity.Form39;

import java.sql.Date;
import java.util.List;

@Service
public class ControllerHelper {

    public ControllerHelper() {
    }

    public Form39 sumForms39Entity (List<Form39> listForm39){
        return sumForms39(listForm39);
    }

    public Form39 sumForms2100Entity(List<Form39> listForm2100) {
        return sumForms39(listForm2100);
    }

    private Form39 sumForms39(List<Form39> listForm39){
        Form39 sumForms39 = new Form39();
        for(Form39 form39 : listForm39) {
            sumForms39.setNumberVisitsAll(sumForms39.getNumberVisitsAll() + form39.getNumberVisitsAll());
            sumForms39.setAdultsVisitsDisease(sumForms39.getAdultsVisitsDisease() + form39.getAdultsVisitsDisease());
            sumForms39.setAdultsVisitsDiseaseVillagers(sumForms39.getAdultsVisitsDiseaseVillagers() + form39.getAdultsVisitsDiseaseVillagers());
            sumForms39.setChildrenPatronage(sumForms39.getChildrenPatronage() + form39.getChildrenPatronage());
            sumForms39.setChildrenPatronageVillagers(sumForms39.getChildrenPatronageVillagers() + form39.getChildrenPatronageVillagers());
            sumForms39.setChildrenVisitsAll(sumForms39.getChildrenVisitsAll() + form39.getChildrenVisitsAll());
            sumForms39.setChildrenVisitsDisease(sumForms39.getChildrenVisitsDisease() + form39.getChildrenVisitsDisease());
            sumForms39.setChildrenVisitsDiseaseVillagers(sumForms39.getChildrenVisitsDiseaseVillagers() + form39.getChildrenVisitsDiseaseVillagers());
            sumForms39.setChildrenVisitsHomeAll(sumForms39.getChildrenVisitsHomeAll() + form39.getChildrenVisitsHomeAll());
            sumForms39.setChildrenVisitsHomeVillagers(sumForms39.getChildrenVisitsHomeVillagers() + form39.getChildrenVisitsHomeVillagers());
            sumForms39.setChildrenVisitsVillagers(sumForms39.getChildrenVisitsVillagers() + form39.getChildrenVisitsVillagers());
            sumForms39.setOfVillagers(sumForms39.getOfVillagers() + form39.getOfVillagers());
            sumForms39.setVisitsHomeAll(sumForms39.getVisitsHomeAll() + form39.getVisitsHomeAll());
            sumForms39.setVisitsHomeVillagers(sumForms39.getVisitsHomeVillagers() + form39.getVisitsHomeVillagers());

        }
        return sumForms39;
    }

    private Form39 resetTheTable (Form39 sumForm){
        sumForm.setNumberVisitsAll(0);
        sumForm.setAdultsVisitsDisease(0);
        sumForm.setAdultsVisitsDiseaseVillagers(0);
        sumForm.setChildrenPatronage(0);
        sumForm.setChildrenPatronageVillagers(0);
        sumForm.setChildrenVisitsAll(0);
        sumForm.setChildrenVisitsDisease(0);
        sumForm.setChildrenVisitsDiseaseVillagers(0);
        sumForm.setChildrenVisitsHomeAll(0);
        sumForm.setChildrenVisitsHomeVillagers(0);
        sumForm.setChildrenVisitsVillagers(0);
        sumForm.setOfVillagers(0);
        sumForm.setVisitsHomeAll(0);
        sumForm.setVisitsHomeVillagers(0);
        return sumForm;
    }

    public ModelAndView modelForPageForm39(List<Form39> listForm39, Date dateStart, Date dateEnd, String url) {
        ModelAndView mod = new ModelAndView();
        mod.addObject("sumForms39", sumForms39Entity(listForm39));
        mod.addObject("form39List", listForm39);
        mod.addObject("dateStart", dateStart);
        mod.addObject("dateEnd", dateEnd);
        mod.setViewName(url);
        return mod;
    }
}

