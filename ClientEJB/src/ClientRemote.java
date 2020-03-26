import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.BanqueRemote;
import metier.entities.Compte;

public class ClientRemote {
	
	public static void main(String[] args) {
		try {
			Context ctx = new InitialContext();
			String appName="BanqueEAR";
			String moduleName="BanqueEJB";
			String beanName="BK";
			String remoteInterface="metier.BanqueRemote";
			String name="ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+remoteInterface;
			BanqueRemote proxy = (BanqueRemote) ctx.lookup(name);
			
			proxy.addCompte(new Compte());
			proxy.addCompte(new Compte());
			proxy.addCompte(new Compte());
			
			
			Compte compte = proxy.getCompte(1L);
			System.out.println(compte.getSolde());
			
			proxy.verser(1L, 4000);
			proxy.retirer(1L, 2000);
			proxy.virement(1L, 2L, 1000);
			
			List<Compte> comptes = proxy.listeComptes();
			for(Compte compte1 : comptes) {
				System.out.println(compte1.getCode()+":"+compte1.getSolde());
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
