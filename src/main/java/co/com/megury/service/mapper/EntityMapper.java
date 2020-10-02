package co.com.megury.service.mapper;

import java.util.List;

/**
 * @param <D> Dto Class
 * @param <E> Entity Class
 */
public interface EntityMapper<D,E> {

    D toDto(E entity);
    E toEntity(D dto);
    List<D> toDtoList(List<E> entities);
    List<E> toEntityList(List<D> dtos);

}
