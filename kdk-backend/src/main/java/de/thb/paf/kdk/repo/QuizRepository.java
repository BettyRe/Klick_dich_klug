package de.thb.paf.kdk.repo;

import de.thb.paf.kdk.entities.Category;
import de.thb.paf.kdk.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findAllByCategory(Category category);
}
