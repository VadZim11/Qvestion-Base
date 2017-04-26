import com.springProject.config.AppContext;
import com.springProject.config.application.WebConfig;
import com.springProject.model.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppContext.class, WebConfig.class, })
public class BeansTests {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    Message message;

    @Test
    public void contentProviderTest() {
        Message helloProviderBean = applicationContext.getBean(Message.class);
        Assert.assertNotNull(helloProviderBean);
        helloProviderBean = (Message) applicationContext.getBean("helloWorldProvider");
        Assert.assertNotNull(helloProviderBean);
        Assert.assertEquals(helloProviderBean.getHello(), "Hello");
    }
}
