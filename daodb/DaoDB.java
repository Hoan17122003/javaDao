package daodb;

import java.sql.SQLException;
import java.util.*;

import nhansu.Nhanvien;

public interface DaoDB<T> {
    public List<String> getAll();

    public void insert(T item) throws SQLException;

    public void update(T item) throws SQLException;

    public void delete(String ID) throws SQLException;

    public void save(T item) throws SQLException;

    public void display(T item, String valueSearch) throws SQLException;
}