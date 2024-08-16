import DataAccess.CMHormigaTipoDAO;
import DataAccess.DTO.CMHormigaTipoDTO;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            CMHormigaTipoDAO CMHT = new CMHormigaTipoDAO();
            for(CMHormigaTipoDTO s : CMHT.readAll())
            System.out.println(s.toString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
