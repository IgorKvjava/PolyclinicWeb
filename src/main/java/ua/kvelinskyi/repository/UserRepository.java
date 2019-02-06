package ua.kvelinskyi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.kvelinskyi.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLoginAndPassword(String login, String password);

    User findByLogin(String login);

    @Query(value = "select b.id from User b where b.login=:login")
    List<Integer> getIdUserByLogin(@Param("login") String login);

}
