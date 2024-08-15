package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import DataAccess.DTO.CMSexoDTO;

public class CMSexoDAO extends CMSQLiteDataHelper implements IDAO<CMSexoDTO>{

    @Override
    public boolean create(CMSexoDTO entity) throws Exception {
        //  'Masculino'   ,'tipos de sexualida'
        String query = " INSERT INTO CMSexo (IdCatalogoTipo ,Nombre ,Descripcion ) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<CMSexoDTO> readAll() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAll'");
    }

    @Override
    public boolean update(CMSexoDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CMSexoDTO readBy(Integer id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readBy'");
    }

}
