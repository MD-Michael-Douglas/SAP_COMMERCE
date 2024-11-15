import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public InscricaoDTO inscreverAluno(@RequestBody InscricaoDTO inscricaoDTO) {
        Aluno aluno = alunoRepository.findById(inscricaoDTO.getAlunoId()).orElseThrow();
        Curso curso = cursoRepository.findById(inscricaoDTO.getCursoId()).orElseThrow();

        Inscricao inscricao = new Inscricao();
        inscricao.setAluno(aluno);
        inscricao.setCurso(curso);
        inscricao.setDataInscricao(new Date());
        inscricaoRepository.save(inscricao);

        return new InscricaoPopulator().toInscricaoDTO(inscricao);
