package BusinessLogic;

import DataAccess.CMProvinciaDAO;
import DataAccess.DTO.CMProvinciaDTO;
import java.util.List;

public class CMProvinciaBL {
    private CMProvinciaDTO cmpdto;
    private CMProvinciaDAO cmpDAO = new CMProvinciaDAO();

    public CMProvinciaBL(){}

    public List<CMProvinciaDTO> getAll() throws Exception{
        List<CMProvinciaDTO> lst = cmpDAO.readAll();
        for (CMProvinciaDTO cmpDTO : lst) 
            cmpDTO.setNombre(cmpDTO.getNombre().toUpperCase());
        return lst;
    }
    public CMProvinciaDTO getBy(int idProvincia) throws Exception{
        cmpdto = cmpDAO.readBy(idProvincia);
        return cmpdto;
    }
    public boolean add(CMProvinciaDTO cmpDTO) throws Exception{   
        return cmpDAO.create(cmpDTO);
    }
    public boolean update(CMProvinciaDTO cmpDTO) throws Exception{
        return cmpDAO.update(cmpDTO);
    }
    public boolean delete(int idProvincia) throws Exception{
        return cmpDAO.delete(idProvincia);
    }
    public Integer getRowCount() throws Exception{
        return cmpDAO.getMaxRow();

    }
}
