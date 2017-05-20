package eu.supersede.dynadapt.adapter.dashboard.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.supersede.dynadapt.adapter.dashboard.model.Adaptation;

public interface AdaptationsJpa extends JpaRepository<Adaptation, Long> {

}
