package DataAccess.DTO;

public class CMAlimentoNativoDTO {
    private Integer IdCMCatalogoAlimento;
    private Integer IdCMCatalogo;
    private String Nombre;
    private String Descripcion;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;
    
    public CMAlimentoNativoDTO(Integer idCMCatalogoAlimento, Integer idCMCatalogo, String nombre, String descripcion,
            String estado, String fechaCreacion, String fechaModifica) {
        IdCMCatalogoAlimento = idCMCatalogoAlimento;
        IdCMCatalogo = idCMCatalogo;
        Nombre = nombre;
        Descripcion = descripcion;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public CMAlimentoNativoDTO() {
    }


    public Integer getIdCMCatalogoAlimento() {
        return IdCMCatalogoAlimento;
    }

    public void setIdCMCatalogoAlimento(Integer idCMCatalogoAlimento) {
        IdCMCatalogoAlimento = idCMCatalogoAlimento;
    }

    public Integer getIdCMCatalogo() {
        return IdCMCatalogo;
    }

    public void setIdCMCatalogo(Integer idCMCatalogo) {
        IdCMCatalogo = idCMCatalogo;
    }

    public String getNombre() {
        return Nombre;
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
        return  getClass().getName()
                + "\n idCatalogoAlimento     "+ getIdCMCatalogoAlimento()
                + "\n idCatalogo     "+ getIdCMCatalogo()
                + "\n nombre         "+ getNombre()
                + "\n descripcion    "+ getDescripcion()
                + "\n estado         "+ getEstado()
                + "\n fechaCreacion  "+ getFechaCreacion()
                + "\n fechaModifica  "+ getFechaModifica();
    }

}
