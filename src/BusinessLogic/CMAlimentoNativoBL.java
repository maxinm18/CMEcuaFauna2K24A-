package BusinessLogic;

import DataAccess.CMAlimentoNativoDAO;
import DataAccess.DTO.CMAlimentoNativoDTO;
import java.util.List;

public class CMAlimentoNativoBL {
    private CMAlimentoNativoDTO cmandto;
    private CMAlimentoNativoDAO cmanDAO = new CMAlimentoNativoDAO();

    public CMAlimentoNativoBL(){}

    public List<CMAlimentoNativoDTO> getAll() throws Exception{
        List<CMAlimentoNativoDTO> lst = cmanDAO.readAll();
        for (CMAlimentoNativoDTO cmanDTO : lst) 
            cmanDTO.setNombre(cmanDTO.getNombre().toUpperCase());
        return lst;
    }
    public CMAlimentoNativoDTO getBy(int idAlimento) throws Exception{
        cmandto = cmanDAO.readBy(idAlimento);
        return cmandto;
    }
    public boolean add(CMAlimentoNativoDTO cmanDTO) throws Exception{   
        return cmanDAO.create(cmanDTO);
    }
    public boolean update(CMAlimentoNativoDTO cmanDTO) throws Exception{
        return cmanDAO.update(cmanDTO);
    }
    public boolean delete(int idAlimento) throws Exception{
        return cmanDAO.delete(idAlimento);
    }
    public Integer getMaxCount() throws Exception{
        return cmanDAO.getMaxRow();
    }
}
