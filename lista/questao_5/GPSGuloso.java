class GPSGuloso {
  public static void encontrarCaminho(Mapa objetoMapa, Ponto partida, Ponto chegada) {
    int linha = partida.getLinha();
    int coluna = partida.getColuna();
    visitaGuloso(objetoMapa.Mapa, linha, coluna, "", chegada);
  }

  private static boolean visitaGuloso(char[][] mapa, int lin, int col, String ultimoMovimento, Ponto chegada) {
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

      if(!ultimoMovimento.equals("baixo") && lin >= chegada.getLinha()) {
        if(visitaGuloso(mapa, lin-1, col, "cima", chegada)) return true;
      }
      if(!ultimoMovimento.equals("direita") && col >= chegada.getColuna()) {
        if(visitaGuloso(mapa, lin, col-1, "esquerda", chegada)) return true;
      }
      if(!ultimoMovimento.equals("esquerda") && col <= chegada.getColuna()) {
        if(visitaGuloso(mapa, lin, col+1, "direita", chegada)) return true;
      }
      if(!ultimoMovimento.equals("cima") && lin <= chegada.getLinha()) {
        if(visitaGuloso(mapa, lin+1, col, "baixo", chegada)) return true;
      }

      if(posicao != 'P') mapa[lin][col] = '.';
      
      return false;
    } catch(ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}