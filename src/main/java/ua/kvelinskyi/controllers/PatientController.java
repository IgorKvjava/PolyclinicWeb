package ua.kvelinskyi.controllers;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.kvelinskyi.entity.User;
import ua.kvelinskyi.service.impl.UserServiceImpl;

/**
 * @author Igor Kvelinskyi (igorkvjava@gmail.com)
 *
 */
@Controller
public class PatientController {
    private Logger log;
    @Autowired
    public void setLog(Logger log) {
        this.log = log;
    }
    @Autowired
    UserServiceImpl userServiceImpl;

    @RequestMapping("/patient/medicalRecord")
    public ModelAndView doMedicalRecord(Authentication loggedUser) {
        log.info("class PatientController - page medical Record ");
        User authenticationUser = userServiceImpl.getByLogin(loggedUser.getName());

        ModelAndView mod = new ModelAndView();
        mod.addObject("user", authenticationUser);
        return mod;
    }
}
