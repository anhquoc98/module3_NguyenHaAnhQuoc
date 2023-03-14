package model.service;

import model.Model;

import java.util.List;

public interface IModelService {
    List<Model> list();
    void save(Model model);
}
