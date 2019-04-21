package controller.command.highCashier;

import controller.command.Command;
import model.service.highCashierService.HighCashierService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class MakeXReport implements Command {
    private HighCashierService highCashierService;

    public MakeXReport(HighCashierService highCashierService) {
        this.highCashierService = highCashierService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Map<String, Integer> zWorkers = highCashierService.makeXreport();

        request.getSession().setAttribute("zWorkers", zWorkers);

        return "/WEB-INF/highCashier/X-Report.jsp";
    }
}
