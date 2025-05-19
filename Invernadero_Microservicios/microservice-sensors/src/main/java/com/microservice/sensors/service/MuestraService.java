package com.microservice.sensors.service;

import com.mycompany.utilities.dto.MuestraDto;

import java.util.List;

public interface MuestraService {
    MuestraDto createMuestra(MuestraDto muestraDto);

    List<MuestraDto> readAllMuestra();
}
