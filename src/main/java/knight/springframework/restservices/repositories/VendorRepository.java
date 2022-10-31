package knight.springframework.restservices.repositories;

import knight.springframework.restservices.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor,Long> {



}
