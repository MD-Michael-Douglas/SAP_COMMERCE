import org.springframework.stereotype.Component;

@Component
public class InscricaoPopulator {

    public AlunoDTO toAlunoDTO(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setDataCadastro(aluno.getDataCadastro());
        return dto;
    }

    public CursoDTO toCursoDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setDescricao(curso.getDescricao());
        dto.setDataCriacao(curso.getDataCriacao());
        return dto;
    }

    public InscricaoDTO toInscricaoDTO(Inscricao inscricao) {
        InscricaoDTO dto = new InscricaoDTO();
        dto.setAlunoId(inscricao.getAluno().getId());
        dto.setCursoId(inscricao.getCurso().getId());
        dto.setDataInscricao(inscricao.getDataInscricao());
        return dto;
    }
}
