package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.entity.AddressEntity;
import sfr.application.corporateportal.portal.repository.AddressRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final HistoryService historyService;
    public List<AddressEntity> getAllAddress() {
        return addressRepository.findAll();
    }
}
