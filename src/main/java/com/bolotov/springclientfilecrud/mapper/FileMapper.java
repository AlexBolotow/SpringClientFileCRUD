package com.bolotov.springclientfilecrud.mapper;

import com.bolotov.springclientfilecrud.dto.FileDTO;
import com.bolotov.springclientfilecrud.entity.File;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileMapper {
    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

    FileDTO fileToFileDTO(File file);

    File fileDTOtoFile(FileDTO dto);
}
