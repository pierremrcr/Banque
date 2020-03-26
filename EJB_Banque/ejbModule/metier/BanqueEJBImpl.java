package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Compte;

@Stateless(name="BK")
public class BanqueEJBImpl implements BanqueLocale, BanqueRemote {
	
	@PersistenceContext(unitName="BanqueEJB")
	private EntityManager em;

	@Override
	public Compte addCompte(Compte compte) {
		em.persist(compte);
		return compte;
	}

	@Override
	public Compte getCompte(Long code) {
		Compte compte = em.find(Compte.class, code);
		if(compte==null) throw new RuntimeException("Compte introuvable");
		return compte;
	}

	@Override
	public List<Compte> listeComptes() {
	    Query request = em.createQuery("select c from Compte c");
		return request.getResultList();
	} 

	@Override
	public void verser(Long code, double mt) {
		Compte compte = getCompte(code);
		compte.setSolde(compte.getSolde()+mt);
	}

	@Override
	public void retirer(Long code, double mt) {
		Compte compte = getCompte(code);
		compte.setSolde(compte.getSolde()-mt);	
	}

	@Override
	public void virement(Long codeCompte1, Long codeCompte2, double mt) {
		retirer(codeCompte1, mt);
		verser(codeCompte2, mt);
	}

}
