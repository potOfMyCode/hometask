package controller.command.cashier;

import controller.command.Command;
import model.entity.Check;
import model.entity.myException.ProductNotExistException;
import model.service.cashierService.CashierService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class CloseCheck implements Command {
    private CashierService cashierService;

    public CloseCheck(CashierService cashierService) {
        this.cashierService = cashierService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Check check = (Check) request.getSession().getAttribute("check");
        check.setidCheck(check.hashCode());
        System.out.println("New id check(hashCode: )"+ check.getidCheck());

        cashierService.createCheck(check);
        Map<Integer, Integer> products = check.getProducts();

        try {
            products.forEach((k, v) -> cashierService.addProductInCheck(check, cashierService.getProduct(k, 0)));
        }catch (ProductNotExistException ex){
            System.out.println("Sorry, product not exist");
        }

        request.getSession().setAttribute("check", null);
        return "/WEB-INF/cashier/cashierBase.jsp";
    }
}
