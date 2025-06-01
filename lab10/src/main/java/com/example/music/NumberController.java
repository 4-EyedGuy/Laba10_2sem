package com.example.music;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class NumberController {
    @GetMapping("/calc")
    public String calculate(
            @RequestParam(name = "a", required = false) Double a,
            @RequestParam(name = "b", required = false) Double b,
            @RequestParam(name = "op", required = false) String op,
            Model model) {

        String result;

        if (a == null && b == null) {
            result = "Not enough parameters.";
        }
        else {
            switch (op) {
                case "+":
                    result = a + " + " + b + " = " + (a + b);
                    break;
                case "-":
                    result = a + " - " + b + " = " + (a - b);
                    break;
                case "*":
                    result = a + " * " + b + " = " + (a * b);
                    break;
                case "/":
                    if (b != 0) {
                        result = a + " / " + b + " = " + (a / b);
                    }
                    else {
                        result = "YOU CAN'T DO THIS! DON'T YOU KNOW MATH???";
                    }
                    break;
                default:
                    result = "Unknown operation: " + op;
            }
        }

        model.addAttribute("result", result);
        return "calc";
    }
}
