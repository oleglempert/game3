package exm.retama.game3.calculator;

import exm.retama.game3.data.Person;
import exm.retama.game3.data.Step;

public class StepCalculatorImpl  implements StepCalculator{
    @Override
    public Step calculateNextStep(int number) {
        int step = 0;
        if((number + 1) % 3 == 0) {
            step = 1;
        }
        else if ((number - 1) % 3 == 0) {
            step = -1;
        }
        return new Step (Person.COMPUTER, step, (number += step) / 3);
    }
}
