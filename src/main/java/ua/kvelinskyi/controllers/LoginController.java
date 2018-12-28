package ua.kvelinskyi.controllers;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.kvelinskyi.entity.InformationDoctor;
import ua.kvelinskyi.entity.User;
import ua.kvelinskyi.service.impl.InformationDoctorServiceImpl;
import ua.kvelinskyi.service.impl.UserServiceImpl;

import java.security.Principal;
import java.util.List;

@RestController
public class LoginController {

    private Logger log;

    @Autowired
    public void setLog(Logger log) {
        this.log = log;
    }

    @Autowired
    private FormValidator formValidator;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private InformationDoctorServiceImpl informationDoctorServiceImpl;
    private List<InformationDoctor> informationDoctorList;

    @RequestMapping(value = "/")
    public ModelAndView getIndexSlash() {
        ModelAndView modelAndView = new ModelAndView();
        log.info("class LoginController -IndexController(/) has started !");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/index")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView();
        log.info("class LoginController - IndexController(/index) has started !");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/loginPage")
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginPage");
        log.info("class LoginController - IndexController /loginPage has started !");
        return modelAndView;
    }

    // Login form with error
    @RequestMapping("/login-error")
    public ModelAndView getLoginError() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("loginError", true);
        modelAndView.setViewName("loginPage");
        return modelAndView;
    }

    @RequestMapping(value = "/infoPage", method = RequestMethod.GET)
    public ModelAndView getInfoPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("info");
        log.info("class LoginController - IndexController /info has started !");
        return modelAndView;
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public ModelAndView getSchedulePage() {
        ModelAndView modelAndView = new ModelAndView();
        log.info("class LoginController - /schedule has started !");
        modelAndView.setViewName("schedule");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/signUp", method = RequestMethod.GET)
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/registration");
        this.informationDoctorList = informationDoctorServiceImpl.getAll();
        informationDoctorList.remove(0);
        modelAndView.addObject("msg", "Введіть коректно дані");
        modelAndView.addObject("informationDoctorList", informationDoctorList);
        log.info("class LoginController - signUp has started !");
        return modelAndView;
    }

    //TODO change registration
    @RequestMapping(value = "/admin/registration", method = RequestMethod.POST)
    public ModelAndView doRegistrationUser(@RequestParam("login") String login,
                                           @RequestParam("password") String password,
                                           @RequestParam("id") Integer informationDoctorID) {
        log.info("public class LoginController -- registration");
        ModelAndView mod = new ModelAndView();
        if (userServiceImpl.getByLogin(login) != null) {
            log.info("class LoginController - registration Login isExist");
            mod.addObject("msg", "Такий користовач існуе");
            mod.addObject("informationDoctorList", informationDoctorList);
            mod.setViewName("admin/registration");
        } else {
            User user = new User();
            user.setLogin(login);
            String encryptedPassword = new BCryptPasswordEncoder().encode(password);
            user.setPassword(encryptedPassword);
            user.setEnabled("true");
            user.setRole(2);
            user.setUserName("enter your name");
            try {
                InformationDoctor informationDoctor = informationDoctorServiceImpl.getById(informationDoctorID);
                log.info("class LoginController - information Doctor Id : " + informationDoctor.getId());
                user.setInformationDoctor(informationDoctor);
                user = userServiceImpl.addUser(user);
                log.info("class LoginController - registration new user" + user.getUserName());
                if (user != null) {
                    mod.setViewName("index");
                } else {
                    mod.addObject("msg", "Реєстрація невдалась спробуйте ще");
                    mod.addObject("informationDoctorList", informationDoctorList);
                    mod.setViewName("admin/registration");
                }
            }catch (NullPointerException e){
                log.info("class LoginController - information Doctor Id page : " + informationDoctorID + ". Exception : NullPointerException");
                mod.addObject("msg", "Виберіть посаду лікаря");
                mod.addObject("informationDoctorList", informationDoctorList);
                mod.setViewName("admin/registration");
            }

        }
        return mod;
    }

    // TODO do'n use initValidator
    @InitBinder
    protected void initValidator(WebDataBinder binder) {
        // bind validator to controller
        binder.setValidator(this.formValidator);
    }

    @RequestMapping(value = "/user/mainUserPage", method = RequestMethod.POST)
    public ModelAndView doEditUser() {
        ModelAndView mod = new ModelAndView();
        return mod;
    }

    // for 403 access denied page
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied(Principal user) {
        ModelAndView model = new ModelAndView();
        if (user != null) {
            model.addObject("msg", "Hi " + user.getName()
                    + ", you do not have permission to access this page!");
        } else {
            model.addObject("msg",
                    "You do not have permission to access this page!");
        }

        model.setViewName("accessDenied");
        return model;

    }

    //TODO link 111
    @RequestMapping(value = "/111")
    public ModelAndView get111() {
        ModelAndView modelAndView = new ModelAndView();
        log.info("class LoginServlet -IndexController(/) has started !");
        modelAndView.setViewName("11111");
        return modelAndView;
    }

    /*@RequestMapping(value = "editUserDataPage", method = RequestMethod.POST)
    public ModelAndView doUserEditDataPage(
            @Validated
                    User user) {
        user = @ModelAttribute("user");
        ModelAndView mod = new ModelAndView();
        mod.addObject("user", user);
        mod.setViewName("/user/userEditDataPage");
        return mod;
    }*/
}
