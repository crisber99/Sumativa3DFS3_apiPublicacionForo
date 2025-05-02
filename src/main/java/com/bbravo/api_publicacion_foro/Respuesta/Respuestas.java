package com.bbravo.api_publicacion_foro.Respuesta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Respuestas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdRespuesta;
    @Column(name = "contenido")
    @NotNull(message = "Campo en null, debe ingresar un contenido.")
    @NotEmpty(message = "Campo vacío, debe ingresar un contenido.")
    private String contenido;
    @Column(name = "idTema")
    @NotNull(message = "Campo en null, debe ingresar el id del tema.")
    private Long idTema;
    @Column(name = "idUsuario")
    @NotNull(message = "Campo en null, debe ingresar el id del usuario.")
    private Long idUsuario;

    public Long getIdRespuesta(){
        return IdRespuesta;
    }

    public String getContenido(){
        return contenido;
    }

    public Long getIdTema(){
        return idTema;
    }

    public Long getIdUsuario(){
        return idUsuario;
    }

    //SET
    public void setIdRespuesta(Long id){
        this.IdRespuesta = id;
    }

    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    public void setIdTema(Long id){
        this.idTema = id;
    }

    public void setIdUsuario(Long id){
        this.idUsuario = id;
    }
}
