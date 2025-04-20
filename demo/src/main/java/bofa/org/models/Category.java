package bofa.org.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Category {
    String name;
    String description;
    List<Product> products;
}
