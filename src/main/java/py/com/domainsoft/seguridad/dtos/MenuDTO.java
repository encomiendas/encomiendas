package py.com.domainsoft.seguridad.dtos;

import java.util.List;

import com.google.common.base.MoreObjects;

import py.com.domainsoft.seguridad.entities.PaginaEntity;
import py.com.domainsoft.seguridad.entities.PerfilEntity;

public class MenuDTO {

    private Integer idMenu;
    
    private String tipoMenu;
    
    private String descripcion;
    
    private Integer posicion;
    
    private PerfilEntity perfil;
    
    private PaginaEntity pagina;
    
    private MenuDTO menuAnterior;
    
    private List<MenuDTO> listSubMenu;
    
    public List<MenuDTO> getListSubMenu() {
        return listSubMenu;
    }

    public void setListSubMenu(List<MenuDTO> listSubMenu) {
        this.listSubMenu = listSubMenu;
    }

    public MenuDTO getMenuAnterior() {
        return menuAnterior;
    }

    public void setMenuAnterior(MenuDTO menuAnterior) {
        this.menuAnterior = menuAnterior;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public PaginaEntity getPagina() {
        return pagina;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public void setPagina(PaginaEntity pagina) {
        this.pagina = pagina;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("idMenu", idMenu)
                .add("tipoMenu", tipoMenu)
                .add("descripcion", descripcion)
                .add("posicion", posicion)
                .add("perfil", perfil)
                .add("pagina", pagina)
                .add("menuAnterior", menuAnterior)
                .add("listSubMenu", listSubMenu)
                .toString();
    }
    
}
