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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.NumeroRecapConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class NumeroRecap extends NumeroRecapAdditional implements Serializable ,Cloneable {//NumeroRecapAdditional,GeneralEntity
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
	
	private NumeroRecap numerorecapOriginal;
	
	private Map<String, Object> mapNumeroRecap;
			
	public Map<String, Object> getMapNumeroRecap() {
		return mapNumeroRecap;
	}

	public void setMapNumeroRecap(Map<String, Object> mapNumeroRecap) {
		this.mapNumeroRecap = mapNumeroRecap;
	}
	
	public void inicializarMapNumeroRecap() {
		this.mapNumeroRecap = new HashMap<String,Object>();
	}
	
	public void setMapNumeroRecapValue(String sKey,Object oValue) {
		this.mapNumeroRecap.put(sKey, oValue);
	}
	
	public Object getMapNumeroRecapValue(String sKey) {
		return this.mapNumeroRecap.get(sKey);
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
	private Long id_conexion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NumeroRecapConstantesFunciones.SREGEXNUMERO_RECAP,message=NumeroRecapConstantesFunciones.SMENSAJEREGEXNUMERO_RECAP)
	private String numero_recap;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Conexion conexion;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String conexion_descripcion;
	
	
		
	public NumeroRecap () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.numerorecapOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_conexion=-1L;
 		this.numero_recap="";
 		this.fecha=new Date();
		
		
		this.empresa=null;
		this.sucursal=null;
		this.conexion=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.conexion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NumeroRecap (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_conexion,String numero_recap,Date fecha) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.numerorecapOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_conexion=id_conexion;
 		this.numero_recap=numero_recap;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NumeroRecap (Long id_empresa,Long id_sucursal,Long id_conexion,String numero_recap,Date fecha) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.numerorecapOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_conexion=id_conexion;
 		this.numero_recap=numero_recap;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NumeroRecap numerorecapLocal=null;
		
		if(object!=null) {
			numerorecapLocal=(NumeroRecap)object;
			
			if(numerorecapLocal!=null) {
				if(this.getId()!=null && numerorecapLocal.getId()!=null) {
					if(this.getId().equals(numerorecapLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NumeroRecapConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NumeroRecapConstantesFunciones.getNumeroRecapDescripcion(this);
		} else {
			sDetalle=NumeroRecapConstantesFunciones.getNumeroRecapDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NumeroRecap getNumeroRecapOriginal() {
		return this.numerorecapOriginal;
	}
	
	public void setNumeroRecapOriginal(NumeroRecap numerorecap) {
		try {
			this.numerorecapOriginal=numerorecap;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NumeroRecapAdditional numerorecapAdditional=null;
	
	public NumeroRecapAdditional getNumeroRecapAdditional() {
		return this.numerorecapAdditional;
	}
	
	public void setNumeroRecapAdditional(NumeroRecapAdditional numerorecapAdditional) {
		try {
			this.numerorecapAdditional=numerorecapAdditional;
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
    
	
	public Long getid_conexion() {
		return this.id_conexion;
	}
    
	
	public String getnumero_recap() {
		return this.numero_recap;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NumeroRecap:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("NumeroRecap:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_conexion(Long newid_conexion)throws Exception
	{
		try {
			if(this.id_conexion!=newid_conexion) {
				if(newid_conexion==null) {
					//newid_conexion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NumeroRecap:Valor nulo no permitido en columna id_conexion");
					}
				}

				this.id_conexion=newid_conexion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_recap(String newnumero_recap)throws Exception
	{
		try {
			if(this.numero_recap!=newnumero_recap) {
				if(newnumero_recap==null) {
					//newnumero_recap="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NumeroRecap:Valor nulo no permitido en columna numero_recap");
					}
				}

				if(newnumero_recap!=null&&newnumero_recap.length()>50) {
					newnumero_recap=newnumero_recap.substring(0,48);
					System.out.println("NumeroRecap:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_recap");
				}

				this.numero_recap=newnumero_recap;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("NumeroRecap:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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

	public Conexion getConexion() {
		return this.conexion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getconexion_descripcion() {
		return this.conexion_descripcion;
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


	public  void  setConexion(Conexion conexion) {
		try {
			this.conexion=conexion;
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


	public  void  setconexion_descripcion(String conexion_descripcion) {
		try {
			this.conexion_descripcion=conexion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_conexion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_conexion_descripcion() {
		return id_conexion_descripcion;
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
	public void setid_conexion_descripcion(String newid_conexion_descripcion)throws Exception {
		try {
			this.id_conexion_descripcion=newid_conexion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_conexion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

