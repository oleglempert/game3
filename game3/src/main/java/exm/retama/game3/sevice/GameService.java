package exm.retama.game3.sevice;

import exm.retama.game3.data.Start;
import exm.retama.game3.data.StepDto;
import exm.retama.game3.data.StepOutput;

import java.util.List;

public interface GameService {

    List<StepOutput> getGameSteps();
    String startGame(Start start);
    int next(StepDto step);
}
