package controller.command;

import model.entity.Worker;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Login implements Command{
    private Map<String, String> pages = new HashMap<>();
    private UserService userService;

    public Login(UserService userService) {
        this.userService = userService;

        pages.put("login", "/login.jsp");
        pages.put("CASHIER", "redirect:cashier");
        pages.put("HIGHCASHIER", "redirect:highcashier");
        pages.put("PRODUCTMAKER", "redirect:productmaker");
        pages.put("ADMIN", "redirect:admin");
    }

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (login == null || login.equals("") || pass == null || pass.equals("")) {
            System.out.println("empty data");
            return "/login.jsp";
        }
        System.out.print("show login: ");
        System.out.println(login + " " + pass);

        Optional<Worker> worker = userService.login(login);
        System.out.println("worker: " + worker);

        if(worker.isPresent() && pass.equals(worker.get().getPassword())){
            System.out.println("worker is present!");
            if (CommandUtility.checkUserIsLogged(request, worker.get().getLogin(), worker.get().getRole(), worker.get().getId())) {
                //todo my Exception
                //throw new RuntimeException();
                System.out.println("worker alredy logged!");
                return "/WEB-INF/error.jsp";
            }
            System.out.println("worker no logged!");
            return pages.getOrDefault(worker.get().getRole().toString().toUpperCase(), pages.get("login"));
        }
        System.out.println("worker no present!");
        return "/login.jsp";
    }
}
