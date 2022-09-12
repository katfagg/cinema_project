package com.example.cinema_project.repositories;

<<<<<<< HEAD
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository {
=======
import com.example.cinema_project.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
>>>>>>> 3dbb8b627e71733ff7325feb0a93406f730645e7
}
