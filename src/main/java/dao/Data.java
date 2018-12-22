package dao;

import java.sql.SQLException;
import java.util.List;

public interface Data {
    public abstract void deleteData(int id) throws SQLException;
    public abstract List<Object> viewData() throws SQLException;
    public abstract Object getData(int id) throws SQLException;
}
