package br.com.decolar.reembolso.controllers;

import br.com.decolar.reembolso.model.Reembolso;
import br.com.decolar.reembolso.services.ReembolsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/detalhesreembolso")
public class ReembolsoController {

    @Autowired
    private ReembolsoService reembolsoService;
    @GetMapping
    public ResponseEntity<List<Reembolso>> listarTodos(){
        return ResponseEntity.ok(this.reembolsoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Reembolso> cadastrar(@RequestBody Reembolso reembolso){
        return ResponseEntity.ok(this.reembolsoService.cadastrar(reembolso));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Reembolso> atualizar(@PathVariable(name = "id") String id, @RequestBody Reembolso reembolso){
        reembolso.setId(id);
        return ResponseEntity.ok(this.reembolsoService.cadastrar(reembolso));
    }
}
