package core.mvc;

import com.google.common.collect.ImmutableMap;
import next.controller.*;

import java.util.Map;

/**
 * Created by heojooyoung on 2017. 5. 24..
 */
public class RequestMapping {
    public static Map<String, Controller> controllerMap = ImmutableMap.<String, Controller>builder()
            .put("/", new HomeController())
            .put("/users", new ListUserController())
            .put("/users/loginForm", new ForwardController("/user/login.jsp"))
            .put("/users/form", new ForwardController("/user/form.jsp"))
            .put("/users/login", new LoginController())
            .put("/users/profile", new ProfileController())
            .put("/users/logout", new LogoutController())
            .put("/users/create", new CreateUserController())
            .put("/users/updateForm", new UpdateFormUserController())
            .put("/users/update", new UpdateUserController())
            .build();

    public Controller find(String url) {
        return controllerMap.get(url);
    }
}
