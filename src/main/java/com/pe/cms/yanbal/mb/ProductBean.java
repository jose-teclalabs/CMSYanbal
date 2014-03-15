package com.pe.cms.yanbal.mb;

import java.beans.DesignMode;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.imageio.stream.FileImageOutputStream;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;
import org.springframework.dao.DataAccessException;

import com.pe.cms.yanbal.model.ProductDTO;
import com.pe.cms.yanbal.pojo.Product;
import com.pe.cms.yanbal.service.ProductService;
import com.pe.cms.yanbal.util.Constant;

@ManagedBean
@ViewScoped
public class ProductBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	@ManagedProperty(value = "#{ProductService}")
	ProductService productService;
	
	private List<ProductDTO> products;
//	private ProductDTO product = new ProductDTO();
	private Integer prodId;
	private String description;
	private String details;
	private String type;
	private Integer status = 1;
	Product productContainer = new Product();
	private Date producDate = new Date();
	private String imageTemp;
	private UploadedFile file;
	private StreamedContent myImage;
	

	public ProductBean() {
		productContainer = new Product();
		
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void limpiar(){
		productContainer = null;
	}
	
	
	public void prepararActualizar(Integer id){
		try {
			System.out.println("ESTOY EN EL MB " + id);
			Product productReturn =  new Product();
			productReturn.setProdId(id);
			productContainer = productService.buscarPorIdProduct(productReturn);
			productContainer.setProdId(productReturn.getProdId());
			setProdId(productContainer.getProdId());
			System.out.println("LA IMAGEN ES " + productContainer.getPhoto());
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void prepararEliminar(Integer id){
		try {
			System.out.println("ESTOY EN EL MB " + id);
			Product productReturn =  new Product();
			productReturn.setProdId(id);
			productContainer = productService.buscarPorIdProduct(productReturn);
			productContainer.setProdId(productReturn.getProdId());
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void eliminarProducto(){
		try{
			Product productReturn = new Product();
			productReturn.setProdId(productContainer.getProdId());
			productService.eliminarProducto(productReturn);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "update success"  + "  " + productContainer.getProdId()   + "  " +productContainer.getDescription() + "  "  + productContainer.getType(), "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void  prepararParaPhoto (Integer id){
		try{
			Product productReturn =  new Product();
			System.out.println(" EL VALOR DE ID DEL PRODUCTO ES  " + id);
			productReturn.setProdId(id);
			productContainer = productService.capturarIdProduct(productReturn);
			this.productContainer.setProdId(productReturn.getProdId());
			setProdId(productContainer.getProdId());
			System.out.println(" EL VALOR DE ID DEL PRODUCTO ES  " + getProdId() );
			productReturn =  new Product();
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public void actualizarProducto(){
		try{
			Product productReturn = new Product();
			productReturn.setProdId(productContainer.getProdId());
			productReturn.setDescription(productContainer.getDescription());
			productReturn.setDetails(productContainer.getDetails());
			productReturn.setType(productContainer.getType());
			System.out.println("ERROR MB SU " + productContainer.toString());
			productService.actualizarProducto(productReturn);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "update success"  + "  " + productContainer.getProdId()   + "  " +productContainer.getDescription() + "  "  + productContainer.getType(), "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	        productContainer = new Product();
		}catch(DataAccessException e){
			e.printStackTrace();
		}
	}
	
	public String guardarProduct(){
		try{
			System.out.println("el codigo es " + description);
			Product producto = new Product();
			producto.setDescription(getDescription());
			producto.setDetails(getDetails());
			producto.setType(getType());
			producto.setStatus(getStatus());
			producto.setProdDate(getProducDate());
			getProductService().addProduct(producto);
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration success", "success"); 
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	         
	        return SUCCESS;
		}catch(DataAccessException e){
			System.out.println("ERROR EN EL CONTROLLER    " + e);
			e.printStackTrace();
		}
		return ERROR;
	}	
//	private String destination="C:\\tmp\\";
//	private String destination= "C:\\Users\\Jose\\Documents\\PROYECTOS TECLALABS\\YANBAL\\CMS\\CMSYanbal\\src\\main\\webapp\\resources\\images\\data\\general\\products\\";
//	private String destination= "\\resources\\images\\Data\\General\\Products\\";
//	private String destination= "C:\\Users\\Jose\\Documents\\PROYECTOS TECLALABS\\YANBAL\\Data\\General\\Products\\";
	private String destination= Constant.IN_MAC;
	
	public void actionFoto(){
	    this.imageTemp = null;
	}
	 
	public void actionGuardarFoto(){
	    String path = destination;
	    String archivo = path + File.separator + this.productContainer.getProdId() + ".jpg";
	    try {	    	
	        if(imageTemp != null){
	        	
	        	Product productVerify =  new Product();
	        	productVerify.setProdId(this.productContainer.getProdId());
	        	productVerify.setPhoto(destination + this.getImageTemp());
	        	productService.actualizarPhotoProducto(productVerify);  
	        }
	 
	        actionFoto();
	 
	    }  catch (DataAccessException e) {
	        e.printStackTrace();
	    }
	}
	
	public void uploadFile(FileUploadEvent event) {
	    try {
	    	System.out.println("DATA FORMATING  " + event.getFile().getFileName() + event.getFile().getContentType() + event.getFile().getSize());
	        String path = destination;
	        String NewIdFile = event.getFile().getFileName();
	        String NewFileName = String.valueOf(this.productContainer.getProdId());
	        NewIdFile = NewFileName;
//	        String archivo = path + File.separator + event.getFile().getFileName();
	        String archivo = path + File.separator + NewIdFile + ".jpg";
	        FileOutputStream fileOutputStream = new FileOutputStream(archivo);
	        byte[] buffer = new byte[6124];
	        int bulk;	        
	        InputStream inputStream = event.getFile().getInputstream();
	        while (true) {
	        bulk = inputStream.read(buffer);
	        if (bulk < 0) {
	          break;
	        }
	        fileOutputStream.write(buffer, 0, bulk);
	        fileOutputStream.flush();
	    }
	    fileOutputStream.close();
	    inputStream.close();
	 
	    this.setImageTemp(NewIdFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	        FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al subir el archivo"));
	    }
	}
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getProducDate() {
		return producDate;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public List<ProductDTO> getProducts() {
		products = new ArrayList();
		products.addAll(getProductService().getAllProducts());
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public void setProducDate(Date producDate) {
		this.producDate = producDate;
	}

	public Product getProductContainer() {
		return productContainer;
	}

	public void setProductContainer(Product productContainer) {
		this.productContainer = productContainer;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getImageTemp() {
		return imageTemp;
	}

	public void setImageTemp(String imageTemp) {
		this.imageTemp = imageTemp;
	}

	public StreamedContent getMyImage() {
		return myImage;
//		FacesContext context = FacesContext.getCurrentInstance();
//
//        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
//            return new DefaultStreamedContent();
//        }
//        else {
//            // So, browser is requesting the image. Return a real StreamedContent with the image bytes.
////            String studentId = context.getExternalContext().getRequestParameterMap().get("studentId");
////            this.productContainer.getProdId();
////            Student student = studentService.find(Long.valueOf(studentId));
//            return new DefaultStreamedContent(new ByteArrayInputStream(this.productContainer.getPhoto()));
//        }
	}

	public void setMyImage(StreamedContent myImage) {
		this.myImage = myImage;
	}
	
	
}
