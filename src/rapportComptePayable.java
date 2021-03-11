import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 
 * @author judelin et Edicson
 *
 */
public class rapportComptePayable extends rapports {
	operateurs operer=new operateurs();
	BaseDonnerFournisseur base;
	int tab[];
	/**
	 * creer un rapport compte payable.
	 * @throws IOException
	 */
	public rapportComptePayable()throws IOException  {
		base=new BaseDonnerFournisseur();
		base.open("ChocFournisseur.dat");
		tab=operer.lireFournisseur();
		for(int i=0;i<tab.length;i++){
			int position = base.find(tab[i]);
			Fournisseur fourni;
			if (position >= 0)
			{
				fourni = base.read(position);

				int j=i+1;
				File file=new File("./RapportComptePayable.txt");




				try(BufferedWriter buf=new BufferedWriter(new FileWriter(file))){
					buf.write(" Liste des fournisseurs "+ fourni.getNom()+" "+fourni.getPrenom());
					buf.newLine();
					buf.write("Donnant de service  de chocAn aux membres le ");

					buf.newLine();
					buf.newLine();
					buf.write("Nom du fournisseu........"+ "Nombre de consultation.........  "+" Total des frais");
					buf.newLine();




					buf.write(fourni.getNom()+"          "+1  +"               "+fourni.getMontant());
					buf.newLine();






				} catch(IOException e)
				{
					e.printStackTrace();
				}

			}
		}

	}





}