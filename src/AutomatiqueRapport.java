import java.io.EOFException;
import java.io.IOException;

public class AutomatiqueRapport implements AfficherInfo {

	ControleMembre memb = new ControleMembre();
	ControlerFournisseur fourni = new ControlerFournisseur();
	
	public AutomatiqueRapport(){
		try{
			rapportsMembres	memb=new rapportsMembres();
			rapportFournisseurs fourni=new rapportFournisseurs();
			affiche();
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("initialiser");
		}

	}
	@Override
	public void affiche() throws IOException {
		System.out.println("Rapport automatique fournisseur ou membre");
		memb.afficher();
		fourni.afficher();
	}


}