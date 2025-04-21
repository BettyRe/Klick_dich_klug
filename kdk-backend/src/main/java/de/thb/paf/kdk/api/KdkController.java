package de.thb.paf.kdk.api;

import de.thb.paf.kdk.entities.Category;
import de.thb.paf.kdk.entities.Quiz;
import de.thb.paf.kdk.model.MathTask;
import de.thb.paf.kdk.service.MathService;
import de.thb.paf.kdk.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class KdkController {

    private final MathService mathService;
    private final QuizService quizService;

    public KdkController(MathService mathService, QuizService quizService) {

        this.mathService = mathService;
        this.quizService = quizService;
    }

    @GetMapping("/testMe")
    ResponseEntity<String> testMe() {
        return new ResponseEntity<>("hello world", OK);
    }

    @GetMapping("/newMathTask")
    ResponseEntity<MathTask> createMathTask() {
        MathTask randomMathTask = mathService.getRandomMathTask();
        return new ResponseEntity<>(randomMathTask, OK);
    }

    @GetMapping("/allCategories")
    ResponseEntity<List <Category>> getCategories(){
        return new ResponseEntity<>(List.of(Category.values()),OK);
    }

    @GetMapping("/loadCategory")
    List<Quiz> getQuizzesForCategory(){
        return quizService.findCategoryHistory();
    }
}
