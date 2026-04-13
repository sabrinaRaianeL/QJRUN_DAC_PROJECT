package com.qjrun.qjrun.service;


import com.qjrun.qjrun.entity.Aluno;
import com.qjrun.qjrun.entity.Plano;
import com.qjrun.qjrun.entity.Turma;
import com.qjrun.qjrun.repository.AlunoRepository;
import com.qjrun.qjrun.repository.PlanoRepository;
import com.qjrun.qjrun.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final PlanoRepository planoRepository;
    private final TurmaRepository turmaRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }
    public Aluno save(Aluno aluno) {

        Plano plano = planoRepository.findById(aluno.getPlano().getId())
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        aluno.setPlano(plano);

        if (aluno.getTurma() != null) {
            Turma turma = turmaRepository.findById(aluno.getTurma().getId())
                    .orElseThrow(() -> new RuntimeException("Turma não encontrada"));

            aluno.setTurma(turma);
        }

        return alunoRepository.save(aluno);
    }
    public Aluno findById(long id) {
        return alunoRepository.findById(id).orElseThrow(()-> new RuntimeException("aluno não encontrado!"));
    }
    public void delete(long id) {
        alunoRepository.deleteById(id);
    }
    public Aluno update(Long id, Aluno alunoAtualizado) {
        Aluno aluno = findById(id);

        aluno.setNome(alunoAtualizado.getNome());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setTelefone(alunoAtualizado.getTelefone());
        aluno.setDataNascimento(alunoAtualizado.getDataNascimento());

        return alunoRepository.save(aluno);
    }
}
