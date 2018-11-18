public class Main {
  public static void main(String args[]) {
    Mapa m = new Mapa(6);
    
    Ponto partida = new Partida(4, 3);
    Ponto chegada = new Chegada(5, 1);

    m.adicionarPontos(
      partida, 
      chegada,
      new Barreira(3, 3),
      new Barreira(1, 3),
      new Barreira(6, 6),
      new Barreira(1, 3),
      new Barreira(4, 2),
      new Barreira(2, 5),
      new Barreira(4, 5),
      new Barreira(5, 4)
    );
    encontrarCaminho(m, partida);
    m.imprimirMapa();
  }

  /*
    NOTA: É a questão 5, logo, sem otimização nenhuma.
  */

  public static void encontrarCaminho(Mapa objetoMapa, Ponto partida) {
    int linha = partida.getLinha();
    int coluna = partida.getColuna();
    visita(objetoMapa.Mapa, linha, coluna, "");
  }
  
  public static boolean visita(char[][] mapa, int lin, int col, String ultimoMovimento) {
    char posicao;
    
    try {
      posicao = mapa[lin][col];
      if(posicao == 'C') {
        System.out.println("Sucesso!\n");
        return true;
      }

      if(posicao == 'X' || posicao == '#') return false;
      if(posicao != 'P') mapa[lin][col] = '#';

      // Abaixo, o movimento está programado para nunca retroceder um passo
      // pois, caso necessário, o próprio Backtracking da recursão retrocede.

      if(!ultimoMovimento.equals("baixo")) {
        if(visita(mapa, lin-1, col, "cima")) return true;
      }
      if(!ultimoMovimento.equals("direita")) {
        if(visita(mapa, lin, col-1, "esquerda")) return true;
      }
      if(!ultimoMovimento.equals("esquerda")) {
        if(visita(mapa, lin, col+1, "direita")) return true;
      }
      if(!ultimoMovimento.equals("cima")) {
        if(visita(mapa, lin+1, col, "baixo")) return true;
      }

      if(posicao != 'P') mapa[lin][col] = '.';
      
      return false;
    } catch(ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}
