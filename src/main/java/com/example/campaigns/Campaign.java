package com.example.campaigns;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Data
@Entity

public class Campaign {
 //komentarz
    private @Id @GeneratedValue Long id;
    @NotNull
    private String nameOfCampaign;
    @NotNull
    private String keywords;
    @NotNull
    private double  bidAmount;
    @NotNull
    private double  campaignFund;
    @NotNull
    private String status;
    @NotNull
    private String town;
    @NotNull
    private int radius;

    private double avalibleFund;

    public Campaign(){};
    public Campaign(String nameOfCampaign,String keywords,double bidAmount,double campaignFund, String status, String town, int radius){
        this.nameOfCampaign=nameOfCampaign;
        this.keywords=keywords;
        this.bidAmount=bidAmount;
        this.campaignFund=campaignFund;
        this.status=status;
        this.town=town;
        this.radius=radius;

    }

}
