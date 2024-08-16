package DataAccess.DTO;

public class CMEstadoDTO {
    private Integer IdCMHormiga;
    private Integer IdCMHormigaTipo;
    private Integer IdCMSexo;
    private Integer IdCMCatalogoProvincia;
    private Integer IdCMCatalogoModificado;
    private Integer IdCMCatalogoNativo;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;
    
    public CMEstadoDTO(Integer idCMHormiga, Integer idCMHormigaTipo, Integer idCMSexo, Integer idCMCatalogoProvincia,
            Integer idCMCatalogoModificado, Integer idCMCatalogoNativo, String estado, String fechaCreacion,
            String fechaModifica) {
        this.IdCMHormiga = idCMHormiga;
        this.IdCMHormigaTipo = idCMHormigaTipo;
        this.IdCMSexo = idCMSexo;
        this.IdCMCatalogoProvincia = idCMCatalogoProvincia;
        this.IdCMCatalogoModificado = idCMCatalogoModificado;
        this.IdCMCatalogoNativo = idCMCatalogoNativo;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModifica = fechaModifica;
    }
    public CMEstadoDTO() {
    }
    public Integer getIdCMHormiga() {
        return IdCMHormiga;
    }
    public void setIdCMHormiga(Integer idCMHormiga) {
        IdCMHormiga = idCMHormiga;
    }
    public Integer getIdCMHormigaTipo() {
        return IdCMHormigaTipo;
    }
    public void setIdCMHormigaTipo(Integer idCMHormigaTipo) {
        IdCMHormigaTipo = idCMHormigaTipo;
    }
    public Integer getIdCMSexo() {
        return IdCMSexo;
    }
    public void setIdCMSexo(Integer idCMSexo) {
        IdCMSexo = idCMSexo;
    }
    public Integer getIdCMCatalogoProvincia() {
        return IdCMCatalogoProvincia;
    }
    public void setIdCMCatalogoProvincia(Integer idCMCatalogoProvincia) {
        IdCMCatalogoProvincia = idCMCatalogoProvincia;
    }
    public Integer getIdCMCatalogoModificado() {
        return IdCMCatalogoModificado;
    }
    public void setIdCMCatalogoModificado(Integer idCMCatalogoModificado) {
        IdCMCatalogoModificado = idCMCatalogoModificado;
    }
    public Integer getIdCMCatalogoNativo() {
        return IdCMCatalogoNativo;
    }
    public void setIdCMCatalogoNativo(Integer idCMCatalogoNativo) {
        IdCMCatalogoNativo = idCMCatalogoNativo;
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
                + "\n IdCMHormiga     "+ getIdCMHormiga()
                + "\n IdCMHormigaTipo "+ getIdCMHormigaTipo()
                + "\n IdCMSexo         "+ getIdCMSexo()
                + "\n IdCMCatalogoProvincia    "+ getIdCMCatalogoProvincia()
                + "\n IdCMCatalogoModificado         "+ getIdCMCatalogoModificado()
                + "\n IdCMCatalogoNativo         "+ getIdCMCatalogoNativo()
                + "\n Estado         "+ getEstado()
                + "\n fechaCreacion  "+ getFechaCreacion()
                + "\n fechaModifica  "+ getFechaModifica();
    }

    
    
    
    
    
    
   
 


}
