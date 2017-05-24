package core.mvc;

import com.google.common.collect.ImmutableMap;
import next.controller.HomeController;
import next.controller.ListUserController;

import java.util.Map;

/**
 * Created by heojooyoung on 2017. 5. 24..
 */
public class RequestMapping {
    public static Map<String, Controller> controllerMap = ImmutableMap.<String, Controller>builder()
            .put("/", new HomeController())
            .put("/user/list", new ListUserController())
            .build();

    public Controller find(String url) {
        return controllerMap.get(url);
    }
}
