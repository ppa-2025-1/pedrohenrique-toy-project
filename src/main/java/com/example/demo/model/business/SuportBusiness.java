package com.example.demo.model.business;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.NewUser;
import com.example.demo.model.entity.Profile;
import com.example.demo.model.entity.Role;
import com.example.demo.model.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

import main.java.com.example.demo.repository.SupportRepository;

// classe que representa o negócio
@Business // marcar como um Bean de Negócio
public class SuportBusiness {
    
    private SupportRepository supportRepository;

    public void criarSuporte(NewSupport newSupport) {

        if (newSupport.action().isEmpty()) {
            throw new IllegalArgumentException("Email e senha não podem estar vazios");
        }
        
        supportRepository.findByEmail(newSupport.email())
            .ifPresent(user -> {
                throw new IllegalArgumentException("Usuário com o email " + newSupport.email() + " já existe");
            });

        supportRepository.findByHandle(newSupport.handle())
            .ifPresent(user -> {
                throw new IllegalArgumentException("Usuário com o nome " + newSupport.handle() + " já existe");
            });

        SuportBussines support = new Support();
        
        user.setEmail(newSupport.email());
    
        supportRepository.save(support); 
    }

    private String generateHandle(String email) {
        String[] parts = email.split("@");
        String handle = parts[0];
        int i = 1;
        while (userRepository.existsByHandle(handle)) {
            handle = parts[0] + i++;
        }
        return handle;
    }

}