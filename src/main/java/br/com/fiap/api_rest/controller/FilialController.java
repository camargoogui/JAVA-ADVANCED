package br.com.fiap.api_rest.controller;

import br.com.fiap.api_rest.dto.FilialRequest;
import br.com.fiap.api_rest.dto.FilialResponse;
import br.com.fiap.api_rest.model.Filial;
import br.com.fiap.api_rest.repository.FilialRepository;
import br.com.fiap.api_rest.service.FilialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RequestController
@RequestMapping("/filial")
public class FilialController{
    @Autowired
    FilialRepository filialRepository;

    @Autowired
    FilialService filialService;

    @PostMapping
    public ResponseEntitty<Filial> create(@Valid @RequestBody FilialRequest filial){
        return new ResponseEntity<>(filialService.create(filialRequest), HttpStatus.CREATED);
    };

}