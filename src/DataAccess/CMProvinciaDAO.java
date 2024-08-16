package DataAccess;

import DataAccess.DTO.CMProvinciaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CMProvinciaDAO extends CMSQLiteDataHelper implements IDAO<CMProvinciaDTO>{

    @Override
    public boolean create(CMProvinciaDTO entity) throws Exception {
        //   1                   ,'Esmeraldas'           ,'Provincia de la Costa'
        String query = " INSERT INTO CMCatalogoProvincia (IdCMCatalogoRegion ,Nombre ,Descripcion ) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdCMCatalogoRegion());   //
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getDescripcion());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;  //new PatException(e.getMessage(), getClass().getName(), "create()");
        }
    }

    @Override
    public List<CMProvinciaDTO> readAll() throws Exception {
        List <CMProvinciaDTO> lst = new ArrayList<>();
        String query =" SELECT IdCMCatalogoProvincia   "
                     +" ,IdCMCatalogoRegion     "
                     +" ,Nombre             "
                     +" ,Descripcion        "
                     +" ,Estado             "
                     +" ,FechaCreacion      "
                     +" ,FechaModifica      "
                     +" FROM    CMCatalogoProvincia    "
                     +" WHERE   Estado ='A' "
                     +" AND   IdCMCatalogoRegion IN (1,2,3,4) ";  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                CMProvinciaDTO s = new CMProvinciaDTO( rs.getInt(1)     // IdCatalogo
                                        ,rs.getInt(2)     // IdCatalogoTipo             
                                        ,rs.getString(3)  // Nombre         
                                        ,rs.getString(4)  // Descripcion      
                                        ,rs.getString(5)  // Estado
                                        ,rs.getString(6)  // FechaCreacion
                                        ,rs.getString(7));// FechaModifica
                lst.add(s);
            }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "readAll()");
        }
        return lst; 
    }

    @Override
    public boolean update(CMProvinciaDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CMCatalogoProvincia SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCMCatalogoProvincia = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCMCatalogoProvincia());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CMCatalogoProvincia SET Estado = ? WHERE IdCMCatalogoProvincia = ?";
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
    public CMProvinciaDTO readBy(Integer id) throws Exception {
        CMProvinciaDTO s = new CMProvinciaDTO();
        String query =" SELECT IdCMCatalogoProvincia   "
                     +" ,IdCMCatalogoRegion     "
                     +" ,Nombre             "
                     +" ,Descripcion        "
                     +" ,Estado             "
                     +" ,FechaCreacion      "
                     +" ,FechaModifica      "
                     +" FROM    Catalogo    "
                     +" WHERE   Estado ='A' "
                     +" AND     IdCMCatalogoProvincia IN (1,2,3,4)"
                     +" AND     IdCMCatalogoProvincia = " + id.toString();  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                s = new CMProvinciaDTO( rs.getInt(1)     // IdCatalogo
                                ,rs.getInt(2)     // IdCatalogoTipo             
                                ,rs.getString(3)  // Nombre         
                                ,rs.getString(4)  // Descripcion      
                                ,rs.getString(5)  // Estado
                                ,rs.getString(6)  // FechaCreacion
                                ,rs.getString(7));// FechaModifica
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
                     +" FROM    CMCatalogoProvincia         "
                     +" WHERE   Estado ='A'      "
                     +" AND     IdCMCatalogoRegion IN (1,2,3,4)";
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
