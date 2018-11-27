class GPS_cache {

  private static char[][] melhorMapa;
  private static int passosMinimos;

  public static void encontrarCaminho(Mapa objetoMapa, Ponto partida) {
    int linha = partida.getLinha();
    int coluna = partida.getColuna();
    passosMinimos = -1;
    visitaNormal(objetoMapa.Mapa, linha, coluna, 0);
    if(passosMinimos != -1) {
      objetoMapa.Mapa = melhorMapa;
      System.out.println("Melhor rota encontrada com sucesso!\n");
    }
  }

  public static char[][] copiarMapa(char[][] mapa) {
    char[][] novoMapa = new char[mapa.length][mapa[0].length];
    for(int i = 0; i < mapa.length; i++) {
      for(int j = 0; j < mapa[0].length; j++) {
        novoMapa[i][j] = mapa[i][j];
      }
    }
    return novoMapa;
  }

  private static void visitaNormal(char[][] mapa, int lin, int col, int passos) {
    if(lin > mapa.length-1 || col > mapa.length-1 || lin < 0 || col < 0) return;

    char posicao = mapa[lin][col];
      if(posicao == 'C') {
        if(passosMinimos > passos || passosMinimos == -1) {
          passosMinimos = passos;
          melhorMapa = copiarMapa(mapa);
        }
        return;
      } else if(posicao == 'X' || posicao == '#') return;
        else if(posicao == 'P' && passos != 0) return;
        else if(posicao != 'P') {
          mapa[lin][col] = '#';
          passos++;
        }
      
      visitaNormal(mapa, lin, col-1, passos);
      visitaNormal(mapa, lin+1, col, passos);
      visitaNormal(mapa, lin, col+1, passos);
      visitaNormal(mapa, lin-1, col, passos);
      
      if(posicao != 'P') mapa[lin][col] = '.';
  }
}