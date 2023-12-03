package com.ll.sbbmission.user.user.repository;

import com.ll.sbbmission.user.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
}
