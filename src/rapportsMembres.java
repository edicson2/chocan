import java.io.*;

public class rapportsMembres extends rapports {

	BaseDonnerMembre base;
	int tab[];
	public rapportsMembres() throws IOException {
		base=new BaseDonnerMembre();
		base.open("ChocMembre.dat");
		tab=operer.lireMembre();
		for(int i=0;i<tab.length;i++){
			int position = base.find(tab[i]);
			Membres memb;
			if (position >= 0)
			{
				memb = base.read(position);
				//fourni.toString();
				System.out.println("Nom: " + memb.getPrenom()+" "+memb.getNumero());


				int j=i+1;
				File file=new File("./RapportMembre"+j+".txt");


				int numeroDuMembre = memb.getNumero();
				int niveau = base.findMembreEnregistrement(numeroDuMembre);
				String dateServiceFourni = base.readDateService(niveau);
				String nomServiceFourni = base.readCodeDuService(niveau);
				double montantServiceFourni = base.readMontant(niveau);



				try(BufferedWriter buf=new BufferedWriter(new FileWriter(file))){
					buf.write("RAPPORT MEMBRE "+ memb.getNom()+" "+memb.getPrenom());
					buf.newLine();
					buf.write("Ce membre a recu le service chocAn le "+dateServiceFourni);
					buf.newLine();
					buf.newLine();
					buf.write("Nom"+"                                         "+memb.getNom());
					buf.newLine();  
					buf.write("Prenom"+"                                      "+memb.getPrenom());
					buf.newLine();
					buf.write("Ville"+"                                       "+memb.getVille());
					buf.newLine();
					buf.write("Adresse"+"                                     "+memb.getAddresse());
					buf.newLine();
					buf.write("Code de postal"+"                              "+memb.getCodePostal());
					buf.newLine();
					buf.write("Nom du service"+"                              "+nomServiceFourni);
					buf.newLine();
					buf.write("Numero Membre"+"                               "+memb.getNumero());
					buf.newLine();
					buf.write("Montant"+"                               "+montantServiceFourni);
					buf.newLine();







				} catch(IOException e)
				{
					e.printStackTrace();
				}
			}	

		}
	}
}