import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Milestone {
	Date dataScadenza;
	static ArrayList<Task> taskArrayList=new ArrayList<Task>();
	boolean completed;

	public Milestone(){

	}

	public int aggiornamento(){
		int iniziale= taskArrayList.size();
		int nuovo=0;

		for (int i = 0; i < iniziale; i++) {
			if (taskArrayList.get(i).completato){
				nuovo+=1;
			}
		}

		return nuovo;
	}

	public float percentualeAvanzamento(int nuovo){
		int iniziale= taskArrayList.size();
		float percentuale=0;

		percentuale=nuovo/iniziale;
		percentuale=percentuale*100;

		if (percentuale==100){
			completed=true;
		}

		return percentuale;
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

		System.out.println("Inserire il numero di task per la milestone:");
		Scanner ntasks=new Scanner(System.in);
		int numeroTasks= ntasks.nextInt();

		for (int i = 0; i < numeroTasks; i++) {
			Task task1=new Task();
			task1.setup();
			taskArrayList.add(task1);
		}

		//Debbo chiedere da quante task è composta la milestone e chiedere che dipendente assegnare ad ogni task
		//Se le task sono più dei dipendenti, attenderò che una venga markata come finita per liberare il dipendente
		// e renderlo disponibile per un'altra task
	}
}
