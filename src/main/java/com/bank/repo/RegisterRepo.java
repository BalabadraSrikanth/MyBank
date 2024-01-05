package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.Entity.OpenAccount;

import jakarta.transaction.Transactional;

@Repository
public interface RegisterRepo extends JpaRepository<OpenAccount, Long> {
    @Query(value = "select amount from open_account where accountnumber = :acno", nativeQuery = true)
    public Double findBalanceByAccountNumber(@Param("acno") Long acno);
    
    @Modifying
    @Transactional
    @Query(value="update open_account set amount =:amount where accountnumber =:acno", nativeQuery = true)
    public void updateAmount(@Param("acno") Long acno,@Param("amount") Double amount);
    
    @Modifying
    @Transactional
    @Query(value = "update open_account set status=:status where accountnumber=:acno", nativeQuery = true)
    public void updateStatus(@Param("acno") Long acno,@Param("status") String status);

   
    @Query(value = "select status from open_account where accountnumber=:acno", nativeQuery = true)
    public String checkStatus(@Param("acno") Long acno);

}


