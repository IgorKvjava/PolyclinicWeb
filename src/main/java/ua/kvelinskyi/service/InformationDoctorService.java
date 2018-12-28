package ua.kvelinskyi.service;

import ua.kvelinskyi.entity.InformationDoctor;

import java.util.List;

public interface InformationDoctorService {

    InformationDoctor addInformationDoctor(InformationDoctor informationDoctor);

    List<InformationDoctor> getAll();

    InformationDoctor editInformationDoctor(InformationDoctor informationDoctor);

    InformationDoctor getById(Integer informationDoctorID);
}
