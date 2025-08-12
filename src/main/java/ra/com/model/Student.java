package ra.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Data = @NoArgsConstructor + @AllArgsConstructor + @Getter + @Setter + Others
public class Student {
    private int studentId;
    private String studentName;
    private int age;
    private boolean status;
}
