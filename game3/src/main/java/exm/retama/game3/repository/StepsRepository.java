package exm.retama.game3.repository;


import exm.retama.game3.data.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepsRepository extends JpaRepository<Step, Long> {

    Step findFirstByOrderByIdDesc();

}
