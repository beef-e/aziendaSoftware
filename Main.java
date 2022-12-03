import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
	static Calendar giornoAttuale=Calendar.getInstance();
	static SimpleDateFormat DateFormat= new SimpleDateFormat("dd/MM/yy");
	public static void main(String[] args) {

		System.out.println(DateFormat.format(giornoAttuale.getTime()));
		Project progettoProva=new Project();
		progettoProva.inizializzazione();
		menu();
	}

	public static void menu(){

		int risposta;

		do{
			System.out.println("Benvenuto. Selezionare la voce a cui si è interessati");
			System.out.println("1. Visualizza vanzamento progetto");
			System.out.println("2. Gestisci avanzamento");
			System.out.println("3. Esci");
			System.out.println("0. Avanza di un giorno");
			System.out.print(">>>");
			Scanner menuanswer=new Scanner(System.in);
			risposta=menuanswer.nextInt();

			switch (risposta){
				case 1:
					System.out.print("Inserisci numero Milestone\n>>>");
					Scanner milestoneasnwer=new Scanner(System.in);
					int numeroMilestone=milestoneasnwer.nextInt();
					Milestone selectedMilestone=Project.milestoneArrayList.get(numeroMilestone);
					selectedMilestone.percentualeAvanzamento();
					risposta=5;
					break;

				case 2:
					System.out.print("Inserisci numero Milestone\n>>>");
					milestoneasnwer=new Scanner(System.in);
					numeroMilestone=milestoneasnwer.nextInt();
					selectedMilestone=Project.milestoneArrayList.get(numeroMilestone);
					System.out.print("Inserisci numero Task\n>>>");
					Scanner taskAnswer=new Scanner(System.in);
					int numeroTask=taskAnswer.nextInt();
					Task selectedTask=selectedMilestone.taskArrayList.get(numeroTask);
					selectedTask.taskHandling();
					risposta=5;
					break;

				case 0:
					System.out.println("Si è selezionato di avanzare di un giorno la simulazione.\nL'avanzamento avverrà " +
							"tra poco...");
					giornoAttuale.add(Calendar.DATE, 1);

					risposta=5;
					break;

				case 3:
					System.out.println("Si è scelto di uscire");
					break;

				default:
					System.out.println("Inserire un numero valido");
					risposta=5;
					break;
			}
		}while(risposta == 5);
	}


}