package com.simplid.gol.logic;

import com.simplid.gol.model.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final static Logger log = LoggerFactory.getLogger(GameController.class);

    private final GameService gameService;


    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Game newGame(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "width", defaultValue = "40") int width,
            @RequestParam(value = "height", defaultValue = "20") int height
    ) {
        log.debug("Creating new game: " + name + " (" + width + "x" + height + ")");
        return gameService.newGame(name, width, height);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Game> getGames(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        log.debug("Get all games");
        return gameService.getGames(new PageRequest(page, size));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Game getGame(@PathVariable String id) {
        log.debug("Get game with id '" + id + "'");
        return validateGame(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Game nextGeneration(@PathVariable String id) {
        log.debug("Simulating game with id: '" + id + "'");
        validateGame(id);
        return gameService.nextGeneration(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteGame(@PathVariable String id) {
        log.debug("Deleting game with id '" + id + "'");
        validateGame(id);
        gameService.delete(id);
    }

    private Game validateGame(String id) {
        return gameService.getGame(id).orElseThrow(() -> new GameNotFoundException(id));
    }
}
