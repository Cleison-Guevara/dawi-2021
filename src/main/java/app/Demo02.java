package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	
	public static void main(String[] args) {
		// especificar la conexion de BD
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql"); 
		
		// Obtener el DAO 
		EntityManager em = fabrica .createEntityManager();
		
		//proceso.. actualizar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(13);
		u.setNombre("Eren");
		u.setApellido("gggdddg");
		u.setUsuario("12345@gmail.com");
		u.setClave("titan");
		u.setFnacim("2010/08/27");
		u.setTipo(1);
		u.setEstado(1);
		
		// reg, act, elim -> Transacciones
		try {
			em.getTransaction().begin();
			em.merge(u); //actualizar si existe el codigo / si no existe lo crea
			em.getTransaction().commit();
			System.out.println("actualizacion OK");
		} catch (Exception e) {
			System.out.println("Error : "+ e.getMessage());
		}
		em.close();
	}


}
