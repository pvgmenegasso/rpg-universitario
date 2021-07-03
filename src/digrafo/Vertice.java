package digrafo;

/**
 * Define um vertice de um digrafo
 */
public class Vertice {

    /*
    ______________________________________
    ||                                  ||
    ||        A T R I B U T O S         ||
    ||                                  ||
    --------------------------------------
    */

    // Nome da quest que define este vertice
    protected String nome;
    // Descricao da quest
    protected String descricao;

    // Id da quest
    protected int id;
    // Contador de vertices
    protected static int nVertices = 0;

    // Vertice ja foi visitado ?
    protected boolean visitado;



    /*
    ______________________________________
    ||                                  ||
    ||    C O N S T R U T O R E S       ||
    ||                                  ||
    --------------------------------------
    */
    /**
     * Cria um novo vertice sem arestas de entrada ou saida
     * 
     * @param nome Nome da quest
     * @param descricao Descricao da quest
     */
    public Vertice(String nome, String descricao){

        // Define automaticamente o id.
        this.id = nVertices;

        // A priori nao foi visitado
        this.visitado = false;

        // Incrementa contador global de vertices
        nVertices ++;

        // Define designa parametros
        this.nome = nome;
        this.descricao = descricao;

    }

    public Vertice(){
 
    }



    /*
    ______________________________________
    ||                                  ||
    ||M E T O D O S  A U X I L I A R E S||
    ||                                  ||
    --------------------------------------
    */


    public int getId(){
        return this.id;
    }


    public void print(){
        System.out.println("Quest{ \n");
        System.out.println("    ID= "+this.id+"\n");
        System.out.println("    name= "+this.nome+"\n");
        System.out.println("    description= "+this.descricao+"\n");
        System.out.println("}\n");
    }

    @Override
    public String toString() {
        
        return this.toString();

    }

    public void visita(){
        this.visitado = true;
    }

    public boolean getVisitado(){
        return this.visitado;
    }

    

}
