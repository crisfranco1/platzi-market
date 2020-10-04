package com.platzi.market.persistence.dao;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoDaoRepository extends CrudRepository<Producto, Integer> {

    // Si estamos usando @Query, el metodo se puede llamar como queramos(sin respetar la sintaxis de Query Methods)
    // y se realiza la consulta dentro de @Query.
    // Si no usamos @Query la consulta se realiza en base a Query Methods.
    // @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
