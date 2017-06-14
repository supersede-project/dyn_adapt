package eu.supersede.dynadapt.adapter.dashboard.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.supersede.dynadapt.adapter.dashboard.model.Action;

public interface ActionsJpa extends JpaRepository<Action, String>{

}
