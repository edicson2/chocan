import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author judelin et Edicson
 *
 */
public class RepertoirFournisseur  {

	operateurs operer=new operateurs();
	BaseDonnerFournisseur base;

	int tab[];
	/**
	 * Repertoire fournisseur un ensemble de service.
	 * @throws IOException
	 */
	public RepertoirFournisseur() throws IOException {



		File file=new File("./RepertoireFournisseur.txt");




		try(BufferedWriter buf=new BufferedWriter(new FileWriter(file))){

			buf.write("Liste de nom de service et code de service et les frais correspondants  aux membres  ");

			buf.newLine();
			buf.newLine();
			buf.write("Nom De service ..........."+"Code De Service .................."+" Frais");
			buf.newLine();

			buf.write("Diétécien..................."+" 598470"+".........................$"+100);
			buf.newLine();
			buf.write("Aerobie....................."+" 883948"+"..........................$"+150);
			buf.newLine();

			buf.write("Yoga........................"+" 66470"+"...........................$"+170);
			buf.newLine();
			buf.write("Cardio......................"+" 883948"+"..........................$"+190);
			buf.newLine();




		} catch(IOException e)
		{
			e.printStackTrace();
		}




	}

}