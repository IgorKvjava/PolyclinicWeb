package ua.kvelinskyi.service;

import ua.kvelinskyi.entity.NameOfThePost;
import ua.kvelinskyi.entity.User;

import java.util.List;

public interface NameOfThePostService {

    NameOfThePost addNameOfThePost(NameOfThePost nameOfThePost);

    List<NameOfThePost> getAll();

    NameOfThePost getById(Integer nameOfThePostID);

    NameOfThePost getElementForRowNumber(int num);
}
