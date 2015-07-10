package com.simplid.gol.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class CellDeserializer extends JsonDeserializer<Cell> {

    @Override
    public Cell deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return Cell.fromValue(jp.getNumberValue().intValue());
    }
}
