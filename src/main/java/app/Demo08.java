package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {
	
	public static void main(String[] args) {
		// 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql"); 
		
		// 
		EntityManager em = fabrica.createEntityManager();
		
		//
		String sql = "Select u from Usuario u where u.usuario = :xuser and u.clave = :xcla";
		TypedQuery<Usuario> query3 = em.createQuery(sql, Usuario.class);
		query3.setParameter("xuser", "U002@gmail.com");
		query3.setParameter("xcla", "10002");
		
		Usuario u = null;
		try {
			 u = query3.getSingleResult();
		} catch (NoResultException e) {
				
		}
		
		if (u == null) {
			System.out.println("el usuario no existe");
		}else {
			System.out.println("Usuario encontrado " + u.getNombre());
			System.out.println(u);
		}
		
		em.close();
	}

}
