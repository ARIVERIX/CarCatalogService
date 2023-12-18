package catalogcar.catalogcar.Repository;


import catalogcar.catalogcar.Model.Offer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
    Optional<Offer> findByDescription(String description);
    List<Offer> findAllByOrderByPriceDesc(PageRequest pageRequest);

    @Modifying
    @Transactional
    void deleteByDescription(String description);
}
