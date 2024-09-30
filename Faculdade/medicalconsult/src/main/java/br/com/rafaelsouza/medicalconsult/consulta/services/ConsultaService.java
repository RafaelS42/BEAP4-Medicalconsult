package br.com.rafaelsouza.medicalconsult.consulta.services;

import br.com.rafaelsouza.medicalconsult.consulta.domain.Consulta;
import br.com.rafaelsouza.medicalconsult.consulta.repositories.ConsultaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta cadastrarConsulta(Consulta consulta){
        consulta.setIdConsulta(null);
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas(){
        return consultaRepository.findAll();
    }

    public Consulta buscarConsulta(Long id){
        Optional<Consulta> consulta = consultaRepository.findById(id);
        return consulta.orElseThrow(()->new ObjectNotFoundException("Especialidade não encontrada! ID: ", id));
    }

    public void deletarConsulta(Long id){
        buscarConsulta(id);
        try {
            consultaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possivel excluir, porque há entidades relacionadas");
        }
    }

    private void updateData(Consulta novaConsulta, Consulta consulta){
        novaConsulta.setDataConsulta(consulta.getDataConsulta());
        novaConsulta.setProfissional(consulta.getProfissional());
        novaConsulta.setProfissional(consulta.getEspecialidade());
    }

    public Consulta atualizarConsulta(Consulta consulta){
        Consulta novaConsulta = buscarConsulta(consulta.getIdConsulta());
        updateData(novaConsulta, consulta);
        return consultaRepository.save(novaConsulta);
    }
}
