package DataAccess;

import DataAccess.DTO.CMEstadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CMEstadoDAO extends CMSQLiteDataHelper implements IDAO<CMEstadoDTO>{

    @Override
    public boolean create(CMEstadoDTO entity) throws Exception {
        //  (1    ,5   ,2    ,6     ,4)
        String query = " INSERT INTO CMHormiga (IdCMHormigaTipo,IdCMSexo,IdCMCatalogoProvincia,IdCMCatalogoModificado,IdCMCatalogoNativo) VALUES (?,?,?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdCMHormigaTipo());   //
            pstmt.setInt(2, entity.getIdCMSexo());
            pstmt.setInt(3, entity.getIdCMCatalogoProvincia());
            pstmt.setInt(4, entity.getIdCMCatalogoModificado());
            pstmt.setInt(5, entity.getIdCMCatalogoNativo());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  //new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<CMEstadoDTO> readAll() throws Exception {
        List <CMEstadoDTO> lst = new ArrayList<>();
        String query ="  SELECT IdCMHormiga   "
                     +" ,IdCMHormigaTipo     "
                     +" ,IdCMSexo             "
                     +" ,IdCMCatalogoProvincia        "
                     +" ,IdCMCatalogoModificado             "
                     +" ,IdCMCatalogoNativo             "
                     +" ,Estado             "
                     +" ,FechaCreacion      "
                     +" ,FechaModifica      "
                     +"  FROM    CMHormiga    "
                     +"  WHERE   Estado ='A' "
                     +"  AND IdCMHormigaTipo IN (1,2,3,4)";  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                CMEstadoDTO s = new CMEstadoDTO( rs.getInt(1)     // IdCatalogo
                                        ,rs.getInt(2)     // IdCatalogoTipo             
                                        ,rs.getInt(3)   // Nombre         
                                        ,rs.getInt(4)   // Descripcion      
                                        ,rs.getInt(5)   // Estado
                                        ,rs.getInt(6)   // FechaCreacion
                                        ,rs.getString(7) // FechaModifica
                                        ,rs.getString(8) // FechaModifica
                                        ,rs.getString(9));// FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean update(CMEstadoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CMHormiga SET Estado = ?, FechaModifica = ? WHERE IdCMHormiga = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getEstado());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCMHormiga());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }       
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CMHormiga SET Estado = ? WHERE IdCMHormiga = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public CMEstadoDTO readBy(Integer id) throws Exception {
        CMEstadoDTO s = new CMEstadoDTO();
        String query ="  SELECT IdCMHormiga   "
                     +" ,IdCMHormigaTipo     "
                     +" ,IdCMSexo             "
                     +" ,IdCMCatalogoProvincia        "
                     +" ,IdCMCatalogoModificado             "
                     +" ,IdCMCatalogoNativo             "
                     +" ,Estado             "
                     +" ,FechaCreacion      "
                     +" ,FechaModifica      "
                     +"  FROM    CMHormiga    "
                     +"  WHERE   Estado ='A' "
                     +" AND     IdCMHormiga = " + id.toString();  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                s = new CMEstadoDTO( rs.getInt(1)     // IdCatalogo
                    	            ,rs.getInt(2)     // IdCatalogoTipo             
                    	            ,rs.getInt(3)   //         
                    	            ,rs.getInt(4)   // Descripcion      
                    	            ,rs.getInt(5)   // Estado
                    	            ,rs.getInt(6)   // FechaCreacion
                    	            ,rs.getString(7) // FechaModifica
                    	            ,rs.getString(8) // FechaModifica
                    	            ,rs.getString(9));// FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return s; 
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query =" SELECT COUNT(*) TotalReg "
                     +" FROM    CMHormiga         "
                     +" WHERE   Estado ='A'      "
                     +" AND     IdCMHormigaTipo IN (1,2,3,4)";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e;//new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
    

}
