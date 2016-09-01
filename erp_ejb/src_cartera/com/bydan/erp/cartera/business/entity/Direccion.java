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
//import com.bydan.erp.cartera.util.DireccionConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Direccion extends DireccionAdditional implements Serializable ,Cloneable {//DireccionAdditional,GeneralEntity
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
	
	private Direccion direccionOriginal;
	
	private Map<String, Object> mapDireccion;
			
	public Map<String, Object> getMapDireccion() {
		return mapDireccion;
	}

	public void setMapDireccion(Map<String, Object> mapDireccion) {
		this.mapDireccion = mapDireccion;
	}
	
	public void inicializarMapDireccion() {
		this.mapDireccion = new HashMap<String,Object>();
	}
	
	public void setMapDireccionValue(String sKey,Object oValue) {
		this.mapDireccion.put(sKey, oValue);
	}
	
	public Object getMapDireccionValue(String sKey) {
		return this.mapDireccion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_vivienda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DireccionConstantesFunciones.SREGEXSECTOR,message=DireccionConstantesFunciones.SMENSAJEREGEXSECTOR)
	private String sector;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DireccionConstantesFunciones.SREGEXBARRIO,message=DireccionConstantesFunciones.SMENSAJEREGEXBARRIO)
	private String barrio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DireccionConstantesFunciones.SREGEXCALLES,message=DireccionConstantesFunciones.SMENSAJEREGEXCALLES)
	private String calles;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DireccionConstantesFunciones.SREGEXASEGURADA,message=DireccionConstantesFunciones.SMENSAJEREGEXASEGURADA)
	private String asegurada;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DireccionConstantesFunciones.SREGEXDIRECCION,message=DireccionConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esactivo;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public TipoDireccion tipodireccion;
	public TipoVivienda tipovivienda;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String tipodireccion_descripcion;
	private String tipovivienda_descripcion;
	
	
		
	public Direccion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.direccionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cliente=-1L;
 		this.id_tipo_direccion=-1L;
 		this.id_tipo_vivienda=-1L;
 		this.sector="";
 		this.barrio="";
 		this.calles="";
 		this.asegurada="";
 		this.direccion="";
 		this.esactivo=false;
		
		
		this.empresa=null;
		this.cliente=null;
		this.tipodireccion=null;
		this.tipovivienda=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.tipodireccion_descripcion="";
		this.tipovivienda_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Direccion (Long id,Date versionRow,Long id_empresa,Long id_cliente,Long id_tipo_direccion,Long id_tipo_vivienda,String sector,String barrio,String calles,String asegurada,String direccion,Boolean esactivo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.direccionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.id_tipo_direccion=id_tipo_direccion;
 		this.id_tipo_vivienda=id_tipo_vivienda;
 		this.sector=sector;
 		this.barrio=barrio;
 		this.calles=calles;
 		this.asegurada=asegurada;
 		this.direccion=direccion;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Direccion (Long id_empresa,Long id_cliente,Long id_tipo_direccion,Long id_tipo_vivienda,String sector,String barrio,String calles,String asegurada,String direccion,Boolean esactivo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.direccionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.id_tipo_direccion=id_tipo_direccion;
 		this.id_tipo_vivienda=id_tipo_vivienda;
 		this.sector=sector;
 		this.barrio=barrio;
 		this.calles=calles;
 		this.asegurada=asegurada;
 		this.direccion=direccion;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Direccion direccionLocal=null;
		
		if(object!=null) {
			direccionLocal=(Direccion)object;
			
			if(direccionLocal!=null) {
				if(this.getId()!=null && direccionLocal.getId()!=null) {
					if(this.getId().equals(direccionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DireccionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DireccionConstantesFunciones.getDireccionDescripcion(this);
		} else {
			sDetalle=DireccionConstantesFunciones.getDireccionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Direccion getDireccionOriginal() {
		return this.direccionOriginal;
	}
	
	public void setDireccionOriginal(Direccion direccion) {
		try {
			this.direccionOriginal=direccion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DireccionAdditional direccionAdditional=null;
	
	public DireccionAdditional getDireccionAdditional() {
		return this.direccionAdditional;
	}
	
	public void setDireccionAdditional(DireccionAdditional direccionAdditional) {
		try {
			this.direccionAdditional=direccionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_tipo_direccion() {
		return this.id_tipo_direccion;
	}
    
	
	public Long getid_tipo_vivienda() {
		return this.id_tipo_vivienda;
	}
    
	
	public String getsector() {
		return this.sector;
	}
    
	
	public String getbarrio() {
		return this.barrio;
	}
    
	
	public String getcalles() {
		return this.calles;
	}
    
	
	public String getasegurada() {
		return this.asegurada;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public Boolean getesactivo() {
		return this.esactivo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Direccion:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Direccion:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_direccion(Long newid_tipo_direccion)throws Exception
	{
		try {
			if(this.id_tipo_direccion!=newid_tipo_direccion) {
				if(newid_tipo_direccion==null) {
					//newid_tipo_direccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Direccion:Valor nulo no permitido en columna id_tipo_direccion");
					}
				}

				this.id_tipo_direccion=newid_tipo_direccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_vivienda(Long newid_tipo_vivienda)throws Exception
	{
		try {
			if(this.id_tipo_vivienda!=newid_tipo_vivienda) {
				if(newid_tipo_vivienda==null) {
					//newid_tipo_vivienda=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Direccion:Valor nulo no permitido en columna id_tipo_vivienda");
					}
				}

				this.id_tipo_vivienda=newid_tipo_vivienda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsector(String newsector)throws Exception
	{
		try {
			if(this.sector!=newsector) {
				if(newsector==null) {
					//newsector="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Direccion:Valor nulo no permitido en columna sector");
					}
				}

				if(newsector!=null&&newsector.length()>200) {
					newsector=newsector.substring(0,198);
					System.out.println("Direccion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna sector");
				}

				this.sector=newsector;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbarrio(String newbarrio)throws Exception
	{
		try {
			if(this.barrio!=newbarrio) {
				if(newbarrio==null) {
					//newbarrio="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Direccion:Valor nulo no permitido en columna barrio");
					}
				}

				if(newbarrio!=null&&newbarrio.length()>200) {
					newbarrio=newbarrio.substring(0,198);
					System.out.println("Direccion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna barrio");
				}

				this.barrio=newbarrio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcalles(String newcalles)throws Exception
	{
		try {
			if(this.calles!=newcalles) {
				if(newcalles==null) {
					//newcalles="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Direccion:Valor nulo no permitido en columna calles");
					}
				}

				if(newcalles!=null&&newcalles.length()>250) {
					newcalles=newcalles.substring(0,248);
					System.out.println("Direccion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna calles");
				}

				this.calles=newcalles;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setasegurada(String newasegurada)throws Exception
	{
		try {
			if(this.asegurada!=newasegurada) {
				if(newasegurada==null) {
					//newasegurada="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Direccion:Valor nulo no permitido en columna asegurada");
					}
				}

				if(newasegurada!=null&&newasegurada.length()>200) {
					newasegurada=newasegurada.substring(0,198);
					System.out.println("Direccion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna asegurada");
				}

				this.asegurada=newasegurada;
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
						System.out.println("Direccion:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>200) {
					newdireccion=newdireccion.substring(0,198);
					System.out.println("Direccion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna direccion");
				}

				this.direccion=newdireccion;
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
						System.out.println("Direccion:Valor nulo no permitido en columna esactivo");
					}
				}

				this.esactivo=newesactivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoDireccion getTipoDireccion() {
		return this.tipodireccion;
	}

	public TipoVivienda getTipoVivienda() {
		return this.tipovivienda;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipodireccion_descripcion() {
		return this.tipodireccion_descripcion;
	}

	public String gettipovivienda_descripcion() {
		return this.tipovivienda_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDireccion(TipoDireccion tipodireccion) {
		try {
			this.tipodireccion=tipodireccion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoVivienda(TipoVivienda tipovivienda) {
		try {
			this.tipovivienda=tipovivienda;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
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


	public  void  settipodireccion_descripcion(String tipodireccion_descripcion) {
		try {
			this.tipodireccion_descripcion=tipodireccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipovivienda_descripcion(String tipovivienda_descripcion) {
		try {
			this.tipovivienda_descripcion=tipovivienda_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cliente_descripcion="";String id_tipo_direccion_descripcion="";String id_tipo_vivienda_descripcion="";String esactivo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_direccion_descripcion() {
		return id_tipo_direccion_descripcion;
	}
	public String getid_tipo_vivienda_descripcion() {
		return id_tipo_vivienda_descripcion;
	}
	public String getesactivo_descripcion() {
		return esactivo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_direccion_descripcion(String newid_tipo_direccion_descripcion)throws Exception {
		try {
			this.id_tipo_direccion_descripcion=newid_tipo_direccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_vivienda_descripcion(String newid_tipo_vivienda_descripcion)throws Exception {
		try {
			this.id_tipo_vivienda_descripcion=newid_tipo_vivienda_descripcion;
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
		this.id_empresa_descripcion="";this.id_cliente_descripcion="";this.id_tipo_direccion_descripcion="";this.id_tipo_vivienda_descripcion="";this.esactivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

