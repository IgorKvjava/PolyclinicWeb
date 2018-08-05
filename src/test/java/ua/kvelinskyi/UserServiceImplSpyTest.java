package ua.kvelinskyi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;
import ua.kvelinskyi.entity.User;
import ua.kvelinskyi.repository.UserRepository;
import ua.kvelinskyi.service.impl.UserServiceImpl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
public class UserServiceImplSpyTest {
    @Spy
    private UserServiceImpl userServiceSpy;
    @Mock
    private UserRepository userRepository;
    @Mock
    private User user;

    @Test(expected=NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetUserByIdIsCalledWithoutContext() throws Exception{
        //Act
        User retrievedUser = userServiceSpy.getUserById(15);
        //Assert
        assertThat(retrievedUser, is(equalTo(user)));

    }
}
