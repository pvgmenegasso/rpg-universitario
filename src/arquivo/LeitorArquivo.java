package arquivo;
import java.util.Scanner;

import digrafo.Digrafo;
import digrafo.Seta;
import digrafo.Vertice;

public class LeitorArquivo {
    public static Digrafo init() {


        Digrafo d = new Digrafo();

        Scanner sc = new Scanner(System.in);
        System.out.println("Lendo System.in .... \n");


        int nv = 0;
        int na = 0;

        if(sc.hasNextLine()){
            // Na primeira linha, le numero de vertices:
            String temp = sc.nextLine();
            nv = Integer.parseInt(temp);
        }

        Vertice temp = new Vertice();

        for(int i = 0; i<nv; i++){
            // Le nome e descricao da quest nV vezes
            String nQuest = sc.nextLine();
            String dQuest = sc.nextLine();
            Vertice novo = new Vertice(nQuest, dQuest);
            temp = novo;
            d.addProxVertice(novo);
        }

        d.setFim(temp);

        if(sc.hasNextLine()){
            // Le o numero de arestas
            String temps = sc.nextLine();
            na = Integer.parseInt(temps);
        }

        for(int i = 0; i<na; i++){

            // Le as ids origem e destino
            int idOrigem;
            int idDestino;
            idOrigem = sc.nextInt();
            idDestino = sc.nextInt();
            
            sc.nextLine();

            // Aqui supomos que retorna o elemento em si e nao copia
            Vertice tempOrigem;
            Vertice tempDestino;
            try {
                tempOrigem = d.getVerticeById(idOrigem);
                tempDestino = d.getVerticeById(idDestino);
                d.addCaminho(new Seta(tempOrigem, tempDestino));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            

            
        }

        // Seta a raíz como o ultimo id lido
        int tempi = sc.nextInt();
        d.setRaizById(tempi);

        sc.close();

        return d;
    }
}
