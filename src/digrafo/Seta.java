package digrafo;

public class Seta {

    
    protected Vertice origem;
    protected Vertice destino;

    /**
     * @param origem
     * @param destino
     */
    public Seta(Vertice origem, Vertice destino) {
        this.origem = origem;
        this.destino = destino;
    }

    
    public Vertice getOrigem() {
        return origem;
    }
    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }
    public Vertice getDestino() {
        return destino;
    }
    public void setDestino(Vertice destino) {
        this.destino = destino;
    }
    

    
}
