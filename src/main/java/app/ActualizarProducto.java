package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class ActualizarProducto {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em = fabrica.createEntityManager();
		
		// proceso actualizar
		
		Producto p = new Producto();
		p.setIdprod("P0032");
		p.setDescripcion("Jamon");
		p.setStock(20);
		p.setPrecio(7.50);
		p.setIdcategoria(2);
		p.setEstado(1);
		
		// transaccion 
		try {
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			System.out.println("Se Actualizo correctamente");
		} catch (Exception e) {
			System.out.println("Error : " +e.getMessage());
		}
		em.close();
		
	}

}
