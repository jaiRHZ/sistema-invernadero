package com.microservice.sensors.service.imp;


import com.microservice.sensors.entity.Muestra;
import com.microservice.sensors.mapper.MuestraMapper;
import com.microservice.sensors.repository.MuestraRepository;
import com.microservice.sensors.service.MuestraService;
import com.mycompany.utilities.dto.MuestraDto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MuestraServiceImp implements MuestraService {

    @Autowired
    private MuestraRepository muestraRepository;

    @Autowired
    private MuestraMapper muestraMapper;

    @Override
    public MuestraDto createMuestra(MuestraDto muestraDto) {
        Muestra muestra = muestraMapper.mapperToMuestra(muestraDto);
        muestra = muestraRepository.save(muestra);
        return muestraMapper.mapperToMuestraDto(muestra);
    }

    @Override
    public List<MuestraDto> readAllMuestra() {
        List<Muestra> muestras = muestraRepository.findAll();
        List<MuestraDto> muestrasDto = new ArrayList<>();
        for (Muestra muestra : muestras) {
            muestrasDto.add(muestraMapper.mapperToMuestraDto(muestra));
        }
        return muestrasDto;
    }

}
