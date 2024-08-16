package DataAccess.DTO;

public class CMProvinciaDTO {
    private Integer IdCMCatalogoProvincia;
    private Integer IdCMCatalogoRegion;
    private String  Nombre;
    private String  Descripcion;
    private String  Estado;
    private String  FechaCreacion;
    private String  FechaModifica;
    
    public CMProvinciaDTO() {
    }

    public CMProvinciaDTO(Integer idCMCatalogoProvincia, Integer idCMCatalogoRegion, String nombre, String descripcion,
            String estado, String fechaCreacion, String fechaModifica) {
        this.IdCMCatalogoProvincia = idCMCatalogoProvincia;
        this.IdCMCatalogoRegion = idCMCatalogoRegion;
        this.Nombre = nombre;
        this.Descripcion = descripcion;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModifica = fechaModifica;
    }

    public Integer getIdCMCatalogoProvincia() {
        return IdCMCatalogoProvincia;
    }

    public void setIdCMCatalogoProvincia(Integer idCMCatalogoProvincia) {
        IdCMCatalogoProvincia = idCMCatalogoProvincia;
    }

    public Integer getIdCMCatalogoRegion() {
        return IdCMCatalogoRegion;
    }

    public void setIdCMCatalogoRegion(Integer idCMCatalogoRegion) {
        IdCMCatalogoRegion = idCMCatalogoRegion;
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
                + "\n idCMCatalogoProvincia     "+ getIdCMCatalogoProvincia()
                + "\n idCMCatalogoRegion        "+ getIdCMCatalogoRegion()
                + "\n nombre                    "+ getNombre()
                + "\n descripcion               "+ getDescripcion()
                + "\n estado                    "+ getEstado()
                + "\n fechaCreacion             "+ getFechaCreacion()
                + "\n fechaModifica             "+ getFechaModifica();
    }



}
