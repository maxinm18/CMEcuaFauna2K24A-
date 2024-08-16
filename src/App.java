import DataAccess.CMProvinciaDAO;
import DataAccess.DTO.CMProvinciaDTO;

public class App {
    public static void main(String[] args) throws Exception {
        /*try {
            CMHormigaTipoDAO CMHT = new CMHormigaTipoDAO();
            for(CMHormigaTipoDTO s : CMHT.readAll())
            System.out.println(s.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        /*
        try {
            CMSexoDAO CMS = new CMSexoDAO();
            for(CMSexoDTO s : CMS.readAll())
            System.out.println(s.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
        /*
        try {
            CMAlimentoNativoDAO CMS = new CMAlimentoNativoDAO();
            for(CMAlimentoNativoDTO s : CMS.readAll())
            System.out.println(s.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
        try {
            CMProvinciaDAO h = new CMProvinciaDAO();
            for(CMProvinciaDTO s : h.readAll())
            System.out.println(s.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
