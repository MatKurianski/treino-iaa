/* 
  NOTA: Implementação dos algoritmos pedidos está em GPS e GPSGuloso.
*/

public class Main {
  public static void main(String args[]) {
    Mapa m = new Mapa(5);
    
    Ponto partida = new Partida(3, 3);
    Ponto chegada = new Chegada(2, 5);

    m.adicionarPontos(
      partida, 
      chegada,
      new Barreira(3, 4),
      new Barreira(4, 4),
      new Barreira(2, 3),
      new Barreira(2, 4),
      new Barreira(1, 5),
      new Barreira(4, 2),
      new Barreira(4, 3)
    );
    
    /*
      Escolher um ou outro abaixo!
    */

    // GPS.encontrarCaminho(m, partida);
    GPS_cache.encontrarCaminho(m, partida);
    m.imprimirMapa();
  }
}
