package AlimentoTipo;

public abstract class CMAlimento {
    protected String tipo;

    public CMAlimento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
