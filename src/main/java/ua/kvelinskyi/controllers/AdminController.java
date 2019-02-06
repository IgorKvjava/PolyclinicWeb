package ua.kvelinskyi.controllers;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.kvelinskyi.entity.*;
import ua.kvelinskyi.service.impl.Form39ServiceImpl;
import ua.kvelinskyi.service.impl.InformationDoctorServiceImpl;
import ua.kvelinskyi.service.impl.NameOfThePostServiceImpl;
import ua.kvelinskyi.service.impl.UserServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {

    private Logger log;

    //TODO Autowired Logger
    @Autowired
    public void setLog(Logger log) {
        this.log = log;
    }
    private File exportedFile;
    @Autowired
    private Form39ServiceImpl form39ServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private InformationDoctorServiceImpl informationDoctorServiceImpl;
    @Autowired
    private ControllerHelper controllerHelper;
    @Autowired
    private NameOfThePostServiceImpl nameOfThePostServiceImpl;
    private List<InformationDoctor> informationDoctorList;
    private List<NameOfThePost> nameOfThePostList;


    private Integer dayOfDate(java.sql.Date date) {
        String datePars = date.toString();
        String[] stringList = datePars.split("-");
        return Integer.parseInt(stringList[2]);
    }

    @RequestMapping("/admin/user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        log.info("class AdminController - edit user id= " + id);
        User user = userServiceImpl.getUserById(id);
        // String pass = user.getPassword();
        // byte[] decodedBytes = Base64.getDecoder().decode(pass);
        //  pass = new String(decodedBytes);
        // pass = new String(Base64.decodeBase64(pass.getBytes()));
        //user.setPassword(pass);
        //import java.util.Base64;
        model.addAttribute("user", user);
        return "/admin/userEditDataPage";
    }

    @RequestMapping(value = "/admin/userUpdateData")
    public ModelAndView doUserEditData(@RequestParam("userName") String userName,
                                       @Validated
                                               User user) {
        ModelAndView mod = new ModelAndView();
        log.info("class AdminController - doUserEditData,  user id = ");
        User userNew = userServiceImpl.getUserById(user.getId());
        userNew.setUserName(userName);
        log.info("class AdminController old name - " + user);
        userNew = userServiceImpl.editUser(userNew);
        log.info("class AdminController new name -  " + userNew.getUserName());
        mod.addObject("user", userNew);
        mod.setViewName("/admin/userEditDataPage");
        return mod;
    }

    @RequestMapping(value = "/admin/usersEditData")
    public ModelAndView doEditUserData() {
        ModelAndView mod = new ModelAndView();
        log.info("class AdminController - RequestMapping usersEditData");
        List<User> listAllUsers = userServiceImpl.getAll();
        mod.addObject("listAllUsers", listAllUsers);
        mod.setViewName("/admin/usersEditData");
        return mod;
    }

    @RequestMapping("/admin/user/onOff/{id}")
    public String doOnOffUser(@PathVariable Integer id, Model model) {
        User user = userServiceImpl.getUserById(id);

        if (user.getEnabled().equals("true")) {
            if (user.getRole() != 11) {
                user.setEnabled("false");
                log.info("class AdminController - disable user id= " + id);
            }
        } else {
            user.setEnabled("true");
            log.info("class AdminController - enable user id= " + id);
        }
        userServiceImpl.editUser(user);
        model.addAttribute("listAllUsers", userServiceImpl.getAll());
        return "/admin/usersEditData";
    }

    @RequestMapping("/admin/informationDoctor")
    public ModelAndView doSpecialtyOfDoctor() {
        log.info("class AdminController - edit Specialty Of Doctor");
        /*ModelAndView mod = new ModelAndView();
        List<InformationDoctor> informationDoctorList = informationDoctorServiceImpl.getAll();
        InformationDoctor informationDoctor = new InformationDoctor();
        mod.addObject("informationDoctor", informationDoctor);
        mod.addObject("informationDoctorList", informationDoctorList);
        mod.setViewName("/admin/informationDoctor");*/
        return formInformationDoctor("/admin/informationDoctor");
    }

    @RequestMapping("/admin/informationDoctor/add")
    public ModelAndView doAddSpecialtyOfDoctor(InformationDoctor newInformationDoctor) {
        log.info("class AdminController - add Specialty Of Doctor");
//        ModelAndView mod = new ModelAndView();
        informationDoctorServiceImpl.addInformationDoctor(newInformationDoctor);
        /*List<InformationDoctor> informationDoctorList = informationDoctorServiceImpl.getAll();
        InformationDoctor informationDoctor = new InformationDoctor();
        mod.addObject("informationDoctor", informationDoctor);
        mod.addObject("informationDoctorList", informationDoctorList);
        mod.setViewName("/admin/informationDoctor");*/
        return formInformationDoctor("/admin/informationDoctor");
    }

    private ModelAndView formInformationDoctor(String url) {
        ModelAndView mod = new ModelAndView();
        List<InformationDoctor> informationDoctorList = informationDoctorServiceImpl.getAll();
        InformationDoctor informationDoctor = new InformationDoctor();
        mod.addObject("informationDoctor", informationDoctor);
        mod.addObject("informationDoctorList", informationDoctorList);
        mod.setViewName(url);
        return mod;
    }

    @RequestMapping("/admin/form39Admin")
    public ModelAndView doForm39() {
        log.info("class AdminController - page form-39 ");
        /*Date curTime = new Date();
        java.sql.Date currentDate = new java.sql.Date(curTime.getTime());
        ModelAndView mod = new ModelAndView();
        mod.addObject("dateStart", currentDate);
        mod.addObject("dateEnd", currentDate);
        mod.setViewName("/admin/form39Admin");*/
        return formDateStartEnd("/admin/form39Admin");
    }

    @RequestMapping("/admin/form2100Admin")
    public ModelAndView doForm2100() {
        log.info("class AdminController - page form-2100 ");
        return formDateStartEnd("/admin/form2100Admin");
    }

    @RequestMapping("/admin/form21001Admin")
    public ModelAndView doForm21001() {
        log.info("class AdminController - page form-2100/1 ");
        return formDateStartEnd("/admin/form21001Admin");
    }

    private ModelAndView formDateStartEnd(String url) {
        Date curTime = new Date();
        java.sql.Date currentDate = new java.sql.Date(curTime.getTime());
        ModelAndView mod = new ModelAndView();
        mod.addObject("dateStart", currentDate);
        mod.addObject("dateEnd", currentDate);
        mod.setViewName(url);
        return mod;
    }

    @RequestMapping("/admin/form39Data/timeInterval")
    public ModelAndView doViewForm39DataOfAllDoctor(@RequestParam("dateStart") java.sql.Date dateStart,
                                                    @RequestParam("dateEnd") java.sql.Date dateEnd) {
        log.info("class AdminController - View Form39 Data Of All Doctor");
        List<Form39> listForm39 = form39ServiceImpl.dataForm39ByTimeInterval(dateStart, dateEnd);
        return controllerHelper.modelForPageForm39(listForm39, dateStart, dateEnd, "/admin/form39Admin");
    }

    //Использовать для добавления списка врачей для формы 2100/1 , кнопка на странице form39Admin.html
    /*
    @RequestMapping("/admin/form39Data/add")
    public ModelAndView doAddListDocsForForm21001() {
        log.info("class AdminController - View add");
        List<String> fileLines = null;
        try {
            //C:\Users\igorjava\IdeaProjects
            fileLines = Files.readAllLines(Paths.get("C:\\Users\\igorjava\\IdeaProjects\\list_docs.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text1 = null;
        for (String text: fileLines) {
            text1+=text;
        }
        String[] fileLines1 = text1.split("=");
        int num = 2;
        for (String value :fileLines1
             ) {
            NameOfThePost nameOfThePost = new NameOfThePost();
            nameOfThePost.setRowNumber(num);
            nameOfThePost.setPosition(value);
            nameOfThePostServiceImpl.addNameOfThePost(nameOfThePost);
            log.info("class AdminController file " + nameOfThePost);
            num++;
        }
        log.info("class AdminController file " + text1);
        return formDateStartEnd("/admin/form39Admin");
    }
*/
    @RequestMapping("/admin/form2100Data/timeInterval")
    public ModelAndView doViewForm2100DataOfAllDoctor(@RequestParam("dateStart") java.sql.Date dateStart,
                                                      @RequestParam("dateEnd") java.sql.Date dateEnd) {
        log.info("class AdminController - View Form2100 Data Of All Doctor");
        ModelAndView mod = new ModelAndView();
        List<Form39> listForm2100 = form39ServiceImpl.dataForm39ByTimeInterval(dateStart, dateEnd);
        log.info("class AdminController size listForm2100 = " + listForm2100.size());
        mod.addObject("sumForms2100", controllerHelper.sumForms2100Entity(listForm2100));
        mod.addObject("dateStart", dateStart);
        mod.addObject("dateEnd", dateEnd);
        mod.setViewName("/admin/form2100Admin");
        return mod;
    }

    @RequestMapping("/admin/form21001Data/timeInterval")
    public ModelAndView doViewForm21001DataOfAllDoctor(@RequestParam("dateStart") java.sql.Date dateStart,
                                                       @RequestParam("dateEnd") java.sql.Date dateEnd) {
        log.info("class AdminController - View Form2100/1 Data Of All Doctor");
        ModelAndView mod = new ModelAndView();
        List<Form39> listForm21001 = form39ServiceImpl.dataForm39ByTimeInterval(dateStart, dateEnd);
        log.info("class AdminController listForm21001.size = " + listForm21001.size());
        List<Form21001> sumForm39ForTable21001 = new ArrayList<>();
        List<NameOfThePost> nameOfThePostList = nameOfThePostServiceImpl.getAll();
        log.info("class AdminController nameOfThePostList.size()= " + nameOfThePostList.size());
        for (NameOfThePost value : nameOfThePostList){
            NameOfThePost elementForRowNumber = nameOfThePostServiceImpl.getElementForRowNumber(value.getRowNumber());
            //TODO elementForRowNumber.getUserList() infinity recursion
            log.info("class AdminController listUsers size = " + elementForRowNumber.getUserList().size());
            //sum for users by row number
            List<Form39> sumForm39ForRowNumber = new ArrayList<>();
            for (User user: elementForRowNumber.getUserList()
                 ) {
                List<Form39> listForm39 = form39ServiceImpl.dataForm39ByTimeIntervalAndIdDoc(dateStart, dateEnd, user.getId());
                log.info("class AdminController listForm39.size() = " + listForm39.size());
                sumForm39ForRowNumber.add(controllerHelper.sumForms2100Entity(listForm39));
                log.info("class AdminController sumForm39ForRowNumber.size() = " + sumForm39ForRowNumber.size());
            }
            Form21001 form21001 = new Form21001();
            form21001.setRowNumber(value.getRowNumber());
            form21001.setPosition(value.getPosition());
            form21001.setForm39(controllerHelper.sumForms2100Entity(sumForm39ForRowNumber));
            sumForm39ForTable21001.add(form21001);
            log.info("class AdminController form21001 " + form21001.getRowNumber() + "==== " + form21001.getPosition());
        }
        mod.addObject("sumForm39ForTable21001", sumForm39ForTable21001);
        mod.addObject("sumForms21001", controllerHelper.sumForms2100Entity(listForm21001));
        mod.addObject("dateStart", dateStart);
        mod.addObject("dateEnd", dateEnd);
        mod.setViewName("/admin/form21001Admin");
        return mod;
    }

    @RequestMapping(value = "/admin/signUp", method = RequestMethod.GET)
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/registration");
        this.informationDoctorList = informationDoctorServiceImpl.getAll();
        //remove user (admin)
        informationDoctorList.remove(0);
        this.nameOfThePostList = nameOfThePostServiceImpl.getAll();
        modelAndView.addObject("msg", "Введіть коректно дані");
        modelAndView.addObject("informationDoctorList", informationDoctorList);
        modelAndView.addObject("nameOfThePostList", nameOfThePostList);
        log.info("class LoginController - signUp has started !");
        return modelAndView;
    }

    //TODO change registration
    @RequestMapping(value = "/admin/registration", method = RequestMethod.POST)
    public ModelAndView doRegistrationUser(@RequestParam("login") String login,
                                           @RequestParam("password") String password,
                                           @RequestParam("id") Integer informationDoctorID,
                                           @RequestParam("idPost") Integer nameOfThePostID) {
        log.info("public class AdminController -- registration");
        ModelAndView mod = new ModelAndView();
        if (userServiceImpl.getByLogin(login) != null) {
            log.info("class AdminController - registration Login isExist");
            mod.addObject("msg", "Такий користовач існуе");
            mod.addObject("informationDoctorList", informationDoctorList);
            mod.setViewName("admin/registration");
        } else {
            log.info("class AdminController - create new user");
            User user = new User();
            user.setLogin(login);
            String encryptedPassword = new BCryptPasswordEncoder().encode(password);
            user.setPassword(encryptedPassword);
            user.setEnabled("true");
            user.setRole(2);
            user.setUserName("Ввести імя лікаря");
            try {
                InformationDoctor informationDoctor = informationDoctorServiceImpl.getById(informationDoctorID);
                NameOfThePost nameOfThePost = nameOfThePostServiceImpl.getById(nameOfThePostID);
                log.info("class AdminController - information Doctor Id : " + informationDoctor.getId());
                log.info("class AdminController - information Name Of The Post Id : " + nameOfThePost.getId());
                user.setInformationDoctor(informationDoctor);
                user.setNameOfThePost(nameOfThePost);
                user = userServiceImpl.addUser(user);
                log.info("class AdminController - registration new user login - " + user.getLogin());
                if (user != null) {
                    mod.setViewName("index");
                } else {
                    mod.addObject("msg", "Реєстрація невдалась спробуйте ще");
                    mod.addObject("informationDoctorList", informationDoctorList);
                    mod.setViewName("admin/registration");
                }
            }catch (NullPointerException e){
                log.info("class AdminController - information Doctor Id page : " + informationDoctorID + ". Exception : NullPointerException");
                mod.addObject("msg", "Виберіть посаду лікаря");
                mod.addObject("informationDoctorList", informationDoctorList);
                mod.setViewName("admin/registration");
            }
        }
        return mod;
    }


}
