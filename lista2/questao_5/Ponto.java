interface Ponto {
  int getLinha();
  int getColuna();
  char getTipo();
}

class Barreira implements Ponto {
  Barreira(int linha, int coluna) {
    this.linha = linha;
    this.coluna = coluna;
  }
  protected int linha;
  protected int coluna;
  protected char tipo = 'X';

  public int getLinha() {
    return this.linha-1;
  }
  public int getColuna() {
    return this.coluna-1;
  }
  public char getTipo() {
    return this.tipo;
  }
}

class Partida implements Ponto {
  Partida(int linha, int coluna) {
    this.linha = linha;
    this.coluna = coluna;
  }
  protected int linha;
  protected int coluna;
  protected char tipo = 'P';

  public int getLinha() {
    return this.linha-1;
  }
  public int getColuna() {
    return this.coluna-1;
  }
  public char getTipo() {
    return this.tipo;
  }
}

class Chegada implements Ponto {
  Chegada(int linha, int coluna) {
    this.linha = linha;
    this.coluna = coluna;
  }
  protected int linha;
  protected int coluna;
  protected char tipo = 'C';

  public int getLinha() {
    return this.linha-1;
  }
  public int getColuna() {
    return this.coluna-1;
  }
  public char getTipo() {
    return this.tipo;
  }
}