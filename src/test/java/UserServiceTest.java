import model.User;
import org.junit.Assert;
import org.junit.Test;
import service.UserService;
import service.UserServiceImpl;

public class UserServiceTest {

    private final UserService userService = new UserServiceImpl();
    private final String testName = "test Name";
    private final int testAge = 100;

    @Test
    public void saveUser() {
        userService.saveUser(new User(testName, testAge));

        User user = userService.getUserById(0);

        Assert.assertEquals("User name not right", user.getName(), testName);
    }
}
