package br.com.fiap.heatwatch.persistencia;

import br.com.fiap.heatwatch.dominio.Medicao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedicaoRepository extends JpaRepository<Medicao, Long> {

    List<Medicao> findByTipoSensor(String tipoSensor);

}
