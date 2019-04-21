package controller.command.highCashier;

import controller.command.Command;
import model.entity.Check;
import model.service.highCashierService.HighCashierService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAllChecks implements Command {
    private HighCashierService highCashierService;

    public ShowAllChecks(HighCashierService highCashierService) {
        this.highCashierService = highCashierService;
    }

    @Override
    public String execute(HttpServletRequest request) {int page = 1;
        int recordsPerPage =1;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));

        System.out.println("page: " + page);

        List<Check> checks = highCashierService.getAllChecks();
        int noOfRecords = checks.size();
        checks = generateNeedsRecords(checks, (page-1)*recordsPerPage, (page-1)*recordsPerPage+1);

        System.out.println("checks: "+checks);

        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        System.out.println("noOfPages: " + noOfPages);

        request.setAttribute("checkList", checks);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        return "/WEB-INF/highCashier/show_all_checks.jsp";
    }
    private List<Check> generateNeedsRecords(List<Check> list, int from, int to){
        return list.subList(from, to);
    }
}
/*
<c:forEach var="check" items="${checks}">
    <div class="">
        <div class="layer ">

            <table class="table my-2">
                <thead>
                <tr>
                    <th scope="col">idCheck</th>
                    <th scope="col">idWorker</th>
                    <th scope="col">Price</th>
                </tr>
                </thead>

                <tbody>

                <tr>
                    <td>${check.idCheck}</td>
                    <td>${check.idWorker}</td>
                    <td>${check.price}</td>
                </tr>
                </tbody>
            </table>
            <table class="table my-2 align-content-center">

                <thead>
                <tr>
                    <th scope="col">idProduct</th>
                    <th scope="col">attribute_value</th>

                </tr>
                </thead>

                <tbody>
                <c:forEach var="product" items="${check.products}">
                    <tr>
                        <td>${product.key}</td>
                        <td>${product.value}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <form action="${pageContext.request.contextPath}/app/highcashier/cancelProductFromCheck" method="post">
                <button type="submit" class="btn btn-primary">Отменить товар в чеке</button>
            </form>
            <br>
            <form action="${pageContext.request.contextPath}/app/highcashier/cancelCheck" method="post">
                <button type="submit" class="btn btn-primary">Отменить чек</button>
            </form>

        </div>
    </div>
</c:forEach>

 */