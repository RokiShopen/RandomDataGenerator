package com.random.people.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RDGResponseBody {
    private RDGErrorIds errorId;
    private String message;
}
