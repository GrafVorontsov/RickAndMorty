package com.rickandmorty.info.converter;

import java.sql.Timestamp;
import java.time.Instant;

public class ConvertTimestamp {
    public static Timestamp srtToTimestamp(String string){
        Instant instant = Instant.parse(string);
        return instant != null ? new Timestamp(instant.toEpochMilli()) : null;
    }

    public static Instant timestampToInstant(Timestamp timestamp) {
        return timestamp != null ? Instant.ofEpochMilli(timestamp.getTime()) : null;
    }
}
