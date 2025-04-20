package org.scaler.product.productservice.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_ta")
@DiscriminatorValue(value ="0")
public class Ta extends User {
    int numberOfHelpReq;
}
