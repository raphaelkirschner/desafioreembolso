package br.com.decolar.reembolso.controllers;

import br.com.decolar.reembolso.model.Reembolso;
import br.com.decolar.reembolso.model.ReembolsoValidator;
import br.com.decolar.reembolso.responses.ReembolsoResponse;
import br.com.decolar.reembolso.services.ReembolsoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ReembolsoController {

    @Autowired
    private ReembolsoServices reembolsoServices;

    @GetMapping
    public ModelAndView Index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Home/Index");
        return mv;
    }

    @GetMapping(path = "api/reembolso")
    public ResponseEntity<ReembolsoResponse<List<Reembolso>>> listarTodos(){
        return ResponseEntity.ok(new ReembolsoResponse<List<Reembolso>>(this.reembolsoServices.listarTodos()));
    }

    @PostMapping(path = "api/reembolso")
    public ResponseEntity<ReembolsoResponse<Reembolso>> cadastrar(@Valid @RequestBody Reembolso reembolso, BindingResult result){
        List<String> erros = ReembolsoValidator.validarReembolso(result, reembolso);

        if (!erros.isEmpty()) {
            return ResponseEntity.badRequest().body(new ReembolsoResponse<Reembolso>(erros));
        }

        return ResponseEntity.ok(new ReembolsoResponse<Reembolso>(this.reembolsoServices.cadastrar(reembolso)));
    }

    @PutMapping(path = "api/reembolso/atualizar/{id}")
    public ResponseEntity<ReembolsoResponse<Reembolso>> atualizar(@PathVariable(name = "id") String id,@Valid @RequestBody Reembolso reembolso, BindingResult result){
        List<String> erros = ReembolsoValidator.validarReembolso(result, reembolso);

        if (!erros.isEmpty()) {
            return ResponseEntity.badRequest().body(new ReembolsoResponse<Reembolso>(erros));
        }

        return ResponseEntity.ok(new ReembolsoResponse<Reembolso>(this.reembolsoServices.atualizar(reembolso)));
    }

    @PutMapping(path = "api/reembolso/atualizar/{id}/{reembolsado}")
    public ResponseEntity<Reembolso> atualizarReembolsado(@PathVariable(name = "id") String id,@PathVariable(name = "reembolsado") boolean isReembolsado){
        return ResponseEntity.ok(this.reembolsoServices.atualizarReembolsado(id, isReembolsado));
    }
}