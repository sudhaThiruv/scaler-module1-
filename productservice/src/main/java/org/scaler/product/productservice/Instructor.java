package org.scaler.product.productservice;

import jakarta.persistence.Entity;
import org.scaler.product.productservice.TableInheritanceExamples.TablePerClass.User;

@Entity(name="tpc_instructor")
public class Instructor extends User {
    String company;
}
