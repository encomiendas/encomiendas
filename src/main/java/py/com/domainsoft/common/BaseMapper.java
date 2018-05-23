package py.com.domainsoft.common;

import java.util.List;

public interface BaseMapper<E, D> {
    List<D> entityListToDtoList(List<E> entityList);

    D entityToDto(E entity);

    E dtoToEntity(D dto);
}
