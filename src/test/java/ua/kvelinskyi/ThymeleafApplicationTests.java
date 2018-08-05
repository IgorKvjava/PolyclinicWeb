package ua.kvelinskyi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.kvelinskyi.controllers.AdminController;
import ua.kvelinskyi.controllers.LoginController;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ThymeleafApplicationTests {

    @Autowired
    private LoginController loginController;

    @Autowired
    AdminController adminController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(adminController).isNotNull();
    }
}
