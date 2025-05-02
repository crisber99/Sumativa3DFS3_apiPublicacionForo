package com.bbravo.api_publicacion_foro.Respuesta;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbravo.api_publicacion_foro.Exception.api_foroNotFoundException;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/respuesta")
@RequiredArgsConstructor
public class RespuestasController {

    private final RespuestasService RespuestaService;
    private static final Logger log = LoggerFactory.getLogger(RespuestasController.class);

    @PostMapping    
    public void addUser(@RequestBody Respuestas user) {
        RespuestaService.creaRespuesta(user);
    }
    
    @GetMapping("/{id}")
    public EntityModel<Respuestas> getRespuestaByid(@PathVariable Long id) {
        log.info("getRespuestaByid");
        Optional<Respuestas> resp = RespuestaService.getRespuesta(id);
        if(resp.isPresent()){
            return EntityModel.of(resp.get(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getRespuestaByid(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllRespuesta()).withRel("all-respuestas"));
        }
        else{
            throw new api_foroNotFoundException("Respuestas no funciona con el id: " + id);
        }
    }
    
    @GetMapping
    public List<Respuestas> getAllRespuesta() {
        return RespuestaService.getAllRespuesta();
    }

    @PutMapping("/{id}")
    public Respuestas updRespuestaes(@PathVariable Long id, @RequestBody Respuestas user) {
        return RespuestaService.updRespuesta(id, user);
    }

    @DeleteMapping("/{id}")
    public void delRespuesta(@PathVariable Long id){
        RespuestaService.delRespuesta(id);
    }
}
