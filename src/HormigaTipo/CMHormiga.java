package HormigaTipo;

import AlimentoTipo.CMAlimento;
import HormigaComportamiento.IHormiga;

public abstract class CMHormiga implements IHormiga {

    protected String tipo;
    
    public CMHormiga(String tipo){
        this.tipo = tipo;
    }
    @Override
    public boolean comer(CMAlimento alimento){
        if(alimento != null && (alimento.equals("carnivoro") || alimento.equals("hervivoro"))){
            return true;
        }else{
            return false;

        }
        
    }
}