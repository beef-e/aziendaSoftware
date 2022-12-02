import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.ServiceConfigurationError;

public class Task {
	//dipendente assegnato
	Date dataScadenza;
	boolean critico;
	Dipendente dipendenteAssegnato;
	boolean completato;

	public Task(){

	}
	
	public void setup(){
		System.out.println("Inserire Data di scadenza con formato dd MM yyyy");
		Scanner dmil=new Scanner(System.in);
		Scanner mMil=new Scanner(System.in);
		Scanner ymil=new Scanner(System.in);
		int y, m, d;
		d=dmil.nextInt();
		m=mMil.nextInt();
		y=ymil.nextInt();
		Calendar myDate=Calendar.getInstance();
		myDate.set(Calendar.DAY_OF_MONTH, d);
		myDate.set(Calendar.MONTH, (m-1));
		myDate.set(Calendar.YEAR, y);
		SimpleDateFormat DateFormat= new SimpleDateFormat("dd/MM/yy");
		this.dataScadenza=myDate.getTime();
		
		System.out.println("Selezionare dipendente assegnato selezionando il numero corrispondente");
		for (int i = 0; i < Project.dipendenteArrayList.size(); i++) {
			Dipendente dipendente=Project.dipendenteArrayList.get(i);
			System.out.print((i+1));
			System.out.print(dipendente.nome);
			System.out.print(" "+dipendente.cognome);
			System.out.print("\n");
		}
		System.out.print(">>>");
		Scanner indice=new Scanner(System.in);
		int index=indice.nextInt();
		dipendenteAssegnato=Project.dipendenteArrayList.get(index);

		System.out.println("Questa task è una task di importanza critica?");
		System.out.println("1. Sì");
		System.out.println("2. No");
		Scanner criticy=new Scanner(System.in);

		switch (criticy.nextInt()){
			case 1:
				critico=true;
				break;

			case 2:
				critico=false;
				break;

			default:
				critico=false;
				break;
		}

		completato=false;
	}
}
