package org.example.jobboardspringboot.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        if(companies != null) return ResponseEntity.ok(companies);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @PostMapping("{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        boolean updated = companyService.updateCompany(id,company);
        if(updated) return new ResponseEntity<>(null, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
