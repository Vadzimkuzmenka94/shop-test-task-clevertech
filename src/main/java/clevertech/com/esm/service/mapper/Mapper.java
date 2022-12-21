package clevertech.com.esm.service.mapper;

import org.springframework.stereotype.Service;

@Service
public interface Mapper<T, E> {
    E mapToDto(T entity) throws Exception;
    T mapToEntity(E dto) throws Exception;
}