package next.controller;

import core.db.DataBase;
import core.mvc.Controller;
import next.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by heojooyoung on 2017. 5. 29..
 */
public class UpdateFormUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String userId = request.getParameter("userId");
        User user = DataBase.findUserById(userId);
        if(!UserSessionUtils.isSameUser(request.getSession(), user)) {
            throw new IllegalStateException("정보를 수정할 수 없습니다");
        }
        request.setAttribute("user", user);
        return "/user/updateForm.jsp";
    }
}
