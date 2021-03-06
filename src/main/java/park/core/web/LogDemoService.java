  package park.core.web;

  import lombok.RequiredArgsConstructor;
  import org.springframework.beans.factory.ObjectProvider;
  import org.springframework.stereotype.Service;
  import park.core.common.MyLogger;

  /**
   * Created by park on 2022/02/20.
   */
  @Service
  @RequiredArgsConstructor
  public class LogDemoService {

    private final MyLogger myLogger;

    public void logic (String id) {
      myLogger.log("Service ID: " + id);
    }
  }
