package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.controller.operation.IllegalArgumentException;
import at.nacs.ex5thecalculator.model.Expression;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Log
class ExpressionsTest {

    @Autowired
    Expressions expressions;

    @Test
    void fromSucceeds() {
        String input = "1.62 @ 3.14";

        Expression expression = null;

        try {
            expression = expressions.from(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
           log.severe(e.toString());

        }finally {
          log.severe("Enter a valid operation!");
        }

        assertEquals(1.62, expression.getNumber1());
        assertEquals("@", expression.getSymbol());
        assertEquals(3.14, expression.getNumber2());
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "1 @",
            "1 2 @ 3"
    })
    void fromFailsBecauseOfWrongNumberOfElements(String input) {
        assertThrows(IllegalArgumentException.class, () -> expressions.from(input));
    }
}