package exm.retama.game3.sevice;

import exm.retama.game3.calculator.StepCalculator;
import exm.retama.game3.data.*;
import exm.retama.game3.random.RandomGenerator;
import exm.retama.game3.repository.StepsRepository;
import exm.retama.game3.validator.FailedValue;
import exm.retama.game3.validator.InputGame3Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private StepsRepository repository;
    @Autowired
    private RandomGenerator generator;
    @Autowired
    private StepCalculator stepCalculator;
    @Autowired
    private InputGame3Validator inputGame3Validator;

    private boolean state = false;

    @Override
    public List<StepOutput> getGameSteps() {
        return repository.findAll().stream().map(x -> new StepOutput(x)).collect(Collectors.toList());
    }

    @Override
    public String startGame(Start start) {
        String gameStartedMessage = "Game not started. To start game choose true";
        repository.deleteAll();
        state = start.isFlag();
        if(state) {
            int startNum = generator.generate();
            repository.save(new Step(start.getPerson().toData(), 0, startNum));
            if (PersonDto.COMPUTER == start.getPerson()) {
                Step step = stepCalculator.calculateNextStep(startNum);
                step = repository.save(step);
                startNum = step.getResult();
                state = startNum != 1;
            }
            gameStartedMessage = start.getPerson().toString() + "is starting . Number is " + startNum;
        }
       return gameStartedMessage;
    }

    @Override
    public int next(StepDto step) {
        Step nextStep = null;
        if (state) {
            Step lastStep = repository.findFirstByOrderByIdDesc();
            FailedValue resValidation = inputGame3Validator.validate(step, lastStep.getResult());
            if (FailedValue.NA != resValidation) {
                resValidation.throwException();
            }
            nextStep = repository.save(new Step(step) );
            if(state = nextStep.getResult() == 1) {
                state = false;
                return 1;
            }
            nextStep = stepCalculator.calculateNextStep(nextStep.getResult());
            nextStep = repository.save(nextStep);
            state = nextStep.getResult() != 1;
        }
        return nextStep != null ? nextStep.getResult() : 1;
    }
}