package ie.atu.sem2week3.controller;

import ie.atu.sem2week3.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {
    private final CalculatorService calculatorService;
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public ResponseEntity<Integer> add(@RequestParam int a, @RequestParam int b) {
       int result = calculatorService.add(a, b);
       return ResponseEntity.ok(result);
    }

    @GetMapping("/div")
    public ResponseEntity<?> div(@RequestParam int a, @RequestParam int b) {
        if (b ==0 )
        {
            return ResponseEntity.badRequest().body("Division by zero is no allowed ");
        }
        int result = calculatorService.div(a, b);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/convert")
    public ResponseEntity<String> convert (@RequestParam double value, @RequestParam String type ) {
        switch (type.toLowerCase()) {
            case "c2f": return ResponseEntity.ok(value + "C = " + calculatorService.c2f(value) + "F");
            case "f2c": return ResponseEntity.ok(value + "F" + calculatorService.f2c(value) + " C");
            default: return ResponseEntity.badRequest().body("Unknown Conversion type. Use c2f or f2c.");
        }
    }
}
