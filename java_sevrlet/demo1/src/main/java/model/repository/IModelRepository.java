package model.repository;

import model.Model;

import java.util.List;

public interface IModelRepository {
    List<Model> list();
    void save(Model model);
}
