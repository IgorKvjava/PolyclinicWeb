package ua.kvelinskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kvelinskyi.entity.NameOfThePost;
import ua.kvelinskyi.entity.User;

import java.util.List;

public interface NameOfThePostRepository extends JpaRepository<NameOfThePost,Integer > {
    List<User> findAllByRowNumber(int num);
}
