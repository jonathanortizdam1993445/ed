package org.institutoserpis.ed;

public class Array {
	public static void main (String [] args){
	int [] v=new int []{5, 9,7, 12, 21};
	int suma = 0;
	int menor= v[0];
	
	System.out.println("primer elemento " +v[0]);
	System.out.println("Segundo elemento " +v[1]);
	System.out.println("tercer elemento " +v[2]);
	System.out.println("suma del array " +suma(v));
	}

	private static int suma(int [] v){
//		metodo del elemento v.length
		int suma =0;
//		for (int index=0 ; index < v.length; index++)
//			suma =suma + v[index];
		for (int item : v)
			suma = suma +item;		
		return suma;
		
	}
public static int menor (int[] v){
//		int menor=v[0];
//		for (int index =0 ;index< v.length ; index++)
//			if (v[index]<menor)
//				menor=v[index];
//				return menor;
	
			//Para buscar el menor valor de los vectores y Para ponerlos en orden desde int aux hasta v[posmenor]=aux
			int posmenor=0;
			int aux=v[0];
			v[0]=v[posmenor];
			v[posmenor]=aux;
			for (int index=1; index < v.length ; index++)
				if (v[index] < v[posmenor])
					posmenor =index;
				return v[posmenor];
	
}
public static int indexOf (int [] v, int item) {
	//implementación basada en algoritmos
	//int index=0;
	//while (index < v.length -1 && v[index]!=item)
		//index++;
	//if (index == v.length)
	//return -1;
	//return 0;
	
	for (int index=0; index < v.length ; index++ )
			return index;
			return -1;
		}
public static void sort(int[] v){
//	for (int stepIndex = 0; stepIndex < v.length -1; stepIndex++){
//		int minIndex = stepIndex ;
//		for (int index = stepIndex + 1; index < v.length; index++){
//			if (v[index] < v[minIndex])
//				minIndex = index;
//		int aux = v[stepIndex];
//		v[stepIndex] = v[minIndex];
//		v[minIndex] = aux;
//		}
//	}
	for (int stepIndex = 0; stepIndex < v.length -1; stepIndex++){
		int minIndex = minIndex (v, stepIndex) ;
		swap(v, stepIndex, minIndex);
		}
	}
	private static int minIndex(int[] v, int initialIndex){
		int minIndex = initialIndex ;
		for (int index = initialIndex + 1; index < v.length; index++)
			if (v[index] < v[minIndex])
				minIndex = index;
		return minIndex;
	}
	private static void swap(int[] v, int oneIndex, int otherIndex){
		int aux = v[oneIndex];
		v[oneIndex] = v[otherIndex];
		v[otherIndex] = aux;
	}

public void sort (){
	int[] v = {9,8,12,7};
	Array.sort(v);
	assertArrayEquals(new int[] {7, 8, 9, 12}, v);
	
	v = new int[] {9,7,12,7};
	Array.sort(v);
	assertArrayEquals(new int[] {7, 7, 9, 12}, v);
}

private void assertArrayEquals(int[] is, int[] v) {
	// TODO Auto-generated method stub
	
}	
}
	

	



	
	
	
	
	
	
