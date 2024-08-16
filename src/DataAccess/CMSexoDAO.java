package DataAccess;

import DataAccess.DTO.CMSexoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;




public class CMSexoDAO extends CMSQLiteDataHelper implements IDAO<CMSexoDTO>{

    @Override
    public boolean create(CMSexoDTO entity) throws Exception {
        String query = " INSERT INTO CMCatalogo (IdCMCatalogoTipo ,Nombre ,Descripcion ) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 2);
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;//(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<CMSexoDTO> readAll() throws Exception {
        List <CMSexoDTO> lst = new ArrayList<>();
        String query =" SELECT ROW_NUMBER () OVER ( ORDER BY IdCMCatalogo ) RowNum "
                     +" ,IdCMCatalogo         "
                     +" ,IdCMCatalogoTipo     "
                     +" ,Nombre             "
                     +" ,Descripcion        "
                     +" ,Estado             "
                     +" ,FechaCreacion      "
                     +" ,FechaModifica      "
                     +" FROM    CMCatalogo    "
                     +" WHERE   Estado ='A' "
                     +" AND   IdCMCatalogoTipo = 2 ";  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                CMSexoDTO s = new CMSexoDTO( 
                                        rs.getInt(1)     // RowNum
                                        ,rs.getInt(2)     // IdCatalogo
                                        ,rs.getInt(3)     // IdCatalogoTipo             
                                        ,rs.getString(4)  // Nombre         
                                        ,rs.getString(5)  // Descripcion      
                                        ,rs.getString(6)  // Estado
                                        ,rs.getString(7)  // FechaCreacion
                                        ,rs.getString(8));// FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            //throw new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean update(CMSexoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CMCatalogo SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCMCatalogo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCMCatalogo());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CMCatalogo SET Estado = ? WHERE IdCMCatalogo = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement  pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;//new PatException(e.getMessage(), getClass().getName(), "delete()");
        }
    }

    @Override
    public CMSexoDTO readBy(Integer id) throws Exception {
        CMSexoDTO s = new CMSexoDTO();
        String query = 
         " SELECT RowNum            "
        +"     ,IdCMCatalogo          "
        +"     ,IdCMCatalogoTipo      "
        +"     ,Nombre              "
        +"     ,Descripcion         "
        +"     ,Estado              "
        +"     ,FechaCreacion       "
        +"     ,FechaModifica       "
        +" FROM (                   "
        +"     SELECT ROW_NUMBER() OVER (ORDER BY IdCMCatalogo) AS RowNum "
        +"         ,IdCMCatalogo      "
        +"         ,IdCMCatalogoTipo  "   
        +"         ,Nombre          "
        +"         ,Descripcion     "   
        +"         ,Estado          "
        +"         ,FechaCreacion   "       
        +"         ,FechaModifica   "   
        +"     FROM CMCatalogo        "
        +"     WHERE Estado = 'A'   "
        +"     AND IdCMCatalogoTipo = 2 "
        +" ) sub                    "
        +" WHERE RowNum = " + id.toString();  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            System.out.println(query);
            while (rs.next()) {
                s = new CMSexoDTO( 
                                rs.getInt(1)     // RowNum
                                ,rs.getInt(2)     // IdCatalogo
                                ,rs.getInt(3)     // IdCatalogoTipo             
                                ,rs.getString(4)  // Nombre         
                                ,rs.getString(5)  // Descripcion      
                                ,rs.getString(6)  // Estado
                                ,rs.getString(7)  // FechaCreacion
                                ,rs.getString(8));// FechaModifica
            }
        } 
        catch (SQLException e) {
            throw e;//new PatException(e.getMessage(), getClass().getName(), "readBy()");
        }
        return s; 
    }

    @Override
    public Integer getMaxRow() throws Exception {
        String query =" SELECT COUNT(*) TotalReg "
                     +" FROM    CMCatalogo         "
                     +" WHERE   Estado ='A'      "
                     +" AND     IdCMCatalogoTipo = 2";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e;//new PatException(e.getMessage(), getClass().getName(), "getRowCount()");
        }
        return 0;
    }
    

}
