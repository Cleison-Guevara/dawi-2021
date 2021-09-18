package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class ConsultarProducto {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql"); 
		
		EntityManager em = fabrica.createEntityManager();
		
		// proceso obtener producto
		Producto p = em.find(Producto.class, "P0032");
		if (p==null) {
			System.out.println("El Producto no existe");
		}else {
			System.out.println("Producto encontrado " + p.getDescripcion());
			System.out.println(p);
		}
		em.close();
		
	}

}
