package org.scaler.product.productservice.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name="tpc_ta")
public class Ta extends User{
    int numberOfHelpReq;
}
