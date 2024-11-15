import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public CursoDTO cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
        Curso curso = new Curso(cursoDTO.getNome(), cursoDTO.getDescricao(), cursoDTO.getDataCriacao());
        cursoRepository.save(curso);
        return new InscricaoPopulator().toCursoDTO(curso);
    }

    @GetMapping("/{id}")
    public CursoDTO buscarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        return new InscricaoPopulator().toCursoDTO(curso);
    }
}
