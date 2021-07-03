import arquivo.LeitorArquivo;
import busca.DFS;
import digrafo.Digrafo;
import digrafo.Vertice;

public class App {
    public static void main(String[] args) throws Exception {
        //String input = "5\n Quest 1  \n Primeira quest \n Quest 2 \n Segunda quest \n Quest 3 \n q3 \n Quest 4 \n q4 \n Quest 5 \n q5 \n5\n0 1\n0 2\n1 3\n2 3\n3 4\n0";
        Digrafo d = LeitorArquivo.init();
        DFS df = new DFS();
        df.dfs(d, d.getRaiz());
        for(Vertice v: df.getCaminho()){
            v.print();
        }
    }
}

