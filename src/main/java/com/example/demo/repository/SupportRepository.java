package main.java.com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.example.demo.model.entity.User;

public interface SupportRepository extends BaseRepository<Support, Integer> {

    Optional<Private> findById(String id);
    // This interface will automatically provide CRUD operations for the Support entity
    // You can add custom query methods here if needed

    // Optional<User> findByHandle(String handle);

    // boolean existsByHandle(String handle);

}
