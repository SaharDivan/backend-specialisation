package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.controller.operation.*;
import at.nacs.ex5thecalculator.model.Expression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.lang.IllegalArgumentException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Calculator {
    private final List<Operation> operations;

    public Double calculate(Expression expression)throws IllegalArgumentException{
        for (Operation operation: operations) {
            if(operation.matches(expression)){
                return  operation.apply(expression);
            }
        }
         throw new IllegalArgumentException();
    }
}
