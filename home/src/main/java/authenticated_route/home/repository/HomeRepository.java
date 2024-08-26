package authenticated_route.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import authenticated_route.home.model.HomeModel;

public interface HomeRepository extends JpaRepository<HomeModel, Long> {
    HomeModel findByUsername(String username);
    
}
