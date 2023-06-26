import edu.greenjack.config.PersistenceConfig;
import edu.greenjack.dao.UsersDao;
import edu.greenjack.dao.UsersDaoImpl;
import edu.greenjack.model.User;
import jakarta.transaction.Transactional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Transactional
public class InMemoryDbTest {

    List<User> userList = new ArrayList<>();

    @Autowired
    UsersDao usersDao;

    @Before
    public void prepareUserList() {
        for (int i = 0; i < 5; i++) {
            userList.add(new User("testUser" + i, 100 * i));
        }
    }

    @Test
    public void saveUser() {
        userList.forEach(usersDao::saveUser);

        Assert.assertEquals(userList.get(0), usersDao.findById(1));
        Assert.assertEquals(userList.get(4), usersDao.findById(5));
    }

    @Test
    public void findAll() {
        userList.forEach(usersDao::saveUser);

        Assert.assertEquals(userList.size(), usersDao.findAll().size());
        Assert.assertEquals(userList.get(0), usersDao.findAll().get(0));
    }

    @Test
    public void findById() {
        userList.forEach(usersDao::saveUser);
        Assert.assertEquals(userList.get(0), usersDao.findById(1));
    }

    @Test
    public void updateUser() {
        userList.forEach(usersDao::saveUser);

        User user = usersDao.findById(1);
        user.setAge(5555);
        usersDao.updateUser(user);

        Assert.assertEquals(5555, usersDao.findById(1).getAge());
    }

    @Test
    public void deleteUser() {
        userList.forEach(usersDao::saveUser);

        usersDao.deleteUser(usersDao.findById(2));

        Assert.assertEquals(userList.size() - 1, usersDao.findAll().size());
        Assert.assertNull(usersDao.findById(2));
    }
}
