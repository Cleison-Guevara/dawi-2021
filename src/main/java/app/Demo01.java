package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
	public static void main(String[] args) {
		// especificar la conexion de BD
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql"); 
		
		// Obtener el DAO 
		EntityManager em = fabrica .createEntityManager();
		
		//proceso.. registrar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(11);
		u.setNombre("Eren");
		u.setApellido("ggggggg");
		u.setUsuario("eren123@gmail.com");
		u.setClave("paloma");
		u.setFnacim("2021/08/27");
		u.setTipo(1);
		u.setEstado(1);
		
		// reg, act, elim -> Transacciones
		em.getTransaction().begin();
		em.persist(u);	//registrar
		em.getTransaction().commit();
		System.out.println("Registro OK");
		em.close();
	}

}
