package busca;

import java.util.ArrayList;
import java.util.Stack;

import digrafo.Digrafo;
import digrafo.Vertice;

public class DFS {

    protected Stack<Vertice> stack;

    protected ArrayList<Vertice> caminho;

    public DFS(){
        this.stack = new Stack<Vertice>();
        this.caminho = new ArrayList<Vertice>();
    }
    
    public void dfs(Digrafo d, Vertice v){

        if(v == d.getFim()){
            caminho.add(v);
            return;
        }


        // Visitando o v
        v.visita();


        // Coloca na pilha:
        stack.push(v);

        caminho.add(v);

        // Pega os vertices djacentes:
        ArrayList<Vertice> vizinhos = d.verticesVizinhos(v);

        // Remove os visitados da lista

        vizinhos.removeIf(

            vertice -> (
                vertice.getVisitado()
            )

        );

        if(vizinhos.size()!= 0){
            dfs(d, vizinhos.get(0));
        } else {
            dfs(d, stack.pop());
        }
    }

    public ArrayList<Vertice> getCaminho(){
        return this.caminho;
    }
}
