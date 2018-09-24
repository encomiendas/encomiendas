package py.com.domainsoft.entidad.dtos;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.seguridad.dtos.PersonaDTO;

public class ClienteDTO {

    private Integer idCliente;

    private PersonaDTO persona;
    
    private boolean estado;
    
   
    
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
       return MoreObjects.toStringHelper(this)
              .add("idCliente", idCliente)
              .add("persona", persona)
              .add("estado", estado)
              .toString();
    }
    
}