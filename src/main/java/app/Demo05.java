package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	
	public static void main(String[] args) {
		// especificar la conexion de BD
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql"); 
		
		// Obtener el DAO 
		EntityManager em = fabrica .createEntityManager();
		
		//proceso.. obtener un nuevo usuario
		Usuario u = em.find(Usuario.class, 13);
		if (u == null) {
			System.out.println("el usuario no existe");
		}else {
			System.out.println("Usuario eliminado " + u.getNombre());
			System.out.println(u);
			em.getTransaction().begin();
			em.remove(u);; //eliminar
			em.getTransaction().commit();
			System.out.println("eliminacion OK");
		}
		
		
		em.close();
	}
	

}
