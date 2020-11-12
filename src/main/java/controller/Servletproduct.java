package controller;

import model.Product;
import severvice.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet-product", urlPatterns = "/product")
public class Servletproduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                addProduct(request,response);
                break;
            case "edit":
                try {
                    updateUser(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":

                break;
            default:
                showListProduct(request,response);
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                try {
                    showEditForm(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteProduct(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                showListProduct(request,response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteUser(id);
        List<Product> listProduct = productService.listProduct();
        request.setAttribute("products", listProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String price = request.getParameter("price");
        String amount = request.getParameter("amount");
        String color = request.getParameter("color");
        String des = request.getParameter("des");
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        String nameProduct = request.getParameter("nameProduct");


        Product product = new Product(id, price, amount, color,des,idCategory,nameProduct );
        productService.updateProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Product existingProduct = productService.getID(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
    }


    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String price=request.getParameter("price");
        String amount=request.getParameter("amount");
        String color=request.getParameter("color");
        String des=request.getParameter("des");
        int idCategory= Integer.parseInt(request.getParameter("idCategory"));
        String nameProduct=request.getParameter("nameProduct");
        productService.add(new Product(price,amount,color,des,idCategory,nameProduct));
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {

//        request.setAttribute("provinces",provinces);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    ProductService productService = new ProductService();
    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList=productService.listProduct();
        request.setAttribute("products",productList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
