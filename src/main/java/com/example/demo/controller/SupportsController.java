package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.NewSupport;
import com.example.demo.model.business.SupportBusiness;
import com.example.demo.model.entity.Support;
import com.example.demo.repository.SupportRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

// fat model
// fat controller (Anti-Pattern: o que não fazer)

// thin controller e um fat model
// controller deve ter apenas o essencial
// para lidar com a requisição
// as regras de negócio ficam no model (business, service, entidade)

@RestController
@RequestMapping("/api/v1/supports")
public class SupportsController extends AbstractController {

    private final SupportRepository supportRepository;
    private final SupportBusiness supportBusiness;

    public SupportController(SupportRepository supportRepository,
                          UserBusiness supportBusiness) {
        this.SupportRepository = supportRepository;
        this.SupportBusiness = supportBusiness;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createNewSupport(
        @Valid
        @RequestBody
        NewSupport newSupport) {

        supportBusiness.criarSuporte(newSupport);

    }

    // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<List<Support>> getUsers() {
    //     return ResponseEntity.ok(supportRepository.findAll());
    // }
}
