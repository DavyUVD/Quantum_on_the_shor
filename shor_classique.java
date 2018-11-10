package cryptographie;

import java.io.*;
import java.util.*;
import java.lang.Math;
public class shor_classique {

	private int p;
	private int a;
	
	
public void shorclassique(int a, int p){
	 
	// sauvgarde
	int val1 = a;
	int val2 = p;
	//methode euclide

	int nbr=0;
	 // si a superieure a p 
	if (a>p){
	nbr = a;
	a=p;
	p=nbr;	
	}
	System.out.println("r : "+ a);
	int r=0;
	//calcul pgcd
	// si var1 sup var2 , on fait la permutation des valeurs
	do{
		r  = a % p;
		a = p;
		p = r;
	
	}while (r != 0);
	if (a != 1 ){
		System.out.println("probleme résolu !");	
	}
	else{	
		System.out.println(" --------------calculer la période---------------- ");	
		if (val1>val2)
	    periodeR(val2,val1);
		else
	    periodeR(val1,val2);


	}
	

		}

public void periodeR(int a, int p){
	System.out.println(" val1: "+a+" val2 " + p);	
	int k;
	int compteurR=0;
	int[] res = new int[p];
	
	for (k=0; k<res.length; k++){
		System.out.println("a : "+a +" k : "+k+ " , length : "+p);
		res[k]  = (int)(Math.pow(a, k)  %  p); 
		if (res[k] ==1)
			++compteurR;
		
     	System.out.println(res[k]);	
	}

System.out.println("on voit que r égal à "+compteurR);
//si r est pair 
if (compteurR%2 == 0){
	/*System.out.println("a "+a+",compteurR/2 "+compteurR/2);
	System.out.println(p);*/
	int pgcd1,pgcd2;
	
//	pgcd1 = (int)((Math.pow(7,2 )+1) %  15);
	pgcd1 = (int)((Math.pow(a,compteurR/2 )+1) %  p);
	pgcd2 = (int)((Math.pow(a,compteurR/2 )-1) %  p);

	System.out.println("facteur1 :"+pgcd1);
	System.out.println("facteur2 :"+pgcd2);
	
	if ( p == pgcd1 * pgcd2){
		System.out.println("factorisé ! ");
	}
	else {
		System.out.println("non factorisé ! ");
	}

}

}
	

	

public shor_classique(int p, int a) {
	super();
	this.p = p;
	this.a = a;
}

	public shor_classique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
	
	public static void main(String[] args){
		
		 shor_classique  shor = new shor_classique();
		 
		//	System.out.println(Math.pow(7, 12) % 15); 
			System.out.println("donnez les deux nombres");
			Scanner input = new Scanner(System.in);
			int a , b;
			a = input.nextInt();
			b = input.nextInt();
			
			 shor.shorclassique(a, b);
			// shor.periodeR(a,b);
		
		 
	}

}
