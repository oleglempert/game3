package exm.retama.game3.controller;

import exm.retama.game3.data.Start;
import exm.retama.game3.data.StepDto;
import exm.retama.game3.data.StepOutput;
import exm.retama.game3.sevice.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController extends BaseController{

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GameService gameService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/getGame")
    private List<StepOutput> getGame() {
        List<StepOutput> gameSteps = gameService.getGameSteps();
        gameSteps.stream().forEach(x -> logger.trace(x + "\n"));
        return gameSteps;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/start")
    private String start(@RequestBody Start start) {
        String startGame = gameService.startGame(start);
        logger.trace(startGame);
        return startGame;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(value = "/next")
    private int next(@Valid @RequestBody StepDto stepDto) {
        int result = gameService.next(stepDto);
        logger.trace("OUT : " + result);
        return result;
    }
}

