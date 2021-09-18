package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class RegistrarProducto {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		// se obtiene el DAO
		EntityManager em = fabrica.createEntityManager();
		
		// proceso registrar
		Producto p = new Producto();
		p.setIdprod("P0032");
		p.setDescripcion("Jamon");
		p.setStock(1);
		p.setPrecio(3.50);
		p.setIdcategoria(2);
		p.setEstado(1);
		
		// Transaccion registrar
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Se Resgistro correctamente");
		em.close();
		
	}

}
