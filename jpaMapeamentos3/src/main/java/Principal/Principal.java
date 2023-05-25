	package Principal;
	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.Persistence;
	import java.util.Arrays;
	import java.util.Collections;
	import jpaMapeamentos3.Classe;
	import jpaMapeamentos3.Professor;

	public class Principal {

		public static void main(String[] args) {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("dbjpa3");
			
			EntityManager entitymanager = emfactory.createEntityManager();
		
			entitymanager.getTransaction().begin();
			
			Classe classe1 = new Classe();
			classe1.setCnome("Portugues");
			
			Classe classe2 = new Classe();
			classe2.setCnome("Quimica");
			
			Classe classe3 = new Classe();
			classe3.setCnome("Matematica");
			
			Classe classe4 = new Classe();
			classe4.setCnome("Fisica");
		
			Professor professor1 = new Professor();
			professor1.setTnome("Caique");
			professor1.setAssunto("Exatas");
			professor1.setClasse(Arrays.asList(classe3, classe4));
			
			Professor professor2 = new Professor();
			professor2.setTnome("Fabio");
			professor2.setAssunto("Exatas");
			professor2.setClasse(Collections.singletonList(classe2));
			
			Professor professor3 = new Professor();
			professor3.setTnome("Gabriela");
			professor3.setAssunto("Humanas");
			professor3.setClasse(Collections.singletonList(classe1));


			entitymanager.persist(professor1);
			entitymanager.persist(professor2);
			entitymanager.persist(professor3);
			entitymanager.persist(classe1);
			entitymanager.persist(classe2);
			entitymanager.persist(classe3);
			entitymanager.persist(classe4);

			entitymanager.getTransaction().commit();
			entitymanager.close();
			emfactory.close();


		}


	}
