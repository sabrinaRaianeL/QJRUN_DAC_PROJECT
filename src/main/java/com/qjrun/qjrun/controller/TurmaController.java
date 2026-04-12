package com.qjrun.qjrun.controller;


import com.qjrun.qjrun.entity.Turma;
import com.qjrun.qjrun.service.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@RequiredArgsConstructor
public class TurmaController {

    private final TurmaService turmaService;

    @PostMapping
    public Turma create(@RequestBody Turma turma) {
        return turmaService.save(turma);
    }

    @GetMapping
    public List<Turma> findAll() {
        return turmaService.findAll();
    }

    @GetMapping("/{id}")
    public Turma findById(@PathVariable Long id) {
        return turmaService.findById(id);
    }

    @PutMapping("/{id}")
    public Turma update(@PathVariable Long id, @RequestBody Turma turma) {
        return turmaService.update(id, turma);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        turmaService.desativar(id);
    }








}
