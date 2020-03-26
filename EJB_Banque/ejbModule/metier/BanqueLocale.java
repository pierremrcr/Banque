 package metier;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Compte;

@Local
public interface BanqueLocale {
	
	public Compte addCompte(Compte compte);
	public Compte getCompte(Long code);
	public List<Compte> listeComptes();
	public void verser(Long code, double mt);
	public void retirer(Long code, double mt);
	public void virement(Long codeCompte1, Long codeCompte2, double mt);

}
