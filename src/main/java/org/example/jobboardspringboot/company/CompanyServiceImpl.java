package org.example.jobboardspringboot.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> companyOptional = companyRepo.findById(id);
        if (companyOptional.isPresent()) {
            Company companyUpdated = companyOptional.get();
            companyUpdated.setName(company.getName());
            companyUpdated.setDesc(company.getDesc());
            companyRepo.save(companyUpdated);
            return true;
        }

        return false;
    }

    public void createCompany(Company company) {
        companyRepo.save(company);
    }
}
