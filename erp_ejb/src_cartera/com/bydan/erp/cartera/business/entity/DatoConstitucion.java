/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.cartera.business.entity;

import java.io.Serializable;
import java.io.File;

import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.cartera.util.DatoConstitucionConstantesFunciones;
import com.bydan.erp.cartera.util.*;









@SuppressWarnings("unused")
public class DatoConstitucion extends DatoConstitucionAdditional implements Serializable ,Cloneable {//DatoConstitucionAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected boolean isNew;
	protected boolean isChanged;
	protected boolean isDeleted;
	protected boolean isSelected;
	protected Date versionRow;
	protected String sType;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long newId) {
		if(this.id!=newId) {
			this.isChanged=true;
		}
		
		this.id=newId;
		super.setId(newId);
	}
	
	
	
	public Date getVersionRow(){
		//ESTO SIEMPRE SE EJECUTA CUANDO SE CONSUME EJB
		return this.versionRow;
	}
	
	public void setVersionRow(Date newVersionRow){
		if(this.versionRow!=newVersionRow){
			//LE COMENTO PORQUE CUANDO HAGO GET SIEMPRE POR ESTO LE PONE isChanged=true
			//this.isChanged=true;
		}
		
		this.versionRow=newVersionRow;
		super.setVersionRow(newVersionRow);
	}
	
	
	public boolean getIsNew() {
		return this.isNew;
	}
	
	public void setIsNew(boolean newIsNew) {
		this.isNew=newIsNew;
		super.setIsNew(newIsNew);
	}
	
	public boolean getIsChanged() {
		return this.isChanged;
	}
	
	public void setIsChanged(boolean newIsChanged) {
		this.isChanged=newIsChanged;
		super.setIsChanged(newIsChanged);
	}
	
	public boolean getIsDeleted() {
		return this.isDeleted;
	}
	
	public void setIsDeleted(boolean newIsDeleted) {
		this.isDeleted=newIsDeleted;
		super.setIsDeleted(newIsDeleted);
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public void setIsSelected(boolean newIsSelected) {
		this.isSelected=newIsSelected;
		super.setIsSelected(newIsSelected);
	}
	
	public String getsType() {
		return this.sType;
	}
	
	public void setsType(String sType) {
		this.sType=sType;
		super.setsType(sType);
	}
	
	private DatoConstitucion datoconstitucionOriginal;
	
	private Map<String, Object> mapDatoConstitucion;
			
	public Map<String, Object> getMapDatoConstitucion() {
		return mapDatoConstitucion;
	}

	public void setMapDatoConstitucion(Map<String, Object> mapDatoConstitucion) {
		this.mapDatoConstitucion = mapDatoConstitucion;
	}
	
	public void inicializarMapDatoConstitucion() {
		this.mapDatoConstitucion = new HashMap<String,Object>();
	}
	
	public void setMapDatoConstitucionValue(String sKey,Object oValue) {
		this.mapDatoConstitucion.put(sKey, oValue);
	}
	
	public Object getMapDatoConstitucionValue(String sKey) {
		return this.mapDatoConstitucion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idcliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclientecompania;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=400,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoConstitucionConstantesFunciones.SREGEXDIRECCION,message=DatoConstitucionConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fechaconstitucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double capitalsuscrito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer plazofiniquito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double reservalegal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fechaestatuto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esactivo;
			
	
	public Cliente cliente;
	public TipoCompania tipocompania;
	
	
	private String cliente_descripcion;
	private String tipocompania_descripcion;
	
	
		
	public DatoConstitucion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.datoconstitucionOriginal=this;
		
 		this.idcliente=-1L;
 		this.idvalorclientecompania=-1L;
 		this.direccion="";
 		this.fechaconstitucion=new Date();
 		this.capitalsuscrito=0.0;
 		this.plazofiniquito=0;
 		this.reservalegal=0.0;
 		this.fechaestatuto=new Date();
 		this.esactivo=false;
		
		
		this.cliente=null;
		this.tipocompania=null;
		
		
		this.cliente_descripcion="";
		this.tipocompania_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DatoConstitucion (Long id,Date versionRow,Long idcliente,Long idvalorclientecompania,String direccion,Date fechaconstitucion,Double capitalsuscrito,Integer plazofiniquito,Double reservalegal,Date fechaestatuto,Boolean esactivo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.datoconstitucionOriginal=this;
		
 		this.idcliente=idcliente;
 		this.idvalorclientecompania=idvalorclientecompania;
 		this.direccion=direccion;
 		this.fechaconstitucion=fechaconstitucion;
 		this.capitalsuscrito=capitalsuscrito;
 		this.plazofiniquito=plazofiniquito;
 		this.reservalegal=reservalegal;
 		this.fechaestatuto=fechaestatuto;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DatoConstitucion (Long idcliente,Long idvalorclientecompania,String direccion,Date fechaconstitucion,Double capitalsuscrito,Integer plazofiniquito,Double reservalegal,Date fechaestatuto,Boolean esactivo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.datoconstitucionOriginal=this;
		
 		this.idcliente=idcliente;
 		this.idvalorclientecompania=idvalorclientecompania;
 		this.direccion=direccion;
 		this.fechaconstitucion=fechaconstitucion;
 		this.capitalsuscrito=capitalsuscrito;
 		this.plazofiniquito=plazofiniquito;
 		this.reservalegal=reservalegal;
 		this.fechaestatuto=fechaestatuto;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DatoConstitucion datoconstitucionLocal=null;
		
		if(object!=null) {
			datoconstitucionLocal=(DatoConstitucion)object;
			
			if(datoconstitucionLocal!=null) {
				if(this.getId()!=null && datoconstitucionLocal.getId()!=null) {
					if(this.getId().equals(datoconstitucionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DatoConstitucionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DatoConstitucionConstantesFunciones.getDatoConstitucionDescripcion(this);
		} else {
			sDetalle=DatoConstitucionConstantesFunciones.getDatoConstitucionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DatoConstitucion getDatoConstitucionOriginal() {
		return this.datoconstitucionOriginal;
	}
	
	public void setDatoConstitucionOriginal(DatoConstitucion datoconstitucion) {
		try {
			this.datoconstitucionOriginal=datoconstitucion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DatoConstitucionAdditional datoconstitucionAdditional=null;
	
	public DatoConstitucionAdditional getDatoConstitucionAdditional() {
		return this.datoconstitucionAdditional;
	}
	
	public void setDatoConstitucionAdditional(DatoConstitucionAdditional datoconstitucionAdditional) {
		try {
			this.datoconstitucionAdditional=datoconstitucionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getidcliente() {
		return this.idcliente;
	}
    
	
	public Long getidvalorclientecompania() {
		return this.idvalorclientecompania;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public Date getfechaconstitucion() {
		return this.fechaconstitucion;
	}
    
	
	public Double getcapitalsuscrito() {
		return this.capitalsuscrito;
	}
    
	
	public Integer getplazofiniquito() {
		return this.plazofiniquito;
	}
    
	
	public Double getreservalegal() {
		return this.reservalegal;
	}
    
	
	public Date getfechaestatuto() {
		return this.fechaestatuto;
	}
    
	
	public Boolean getesactivo() {
		return this.esactivo;
	}
	
    
	public void setidcliente(Long newidcliente)throws Exception
	{
		try {
			if(this.idcliente!=newidcliente) {
				if(newidcliente==null) {
					//newidcliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoConstitucion:Valor nulo no permitido en columna idcliente");
					}
				}

				this.idcliente=newidcliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclientecompania(Long newidvalorclientecompania)throws Exception
	{
		try {
			if(this.idvalorclientecompania!=newidvalorclientecompania) {
				if(newidvalorclientecompania==null) {
					//newidvalorclientecompania=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoConstitucion:Valor nulo no permitido en columna idvalorclientecompania");
					}
				}

				this.idvalorclientecompania=newidvalorclientecompania;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoConstitucion:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>400) {
					newdireccion=newdireccion.substring(0,398);
					System.out.println("DatoConstitucion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=400 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfechaconstitucion(Date newfechaconstitucion)throws Exception
	{
		try {
			if(this.fechaconstitucion!=newfechaconstitucion) {
				if(newfechaconstitucion==null) {
					//newfechaconstitucion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoConstitucion:Valor nulo no permitido en columna fechaconstitucion");
					}
				}

				this.fechaconstitucion=newfechaconstitucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcapitalsuscrito(Double newcapitalsuscrito)throws Exception
	{
		try {
			if(this.capitalsuscrito!=newcapitalsuscrito) {
				if(newcapitalsuscrito==null) {
					//newcapitalsuscrito=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoConstitucion:Valor nulo no permitido en columna capitalsuscrito");
					}
				}

				this.capitalsuscrito=newcapitalsuscrito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setplazofiniquito(Integer newplazofiniquito)throws Exception
	{
		try {
			if(this.plazofiniquito!=newplazofiniquito) {
				if(newplazofiniquito==null) {
					//newplazofiniquito=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoConstitucion:Valor nulo no permitido en columna plazofiniquito");
					}
				}

				this.plazofiniquito=newplazofiniquito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setreservalegal(Double newreservalegal)throws Exception
	{
		try {
			if(this.reservalegal!=newreservalegal) {
				if(newreservalegal==null) {
					//newreservalegal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoConstitucion:Valor nulo no permitido en columna reservalegal");
					}
				}

				this.reservalegal=newreservalegal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfechaestatuto(Date newfechaestatuto)throws Exception
	{
		try {
			if(this.fechaestatuto!=newfechaestatuto) {
				if(newfechaestatuto==null) {
					//newfechaestatuto=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoConstitucion:Valor nulo no permitido en columna fechaestatuto");
					}
				}

				this.fechaestatuto=newfechaestatuto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesactivo(Boolean newesactivo)throws Exception
	{
		try {
			if(this.esactivo!=newesactivo) {
				if(newesactivo==null) {
					//newesactivo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoConstitucion:Valor nulo no permitido en columna esactivo");
					}
				}

				this.esactivo=newesactivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoCompania getTipoCompania() {
		return this.tipocompania;
	}

	
	
	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipocompania_descripcion() {
		return this.tipocompania_descripcion;
	}

	
	
	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCompania(TipoCompania tipocompania) {
		try {
			this.tipocompania=tipocompania;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocompania_descripcion(String tipocompania_descripcion) {
		try {
			this.tipocompania_descripcion=tipocompania_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String idcliente_descripcion="";String idvalorclientecompania_descripcion="";String esactivo_descripcion="";
	
	
	public String getidcliente_descripcion() {
		return idcliente_descripcion;
	}
	public String getidvalorclientecompania_descripcion() {
		return idvalorclientecompania_descripcion;
	}
	public String getesactivo_descripcion() {
		return esactivo_descripcion;
	}
	
	
	public void setidcliente_descripcion(String newidcliente_descripcion)throws Exception {
		try {
			this.idcliente_descripcion=newidcliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclientecompania_descripcion(String newidvalorclientecompania_descripcion)throws Exception {
		try {
			this.idvalorclientecompania_descripcion=newidvalorclientecompania_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesactivo_descripcion(String newesactivo_descripcion)throws Exception {
		try {
			this.esactivo_descripcion=newesactivo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.idcliente_descripcion="";this.idvalorclientecompania_descripcion="";this.esactivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

