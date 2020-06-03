package exm.retama.game3.validator;

import exm.retama.game3.data.StepDto;

public class InputGame3ValidatorImpl implements InputGame3Validator {
    @Override
    public FailedValue validate(StepDto step, int prevNumber) {
        FailedValue failedValue = FailedValue.NA;
        prevNumber+=step.getStep();
        if (prevNumber % 3 != 0 ) {
            failedValue = FailedValue.STEP;
        }
        else if (prevNumber / 3 != step.getResult()) {
            failedValue = FailedValue.RETURNED_VALUE;
        }
        return failedValue;
    }
}
