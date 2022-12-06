import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
	static Calendar giornoAttuale=Calendar.getInstance();
	static SimpleDateFormat DateFormat= new SimpleDateFormat("dd/MM/yy");
	static Project progettoProva=new Project();

	public static void main(String[] args) {
		System.out.println(DateFormat.format(giornoAttuale.getTime()));
		progettoProva.inizializzazione();
		menu();
	}

	public static void menu(){

		int risposta;

		do{
			System.out.println("Benvenuto. Selezionare la voce a cui si è interessati");
			System.out.println("1. Visualizza avanzamento progetto");
			System.out.println("2. Visualizza avanzamento singola Milestone");
			System.out.println("2. Gestisci avanzamento");
			System.out.println("3. Esci");
			System.out.println("0. Avanza di un giorno");
			System.out.print(">>>");
			Scanner menuanswer=new Scanner(System.in);
			risposta=menuanswer.nextInt();

			switch (risposta){

				case 1:
					float percentualeProject=progettoProva.percentualeCompletamento();
					System.out.println("La percentuale di completamento del progetto attuale è del "+percentualeProject +"%");
					break;


				case 2:
					System.out.print("Inserisci numero Milestone\n>>>");
					Scanner milestoneAsnwer =new Scanner(System.in);
					int numeroMilestone= milestoneAsnwer.nextInt();
					Milestone selectedMilestone=Project.milestoneArrayList.get(numeroMilestone);
					int nuovo=selectedMilestone.aggiornamento();
					float percentuale=selectedMilestone.percentualeAvanzamento(nuovo);
					System.out.println("La percentuale di avanzamento della Milestone selezionata è del "+percentuale +"%");
					risposta=5;
					break;

				case 3:
					System.out.print("Inserisci numero Milestone\n>>>");
					milestoneAsnwer =new Scanner(System.in);
					numeroMilestone= milestoneAsnwer.nextInt();
					selectedMilestone=Project.milestoneArrayList.get(numeroMilestone);
					System.out.print("Inserisci numero Task\n>>>");
					Scanner taskAnswer=new Scanner(System.in);
					int numeroTask=taskAnswer.nextInt();
					Task selectedTask=selectedMilestone.taskArrayList.get(numeroTask);
					selectedTask.taskHandling();
					if (selectedTask.completato){
						selectedMilestone.aggiornamento();
					}
					risposta=5;
					break;

				case 0:
					System.out.println("Si è selezionato di avanzare di un giorno la simulazione.\nL'avanzamento avverrà " +
							"tra poco...");
					giornoAttuale.add(Calendar.DATE, 1);

					risposta=5;
					break;

				case 4:
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