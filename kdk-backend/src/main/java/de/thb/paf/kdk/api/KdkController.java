package de.thb.paf.kdk.api;

import de.thb.paf.kdk.model.MathTask;
import de.thb.paf.kdk.service.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class KdkController {

    private final MathService mathService;

    public KdkController(MathService mathService) {

        this.mathService = mathService;
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
}
