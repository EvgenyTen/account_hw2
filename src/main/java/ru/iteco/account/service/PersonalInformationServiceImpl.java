package ru.iteco.account.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.iteco.account.model.PersonalInfo;

@Service
public class PersonalInformationServiceImpl implements PersonalInformationService {

    @Value("${name}")
    private String name;

    @Override
    public PersonalInfo getPersonalInfoById(Integer id) {
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setName(name);
        personalInfo.setUserId(id);
        return personalInfo;
    }
}
