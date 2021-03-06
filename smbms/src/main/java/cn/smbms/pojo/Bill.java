package cn.smbms.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Bill {
	private Integer id;   //id
	@NotEmpty(message = "账单编号不能为空")
	private String billCode; //账单编码
	@NotEmpty(message = "商品名称不能为空")
	private String productName; //商品名称 
	private String productDesc; //商品描述 
	private String productUnit; //商品单位
	private BigDecimal productCount; //商品数量
	private BigDecimal totalPrice; //总金额
	private Integer isPayment; //是否支付 
	private Integer providerId; //供应商ID 
	private Integer createdBy; //创建者
	private Date creationDate; //创建时间
	private Integer modifyBy; //更新者
	private Date modifyDate;//更新时间
	
	private String providerName;//供应商名称
	
}
