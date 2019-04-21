package controller;

import controller.command.Command;
import model.entity.enums.Role;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
//    private Map<String, Command> commands = new HashMap<>();


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        servletConfig.getServletContext().setAttribute("loggedUsers", new HashSet<String>());


//        commands.put("registration", new Registration(new UserService()));
//        commands.put("login", new Login(new UserService()));
//
//        commands.put("cashier", new CashierCommand());
//        commands.put("highcashier", new HighCashierCommand());
//        commands.put("productmaker",new ProductMakerCommand());
//        commands.put("logout", new LogOut());
//        commands.put("home", new Home());
//        commands.put("exception", new Exception());

        servletConfig.getServletContext().setAttribute("role", Role.UNKNOWN);

        System.out.println("first step");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("IN GET!!!!!!!!!!");
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("IN POST!!!!!!!!!!");
        processRequest(req, resp);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("IN PROCESSREQUEST!!!!!!!!!!!!!!!!!");
        Map<String, Command> commands = (Map<String, Command>) request.getSession().getAttribute("commands");

        String path = request.getRequestURI();
        path = path.replaceAll(".*/app/", "");
        System.out.println("path: " + path);
        System.out.println("commands: " + commands);

        Command command =commands.getOrDefault(path, (r)->"/login.jsp");

        System.out.println(request.getSession().getAttribute("role"));
        System.out.println(command.getClass().getName());

        System.out.println("path: " + path);

        String page = command.execute(request);

        if (page.contains("redirect")) {
            System.out.println("IN REDIRECT!!!!");
            response.sendRedirect(page.replace("redirect:", ""));
            System.out.println(page);
        } else {
            System.out.println("IN FORWARD!!!!!");
            System.out.println(request.getRequestURI());
            request.getRequestDispatcher(page).forward(request, response);
        }

        System.out.println(request.getSession().getServletContext().getAttribute("loggedUsers"));
        System.out.println(request.getSession().getAttribute("role"));
    }
}
