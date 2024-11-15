import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private Date dataCriacao;

    @ManyToMany
    @JoinTable(
        name = "inscricao",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private Set<Aluno> alunos;

    // Getters and Setters (usando Lombok)
    public Curso(String nome, String descricao, Date dataCriacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }
}
