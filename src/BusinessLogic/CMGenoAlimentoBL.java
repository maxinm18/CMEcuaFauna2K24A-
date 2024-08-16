package BusinessLogic;

import DataAccess.CMGenoAlimentoDAO;
import DataAccess.DTO.CMGenoAlimentoDTO;
import java.util.List;

public class CMGenoAlimentoBL {
    private CMGenoAlimentoDTO cmgadto;
    private CMGenoAlimentoDAO cmgaDAO = new CMGenoAlimentoDAO();

    public CMGenoAlimentoBL(){}

    public List<CMGenoAlimentoDTO> getAll() throws Exception{
        List<CMGenoAlimentoDTO> lst = cmgaDAO.readAll();
        for (CMGenoAlimentoDTO cmgaDTO : lst) 
            cmgaDTO.setNombre(cmgaDTO.getNombre().toUpperCase());
        return lst;
    }
    public CMGenoAlimentoDTO getBy(int idAlimento) throws Exception{
        cmgadto = cmgaDAO.readBy(idAlimento);
        return cmgadto;
    }
    public boolean add(CMGenoAlimentoDTO cmgaDTO) throws Exception{   
        return cmgaDAO.create(cmgaDTO);
    }
    public boolean update(CMGenoAlimentoDTO cmgaDTO) throws Exception{
        return cmgaDAO.update(cmgaDTO);
    }
    public boolean delete(int idAlimento) throws Exception{
        return cmgaDAO.delete(idAlimento);
    }
    public Integer getMaxCount() throws Exception{
        return cmgaDAO.getMaxRow();
    }
}
