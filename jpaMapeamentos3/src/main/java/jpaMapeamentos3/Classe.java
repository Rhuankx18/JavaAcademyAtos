	package jpaMapeamentos3;
	import java.util.List;
	import javax.persistence.Entity;
	import javax.persistence.ManyToMany;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	

	@Entity
	public class Classe {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int cid;
		private String cnome;
		
		@ManyToMany(mappedBy = "classe")
		private List<Professor> professor;
		
		public int getCid() {
			return cid;
		}
		public void setCid(int cid) {
			this.cid = cid;
		}
		public String getCnome() {
			return cnome;
		}
		public void setCnome(String cnome) {
			this.cnome = cnome;
		}
		public List<Professor> getProfessor() {
			return professor;
		}
		public void setProfessor(List<Professor> professor) {
			this.professor = professor;
		}
	}
