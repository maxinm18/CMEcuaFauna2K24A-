package BusinessLogic;
import DataAccess.CMEstadoDAO;
import DataAccess.DTO.CMEstadoDTO;
import java.util.List;

public class CMEstadoBL {
    private CMEstadoDTO cmedto;
    private CMEstadoDAO cmeDAO = new CMEstadoDAO();

    public CMEstadoBL(){}

    public List<CMEstadoDTO> getAll() throws Exception{
        List<CMEstadoDTO> lst = cmeDAO.readAll();
        //for (CMEstadoDTO cmeDTO : lst) 
        //    cmeDTO.setNombre(cmeDTO.getNombre().toUpperCase());
        return lst;
    }
    public CMEstadoDTO getBy(int idEstado) throws Exception{
        cmedto = cmeDAO.readBy(idEstado);
        return cmedto;
    }
    public boolean add(CMEstadoDTO cmeDTO) throws Exception{   
        return cmeDAO.create(cmeDTO);
    }
    public boolean update(CMEstadoDTO cmeDTO) throws Exception{
        return cmeDAO.update(cmeDTO);
    }
    public boolean delete(int idEstado) throws Exception{
        return cmeDAO.delete(idEstado);
    }
    public Integer getRowCount() throws Exception{
        return cmeDAO.getMaxRow();
    }
}
