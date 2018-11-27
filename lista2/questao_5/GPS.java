class GPS {
  public static void encontrarCaminho(Mapa objetoMapa, Ponto partida) {
    int linha = partida.getLinha();
    int coluna = partida.getColuna();
    visitaNormal(objetoMapa.Mapa, linha, coluna);
  }

  private static boolean visitaNormal(char[][] mapa, int lin, int col) {
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

      if(visitaNormal(mapa, lin+1, col)) return true;
      if(visitaNormal(mapa, lin-1, col)) return true;
      if(visitaNormal(mapa, lin, col+1)) return true;
      if(visitaNormal(mapa, lin, col-1)) return true;

      if(posicao != 'P') mapa[lin][col] = '.';
      
      return false;
    } catch(ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}