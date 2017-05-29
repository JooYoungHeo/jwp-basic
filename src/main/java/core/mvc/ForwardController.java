package core.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by heojooyoung on 2017. 5. 25..
 */
public class ForwardController implements Controller{
    private String forwardUrl;

    public ForwardController(String forwardUrl){
        this.forwardUrl = forwardUrl;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return forwardUrl;
    }
}
