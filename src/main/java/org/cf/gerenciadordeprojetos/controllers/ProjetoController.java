package org.cf.gerenciadordeprojetos.controllers;

import org.cf.gerenciadordeprojetos.models.ProjetoModel;
import org.cf.gerenciadordeprojetos.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> getAll() {
        List<ProjetoModel> request = projetoService.findAll();
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<ProjetoModel> create(@RequestBody ProjetoModel projeto) {
        ProjetoModel request = projetoService.save(projeto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(projeto.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        projetoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProjetoModel projeto) {
        projetoService.update(id, projeto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoModel> findById(@PathVariable Long id) {
        ProjetoModel projeto = projetoService.findById(id);

        if (projeto != null) {
            return ResponseEntity.ok(projeto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
