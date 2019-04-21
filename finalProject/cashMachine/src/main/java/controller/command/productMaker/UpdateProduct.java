package controller.command.productMaker;

import controller.command.Command;
import model.entity.Product;
import model.entity.myException.ProductNotExistException;
import model.service.productMakerService.ProductMakerService;

import javax.servlet.http.HttpServletRequest;

public class UpdateProduct implements Command {
    ProductMakerService productMakerService;

    public UpdateProduct(ProductMakerService productMakerService) {
        this.productMakerService = productMakerService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("UPDATING PRODUCT!!!!!!!!!!!");
        String idProduct = request.getParameter("idProduct");
        String attribute_value = request.getParameter("attribute_value");
        String price = request.getParameter("price");

        System.out.println(idProduct + " " + attribute_value + " " + price+ " PRICEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");

        if(idProduct==null || attribute_value == null || price == null){
            return "/WEB-INF/productMaker/updateProduct.jsp";
        }
        Product product;

        try{
            product = productMakerService.getProduct(Integer.valueOf(idProduct));
        }catch (ProductNotExistException ex){
            System.out.println("Sorry, product mot exist!");
            return "/WEB-INF/exceptionPages/productNotExist.jsp";
        }

        System.out.println("Product is: " + product);

        product.setAttribute_value(Integer.valueOf(attribute_value));

        if(request.getServletContext().getAttribute("language").equals("en")) {
            int temp = (int) request.getServletContext().getAttribute("course");
            product.setPrice((int) (Double.valueOf(price)*temp));
        }else {
            product.setPrice(Integer.valueOf(price));
        }
        productMakerService.updateProduct(product);

        request.getServletContext().setAttribute("products", productMakerService.getAllProducts());

        return "/WEB-INF/productMaker/updateProduct.jsp";
    }
}
