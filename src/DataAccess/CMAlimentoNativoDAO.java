package DataAccess;

import DataAccess.DTO.CMAlimentoNativoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CMAlimentoNativoDAO extends CMSQLiteDataHelper implements IDAO<CMAlimentoNativoDTO> {

    @Override
    public boolean create(CMAlimentoNativoDTO entity) throws Exception {
                //  (8                   ,'Carnivoro'        , 'Alimento de origen animal'
        String query = " INSERT INTO CMCatalogoAlimento (IdCMCatalogo ,Nombre ,Descripcion ) VALUES (?,?,?)";
        try {
            Connection        conn  = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 8);   //
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
    public List<CMAlimentoNativoDTO> readAll() throws Exception {
        List <CMAlimentoNativoDTO> lst = new ArrayList<>();
        String query =" SELECT IdCMCatalogoAlimento   "
                     +" ,IdCMCatalogo     "
                     +" ,Nombre             "
                     +" ,Descripcion        "
                     +" ,Estado             "
                     +" ,FechaCreacion      "
                     +" ,FechaModifica      "
                     +" FROM    CMCatalogoAlimento    "
                     +" WHERE   Estado ='A' "
                     +" AND   IdCMCatalogo = 8 ";  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                CMAlimentoNativoDTO s = new CMAlimentoNativoDTO( rs.getInt(1)     // IdCatalogo
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
    public boolean update(CMAlimentoNativoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE CMCatalogoAlimento SET Nombre = ?, Descripcion = ?, FechaModifica = ? WHERE IdCMCatalogoAlimento = ?";
        try {
            Connection          conn = openConnection();
            PreparedStatement pstmt  = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getDescripcion());
            pstmt.setString(3, dtf.format(now).toString());
            pstmt.setInt(4, entity.getIdCMCatalogoAlimento());
            pstmt.executeUpdate();
            return true;
        } 
        catch (SQLException e) {
            throw e;// new PatException(e.getMessage(), getClass().getName(), "update()");
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = " UPDATE CMCatalogoAlimento SET Estado = ? WHERE IdCMCatalogoAlimento = ?";
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
    public CMAlimentoNativoDTO readBy(Integer id) throws Exception {
        CMAlimentoNativoDTO s = new CMAlimentoNativoDTO();
        String query =" SELECT IdCMCatalogoAlimento   "
                     +" ,IdCMCatalogo     "
                     +" ,Nombre             "
                     +" ,Descripcion        "
                     +" ,Estado             "
                     +" ,FechaCreacion      "
                     +" ,FechaModifica      "
                     +" FROM    CMCatalogoAlimento    "
                     +" WHERE   Estado ='A' "
                     +" AND     IdCMCatalogo = 8"
                     +" AND     IdCMCatalogoAlimento = " + id.toString();  
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet  rs   = stmt.executeQuery(query);    // ejecutar la
            while (rs.next()) {
                s = new CMAlimentoNativoDTO( rs.getInt(1)     // IdCatalogo
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
                     +" FROM    CMCatalogoAlimento         "
                     +" WHERE   Estado ='A'      "
                     +" AND     IdCMCatalogo = 8";
        try {
            Connection conn = openConnection();         // conectar a DB     
            Statement  stmt = conn.createStatement();   // CRUD : select * ...    
            ResultSet rs   = stmt.executeQuery(query);  // ejecutar la
            while (rs.next()) {
                return rs.getInt(1);                    // TotalReg
            }
        } 
        catch (SQLException e) {
            throw e; //new PatException(e.getMessage(), getClass().getName(), "getMaxRow()");
        }
        return 0;
    }
    

}
