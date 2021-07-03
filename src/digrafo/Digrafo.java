package digrafo;
import java.util.ArrayList;

/**
 * 
 */
public class Digrafo {

    protected Vertice raiz;

    protected Vertice atual;

    protected Vertice fim;

    protected ArrayList<Vertice> vertices;

    protected ArrayList<Seta> caminhos;


    

    public void setRaiz(Vertice raiz) {
        this.raiz = raiz;
    }

    public void setFim(Vertice fim){
        this.fim = fim;
    }

    public Vertice getFim(){
        return this.fim;
    }

    public Digrafo(Vertice raiz){
        this.raiz = raiz;
        this.atual = raiz;
        this.vertices = new ArrayList<Vertice>();
        this.vertices.add(raiz);
                       
    }

    public Digrafo(){
        this.raiz = null;
        this.atual = null;
        this.vertices = null;
        this.caminhos = null;
    }

    /**
     * Adiciona um vertice como prox no digrafo, desconsidera caminhos
     * @param v
     */
    public void addProxVertice(Vertice v){

        // Caso ainda n tenha sido inicializado, inicializa
        if(this.raiz == null){
            this.raiz = v;
            this.atual = v;
            this.vertices = new ArrayList<Vertice>();
            this.vertices.add(v);
        }
        // Adiciona assumindo inicializado
        else{
            Seta novaSeta = new Seta(this.atual, v);
            this.atual = v;
            this.vertices.add(v);
            if(this.caminhos == null){
                this.caminhos = new ArrayList<Seta>();
                this.caminhos.add(novaSeta);
            } else 
            {
                this.caminhos.add(novaSeta);
            }
        }

    }

    public void addVerticeLimbo(Vertice v){
        // Caso ainda n tenha sido inicializado, inicializa
        if(this.raiz == null){
            this.raiz = v;
            this.atual = v;
        }
        // Adiciona assumindo inicializado
        else{
            this.vertices.add(v);
        }
    }

    /**
     * Retorna um vertice dado seu id por referencia
     * @param id o id do vertice
     * @return o Vertice
     * @throws Error se o vertice foi encontrado ou nao
     */
    public Vertice getVerticeById(int id) throws Exception{

        for(Vertice v: this.vertices){
            if(v.id == id){
                return this.vertices.get(this.vertices.indexOf(v));
            }
        }
        throw new Exception("Vertice inexistente");

    }

    public void setRaizById(int id) throws Error{
        for(Vertice v: this.vertices){
            if(v.getId() == id){
                this.raiz = v;
                return;
            }
        }
        throw new Error("Vertice nao encontrado");
    }

    public void printDigrafo(Vertice v){
        v.print();
        while(proximo(v) != null){
            printDigrafo(proximo(v));
        }
    }


    public Vertice proximo(Vertice origem){
        try{
            return findArestaByOrigem(origem).destino;
        }catch(Exception e){
            return null;
        }
            
    }

    public Seta findArestaByOrigem(Vertice origem) throws Exception{
        for(Seta s: this.caminhos){
            if(s.origem == origem){
                return s;
            }
        }
        throw new Exception("Nao existe essa origem");
    }

    public Seta findArestaByDestino(Vertice destino) throws Error{
        for(Seta s: this.caminhos){
            if(s.destino == destino){
                return s;
            }
        }
        throw new Error("Nao existe esse destino");
    }

    public ArrayList<Seta> getCaminhos() {
        return caminhos;
    }

    public void setCaminhos(ArrayList<Seta> caminhos) {
        this.caminhos = caminhos;
    }
    
    public void addCaminho(Seta s){
        this.caminhos.add(s);
    }

    public Vertice getRaiz() {
        return raiz;
    }

    public ArrayList<Vertice> verticesVizinhos(Vertice v){
        ArrayList<Vertice> vizinhos = new ArrayList<Vertice>();

        for(Seta s: this.caminhos){
            if(s.origem == v){
                vizinhos.add(s.destino);
            }
        }

        return vizinhos;


    }
}


