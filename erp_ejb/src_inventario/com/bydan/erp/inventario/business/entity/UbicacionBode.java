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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.UbicacionBodeConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class UbicacionBode extends UbicacionBodeAdditional implements Serializable ,Cloneable {//UbicacionBodeAdditional,GeneralEntity
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
	
	private UbicacionBode ubicacionbodeOriginal;
	
	private Map<String, Object> mapUbicacionBode;
			
	public Map<String, Object> getMapUbicacionBode() {
		return mapUbicacionBode;
	}

	public void setMapUbicacionBode(Map<String, Object> mapUbicacionBode) {
		this.mapUbicacionBode = mapUbicacionBode;
	}
	
	public void inicializarMapUbicacionBode() {
		this.mapUbicacionBode = new HashMap<String,Object>();
	}
	
	public void setMapUbicacionBodeValue(String sKey,Object oValue) {
		this.mapUbicacionBode.put(sKey, oValue);
	}
	
	public Object getMapUbicacionBodeValue(String sKey) {
		return this.mapUbicacionBode.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ubicacion_bode;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UbicacionBodeConstantesFunciones.SREGEXNOMBRE,message=UbicacionBodeConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer nivel;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer orden;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Bodega bodega;
	public UbicacionBode ubicacionbode;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String bodega_descripcion;
	private String ubicacionbode_descripcion;
	
	
	public List<UbicacionBode> ubicacionbodes;
	public List<UbicacionProdu> ubicacionprodus;
		
	public UbicacionBode () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.ubicacionbodeOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_bodega=-1L;
 		this.id_ubicacion_bode=null;
 		this.nombre="";
 		this.nivel=0;
 		this.orden=0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.bodega=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.bodega_descripcion="";
		
		
		this.ubicacionbodes=null;
		this.ubicacionprodus=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public UbicacionBode (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_ubicacion_bode,String nombre,Integer nivel,Integer orden) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ubicacionbodeOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_ubicacion_bode=id_ubicacion_bode;
 		this.nombre=nombre;
 		this.nivel=nivel;
 		this.orden=orden;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public UbicacionBode (Long id_empresa,Long id_sucursal,Long id_bodega,Long id_ubicacion_bode,String nombre,Integer nivel,Integer orden) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ubicacionbodeOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_ubicacion_bode=id_ubicacion_bode;
 		this.nombre=nombre;
 		this.nivel=nivel;
 		this.orden=orden;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		UbicacionBode ubicacionbodeLocal=null;
		
		if(object!=null) {
			ubicacionbodeLocal=(UbicacionBode)object;
			
			if(ubicacionbodeLocal!=null) {
				if(this.getId()!=null && ubicacionbodeLocal.getId()!=null) {
					if(this.getId().equals(ubicacionbodeLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!UbicacionBodeConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=UbicacionBodeConstantesFunciones.getUbicacionBodeDescripcion(this);
		} else {
			sDetalle=UbicacionBodeConstantesFunciones.getUbicacionBodeDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public UbicacionBode getUbicacionBodeOriginal() {
		return this.ubicacionbodeOriginal;
	}
	
	public void setUbicacionBodeOriginal(UbicacionBode ubicacionbode) {
		try {
			this.ubicacionbodeOriginal=ubicacionbode;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected UbicacionBodeAdditional ubicacionbodeAdditional=null;
	
	public UbicacionBodeAdditional getUbicacionBodeAdditional() {
		return this.ubicacionbodeAdditional;
	}
	
	public void setUbicacionBodeAdditional(UbicacionBodeAdditional ubicacionbodeAdditional) {
		try {
			this.ubicacionbodeAdditional=ubicacionbodeAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_ubicacion_bode() {
		return this.id_ubicacion_bode;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Integer getnivel() {
		return this.nivel;
	}
    
	
	public Integer getorden() {
		return this.orden;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UbicacionBode:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UbicacionBode:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega(Long newid_bodega)throws Exception
	{
		try {
			if(this.id_bodega!=newid_bodega) {
				if(newid_bodega==null) {
					//newid_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UbicacionBode:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ubicacion_bode(Long newid_ubicacion_bode) {
		if(this.id_ubicacion_bode==null&&newid_ubicacion_bode!=null) {
			this.id_ubicacion_bode=newid_ubicacion_bode;
				this.setIsChanged(true);
		}

		if(this.id_ubicacion_bode!=null&&!this.id_ubicacion_bode.equals(newid_ubicacion_bode)) {

			this.id_ubicacion_bode=newid_ubicacion_bode;
				this.setIsChanged(true);
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("UbicacionBode:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("UbicacionBode:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnivel(Integer newnivel)throws Exception
	{
		try {
			if(this.nivel!=newnivel) {
				if(newnivel==null) {
					//newnivel=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UbicacionBode:Valor nulo no permitido en columna nivel");
					}
				}

				this.nivel=newnivel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorden(Integer neworden)throws Exception
	{
		try {
			if(this.orden!=neworden) {
				if(neworden==null) {
					//neworden=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UbicacionBode:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public UbicacionBode getUbicacionBode() {
		return this.ubicacionbode;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getubicacionbode_descripcion() {
		return this.ubicacionbode_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodega(Bodega bodega) {
		try {
			this.bodega=bodega;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUbicacionBode(UbicacionBode ubicacionbode) {
		try {
			this.ubicacionbode=ubicacionbode;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodega_descripcion(String bodega_descripcion) {
		try {
			this.bodega_descripcion=bodega_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setubicacionbode_descripcion(String ubicacionbode_descripcion) {
		try {
			this.ubicacionbode_descripcion=ubicacionbode_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<UbicacionBode> getUbicacionBodes() {
		return this.ubicacionbodes;
	}

	public List<UbicacionProdu> getUbicacionProdus() {
		return this.ubicacionprodus;
	}

	
	
	public  void  setUbicacionBodes(List<UbicacionBode> ubicacionbodes) {
		try {
			this.ubicacionbodes=ubicacionbodes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setUbicacionProdus(List<UbicacionProdu> ubicacionprodus) {
		try {
			this.ubicacionprodus=ubicacionprodus;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_bodega_descripcion="";String id_ubicacion_bode_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_ubicacion_bode_descripcion() {
		return id_ubicacion_bode_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_descripcion(String newid_bodega_descripcion)throws Exception {
		try {
			this.id_bodega_descripcion=newid_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ubicacion_bode_descripcion(String newid_ubicacion_bode_descripcion)throws Exception {
		try {
			this.id_ubicacion_bode_descripcion=newid_ubicacion_bode_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_bodega_descripcion="";this.id_ubicacion_bode_descripcion="";
	}
	
	
	Object ubicacionbodesDescripcionReporte;
	Object ubicacionprodusDescripcionReporte;
	
	
	public Object getubicacionbodesDescripcionReporte() {
		return ubicacionbodesDescripcionReporte;
	}

	public Object getubicacionprodusDescripcionReporte() {
		return ubicacionprodusDescripcionReporte;
	}

	
	
	public  void  setubicacionbodesDescripcionReporte(Object ubicacionbodes) {
		try {
			this.ubicacionbodesDescripcionReporte=ubicacionbodes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setubicacionprodusDescripcionReporte(Object ubicacionprodus) {
		try {
			this.ubicacionprodusDescripcionReporte=ubicacionprodus;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

