package br.com.fiap.heatwatch.persistencia;

import br.com.fiap.heatwatch.dominio.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
