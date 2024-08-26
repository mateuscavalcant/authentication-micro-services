package authenticated_route.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import authenticated_route.home.model.HomeModel;
import authenticated_route.home.repository.HomeRepository;

@Service
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;

    public String getNameByUsername(String username) {
        HomeModel homeModel = homeRepository.findByUsername(username);
        return homeModel != null ? homeModel.getName() : null;
    }
}
