import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;


public class Tests {

	Fournisseur fourni1;
	Membres membre1;
	BaseDonnerFournisseur baseFournis;
	BaseDonnerMembre baseMembres;
	operateurs op = new operateurs();
	private String nom="Garcia", 
			nom2="Ballen";
	private String prenom="Edicson", 
			prenom2="Claudia";
	private int numero=op.genererNumeroFournisseur(), 
			numero2=op.genererNumeroMembre();
	private String adresse="1400zotique", 
			adresse2="1410Marquette";
	private String ville="Montreal", 
			ville2="Toronto";
	private String province="QC", 
			province2="ON";
	private String codeDePostal="H2g1g", 
			codeDePostal2="y1r34";
	private String dateDuService="",
			dateDuService2="12122011";
	private String nomDuMembre="";


	private String nomDuService="";
	private double codeDuService=12345;
	private double montant=20, 
			montant2=50;
	private String telephone="";


	String message = "Test reussit!";
	String erreur = "Test echoué!";

	@Before
	public void creerDonnees () {

		// founisseur a int numero, double montant et double codeDuService
		fourni1 = new Fournisseur(numero, nom, prenom,
				adresse, ville,province, codeDePostal);

		// membres a int numero et double montant
		membre1 = new Membres(numero2,  nom2, prenom2,
				adresse2, ville2,province2,codeDePostal);

	}

	@Before
	public void creerBaseDonnees() throws IOException {

		baseFournis = new BaseDonnerFournisseur();
		baseFournis.open("FournisseurTest.dat");

		baseMembres = new BaseDonnerMembre();
		baseMembres.open("MembresTests.dat");

	}

	@Before
	public void ajouterDonnees() throws IOException{

		int position = baseFournis.size();
		baseFournis.write(position, fourni1);

		position = baseMembres.size();
		baseMembres.write(position, membre1);

	}


	@Test
	public void testFindFournisseur() {

		try {
			int position = baseFournis.find(fourni1.getNumero());
			Fournisseur trouve = baseFournis.read(baseFournis.find(numero));
			Assert.assertEquals(message, "Garcia", trouve.getNom()); // TODO afficher message de test reussit
		} catch (IOException e) {
			System.out.println(erreur);

		}
	}

	@Test
	public void testFindMembre() {

		try {
			int position = baseMembres.find(membre1.getNumero());
			Membres trouve = baseMembres.read(baseMembres.find(numero2));
			Assert.assertEquals(message, "Ballen", trouve.getNom()); // TODO afficher message de test reussit 
		} catch (IOException e) {
			System.out.print(erreur);
		}
	}
}
