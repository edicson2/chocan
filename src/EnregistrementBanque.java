import java.io.*;
import java.util.*;

/**
 * 
 * @author judelin et Edicson
 *
 */
public class EnregistrementBanque {
	Fournisseur fourni;

	BaseDonnerFournisseur base;

	/**
	 * 
	 * @return qui retourne un tableau de clé fournisseur
	 * @throws IOException
	 */
	public int[]  lireFournisseur() throws IOException{

		base=new BaseDonnerFournisseur();
		base.open("ChocFournisseur.dat");

		int key=0;
		long fileSize=base.getFile().length(); // taille du tableau de registres
		long records=fileSize/12; // quantite de registres dans le tableau
		int recordSize = (int) (fileSize/records); // la taille de chaque registre
		int tableSize = (int) (records);
		int [] cle=new int[tableSize]; // le tableau qui va garder les clefs
		base.getFile().seek(fileSize); // On modifie la fin de l'archive qu'on lit

		for(int i=0; i<fileSize; ++i){
			recordSize *=i; // On change au registre suivant
			key=base.getFile().readInt();
			cle[i]=key;
			System.out.println(key);
		}

		return cle;


	}

	/**
	 * 
	 * @throws IOException
	 */
	public void AjouterFraisFournisseur() throws IOException{

		try (Scanner in = new Scanner(System.in);
				BaseDeDonnerTef base = new BaseDeDonnerTef())
		{
			base.open("DonnerTef.dat"); 
			int cle = 0;

			double montant =0;
			int tab[]=lireFournisseur();
			for(int i=0;i<tab.length;i++){
				int position = base.find(tab[i]);

				if (position >= 0)
				{
					fourni = base.read(position);
					montant =fourni.getMontant();
					System.out.println("Paiment: " + montant);
				}

				base.write(position, fourni);

			} 
		}
	}
}