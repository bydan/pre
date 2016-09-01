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
package com.bydan.erp.cartera.business.entity.report;

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
//import com.bydan.erp.cartera.util.CobrarListadoVendedoresConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;




@SuppressWarnings("unused")
public class CobrarListadoVendedores extends CobrarListadoVendedoresAdditional implements Serializable ,Cloneable {//CobrarListadoVendedoresAdditional,GeneralEntity
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
	
	private CobrarListadoVendedores cobrarlistadovendedoresOriginal;
	
	private Map<String, Object> mapCobrarListadoVendedores;
			
	public Map<String, Object> getMapCobrarListadoVendedores() {
		return mapCobrarListadoVendedores;
	}

	public void setMapCobrarListadoVendedores(Map<String, Object> mapCobrarListadoVendedores) {
		this.mapCobrarListadoVendedores = mapCobrarListadoVendedores;
	}
	
	public void inicializarMapCobrarListadoVendedores() {
		this.mapCobrarListadoVendedores = new HashMap<String,Object>();
	}
	
	public void setMapCobrarListadoVendedoresValue(String sKey,Object oValue) {
		this.mapCobrarListadoVendedores.put(sKey, oValue);
	}
	
	public Object getMapCobrarListadoVendedoresValue(String sKey) {
		return this.mapCobrarListadoVendedores.get(sKey);
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
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarListadoVendedoresConstantesFunciones.SREGEXNOMBRE_VENDEDOR,message=CobrarListadoVendedoresConstantesFunciones.SMENSAJEREGEXNOMBRE_VENDEDOR)
	private String nombre_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarListadoVendedoresConstantesFunciones.SREGEXCODIGO,message=CobrarListadoVendedoresConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarListadoVendedoresConstantesFunciones.SREGEXNOMBRE,message=CobrarListadoVendedoresConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarListadoVendedoresConstantesFunciones.SREGEXRUC,message=CobrarListadoVendedoresConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarListadoVendedoresConstantesFunciones.SREGEXDIRECCION_DOMICILIO,message=CobrarListadoVendedoresConstantesFunciones.SMENSAJEREGEXDIRECCION_DOMICILIO)
	private String direccion_domicilio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarListadoVendedoresConstantesFunciones.SREGEXTELEFONO,message=CobrarListadoVendedoresConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Vendedor vendedor;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String vendedor_descripcion;
	
	
		
	public CobrarListadoVendedores () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobrarlistadovendedoresOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_vendedor=-1L;
 		this.nombre_vendedor="";
 		this.codigo="";
 		this.nombre="";
 		this.ruc="";
 		this.direccion_domicilio="";
 		this.telefono="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.vendedor=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.vendedor_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CobrarListadoVendedores (Long id,Date versionRow,String nombre_vendedor,String codigo,String nombre,String ruc,String direccion_domicilio,String telefono) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarlistadovendedoresOriginal=this;
		
 		this.nombre_vendedor=nombre_vendedor;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.ruc=ruc;
 		this.direccion_domicilio=direccion_domicilio;
 		this.telefono=telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CobrarListadoVendedores (String nombre_vendedor,String codigo,String nombre,String ruc,String direccion_domicilio,String telefono) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarlistadovendedoresOriginal=this;
		
 		this.nombre_vendedor=nombre_vendedor;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.ruc=ruc;
 		this.direccion_domicilio=direccion_domicilio;
 		this.telefono=telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CobrarListadoVendedores getCobrarListadoVendedoresOriginal() {
		return this.cobrarlistadovendedoresOriginal;
	}
	
	public void setCobrarListadoVendedoresOriginal(CobrarListadoVendedores cobrarlistadovendedores) {
		try {
			this.cobrarlistadovendedoresOriginal=cobrarlistadovendedores;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobrarListadoVendedoresAdditional cobrarlistadovendedoresAdditional=null;
	
	public CobrarListadoVendedoresAdditional getCobrarListadoVendedoresAdditional() {
		return this.cobrarlistadovendedoresAdditional;
	}
	
	public void setCobrarListadoVendedoresAdditional(CobrarListadoVendedoresAdditional cobrarlistadovendedoresAdditional) {
		try {
			this.cobrarlistadovendedoresAdditional=cobrarlistadovendedoresAdditional;
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
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public String getnombre_vendedor() {
		return this.nombre_vendedor;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getdireccion_domicilio() {
		return this.direccion_domicilio;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarListadoVendedores:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CobrarListadoVendedores:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_vendedor(Long newid_vendedor)throws Exception
	{
		try {
			if(this.id_vendedor!=newid_vendedor) {
				if(newid_vendedor==null) {
					//newid_vendedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarListadoVendedores:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_vendedor(String newnombre_vendedor)throws Exception
	{
		try {
			if(this.nombre_vendedor!=newnombre_vendedor) {
				if(newnombre_vendedor==null) {
					//newnombre_vendedor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarListadoVendedores:Valor nulo no permitido en columna nombre_vendedor");
					}
				}

				if(newnombre_vendedor!=null&&newnombre_vendedor.length()>150) {
					newnombre_vendedor=newnombre_vendedor.substring(0,148);
					System.out.println("CobrarListadoVendedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_vendedor");
				}

				this.nombre_vendedor=newnombre_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarListadoVendedores:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>20) {
					newcodigo=newcodigo.substring(0,18);
					System.out.println("CobrarListadoVendedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarListadoVendedores:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("CobrarListadoVendedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarListadoVendedores:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>15) {
					newruc=newruc.substring(0,13);
					System.out.println("CobrarListadoVendedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_domicilio(String newdireccion_domicilio)throws Exception
	{
		try {
			if(this.direccion_domicilio!=newdireccion_domicilio) {
				if(newdireccion_domicilio==null) {
					//newdireccion_domicilio="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarListadoVendedores:Valor nulo no permitido en columna direccion_domicilio");
					}
				}

				if(newdireccion_domicilio!=null&&newdireccion_domicilio.length()>150) {
					newdireccion_domicilio=newdireccion_domicilio.substring(0,148);
					System.out.println("CobrarListadoVendedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion_domicilio");
				}

				this.direccion_domicilio=newdireccion_domicilio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarListadoVendedores:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>100) {
					newtelefono=newtelefono.substring(0,98);
					System.out.println("CobrarListadoVendedores:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna telefono");
				}

				this.telefono=newtelefono;
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

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
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


	public  void  setVendedor(Vendedor vendedor) {
		try {
			this.vendedor=vendedor;
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


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_vendedor_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
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
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion) {
		this.id_vendedor_descripcion=newid_vendedor_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_vendedor_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

