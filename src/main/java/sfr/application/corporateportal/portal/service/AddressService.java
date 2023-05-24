package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.entity.AddressEntity;
import sfr.application.corporateportal.portal.repository.AddressRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public List<AddressEntity> getAllAddress() {
        return addressRepository.findAll();
    }
}
