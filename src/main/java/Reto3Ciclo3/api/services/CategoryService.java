package Reto3Ciclo3.api.services;

import Reto3Ciclo3.api.model.Boat;
import Reto3Ciclo3.api.model.Category;
import Reto3Ciclo3.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    }

    public Category save(Category category){
        if (category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> baux=categoryRepository.getCategory(category.getId());
            if (baux.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }

    public Category update(Category category){
        if (category.getId() !=null){
            Optional<Category> auxUpdt=categoryRepository.getCategory(category.getId());
            if(!auxUpdt.isEmpty()){
                if (category.getDescription()!=null){
                    auxUpdt.get().setDescription(category.getDescription());
                }
                if (category.getName()!=null){
                    auxUpdt.get().setName(category.getName());
                }
                return categoryRepository.save(auxUpdt.get());
            }else{
                return category;
            }
        }else{
            return category;
        }
    }

    public boolean deleteCategory(int categoryId){
        Boolean dBoolean = getCategory(categoryId).map(boat -> {
            categoryRepository.delete(boat);
            return true;
        }).orElse(false);
        return dBoolean;
    }



}
