package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SalvarBD {

	EntityManager entityManager;
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("piru");

	public SalvarBD() {
		entityManager = emfactory.createEntityManager();
	}

	public void salvar(Object o) {
			entityManager.getTransaction().begin();
			entityManager.persist(o);
			entityManager.getTransaction().commit();
		
	}

	public void salvarVarias(int num, List<Object> objetos) {
		entityManager.getTransaction().begin();
		for (int i = 0; i < num; i++) {
			entityManager.persist(objetos.get(i));
		}
		entityManager.getTransaction().commit();
	}

	public Object pegar(Class t, Object chave) {
		Object objeto = entityManager.find(t , chave);
		return objeto;
	}
	
	
	public void set(Object o) {
		entityManager.getTransaction().begin();
		o = entityManager.merge(o);
		entityManager.persist(o);
		entityManager.getTransaction().commit();
	}

	public void remover(Object o) {
		entityManager.getTransaction().begin();
		o = entityManager.merge(o);
		entityManager.remove(o);
		entityManager.getTransaction().commit();
	}

	public List pegarVarias(Class t, String atributo, String valor) {
		Query query = entityManager.createQuery("from " + t.getName() +" where "+ atributo +" like :valor");

		query.setParameter("valor", valor);
		return query.getResultList();

	}

	public List pegarVarias(Class t) {
		Query query = entityManager.createQuery("from " + t.getName());
		return query.getResultList();

	}

}
