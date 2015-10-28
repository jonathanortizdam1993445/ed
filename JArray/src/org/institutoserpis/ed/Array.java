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
		int menor=v[0];
		for (int index =0 ;index< v.length ; index++){
			if (v[index]<menor){
				menor=v[index];
			}
		}
			return menor;
		
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
	
}
	



	
	
	
	
	
	
