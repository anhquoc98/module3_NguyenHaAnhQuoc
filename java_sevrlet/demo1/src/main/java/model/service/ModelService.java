package model.service;

import model.Model;
import model.repository.ModelDBRepository;

import java.util.List;

public class ModelService implements IModelService{
    ModelDBRepository modelDBRepository=new ModelDBRepository();
    @Override
    public List<Model> list() {
        return modelDBRepository.list();
    }

    @Override
    public void save(Model model) {

    }
}
