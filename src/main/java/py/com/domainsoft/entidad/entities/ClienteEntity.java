package py.com.domainsoft.entidad.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.seguridad.entities.PersonaEntity;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GenericGenerator(name = "clienteSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "cliente_id_cliente_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "clienteSequenceGenerator")
    @Column(name = "id_cliente")
    private Integer idCliente;
    
    @ManyToOne(targetEntity = PersonaEntity.class)
    @JoinColumn(name = "id_persona")
    private PersonaEntity persona;
    
    private Boolean estado;

    
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public PersonaEntity getPersona() {
        return persona;
    }

    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idCliente == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClienteEntity toCompare = (ClienteEntity) obj;
        return idCliente.equals(toCompare.idCliente);
    }

    @Override
    public int hashCode() {
        return idCliente == null ? 0 : idCliente.hashCode();
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
