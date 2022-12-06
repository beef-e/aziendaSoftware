import java.util.Scanner;

public class Dipendente {
	String nome;
	String cognome;

	public Dipendente(){

	}

	public void setup(){
		System.out.println("Inserire il nome del dipendente");
		Scanner nome=new Scanner(System.in);
		this.nome=nome.nextLine();
		System.out.println("Inserire il cognome del dipendente");
		Scanner cognome=new Scanner(System.in);
		this.cognome=cognome.nextLine();
	}
}
