package com.io.github.ktrzaskoma.model.meterstatus;

import org.springframework.stereotype.Service;

@Service
public class MeterStatusService {

    String meterCalculator(MeterStatus meterStatus) {

        double measurementToInt = Double.parseDouble(meterStatus.getMeasurement());
        double kiloWattPerHourPayment = 0.5;
        double taxPayment = 23;

        double finalRes = measurementToInt * kiloWattPerHourPayment * (1 + taxPayment / 100);

        String str = Double.toString(finalRes);
        return str;

    }

}
