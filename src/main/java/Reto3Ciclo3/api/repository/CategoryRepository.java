package Reto3Ciclo3.api.repository;

import Reto3Ciclo3.api.model.Category;
import Reto3Ciclo3.api.repository.Crud.CategoryCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepo categoryCrudRepo;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepo.findAll();
    }

    public Optional<Category>getCategory(int id){
        return categoryCrudRepo.findById(id);
    }

    public Category save(Category category){
        return categoryCrudRepo.save(category);
    }

    public void delete(Category category){
        categoryCrudRepo.delete(category);
    }

}
