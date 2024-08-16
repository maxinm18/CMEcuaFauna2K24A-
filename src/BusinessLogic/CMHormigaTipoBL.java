package BusinessLogic;

import DataAccess.CMHormigaTipoDAO;
import DataAccess.DTO.CMHormigaTipoDTO;
import java.util.List;

public class CMHormigaTipoBL {
    private CMHormigaTipoDTO cmhormigatipo;
    private CMHormigaTipoDAO cmhDAO = new CMHormigaTipoDAO();

    public CMHormigaTipoBL(){}

    public List<CMHormigaTipoDTO> getAll() throws Exception{
        List<CMHormigaTipoDTO> lst = cmhDAO.readAll();
        for (CMHormigaTipoDTO cmhtDTO : lst) 
            cmhtDTO.setNombre(cmhtDTO.getNombre().toUpperCase());
        return lst;
    }
    public CMHormigaTipoDTO getBy(int idHormigaTipo) throws Exception{
        cmhormigatipo = cmhDAO.readBy(idHormigaTipo);
        return cmhormigatipo;
    }
    public boolean add(CMHormigaTipoDTO cmhtDTO) throws Exception{   
        return cmhDAO.create(cmhtDTO);
    }
    public boolean update(CMHormigaTipoDTO cmhtDTO) throws Exception{
        return cmhDAO.update(cmhtDTO);
    }
    public boolean delete(int idHormigaTipo) throws Exception{
        return cmhDAO.delete(idHormigaTipo);
    }
    public Integer getRowCount() throws Exception{
        return cmhDAO.getMaxRow();
    }
}
