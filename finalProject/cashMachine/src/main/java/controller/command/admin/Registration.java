package controller.command.admin;

import controller.command.Command;
import model.entity.Worker;
import model.entity.enums.Role;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Registration implements Command {
    private UserService userService;

    public Registration(UserService userService) {
        this.userService = userService;
    }
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        if(name==null || role == null || login == null){
            return "/WEB-INF/admin/registration.jsp";
        }

        Worker worker = new Worker();
        worker.setName(name);
        worker.setRole(Role.valueOf(role));
        worker.setPassword(password);
        worker.setLogin(login);
        worker.setId(worker.hashCode());

        try {
            if (!userService.validateData(worker)) {
                System.out.println("Non-valid input!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                return "/WEB-INF/admin/registration.jsp";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        userService.addCashierToDB(worker);

        UserService userService = new UserService();
        request.getServletContext().setAttribute("workers", userService.getAllWorkers());

        return "/WEB-INF/admin/registration.jsp";
    }
}
