package severvice;

import model.MyConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static final String SELECT_ALL = "select *from product";
    private String INSERT_PRODUCT = "insert into product(price,amount,color,des,idCategory,nameProduct) values (?,?,?,?,?,?)";
    private static final String DELETE_Product_SQL = "delete from product where idProduct = ?;";
    private static final String SELECT_Product_BY_ID = "select * from product where idProduct = ?";
    private static final String UPDATE_Product_SQL = "update product set price = ?,amount= ?, color =? ,des = ?,idCategory = ?, nameProduct = ? where idProduct = ?";


    MyConnection myConnection = new MyConnection();


    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated =false;
        try (Connection connection = myConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_Product_SQL);) {

            statement.setString(1, product.getPrice());
            statement.setString(2, product.getAmount());
            statement.setString(3, product.getColor());
            statement.setString(4, product.getDes());
            statement.setInt(5,product.getIdCategory());
            statement.setString(6, product.getNameProduct());
            statement.setInt(7, product.getIdProduct());
            System.out.println(product);
            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = myConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_Product_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }



    public Product getID(int id) {
        Product product = null;
        try (Connection connection = myConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Product_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String price = rs.getString("price");
                String amount = rs.getString("amount");
                String color = rs.getString("color");
                String des = rs.getString("des");
                int idCategory = rs.getInt("idCategory");
                String nameProduct = rs.getString("nameProduct");
                product = new Product(id, price, amount, color, des, idCategory, nameProduct);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    public List<Product> listProduct() {
//        CateGoryService cateGoryService=new CateGoryService();
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement ps = myConnection.getConnection().prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idProduct");
                String price = rs.getString("price");
                String amount = rs.getString("amount");
                String color = rs.getString("color");
                String des = rs.getString("des");
                int idCategory = rs.getInt("idCategory");
                String nameProduct = rs.getString("nameProduct");
                productList.add(new Product(id, price, amount, color, des, idCategory, nameProduct));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void add(Product product) {
        try {
            PreparedStatement ps = myConnection.getConnection().prepareStatement(INSERT_PRODUCT);
            ps.setString(1, product.getPrice());
            ps.setString(2, product.getAmount());
            ps.setString(3, product.getColor());
            ps.setString(4, product.getDes());
            ps.setInt(5, product.getIdCategory());
            ps.setString(6, product.getNameProduct());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
