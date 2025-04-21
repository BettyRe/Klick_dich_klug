package de.thb.paf.kdk;

import de.thb.paf.kdk.entities.*;
import de.thb.paf.kdk.repo.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class QuizDataLoader implements CommandLineRunner {

    private final QuizRepository quizRepository;

    public QuizDataLoader(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Question q1 = Question.builder()
                .question("Was ist die Hauptstadt von Deutschland?")
                .answerList(List.of("Paris", "London", "Berlin", "Rom"))
                .correctAnswer("Berlin")
                .build();

        Question q2 = Question.builder()
                .question("Wie viele Beine hat ein Hund?")
                .answerList(List.of("2", "3", "4", "5"))
                .correctAnswer("4")
                .build();

        Question q3 = Question.builder()
                .question("Wie viele Beine hat eine Katze?")
                .answerList(List.of("2", "3", "4", "5"))
                .correctAnswer("4")
                .build();

        Quiz quizHistory = Quiz.builder()
                .questionList(List.of(q1, q2))
                .category(Category.HISTORY)
                .infoText("Ein kleines Allgemeinwissen-Quiz.")
                .build();

        Quiz quizAnimals = Quiz.builder()
                .questionList(List.of(q3))
                .category(Category.ANIMALS)
                .infoText("Ein kleines Allgemeinwissen-Quiz.")
                .build();

//        quizRepository.save(quizHistory);
//        quizRepository.save(quizAnimals);
        List<Quiz> foobar = List.of(quizHistory,quizAnimals);
        quizRepository.saveAll(foobar);

        log.info("✅ Test-Quiz gespeichert!");
    }
}
