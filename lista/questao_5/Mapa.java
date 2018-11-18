class Mapa {
  Mapa(int dimensoes) {
    this.Mapa = new char[dimensoes][dimensoes];
    this.inicializarMapa();
  }

  public char[][] Mapa;

  private void inicializarMapa() {
    for(char[] vetor : this.Mapa)
      for(int i = 0; i < vetor.length; i++) vetor[i] = '.';
  }

  public void adicionarPontos(Ponto... args) {
    for(Ponto p : args) Mapa[p.getLinha()][p.getColuna()] = p.getTipo();
  }

  public void imprimirMapa() {
    int contadorL = 1;
    int contadorC = 1;

    System.out.print(" ");
    for(char[] vetor : this.Mapa) {
      System.out.print(" "+contadorC);
      contadorC++;
    }

    System.out.println("");

    for(char[] vetor : this.Mapa) {
      System.out.print(contadorL+" ");
      for(char elemento : vetor)
        System.out.print(elemento+ " ");
      System.out.println("");
      contadorL++;
    }
  }
}