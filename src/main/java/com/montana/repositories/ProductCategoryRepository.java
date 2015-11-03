package com.montana.repositories;

import com.montana.models.nodes.ProductCategory;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by alex on 3/11/15.
 */

@NodeEntity
public interface ProductCategoryRepository extends GraphRepository<ProductCategory> {
}
