package BusinessLogic;

import DataAccess.CMSexoDAO;
import DataAccess.DTO.CMSexoDTO;
import java.util.List;



public class CMSexoBL {
    private CMSexoDTO sexo;
    private CMSexoDAO sDAO = new CMSexoDAO();

    public CMSexoBL(){}

    public List<CMSexoDTO> getAll() throws Exception{
        List<CMSexoDTO> lst = sDAO.readAll();
        for (CMSexoDTO cmsexoDTO : lst) 
            cmsexoDTO.setNombre(cmsexoDTO.getNombre().toUpperCase());
        return lst;
    }
    public CMSexoDTO getBy(int idSexo) throws Exception{
        sexo = sDAO.readBy(idSexo);
        return sexo;
    }
    public boolean add(CMSexoDTO sexoDTO) throws Exception{   
        return sDAO.create(sexoDTO);
    }
    public boolean update(CMSexoDTO sexoDTO) throws Exception{
        return sDAO.update(sexoDTO);
    }
    public boolean delete(int idSexo) throws Exception{
        return sDAO.delete(idSexo);
    }
    public Integer getRowCount() throws Exception{
        return sDAO.getMaxRow();
    }
}
