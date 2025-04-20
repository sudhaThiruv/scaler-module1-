package org.scaler.product.productservice.TableInheritanceExamples.JoinedClass;

import jakarta.persistence.*;

@Entity(name="jc_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    Long id;
}
