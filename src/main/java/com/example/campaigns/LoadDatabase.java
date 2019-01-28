package com.example.campaigns;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(CampaignRepository campaignRepository){
        return args -> {
            log.info("Preloading" + campaignRepository.save(new Campaign("Smart Lock","atomation home, smart lock, door security",10d,1000d,"on","Warszawa",145)));



        };
    }

}
