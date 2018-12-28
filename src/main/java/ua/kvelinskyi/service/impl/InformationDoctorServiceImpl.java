package ua.kvelinskyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kvelinskyi.entity.InformationDoctor;
import ua.kvelinskyi.repository.InformationDoctorRepository;
import ua.kvelinskyi.service.InformationDoctorService;

import java.util.List;

@Service
public class InformationDoctorServiceImpl implements InformationDoctorService{
    private InformationDoctorRepository  informationDoctorRepository;
    @Autowired
    public void setInformationDoctorRepository(InformationDoctorRepository  informationDoctorRepository){
        this.informationDoctorRepository = informationDoctorRepository;
    }
    @Override
    public InformationDoctor addInformationDoctor(InformationDoctor informationDoctor) {
        return informationDoctorRepository.saveAndFlush(informationDoctor);
    }

    @Override
    public List<InformationDoctor> getAll() {
        return informationDoctorRepository.findAll();
    }

    @Override
    public InformationDoctor editInformationDoctor(InformationDoctor informationDoctor) {
        return informationDoctorRepository.saveAndFlush(informationDoctor);
    }

    @Override
    public InformationDoctor getById(Integer informationDoctorID) {
        return informationDoctorRepository.findOne(informationDoctorID);
    }


}
