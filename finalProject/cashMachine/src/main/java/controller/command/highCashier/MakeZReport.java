package controller.command.highCashier;

import controller.command.Command;
import model.service.highCashierService.HighCashierService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MakeZReport implements Command {
    private HighCashierService highCashierService;
    Map<Integer, Integer> zProducts;

    public MakeZReport(HighCashierService highCashierService) {
        this.highCashierService = highCashierService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        zProducts = highCashierService.makeZReport();
        Map<String, Integer> nameProducts = new HashMap<>();

        zProducts.forEach((k,v)-> nameProducts.put(highCashierService.getProduct(k).getName(), v));

        System.out.println("nameProducts" + nameProducts);
        Map<String, Integer> totalPriceForProduct= new HashMap<>();

        zProducts.forEach((k,v)->totalPriceForProduct
                .put(highCashierService.getProduct(k).getName(), highCashierService.getProduct(k).getPrice()*v));


        System.out.println("totalPriceForProduct"+ totalPriceForProduct);

        int totalSum= new ArrayList<Integer>(totalPriceForProduct.values()).stream().mapToInt(Integer::intValue).sum();

        System.out.println("totalSum" + totalSum);
        request.getSession().setAttribute("nameProducts", nameProducts);
        request.getSession().setAttribute("totalPriceForProduct", totalPriceForProduct);
        request.getSession().setAttribute("totalSum", totalSum);
        return "/WEB-INF/highCashier/Z-Report.jsp";
    }
}
