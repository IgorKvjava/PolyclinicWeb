package ua.kvelinskyi.service.impl;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kvelinskyi.entity.NameOfThePost;
import ua.kvelinskyi.entity.User;
import ua.kvelinskyi.repository.NameOfThePostRepository;
import ua.kvelinskyi.service.NameOfThePostService;

import java.util.List;

@Service
public class NameOfThePostServiceImpl implements NameOfThePostService{
    private Logger log;
    @Autowired
    public void setLog(Logger log) {
        this.log = log;
    }
    @Autowired
    NameOfThePostRepository nameOfThePostRepository;

    @Override
    public NameOfThePost addNameOfThePost(NameOfThePost nameOfThePost) {
        return nameOfThePostRepository.save(nameOfThePost);
    }

    @Override
    public List<NameOfThePost> getAll() {
        return nameOfThePostRepository.findAll();
    }

    @Override
    public NameOfThePost getById(Integer nameOfThePostID) {
        return nameOfThePostRepository.findOne(nameOfThePostID);
    }

    @Override
    public NameOfThePost getElementForRowNumber(int num) {
        return nameOfThePostRepository.findByRowNumber(num);
    }
}
