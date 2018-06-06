package Transformation;

import cucumber.api.Transformer;
import javafx.scene.transform.Transform;

public class SalaryCountTransformer extends Transformer<Integer>  {

    @Override
    public Integer transform(String salary) {

        return salary.length();
    }

}
