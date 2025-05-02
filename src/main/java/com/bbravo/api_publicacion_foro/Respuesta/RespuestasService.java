package com.bbravo.api_publicacion_foro.Respuesta;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RespuestasService {

private final RespuestasRepository RespuestaRepo;

    public Respuestas creaRespuesta(Respuestas respuesta){
        return RespuestaRepo.save(respuesta);
    }

    public List<Respuestas> getAllRespuesta(){
        return RespuestaRepo.findAll();
    }

    public Optional<Respuestas> getRespuesta(Long id){
        return RespuestaRepo.findById(id);
    }

    public Respuestas updRespuesta(Long id, Respuestas respuesta){
        if(RespuestaRepo.existsById(id)){
            respuesta.setIdRespuesta(id);
            return RespuestaRepo.save(respuesta);
        }
        else return null;
    }

    public void delRespuesta(long id){
        RespuestaRepo.deleteById(id);
    }
}
