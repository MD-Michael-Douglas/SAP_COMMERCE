import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public AlunoDTO cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getEmail(), alunoDTO.getDataCadastro());
        alunoRepository.save(aluno);
        return new InscricaoPopulator().toAlunoDTO(aluno);
    }

    @GetMapping("/{id}")
    public AlunoDTO buscarAluno(@PathVariable Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        return new InscricaoPopulator().toAlunoDTO(aluno);
    }
}
