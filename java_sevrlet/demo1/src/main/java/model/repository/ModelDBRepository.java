package model.repository;

import model.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDBRepository implements IModelRepository {
    private static final String SELECT_ALL_MODEL = "select * from student";


    @Override
    public List<Model> list() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Model> modelList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_MODEL);
                resultSet = statement.executeQuery();
                Model model =null;
                while (resultSet.next()){
                    int id =resultSet.getInt("id");
                    String name =resultSet.getString("name");
                    String email=resultSet.getString("email");
                    String country=resultSet.getString("country");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return modelList;
    }

    @Override
    public void save(Model model) {

    }
}
