package park.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by park on 2022/02/20.
 */
public class BeanLifeCycleTest {

  @Test
  public void lifeCycleTest() throws Exception {
    //given
    ApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
    //when
    NetworkClient client = ac.getBean(NetworkClient.class);
    client.disConnect();
    //then
  }


  @Configuration
  static class LifeCycleConfig  {
    @Bean
    public NetworkClient networkClient() {
      NetworkClient networkClient = new NetworkClient();
      networkClient.setUrl("https://hello.co.kr");
      return networkClient;
    }
  }

}
