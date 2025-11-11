package com.sismografo.mapper;

import com.sismografo.dto.DetalleMuestraSismicaDto;
import com.sismografo.model.DetalleMuestraSismica;
import com.sismografo.model.TipoDeDato;

public class DetalleMuestraSismicaMapper {

    public static DetalleMuestraSismicaDto entityToDto(DetalleMuestraSismica detalle) {
        if (detalle == null) return null;

        TipoDeDato tipo = detalle.getTipoDeDato();

        return DetalleMuestraSismicaDto.builder()
                .valor(detalle.getValor())
                .denominacion(tipo != null ? tipo.getDenominacion() : null)
                .build();
    }

    public static DetalleMuestraSismica dtoToEntity(DetalleMuestraSismicaDto dto) {
        if (dto == null) return null;

        return DetalleMuestraSismica.builder()
                .valor(dto.getValor())
                // tipoDeDato se asigna en el Service usando la denominacion
                .build();
    }
}
