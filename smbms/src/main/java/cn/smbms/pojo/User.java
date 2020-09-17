package cn.smbms.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class User {
    private Integer id; //id
    @NotEmpty(message = "用户编码不能为空")
    private String userCode; //用户编码
    private String userName; //用户名称
    @Length(min = 6, max = 20, message = "密码在6-20位")
    private String userPassword; //用户密码
    private Integer gender;  //性别
    @Past(message = "出生日期必须是过去时间")
    private Date birthday;  //出生日期
    private String phone;   //电话
    private String address; //地址
    private Integer userRole;    //用户角色
    private Integer createdBy;   //创建者
    private Date creationDate; //创建时间
    private Integer modifyBy;     //更新者
    private Date modifyDate;   //更新时间

    private Integer age;//年龄

    private String userRoleName;    //用户角色名称
    private String idPicPath;
    private String workPicPath;


    public Integer getAge() {
		/*long time = System.currentTimeMillis()-birthday.getTime();
		Integer age = Long.valueOf(time/365/24/60/60/1000).IntegerValue();*/
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Integer age = Integer.parseInt(simpleDateFormat.format(date)) -
                Integer.parseInt(simpleDateFormat.format(birthday));
//		Integer age = date.getYear()-birthday.getYear();
        return age;
    }

}
