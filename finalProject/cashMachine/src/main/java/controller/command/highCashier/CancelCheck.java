package controller.command.highCashier;

import controller.command.Command;
import model.service.highCashierService.HighCashierService;

import javax.servlet.http.HttpServletRequest;

public class CancelCheck implements Command {
    private HighCashierService highCashierService;

    public CancelCheck(HighCashierService highCashierService) {
        this.highCashierService = highCashierService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter("idCheck");
        System.out.println("ID: " + id + "============================================");
        highCashierService.cancelCheck(Integer.valueOf(id));

        request.getServletContext().setAttribute("checks", highCashierService.getAllChecks());
        return "/WEB-INF/highCashier/highCashierBase.jsp";
    }
}
