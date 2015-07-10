package com.simplid.gol.logic;

import com.simplid.gol.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final IGameRepository gameRepository;
    private final IGameLogic gameLogic;

    @Autowired
    public GameService(IGameRepository gameRepository, IGameLogic gameLogic) {
        this.gameRepository = gameRepository;
        this.gameLogic = gameLogic;
    }

    public Game newGame(String name, int width, int height) {
        Game game = new Game(name, width, height);
        return gameRepository.save(game);
    }

    public Game newGame(Game game) {
        return gameRepository.save(game);
    }

    public Game nextGeneration(String id) {
        Game game = gameRepository.findOne(id);
        game = gameLogic.nextGeneration(game);
        return gameRepository.save(game);
    }

    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public Page<Game> getGames(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public Optional<Game> getGame(String id) {
        return Optional.ofNullable(gameRepository.findOne(id));
    }

    public Optional<Game> getGameByName(String name) {
        return Optional.ofNullable(gameRepository.findByName(name));
    }

    public void delete(String id) {
        gameRepository.delete(id);
    }

    public void deleteAll() {
        gameRepository.deleteAll();
    }
}
