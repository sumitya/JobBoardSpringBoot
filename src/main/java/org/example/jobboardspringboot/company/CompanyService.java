package org.example.jobboardspringboot.company;

import org.example.jobboardspringboot.job.Job;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);

    void createCompany(Company company);

    boolean updateCompany(Long id, Company company);

    boolean deleteCompanyById(Long id);

}
