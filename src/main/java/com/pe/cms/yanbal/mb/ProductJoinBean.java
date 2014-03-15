package com.pe.cms.yanbal.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.springframework.dao.DataAccessException;
import com.pe.cms.yanbal.model.BenefitDTO;
import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.model.ProductApplicationDTO;
import com.pe.cms.yanbal.pojo.Application;
import com.pe.cms.yanbal.pojo.Benefit;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.pojo.ProductApplication;
import com.pe.cms.yanbal.pojo.Tip;
import com.pe.cms.yanbal.pojo.ApplicationProduct;
import com.pe.cms.yanbal.service.ProductJoinService;

@ManagedBean
@ViewScoped
public class ProductJoinBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	@ManagedProperty(value = "#{ProductJoinService}")
	ProductJoinService productJoinService;

	private ProductApplicationDTO productApplication = new ProductApplicationDTO();
	private BenefitDTO benefit = new BenefitDTO();
	private List<Product> products;
	private List<ProductApplicationDTO> productApplications;
	private List<Application> applications;
	private List<Tip> tips;
	private List<Benefit> benefits;
	private Integer status = 1;
	private Date prappDate = new Date();
	private Date potiDate = new Date();
	private ProductApplication containerProductoApplication = new ProductApplication();
	private List<ApplicationProduct> tipApplicationProducts;
	private String valorNulo = "";

	public ProductJoinBean (){
//		productApplication = new ProductApplicationDTO();
		products = new ArrayList<Product>();		
		applications = new ArrayList<Application>();
		tips = new ArrayList<Tip>();
	}
	
	public void prepararEliminar(Integer id){
		try {
			System.out.println("ESTOY EN EL MB " + id);
			ProductApplication productApplicationReturn =  new ProductApplication();
			productApplicationReturn.setPrapId(id);
			System.out.println("EL ID AQUE DEVUELVO DEL MB ES  " + productApplicationReturn.getPrapId());
			containerProductoApplication = getProductJoinService().buscarPorIdProductApplication(productApplicationReturn);
			containerProductoApplication.setPrapId(productApplicationReturn.getPrapId());
			System.out.println("EL ID AQUE DEVUELVO DEL MB ES  " + containerProductoApplication.getPrapId());
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void eliminarProductoApplication(){
		try{
			ProductApplication productApplicationReturn = new ProductApplication();
			productApplicationReturn.setPrapId(containerProductoApplication.getPrapId());
			getProductJoinService().eliminarProductoApplication(productApplicationReturn);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "update success"  + "  " + containerProductoApplication.getPrapId() , "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	

	
	public ProductJoinService getProductJoinService() {
		return productJoinService;
	}
	
	public void limpiar(){
		productApplication = new ProductApplicationDTO();
		products = new ArrayList<Product>();
		applications = new ArrayList<Application>();
		tips = new ArrayList<Tip>();
	}

	public void setProductJoinService(ProductJoinService productJoinService) {
		this.productJoinService = productJoinService;
	}
	
	public void guardarProductoApplicacion() {
		try{
			ProductApplication prodApp =  new ProductApplication();
			prodApp.setProdId(productApplication.getProduct().getProdId());
			Integer idApplicacion = productApplication.getApplication().getApplId();
			if(idApplicacion ==  null){
				
				
			}
			prodApp.setAppldId(productApplication.getApplication().getApplId());
			Integer idBenefit = productApplication.getBenefit().getBeneId();
			if(idBenefit == null){
				
			}			
			prodApp.setBeneId(productApplication.getBenefit().getBeneId());
			Integer idTip = productApplication.getTip().getTipId();
			if(idTip == null){
				System.out.println("ENTRO ACAAAAA ======= ");
//				getProductJoinService().addProductoAndTip(prodApp);
				prodApp.setTipId(productApplication.getTip().getTipId());
				prodApp.setPrapDate(prappDate);
				prodApp.setStatus(status);
				System.out.println("MANAGER BEAN " + prodApp.toString());
				getProductJoinService().addProductoAndTip(prodApp);
				prodApp = new ProductApplication();
			}
			
		}catch(DataAccessException e){
			e.printStackTrace();
		}  
    }

	public List<Product> getProducts() {
		products = new ArrayList();
		products.addAll(getProductJoinService().getAllProducts());
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Application> getApplications() {
		applications = getProductJoinService().getAllApplicattions();
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public List<Tip> getTips() {
		tips = getProductJoinService().getAllTips();
		return tips;
	}
	
	public void setTips(List<Tip> tips) {
		this.tips = tips;
	}
	
	public BenefitDTO getBenefit() {
		return benefit;
	}

	public void setBenefit(BenefitDTO benefit) {
		this.benefit = benefit;
	}

	public List<Benefit> getBenefits() {
		benefits = getProductJoinService().getAllBenefits();
		return benefits;
	}

	public void setBenefits(List<Benefit> benefits) {
		this.benefits = benefits;
	}

	public ProductApplicationDTO getProductApplication() {
		return productApplication;
	}


	public void setProductApplication(ProductApplicationDTO productApplication) {
		this.productApplication = productApplication;
	}

	public List<ProductApplicationDTO> getProductApplications() {
		Integer idProductApllicacion = productApplication.getProduct().getProdId();
		if(idProductApllicacion == null){
			idProductApllicacion = 0;
		}
		ProductDTO product = new ProductDTO();
		product.setProdId(idProductApllicacion);
		productApplications = getProductJoinService().getAllProductApplications(product);
		System.out.println("Y EL IDE ES ==== " +idProductApllicacion);
		return productApplications;
	}

	public void setProductApplications(
			List<ProductApplicationDTO> productApplications) {
		this.productApplications = productApplications;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPrappDate() {
		return prappDate;
	}

	public void setPrappDate(Date prappDate) {
		this.prappDate = prappDate;
	}

	public Date getPotiDate() {
		return potiDate;
	}

	public void setPotiDate(Date potiDate) {
		this.potiDate = potiDate;
	}

	public ProductApplication getContainerProductoApplication() {
		return containerProductoApplication;
	}

	public void setContainerProductoApplication(
			ProductApplication containerProductoApplication) {
		this.containerProductoApplication = containerProductoApplication;
	}

	public void setTipApplicationProducts(
			List<ApplicationProduct> tipApplicationProducts) {
		this.tipApplicationProducts = tipApplicationProducts;
	}
}
