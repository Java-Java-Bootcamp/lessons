package com.example.jpalesson.config;

import com.example.jpalesson.dao.CompanyRepository;
import com.example.jpalesson.model.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class SampleDataConfig implements InitializingBean {

    private final Logger LOG = LoggerFactory.getLogger(SampleDataConfig.class);

    private final CompanyRepository companyRepository;

    public SampleDataConfig(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void afterPropertiesSet() {
        LOG.info("Bootstrapping data...");
        Company company = new Company();
        company.setName("Google");
        companyRepository.save(company);
        LOG.info("...Bootstrapping completed");
    }
}
