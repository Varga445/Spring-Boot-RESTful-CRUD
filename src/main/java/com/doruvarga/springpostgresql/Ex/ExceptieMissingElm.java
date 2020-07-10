package com.doruvarga.springpostgresql.Ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptieMissingElm extends Exception {

    public ExceptieMissingElm(String mesaj) {

        super(mesaj);

    }


}
