package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 2L);
		usuario.setNome("Zequinha");
		usuario.setEmail("zequinha@gmail.com.br");
		
		//em.merge(usuario); alterado o dado mesmo sem o "merge". Qualquer mudança o Jpa sincroniza com o BD, mesmo se não chamar o merge		
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
