package br.com.rafaelsouza.medicalconsult.consulta.repositories;

import br.com.rafaelsouza.medicalconsult.consulta.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
