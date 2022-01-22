package park.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import park.core.config.AppConfig;

/**
 * Created by park on 2022/01/22.
 */
public class ApplicationContextInfoTest {

   AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

   @Test
   @DisplayName("모든 빈 출력하기")
   public void findAllBean() throws Exception {
     String[] beanDefinitionNames = ac.getBeanDefinitionNames();
     for (String beanDefinitionName : beanDefinitionNames) {
       Object bean = ac.getBean(beanDefinitionName);
       System.out.println("name: " + beanDefinitionName + ", Object: " +bean);
     }
   }


  @Test
  @DisplayName("애플리케이션 빈 출력하기")
  public void findApplicationBean() throws Exception {
    String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);


      //BeanDefinition.ROLE_APPLICATION -> 직접 등록한  애플리케이션 빈
      //BeanDefinition.ROLE_INFRASTRUCTURE -> 스프링이 내부에서 사용하는 빈
      if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
        Object bean = ac.getBean(beanDefinitionName);
        System.out.println("name: " + beanDefinitionName + ", Object: " +bean);
      }
    }
  }

}
