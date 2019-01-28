package com.example.campaigns;


public class CampaignNotFoundException extends RuntimeException {
    CampaignNotFoundException(Long id){
        super("Cought not found campaign "+id);
    }

}
