package DataAccess.DTO;

public class CMSexoDTO {

    private Integer IdCMHormiga;
    private String  HormigaTipo;
    private Integer IdCMSexo;
    private Integer IdCMProvincia;
    private Integer IdCMAlimentoModificado;
    private Integer IdCMAlimentoNativo;
    private String  Estado;
    private String  FechaCreacion;
    private String  FechaModifica;
    
    public CMSexoDTO() {
    }
    
    public CMSexoDTO(Integer idCMHormiga, String hormigaTipo, Integer idCMSexo, Integer idCMProvincia,
            Integer idCMAlimentoModificado, Integer idCMAlimentoNativo, String estado, String fechaCreacion,
            String fechaModifica) {
        this.IdCMHormiga = idCMHormiga;
        this.HormigaTipo = hormigaTipo;
        this.IdCMSexo = idCMSexo;
        this.IdCMProvincia = idCMProvincia;
        this.IdCMAlimentoModificado = idCMAlimentoModificado;
        this.IdCMAlimentoNativo = idCMAlimentoNativo;
        this.Estado = estado;
        this.FechaCreacion = fechaCreacion;
        this.FechaModifica = fechaModifica;
    }

    public Integer getIdCMHormiga() {
        return IdCMHormiga;
    }

    public void setIdCMHormiga(Integer idCMHormiga) {
        IdCMHormiga = idCMHormiga;
    }

    public String getHormigaTipo() {
        return HormigaTipo;
    }

    public void setHormigaTipo(String hormigaTipo) {
        HormigaTipo = hormigaTipo;
    }

    public Integer getIdCMSexo() {
        return IdCMSexo;
    }

    public void setIdCMSexo(Integer idCMSexo) {
        IdCMSexo = idCMSexo;
    }

    public Integer getIdCMProvincia() {
        return IdCMProvincia;
    }

    public void setIdCMProvincia(Integer idCMProvincia) {
        IdCMProvincia = idCMProvincia;
    }

    public Integer getIdCMAlimentoModificado() {
        return IdCMAlimentoModificado;
    }

    public void setIdCMAlimentoModificado(Integer idCMAlimentoModificado) {
        IdCMAlimentoModificado = idCMAlimentoModificado;
    }

    public Integer getIdCMAlimentoNativo() {
        return IdCMAlimentoNativo;
    }

    public void setIdCMAlimentoNativo(Integer idCMAlimentoNativo) {
        IdCMAlimentoNativo = idCMAlimentoNativo;
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
                + "\n IdCMHormiga                "+ getIdCMHormiga()
                + "\n HormigaTipo                "+ getHormigaTipo()
                + "\n IdCMSexo                   "+ getIdCMSexo()
                + "\n IdCMProvincia              "+ getIdCMProvincia()
                + "\n IdCMAlimentoModificado     "+ getIdCMAlimentoModificado()
                + "\n IdCMAlimentoNativo         "+ getIdCMAlimentoNativo()
                + "\n Estado                     "+ getEstado()
                + "\n FechaCreacion              "+ getFechaCreacion()
                + "\n FechaModifica              "+ getFechaModifica();
    }

}
