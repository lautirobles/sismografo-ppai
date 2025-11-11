package com.sismografo.mapper;

import com.sismografo.dto.MuestraSismicaDto;
import com.sismografo.model.MuestraSismica;
import java.util.stream.Collectors;

public class MuestraSismicaMapper {

    public static MuestraSismicaDto entityToDto(MuestraSismica muestra) {
        if (muestra == null) return null;

        return MuestraSismicaDto.builder()
                .fechaHoraMuestra(muestra.getFechaHoraMuestra())
                .detalles(
                    muestra.getDetalleMuestraSismica() != null
                        ? muestra.getDetalleMuestraSismica().stream()
                            .map(DetalleMuestraSismicaMapper::entityToDto)
                            .collect(Collectors.toList())
                        : null
                )
                .build();
    }

    public static MuestraSismica dtoToEntity(MuestraSismicaDto dto) {
        if (dto == null) return null;

        MuestraSismica muestra = MuestraSismica.builder()
                .fechaHoraMuestra(dto.getFechaHoraMuestra())
                .build();

        if (dto.getDetalles() != null) {
            muestra.setDetalleMuestraSismica(
                dto.getDetalles().stream()
                    .map(DetalleMuestraSismicaMapper::dtoToEntity)
                    .collect(Collectors.toList())
            );
        }

        return muestra;
    }
}
