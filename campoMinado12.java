/**
Aluno: João Victor Alves de Lima
Aluno: João Pedro Haufes
Turma: Info-126
Data: 21/10/19
**/
//armazena no vetor e ve se ja tem a jogadda
//fim ve a qnt de jogada que tu tive
import java.util.Scanner;
import java.util.Random;
public class campoMinado12{
	public static void inicializaMatriz(char campo[][]){
		int a=49;
		for(int i =0;i <12;i++){
			for(int j=0;j<12;j++){
					if(i==0 && j % 2 == 0 && j!=0){
						campo[i][j]=(char)a;
						a+=2;
				}else
					if(j % 2 == 0 && i % 2 != 0 &&  j!=0){
					campo[i][j] = 45;
				}else
					if(j % 2 != 0 && i!=0 && j!=0 && i%2==0){
					campo[i][j]= '|';
				}else{
					campo[i][j]=' ';
				}
				
			}
			a=49;
		}
		for(int i =0;i <12;i++){
			for(int j=0;j<12;j++){
				if(j==0 && i % 2 == 0 && i!=0){
					campo[i][j]=(char)a;
					a+=2;
				}
			}
		}
	}
	public static void imprimeMatriz(char campo[][]){//imprime a matriz na tela
		for(int i = 0;i < 12;i++){
			for(int j = 0;j< 12;j++){
				System.out.print(campo[i][j]);
				if(j == 11){
				System.out.println("");
				}
			}
		}
	}
	public static int aleatorio(){//gera numeros aleatorios
		Random r = new Random();
		int v = 0;
		for(int i=0;i<=4;i++){
			v=r.nextInt(10);
			while(v%2!=0 || v==0){
				v=r.nextInt(10);
			}
		}
		return v;
	}
	public static boolean verificaSort(int pSorteioLinha[],int pSorteioColuna[],int sortL,int sortC,int fim){//verifica se a coordeanada botada ja existe
		boolean test=false;
		pSorteioLinha[fim]=sortL ;
		pSorteioColuna[fim]=sortC;
		if(fim!=1){
			for(int i = 0;i<fim;i++){
				if(pSorteioLinha[i]==sortL && pSorteioColuna[i]==sortC){
					test=true;
					break;
				}
			}
		}
		return test;
	}
	public static boolean verificaJogo(int pSorteioLinha[],int pSorteioColuna[],int sortL,int sortC){//verifica se tem mina ou ñ
		boolean test=false;
		for(int i = 0;i<5;i++){
			if(pSorteioLinha[i]==sortL && pSorteioColuna[i]==sortC){
				test=true;
				break;
			}
		}
		return test;
	}
	public static void preencheMatrizMina(char campo[][],int pSorteioLinha[],int pSorteioColuna[]){//preenche apenas os espaços das minas
		for(int i = 0;i<5;i++){
			campo[pSorteioLinha[i]][pSorteioColuna[i]]='O';
		}
	}
	public static int[] arrumaJogo(int sortL,int sortC){
		Scanner l = new Scanner (System.in);
		sortL=l.nextInt();
		sortC=l.nextInt();
		int v[]=new int[2];
		while(sortC%2==0 || sortL%2==0){
			System.out.print("Valores invalidos. Insira apenas numero impares");
			sortL=l.nextInt();
			sortC=l.nextInt();
		}
		switch(sortC){
		case 1:
			sortC=2;
			break;
		case 3:
			sortC=4;
			break;
		case 5:
			sortC=6;
			break;
		case 7:
			sortC=8;
			break;
		case 9:
			sortC=10;
			break;
		}
		switch(sortL){
		case 1:
			sortL=2;
			break;
		case 3:
			sortL=4;
			break;
		case 5:
			sortL=6;
			break;
		case 7:
			sortL=8;
			break;
		case 9:
			sortL=10;
			break;
		}
		v[0]=sortL;
		v[1]=sortC;
		return v;
	}
	public static void arrumabomba(int pSL[],int pSC[]){
		int v[][]=new int[2][5];
		for(int i=0;i<2;i++){
			for(int j=0;j<=4;j++){
				if(i==0){
					v[i][j]=pSL[j];
				}else{
					v[i][j]=pSC[j];
				}
			}
		}
		for(int i=0;i<=1;i++)
			for(int j=0;j<=4;j++){
				switch(v[i][j]){
					case 2:
						v[i][j]=1;
						break;
					case 4:
						v[i][j]=3;
						break;
					case 6:
						v[i][j]=5;
						break;
					case 8:
						v[i][j]=7;
						break;
					case 10:
						v[i][j]=9;
						break;
				}
			}
	System.out.println("["+v[0][0]+","+v[1][0]+"] ["+v[0][1]+","+v[1][1]+"] ["+v[0][2]+","+v[1][2]+"] ["+v[0][3]+","+v[1][3]+"] ["+v[0][4]+","+v[1][4]+"]");
		
	}
	public static void main(String[]args){
		Scanner l = new Scanner(System.in);
		int veriReL[]= new int[21];//verifica se repete
		int veriReC[]= new int[21];
		char campo[][]=new char[12][12];
		int sortC=0;
		int sortL=0;
		char denovo = 's';
		int pSL[]= new int[5];//recebe as bombas
		int pSC[]= new int[5];
		int cont = 1;
		boolean teste = false;
		boolean teste1 = false;
		boolean teste2 ;
		int v[]= new int[2];
		while(denovo=='s'){
			inicializaMatriz(campo);
			for(int i=0;i<=4;i++){
				pSL[i]=aleatorio();
				pSC[i]=aleatorio();
			}
			for(int i=0;i<=4;i++){
				for(int j=0;j<=4;j++){
					while(pSL[i]==pSL[j] && pSC[i]==pSC[j] && i!=j){
								pSL[i]=aleatorio();
								pSC[i]=aleatorio();
					}
				}
			}
			cont=1;
			teste2 = false;
			while(teste2==false){
				imprimeMatriz(campo);
				System.out.print("Digite as coordenadas da sua jogada:");
				v = arrumaJogo(sortL,sortC);
				while(v[0]%2!=0 || v[1]%2!=0){
					System.out.print("Valores invalidos. Insira apenas numero impares");
					v = arrumaJogo(sortL,sortC);
				}
				teste=verificaSort(veriReL,veriReC,v[0],v[1],cont);//verifica se a coordeanada sorteada ja existe
				while(teste==true){
					System.out.print("Essa coordenada ja foi inserida, insira uma nova");
					v = arrumaJogo(sortL,sortC);
					while(v[0]%2!=0 || v[1]%2!=0){
						System.out.print("Valores invalidos. Insira apenas numero impares");
						v = arrumaJogo(sortL,sortC);
					}
					teste=verificaSort(veriReL,veriReC,v[0],v[1],cont);//verifica se a coordeanada sorteada ja existe dnv
				}
				teste1=verificaJogo(pSL,pSC,v[0],v[1]);//verifica se tem mina ou ñ
				if(teste1==true){
					teste2=true;
					preencheMatrizMina(campo,pSL,pSC);
					imprimeMatriz(campo);
					arrumabomba(pSL,pSC);
					System.out.println("Voce perdeu com: "+cont+" rodada(s)");
					System.out.println("Deseja jogar novamente? (s/n)");
					denovo=l.next().charAt(0);
				}else{
					campo[v[0]][v[1]]='x';
				}
				cont=cont+1;
			}	
		}
	}
}
