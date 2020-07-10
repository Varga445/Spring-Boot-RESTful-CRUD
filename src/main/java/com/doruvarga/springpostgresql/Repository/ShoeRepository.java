package com.doruvarga.springpostgresql.Repository;

import com.doruvarga.springpostgresql.Model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//asa transformi interfata asta intr-o componenta
@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Integer> {


}
