package de.thb.paf.kdk.service;

import de.thb.paf.kdk.entities.Category;
import de.thb.paf.kdk.entities.Quiz;
import de.thb.paf.kdk.repo.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuizService {
    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> findCategoryHistory(){
        List<Quiz> historyQuizzes = quizRepository.findAllByCategory(Category.HISTORY);

        return historyQuizzes;
    }
}
