package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Referee;

public interface RefereeRepository extends JpaRepository<Referee, Integer> {

}
