package catalogcar.catalogcar.Repository;


import catalogcar.catalogcar.Model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


public interface BrandRepository extends JpaRepository<Brand, Integer>{
    Optional<Brand> findByName(String name);
    @Modifying
    @Transactional
    void deleteByName(String name);
}