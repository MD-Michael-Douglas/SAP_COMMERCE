import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private Date dataCadastro;

    @ManyToMany(mappedBy = "alunos")
    private Set<Curso> cursos;

    // Getters and Setters (usando Lombok)
    public Aluno(String nome, String email, Date dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.dataCadastro = dataCadastro;
    }
}
