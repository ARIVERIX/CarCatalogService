package catalogcar.catalogcar.Repository;

import catalogcar.catalogcar.DTO.AddModelsDto;

import catalogcar.catalogcar.Model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, Integer>{

    Optional<Model> findByName(String name);
    @Modifying
    @Transactional
    void deleteByName(String name);

}
