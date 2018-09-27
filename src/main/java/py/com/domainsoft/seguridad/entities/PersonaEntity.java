package py.com.domainsoft.seguridad.entities;

import java.time.LocalDate;

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

import py.com.domainsoft.entidad.entities.ActividadEconomicaEntity;
import py.com.domainsoft.entidad.entities.CiudadEntity;
import py.com.domainsoft.entidad.entities.PaisEntity;

@Entity
@Table(name = "persona")
public class PersonaEntity {

    @Id
    @GenericGenerator(name = "personaSequenceGenerator",
    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
    parameters = {
            @Parameter(name = SequenceStyleGenerator.SEQUENCE_PARAM,
                    value = "persona_id_persona_seq"),
            @Parameter(name = SequenceStyleGenerator.INITIAL_PARAM,
            value = "1"),
            @Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM,
            value = "1") })
    @GeneratedValue(generator = "personaSequenceGenerator")
    @Column(name = "id_persona")
    private Integer idPersona;
    
    private String nombres;
    
    private String apellidos;
    
    @ManyToOne(targetEntity = TipoDocumentoEntity.class)
    @JoinColumn(name = "id_tipo_documento")
    private TipoDocumentoEntity tipoDocumento;
    
    private String documento;

    @ManyToOne(targetEntity = TipoDocumentoEntity.class)
    @JoinColumn(name = "id_tipo_documento2")
    private TipoDocumentoEntity tipoDocumento2;
    
    private String documento2;
    
    private LocalDate fechaNacimiento;
    
    private String telefono;
    
    private String direccion;
    
    private String correo;
    
    @ManyToOne(targetEntity = PaisEntity.class)
    @JoinColumn(name = "id_pais_residencia")
    private PaisEntity paisResidencia;
    
    @ManyToOne(targetEntity = PaisEntity.class)
    @JoinColumn(name = "id_pais_nacionalidad")
    private PaisEntity paisNacionalidad;
    
    
    @ManyToOne(targetEntity = TipoPersonaEntity.class)
    @JoinColumn(name = "id_tipo_persona")
    private TipoPersonaEntity tipoPersona;
    
    private String genero;
    
    @ManyToOne(targetEntity = EstadoCivilEntity.class)
    @JoinColumn(name = "id_estado_civil")
    private EstadoCivilEntity estadoCivil;
    
    private Boolean estado;
    
    @ManyToOne(targetEntity = ActividadEconomicaEntity.class)
    @JoinColumn(name = "id_actividad_economica")
    private ActividadEconomicaEntity actividadEconomica;
    
    @ManyToOne(targetEntity = CiudadEntity.class)
    @JoinColumn(name = "id_ciudad_residencia")
    private CiudadEntity ciudad;
    
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getDocumento2() {
        return documento2;
    }
    public void setDocumento2(String documento2) {
        this.documento2 = documento2;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public Integer getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public TipoDocumentoEntity getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(TipoDocumentoEntity tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public TipoDocumentoEntity getTipoDocumento2() {
        return tipoDocumento2;
    }
    public void setTipoDocumento2(TipoDocumentoEntity tipoDocumento2) {
        this.tipoDocumento2 = tipoDocumento2;
    }
   
    public PaisEntity getPaisNacionalidad() {
        return paisNacionalidad;
    }
    public void setPaisNacionalidad(PaisEntity paisNacionalidad) {
        this.paisNacionalidad = paisNacionalidad;
    }
    public TipoPersonaEntity getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(TipoPersonaEntity tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    public EstadoCivilEntity getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(EstadoCivilEntity estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    public PaisEntity getPaisResidencia() {
        return paisResidencia;
    }
    public void setPaisResidencia(PaisEntity paisResidencia) {
        this.paisResidencia = paisResidencia;
    }
    public ActividadEconomicaEntity getActividadEconomica() {
        return actividadEconomica;
    }
    public void setActividadEconomica(ActividadEconomicaEntity actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }
    public CiudadEntity getCiudad() {
        return ciudad;
    }
    public void setCiudad(CiudadEntity ciudad) {
        this.ciudad = ciudad;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (idPersona == null || obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PersonaEntity toCompare = (PersonaEntity) obj;
        return idPersona.equals(toCompare.idPersona);
    }

    @Override
    public int hashCode() {
        return idPersona == null ? 0 : idPersona.hashCode();
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idPersona", idPersona)
                .add("nombres", nombres)
                .add("apellidos", apellidos)
                .add("documento", documento)
                .add("documento2", documento2)
                .add("fechaNacimiento", fechaNacimiento)
                .add("telefono", telefono)
                .add("direccion", direccion)
                .add("genero", genero)
                .add("estado", estado)
                .add("tipoPersona", tipoPersona)
                .add("tipoDocumento", tipoDocumento)
                .add("tipoDocumento2", tipoDocumento2)
                .add("paisResidencia", paisResidencia)
                .add("paisNacionalidad", paisNacionalidad)
                .add("estadoCivil", estadoCivil)
                .add("correo", correo)
                .add("ciudad", ciudad)
                .add("actividadEconomica", actividadEconomica)
                .toString();
    }

    
}
