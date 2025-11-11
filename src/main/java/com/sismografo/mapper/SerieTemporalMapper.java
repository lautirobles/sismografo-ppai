package com.sismografo.mapper;

import com.sismografo.dto.SerieTemporalDto;
import com.sismografo.model.SerieTemporal;
import java.util.stream.Collectors;

public class SerieTemporalMapper {

    public static SerieTemporalDto entityToDto(SerieTemporal serie) {
        if (serie == null) return null;

        return SerieTemporalDto.builder()
                .fechaHoraRegistro(serie.getFechaHoraRegistro())
                .muestras(
                    serie.getMuestrasSismicas() != null
                        ? serie.getMuestrasSismicas().stream()
                            .map(MuestraSismicaMapper::entityToDto)
                            .collect(Collectors.toList())
                        : null
                )
                .build();
    }

    public static SerieTemporal dtoToEntity(SerieTemporalDto dto) {
        if (dto == null) return null;

        SerieTemporal serie = SerieTemporal.builder()
                .fechaHoraRegistro(dto.getFechaHoraRegistro())
                .build();

        if (dto.getMuestras() != null) {
            serie.setMuestrasSismicas(
                dto.getMuestras().stream()
                    .map(MuestraSismicaMapper::dtoToEntity)
                    .collect(Collectors.toList())
            );
        }

        return serie;
    }
}
