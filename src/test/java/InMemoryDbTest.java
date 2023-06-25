import edu.greenjack.config.PersistenceConfig;
import edu.greenjack.dao.UsersDao;
import edu.greenjack.model.User;
import jakarta.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class InMemoryDbTest {

    @Autowired
    UsersDao usersDao;

    @Test
    public void saveUser() {
        User user1 = new User("testUser", 1001);
        usersDao.saveUser(user1);

        User user2 = usersDao.findById(1);
        Assert.assertEquals(user1, user2);
    }
}
