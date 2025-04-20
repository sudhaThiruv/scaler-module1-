package org.scaler.product.productservice.TableInheritanceExamples.JoinedClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="jc_ta")
@PrimaryKeyJoinColumn(name="user_id")
public class Ta extends User {
    int numberOfHelpReq;
}
