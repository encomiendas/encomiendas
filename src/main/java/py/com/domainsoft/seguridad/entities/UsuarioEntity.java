package py.com.domainsoft.seguridad.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.entidad.entities.SucursalEntity;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GenericGenerator(name = "usuarioSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "usuario_id_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "usuarioSequenceGenerator")
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "login")
    private String login;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "activo")
    private boolean activo;
    
    @Column(name = "expira")
    private boolean expira;
    
    @Column(name = "fecha_expiracion")
    private LocalDate fechaExpiracion;
    
    @ManyToOne(targetEntity = PersonaEntity.class)
    @JoinColumn(name = "id_persona")
    private PersonaEntity persona;
    
    @ManyToOne(targetEntity = SucursalEntity.class)
    @JoinColumn(name = "id_sucursal")
    private SucursalEntity sucursal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public PersonaEntity getPersona() {
        return persona;
    }

    public SucursalEntity getSucursal() {
        return sucursal;
    }

    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }

    public void setSucursal(SucursalEntity sucursal) {
        this.sucursal = sucursal;
    }
    
    public boolean isExpira() {
        return expira;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setExpira(boolean expira) {
        this.expira = expira;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (id == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UsuarioEntity toCompare = (UsuarioEntity) obj;
        return id.equals(toCompare.id);
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("login", login)
                .add("password", password)
                .add("activo", activo)
                .add("persona", persona)
                .add("sucursal", sucursal)
                .add("expira", expira)
                .add("fechaExpiracion", fechaExpiracion)
                .toString();
    }
    
}
