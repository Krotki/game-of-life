package com.simplid.gol.logic;

import com.simplid.gol.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IGameRepository extends MongoRepository<Game, String> {

    Game findByName(String name);
}
