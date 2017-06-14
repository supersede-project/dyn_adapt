package eu.supersede.dynadapt.adapter.dashboard.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.supersede.dynadapt.adapter.dashboard.model.Enactment;

public interface EnactmentsJpa extends JpaRepository<Enactment, String> {

}
