package severvice;

import model.Category;
import model.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CateGoryService {
    MyConnection myConnection = new MyConnection();
    private String SELECT_ALL_CATEGORY = "select * from category";
    private String SELECT_CATEGORY_BY_ID = "select * from category where idCategory=?";
//    private String SELECT__BY_NAME = "select * from province where provinceName=?";


    public List<Category> listProvince() {
        List<Category> categoryList=new ArrayList<>();
        try {
            PreparedStatement ps=myConnection.getConnection().prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("idCategory");
                String name=rs.getString("category");
//
                categoryList.add(new Category(id,name));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public Category getProvinceById(int id) {
        Category category=null;
        try {
            PreparedStatement ps=myConnection.getConnection().prepareStatement(SELECT_CATEGORY_BY_ID);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                String name=rs.getString("category");
                category=new Category(id,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
