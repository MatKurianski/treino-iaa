/* 
  NOTA: Implementação dos algoritmos pedidos está em GPS e GPSGuloso.
*/

public class Main {
  public static void main(String args[]) {
    Mapa m = new Mapa(6);
    
    Ponto partida = new Partida(1, 1);
    Ponto chegada = new Chegada(6, 6);

    m.adicionarPontos(
      partida, 
      chegada,
      new Barreira(3, 3),
      new Barreira(1, 3),
      new Barreira(1, 3),
      new Barreira(4, 2),
      new Barreira(2, 5),
      new Barreira(4, 5),
      new Barreira(5, 4),
      new Barreira(5, 5),
      new Barreira(6, 5)
    );
    
    /*
      Escolher um ou outro abaixo!
    */

    GPS.encontrarCaminho(m, partida);
    
    m.imprimirMapa();
  }
}
