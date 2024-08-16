import BusinessLogic.CMSexoBL;
import DataAccess.DTO.CMSexoDTO;

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
         /*
        try {
            CMProvinciaDAO h = new CMProvinciaDAO();
            for(CMProvinciaDTO s : h.readAll())
            System.out.println(s.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            */
        try {
            CMProvinciaBL pbl =  new CMProvinciaBL();
            pbl.add(new CMProvinciaDTO(0, 0, 0, "Nuevo sexo", "prueba",
            null, null, null));
            for(CMSexoDTO s : sbl.getAll())
            System.out.println(s.toString());
        } catch (Exception e) {
        System.out.println(e.getMessage());
        }
    }
}
