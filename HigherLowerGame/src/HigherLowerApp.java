import java.lang.reflect.*;
import java.util.*;
public class HigherLowerApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int test = 0;
		int lost = 0;
		String[] questions = new String[2];
		int answer = 0;
		int[] scoreQuestion = new int[2];
		Player player = new Player();
		String whichMethod[] = new String[13];
		System.out.println("Witaj w grze Higher or Lower. Jak chcesz si� naywa�?");
		String methods;
		int chooseMethods = 0;
		player.name = sc.next();
		System.out.println("Twoim zadaniem jest wybranie stadionu z wi�ksz� pojemno�ci�. Musisz odpowiedzie� liczb� 1 lub 2");
		AssignQuest aq = new AssignQuest();
	
		do {
			for(int i=0;i<13;i++) {
				whichMethod[i]="assignQuest"+i;
			}
			
			for(int i=0;i<2;i++) {
				chooseMethods = rd.nextInt(12);
				if(chooseMethods == test) {
					chooseMethods = rd.nextInt(12);
				}
				methods = whichMethod[chooseMethods];
				//System.out.println(methods);
				try {				
					Class AQ = Class.forName("AssignQuest");
					Method aQ = AQ.getDeclaredMethod(methods, null);
					Question q = (Question) aQ.invoke(methods, null);
					
				
					scoreQuestion[i] = q.points;
					questions[i] = q.quest;
					
					
					//Method aQ = AQ.getDeclaredMethod(methods, Question.class);
					//aQ.invoke(methods, null);
					
					/*Method aQ = Class.forName("AssignQuest").getDeclaredMethod(methods, null);
					aQ.invoke(null);*/
								}
				catch(Exception e) {
					System.out.println("Nie ma takiej klasy");
				}
			}
			
			System.out.print("Stadion"+questions[0]+" czy "+questions[1]+" ma wi�ksz� pojemjo��: ");
			answer = sc.nextInt();
			answer--;
			if(answer == 0) {
				if(scoreQuestion[answer]>scoreQuestion[1]) {
					System.out.println("Wygra�e�, poniewa� "+questions[answer]+" z pojemno�ci�:"+scoreQuestion[answer]+" jest wi�kszy ni� stadion "+questions[1]+" z pojemno�ci�:"+scoreQuestion[1]);
					player.points++;
				}
				else{
					System.out.println("Przegra�e�, poniewa� "+questions[answer]+" z pojemno�ci�:"+scoreQuestion[answer]+" jest mniejszy ni� "+questions[1]+" z pojemno�ci�:"+scoreQuestion[1]);
					lost++;
				}
			}
			else if(answer == 1) {
				if(scoreQuestion[answer]>scoreQuestion[0]) {
					System.out.println("Wygra�e�, poniewa� "+questions[answer]+" z pojemno�ci�:"+scoreQuestion[answer]+" jest wi�kszy ni� stadion "+questions[0]+" z pojemno�ci�:"+scoreQuestion[0]);
					player.points++;
				}
				else{
					System.out.println("Przegra�e�, poniewa� "+questions[answer]+" z pojemno�ci�:"+scoreQuestion[answer]+" jest mniejszy ni� "+questions[0]+" z pojemno�ci�:"+scoreQuestion[0]);
					lost++;	
				}
			}
			
			
	}while(lost==0);
		System.out.println("Gratulacje zdoby�e� "+player.points+" punkt�w");
	}
}
