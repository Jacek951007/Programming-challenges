import java.util.*;

public class NameGeneratorApp {
	public static void main(String[] args) {
		Person person = new Person();
		Scanner sc = new Scanner(System.in);
		StringBuilder newName = new StringBuilder();
		Random rd = new Random();
		int iloscZnakow = 0;
		int znaki = 0;
		System.out.println("Podaj po spacji imiê, nazwisko oraz wiek. Przyk³ad - (Jan Kowalski 23)");
		person.imie = sc.next();
		person.nazwisko = sc.next();
		person.wiek = sc.nextInt();
		
		
		System.out.println("Twoje dane to: "+person.imie+" "+person.nazwisko+" "+person.wiek);
		znaki = person.imie.length() + person.nazwisko.length();
		System.out.print("Teraz podaj z ilu znakow ma siê sk³adaæ Twoja nazwa: ");
		iloscZnakow = sc.nextInt();
		for(int i = 0; i<iloscZnakow;i++) {
			if(i<(iloscZnakow/2)-2) {
				try {
					newName.append(person.imie.charAt(i));
				}catch(IndexOutOfBoundsException e) {
					newName.append(person.nazwisko.charAt(rd.nextInt(person.nazwisko.length())));
				}
			}
			else if(i<(iloscZnakow-2)){
				try {
					newName.append(person.nazwisko.charAt(i));		
				}catch(IndexOutOfBoundsException e) {
					newName.append(person.imie.charAt(rd.nextInt(person.imie.length())));
				}
			}
		}
		newName.append(person.wiek);
		
		System.out.println("Twoja nowa nazwa to:"+newName);
		
	}
}
