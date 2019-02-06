package ua.kvelinskyi.service;

import ua.kvelinskyi.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);
    void delete(Integer id);
    User getByLoginAndName(String login, String password);
    User  getByLogin(String login);
    User  editUser(User user);
    List<User > getAll();
    User getUserById(Integer id);
    Integer getUserIdByLogin(String login);
    //List<Form39> getListForm39User(Integer idUser);
}
