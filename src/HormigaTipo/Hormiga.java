package HormigaTipo;

public abstract class Hormiga implements IHormiga {
    private int cmHormiga;
    private String cmHormigaTipo;

    public Hormiga(int idCMHormiga, String hormigaTipo) {
        this.IdCMHormiga = idCMHormiga;
        this.HormigaTipo = hormigaTipo;
    }

    public int getIdCMHormiga() {
        return IdCMHormiga;
    }

    public void setIdCMHormiga(int idCMHormiga) {
        IdCMHormiga = idCMHormiga;
    }

    public String getHormigaTipo() {
        return HormigaTipo;
    }

    public void setHormigaTipo(String hormigaTipo) {
        HormigaTipo = hormigaTipo;
    }

    // Implementación de comer() será definida por las subclases
    public abstract boolean comer(Alimento alimento);


import HormigaComportamiento.IHormiga;
}
