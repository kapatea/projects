/**
 * 
 */
package com.orileo.edairy.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orileo.edairy.authservice.modal.Student;

/**
 * @author H Kapil Kumar
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long>
{
}