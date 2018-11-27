class Sort {
  
  public static void imprimirArray(int[] array) {
    for(int elemento : array) System.out.print(elemento+" ");
  }

  public static void main(String args[]) {
    SortCollection s = new SortCollection();
    int[] array = {5, 8, 9, 7, 19, 8, 5, 6, 9, 8};
    s.quickSort(array);
    imprimirArray(array);
  }

}

class SortCollection {
  public void quickSort(int[] a) {
    quickSort(a, 0, a.length-1);
  }

	public static void mergeSort(int [] a) {
		mergeSortRec(a, 0, a.length - 1);
  }

  private void quickSort(int[] a, int ini, int fim) {
      if(ini<fim){
          int q = particiona(a, ini, fim);
          quickSort(a, ini, q);
          quickSort(a, q+1, fim);
      }
  }

  private static void mergeSortRec(int [] a, int ini, int fim) {
		if(ini < fim) {
			int med = (ini + fim) / 2;

			mergeSortRec(a, ini, med);
			mergeSortRec(a, med + 1, fim);
			merge(a, ini, med, fim);
		}
	}

  private int particiona (int[] a, int ini, int fim){
    int x = a[ini];
    int i = ini-1;
    int j = fim+1;
    while(true){
        do j--; while(a[j]>x);
        do i++; while(a[i]<x);
        if(i<j){
            int aux = a[i];
            a[i] = a[j];
            a[j] = aux;
        }
        else return j;
    }
  }

  public static void merge(int [] a, int ini, int med, int fim){
		int [] b = new int[fim - ini + 1];
		int i = ini;
		int j = med + 1;
		int k = 0;

		while(i <= med && j <= fim) {
			if(a[i] <= a[j]){
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
			k++;
		}

		while(i <= med) {
			b[k] = a[i];
			i++;
			k++;
		}

		while(j <= fim) {
			b[k] = a[j];
			j++;
			k++;
		}

		for(k = 0; k < b.length; k++) a[ini + k] = b[k];
	}
}