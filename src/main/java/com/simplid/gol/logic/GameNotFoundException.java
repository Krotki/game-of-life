package com.simplid.gol.logic;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3736514961479197108L;

    public GameNotFoundException(String id) {
        super("Could not find game with id: '" + id + "'.");
    }
}
