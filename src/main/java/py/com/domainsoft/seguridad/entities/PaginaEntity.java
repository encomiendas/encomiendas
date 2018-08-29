package py.com.domainsoft.seguridad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

@Entity
@Table(name = "pagina")
public class PaginaEntity {

    @Id
    @GenericGenerator(name = "paginaSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "pagina_id_pagina_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "paginaSequenceGenerator")
    @Column(name = "id_pagina")
    private Integer idPagina;
    
    private String descripcion;

    public Integer getIdPagina() {
        return idPagina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdPagina(Integer idPagina) {
        this.idPagina = idPagina;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idPagina == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PaginaEntity toCompare = (PaginaEntity) obj;
        return idPagina.equals(toCompare.idPagina);
    }

    @Override
    public int hashCode() {
        return idPagina == null ? 0 : idPagina.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idPagina", idPagina)
                .add("descripcion", descripcion)
                .toString();
    }  
    
}
