package com.alisson.workshopmongo.services;

import com.alisson.workshopmongo.domain.User;
import com.alisson.workshopmongo.dto.UserDTO;
import com.alisson.workshopmongo.repository.UserRepository;
import com.alisson.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
       return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete (String id){
        findById(id);
        repo.deleteById(id);
    }

    public User fromDto(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
    }

    public void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }


}
