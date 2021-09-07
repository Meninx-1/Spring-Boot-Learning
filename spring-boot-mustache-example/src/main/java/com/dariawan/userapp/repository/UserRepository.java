package com.dariawan.userapp.repository;
 
import com.dariawan.userapp.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>, 
        JpaSpecificationExecutor<User> {
}

/*
The JpaSpecificationExecutor interface adds methods which will allow us to execute Specifications, for example, these:

List<T> findAll(Specification<T> spec);

Page<T> findAll(Specification<T> spec, Pageable pageable);

List<T> findAll(Specification<T> spec, Sort sort);

Finally, to execute our query we can simply call:

List<Product> products = productRepository.findAll(namelike("reflectoring"));
We can also take advantage of findAll() functions overloaded with Pageable and 
Sort in case we are expecting a large number of records in the result or want records in sorted order.

*/