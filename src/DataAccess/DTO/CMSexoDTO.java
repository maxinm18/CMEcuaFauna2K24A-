package DataAccess.DTO;

public class CMSexoDTO {
    private Integer RowNum;
    
    private Integer IdCMCatalogo;
    private Integer IdCMCatalogoTipo;
    private String Nombre;
    private String Descripcion;    
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;
    
    public CMSexoDTO() {
    }

    public CMSexoDTO(Integer RowNum, Integer idCMCatalogo, Integer idCMCatalogoTipo, String nombre, String descripcion,
            String estado, String fechaCreacion, String fechaModifica) {
        this.RowNum  = RowNum;
        this.IdCMCatalogo = idCMCatalogo;
        this.IdCMCatalogoTipo = idCMCatalogoTipo;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModifica = fechaModifica;
    }
    
    public Integer getRowNum() {
        return RowNum;
    }

    public void setRowNum(Integer rowNum) {
        RowNum = rowNum;
    }
    
    public Integer getIdCMCatalogo() {
        return IdCMCatalogo;
    }

    public void setIdCMCatalogo(Integer idCMCatalogo) {
        IdCMCatalogo = idCMCatalogo;
    }

    public Integer getIdCMCatalogoTipo() {
        return IdCMCatalogoTipo;
    }

    public void setIdCMCatalogoTipo(Integer idCMCatalogoTipo) {
        IdCMCatalogoTipo = idCMCatalogoTipo;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString(){
        return  "  \n" + getClass().getName()
                + "\n idCMCatalogo     "+ getIdCMCatalogo()
                + "\n idCMCatalogoTipo "+ getIdCMCatalogoTipo()
                + "\n nombre         "+ getNombre()
                + "\n descripcion    "+ getDescripcion()
                + "\n estado         "+ getEstado()
                + "\n fechaCreacion  "+ getFechaCreacion()
                + "\n fechaModifica  "+ getFechaModifica();
    }

}
