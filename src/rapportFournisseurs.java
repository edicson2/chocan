import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author judelin et Edicson
 *
 */
public class rapportFournisseurs extends rapports {

	BaseDonnerFournisseur base,base1;
	int tab[];

	/**
	 * rapport fournisseur
	 * @throws IOException
	 */
	public rapportFournisseurs() throws IOException {
		base=new BaseDonnerFournisseur();
		base.open("ChocFournisseur.dat");
		base1.open("Enregistrement.dat");
		tab=operer.lireFournisseur();;

		for(int i=0;i<tab.length;i++){
			int position = base.find(tab[i]);
			System.out.println(position);
			Fournisseur fourni;
			if (position >= 0)
			{
				fourni = base.read(position);
				//fourni.toString();
				//System.out.println("Nom: " + fourni.getPrenom()+" "+fourni.getNumero());


				int j=i+1;
				File file=new File("./RapportFournisseur"+j+".txt");

				int numeroFournisseur = fourni.getNumero();
				int niveau = base.findFournisseurEnregistrement(numeroFournisseur);
				String dateServiceFourni = base.readDate(niveau);
				String codeEnregistre = base.readDate(niveau);


				try(BufferedWriter buf=new BufferedWriter(new FileWriter(file))){
					buf.write("RAPPORT Fournisseur "+ fourni.getNom()+" "+fourni.getPrenom());
					buf.newLine();
					buf.write("Ce fournisseur a donner de service  de chocAn aux membres le "+ dateServiceFourni);
					buf.newLine();
					buf.newLine();
					buf.write("Nom"+"                                         "+fourni.getNom());
					buf.newLine();  
					buf.write("Prenom"+"                                      "+fourni.getPrenom());
					buf.newLine();
					buf.write("Ville"+"                                       "+fourni.getVille());
					buf.newLine();
					buf.write("Adresse"+"                                     "+fourni.getAdresse());
					buf.newLine();
					buf.write("Code de postal"+"                              "+fourni.getCodeDePostal());
					buf.newLine();
					buf.write("Code du service"+"                             "+codeEnregistre);
					buf.newLine();
					buf.write("Numero Fournisseur"+"                          "+fourni.getNumero());
					buf.newLine();






				} catch(IOException e)
				{
					e.printStackTrace();
				}
			}	

		}
	}
}