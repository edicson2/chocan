import java.util.*;
import java.io.*;
/**
 * 
 * @author judelin
 *
 */

public class ChocAnMain {
	static int n;


	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Scanner scan=new Scanner(System.in);

		StringBuilder menu = new StringBuilder();
		menu.append("\n  .d8888b.  888                               d8888          \n");
		menu.append(" d88P  Y88b 888                              d88888          \n");
		menu.append(" 888    888 888                             d88P888          \n");
		menu.append(" 888        88888b.   .d88b.   .d8888b     d88P 888 88888b.  \n");
		menu.append(" 888        888 '88b d88''88b d88P'       d88P  888 888 '88b \n");
		menu.append(" 888    888 888  888 888  888 888        d88P   888 888  888 \n");
		menu.append(" Y88b  d88P 888  888 Y88..88P Y88b.     d8888888888 888  888 \n");
		menu.append("  'Y8888P'  888  888  'Y88P'   'Y8888P d88P     888 888  888 \n");
		System.out.println(menu.toString());

		boolean done = false;
		while (!done){
			done = false;
			System.out.println("Entrer un chiffre entre 1 à 4 SVP pour acceder au system de chocAn");
			System.out.println("1:Fournisseurs");
			System.out.println("2:Operateurs");
			System.out.println("3:Gerant");
			System.out.println("4:Service Comptable");
			while(!done){
				try{

					n=scan.nextInt();
					if(n>5||n==0)
						System.out.println("Entrer un chiffre entre 1 a 4 SVP");
					else{

						switch(n){
						case 1:
							ControlerFournisseur fournis=new ControlerFournisseur();
							fournis.afficher();
							break;
						case 2: 
							operateurs operer=new operateurs();
							operer.AfficherOperer();
							break;
						case 3:
							Gerant gerer=new Gerant();
							gerer.affiche();
							break;
						case 4: 
							serviceComptable service=new serviceComptable();
							service.affiche();
							break;
						case 5: 
							AutomatiqueRapport auto=new AutomatiqueRapport();
							break;
						}
					}
				}
				catch (InputMismatchException e){
					System.out.println("erreur entrer un chiffre entrer 1 a 4 pas un symbole et redemarre le programme");
					done=true;
					break;


				}	

			}
		}

		System.out.print("Done? (Y/N) ");

		String input =scan.next();
		if (input.equalsIgnoreCase("Y")) { done = true; }
	}


}