
import java.io.*;
import java.util.*;

/**
 * 
 * @author judelin et Edicson
 *
 */
public class Gerant implements AfficherInfo {
	Scanner scan=new Scanner(System.in);
	public int Entrer=0;



	/**
	 * affiche les rapports  a la demande d'un gerant
	 */

	@Override
	public void affiche() throws IOException {
		System.out.println("Generer les rapports sur la demande Gerant en entrant un numero 1 a 4 SVP");
		System.out.println("1:Rapport manuel");
		System.out.println("2:Rapport compte payable");
		System.out.println("3:Rapport fournisseur");
		System.out.println("4:Rapport membre");
		boolean done=true;
		while(done){

			try{
				Entrer=scan.nextInt();

				switch(Entrer){

				case 1:
					done=true;
					while(done){
						try{
							rapportManuel rapport=new rapportManuel();
						}
						catch(NullPointerException e){
							e.printStackTrace();
							done=false;
							System.out.println("pas encore des fournisseurs et des membres");
						}
					}
					break;
				case 2:
					done=true;
					while(done){
						try{
							rapportComptePayable rapport=new rapportComptePayable();
						}
						catch(NullPointerException | IOException e){
							e.printStackTrace();
							done=false;
							System.out.println("pas encore des fournisseurs et des membres");
							System.out.println("Entrer un chiffre entre 1 a 4 SVP");
						}
					}
					break;
				case 3:
					done=true;
					while(done){
						try{
							rapportFournisseurs rapport=new rapportFournisseurs();
						}
						catch(IOException | NullPointerException e){
							e.printStackTrace();
							done=false;
							System.out.println("pas encore des fournisseurs et des membres");
							System.out.println("Entrer un chiffre entre 1 a 4 SVP");
						}
					}
					break;
				case 4:
					done=true;
					while(done){
						try{
							rapportsMembres rapport=new rapportsMembres();
						}
						catch(IOException | NullPointerException e){
							e.printStackTrace();
							System.out.println("pas encore des fournisseurs et des membres");
							System.out.println("Entrer un chiffre entre 1 a 4 SVP");
						}
					}

					break;
				default:
					break;

				}
			}
			catch (InputMismatchException e){
				System.out.println("erreur entrer un chiffre entrer 1 a 4 pas un symbole et redemarre le programme");
				done=false;


			}
		}
	}
}