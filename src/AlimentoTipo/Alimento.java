package AlimentoTipo;

public abstract class Alimento {
    protected String tipo;

    public Alimento(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString(){
        return tipo;
    }
}
