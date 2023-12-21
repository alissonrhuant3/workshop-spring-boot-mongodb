package com.alisson.workshopmongo.resources;

import com.alisson.workshopmongo.domain.Post;
import com.alisson.workshopmongo.domain.User;
import com.alisson.workshopmongo.dto.UserDTO;
import com.alisson.workshopmongo.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    PostService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
       return ResponseEntity.ok().body(obj);
    }

}
