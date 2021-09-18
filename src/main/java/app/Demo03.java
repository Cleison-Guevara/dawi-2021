package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
	public static void main(String[] args) {
		// especificar la conexion de BD
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql"); 
		
		// Obtener el DAO 
		EntityManager em = fabrica .createEntityManager();
		
		//proceso.. eliminar un usuario
		Usuario u = new Usuario();
		u.setCodigo(13);
		/*u.setNombre("Eren");
		u.setApellido("Jeager");
		u.setUsuario("calinrodri12@gmail.com");
		u.setClave("titan");
		u.setFnacim("2010/08/27");
		u.setTipo(1);
		u.setEstado(1);*/
		
		// reg, act, elim -> Transacciones
		em.getTransaction().begin();
		em.remove(u);; //eliminar
		em.getTransaction().commit();
		System.out.println("eliminacion OK");
		em.close();
	}


}
