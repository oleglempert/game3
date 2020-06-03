package exm.retama.game3.validator;

import exm.retama.game3.data.StepDto;

public interface InputGame3Validator {

    FailedValue validate (StepDto step, int prevNumber);
}
