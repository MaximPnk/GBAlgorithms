package hw5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Thing {
    private String name;
    private int price;
    private int weight;

    @Override
    public String toString() {
        return name;
    }
}
