package ua.kvelinskyi.controllers;

import org.springframework.stereotype.Service;
import ua.kvelinskyi.entity.Form39;

import java.util.List;

@Service
public class ControllerHelper {

    private Form39 sumForms39 = new Form39();

    public ControllerHelper() {
    }

    public Form39 sumForms39Entity (List<Form39> listForm39){
        /*Form39 sumForms39 = new Form39();*/
        sumForms39.setNumberVisitsAll(0);
        sumForms39.setAdultsVisitsDisease(0);
        sumForms39.setAdultsVisitsDiseaseVillagers(0);
        sumForms39.setChildrenPatronage(0);
        sumForms39.setChildrenPatronageVillagers(0);
        sumForms39.setChildrenVisitsAll(0);
        sumForms39.setChildrenVisitsDisease(0);
        sumForms39.setChildrenVisitsDiseaseVillagers(0);
        sumForms39.setChildrenVisitsHomeAll(0);
        sumForms39.setChildrenVisitsHomeVillagers(0);
        sumForms39.setChildrenVisitsVillagers(0);
        sumForms39.setOfVillagers(0);
        sumForms39.setVisitsHomeAll(0);
        sumForms39.setVisitsHomeVillagers(0);
        for(Form39 form39 : listForm39){
            sumForms39.setNumberVisitsAll(sumForms39.getNumberVisitsAll()+form39.getNumberVisitsAll());
            sumForms39.setAdultsVisitsDisease(sumForms39.getAdultsVisitsDisease()+form39.getAdultsVisitsDisease());
            sumForms39.setAdultsVisitsDiseaseVillagers(sumForms39.getAdultsVisitsDiseaseVillagers()+form39.getAdultsVisitsDiseaseVillagers());
            sumForms39.setChildrenPatronage(sumForms39.getChildrenPatronage()+form39.getChildrenPatronage());
            sumForms39.setChildrenPatronageVillagers(sumForms39.getChildrenPatronageVillagers()+form39.getChildrenPatronageVillagers());
            sumForms39.setChildrenVisitsAll(sumForms39.getChildrenVisitsAll()+form39.getChildrenVisitsAll());
            sumForms39.setChildrenVisitsDisease(sumForms39.getChildrenVisitsDisease()+form39.getChildrenVisitsDisease());
            sumForms39.setChildrenVisitsDiseaseVillagers(sumForms39.getChildrenVisitsDiseaseVillagers()+form39.getChildrenVisitsDiseaseVillagers());
            sumForms39.setChildrenVisitsHomeAll(sumForms39.getChildrenVisitsHomeAll()+form39.getChildrenVisitsHomeAll());
            sumForms39.setChildrenVisitsHomeVillagers(sumForms39.getChildrenVisitsHomeVillagers()+form39.getChildrenVisitsHomeVillagers());
            sumForms39.setChildrenVisitsVillagers(sumForms39.getChildrenVisitsVillagers()+form39.getChildrenVisitsVillagers());
            sumForms39.setOfVillagers(sumForms39.getOfVillagers()+form39.getOfVillagers());
            sumForms39.setVisitsHomeAll(sumForms39.getVisitsHomeAll()+form39.getVisitsHomeAll());
            sumForms39.setVisitsHomeVillagers(sumForms39.getVisitsHomeVillagers()+form39.getVisitsHomeVillagers());
        }
        return sumForms39;
    }
}

