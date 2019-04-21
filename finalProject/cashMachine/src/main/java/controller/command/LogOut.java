package controller.command;

import model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LogOut implements Command{
    @Override
    public String execute(HttpServletRequest request) {
        Optional<Object> login = Optional.ofNullable(request.getSession().getAttribute("login"));
        System.out.println("login: " + login);

        login.ifPresent(e -> CommandUtility.unlogUser(request, e.toString()));

        return "redirect:login";
    }
}
