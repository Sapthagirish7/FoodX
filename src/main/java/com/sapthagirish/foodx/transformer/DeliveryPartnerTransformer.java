package com.sapthagirish.foodx.transformer;

import com.sapthagirish.foodx.dto.request.DeliveryPartnerRequest;
import com.sapthagirish.foodx.model.DeliveryPartner;

import java.util.ArrayList;

public class DeliveryPartnerTransformer {
    public static DeliveryPartner PartnerRequestToDeliveryPartner(
            DeliveryPartnerRequest deliveryPartnerRequest){

        return DeliveryPartner.builder()
                .name(deliveryPartnerRequest.getName())
                .mobileNumber(deliveryPartnerRequest.getMobileNo())
                .gender(deliveryPartnerRequest.getGender())
                .orders(new ArrayList<>())
                .build();
    }
}
