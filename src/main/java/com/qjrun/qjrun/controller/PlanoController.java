package com.qjrun.qjrun.controller;

import com.qjrun.qjrun.entity.Plano;
import com.qjrun.qjrun.service.PlanoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
@RequiredArgsConstructor
public class PlanoController {

    private final PlanoService planoService;

    @PostMapping
    public Plano create(@RequestBody Plano novoPlano) {
        return planoService.save(novoPlano);
    }

    @GetMapping
    public List<Plano> findAll() {
        return planoService.findAll();
    }

    @GetMapping("{id}")
    public Plano findById(@PathVariable Long id) {
        return planoService.findById(id);
    }

    @PutMapping("/{id}")
    public Plano update(@PathVariable Long id, @RequestBody Plano dadosAtualizados) {
        return planoService.update(id, dadosAtualizados);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        planoService.desativar(id);
    }
}
