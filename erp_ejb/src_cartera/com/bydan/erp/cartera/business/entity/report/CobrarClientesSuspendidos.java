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
//import com.bydan.erp.cartera.util.CobrarClientesSuspendidosConstantesFunciones;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.cartera.business.entity.*;






@SuppressWarnings("unused")
public class CobrarClientesSuspendidos extends CobrarClientesSuspendidosAdditional implements Serializable ,Cloneable {//CobrarClientesSuspendidosAdditional,GeneralEntity
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
	
	private CobrarClientesSuspendidos cobrarclientessuspendidosOriginal;
	
	private Map<String, Object> mapCobrarClientesSuspendidos;
			
	public Map<String, Object> getMapCobrarClientesSuspendidos() {
		return mapCobrarClientesSuspendidos;
	}

	public void setMapCobrarClientesSuspendidos(Map<String, Object> mapCobrarClientesSuspendidos) {
		this.mapCobrarClientesSuspendidos = mapCobrarClientesSuspendidos;
	}
	
	public void inicializarMapCobrarClientesSuspendidos() {
		this.mapCobrarClientesSuspendidos = new HashMap<String,Object>();
	}
	
	public void setMapCobrarClientesSuspendidosValue(String sKey,Object oValue) {
		this.mapCobrarClientesSuspendidos.put(sKey, oValue);
	}
	
	public Object getMapCobrarClientesSuspendidosValue(String sKey) {
		return this.mapCobrarClientesSuspendidos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSuspendidosConstantesFunciones.SREGEXNOMBRE_CIUDAD,message=CobrarClientesSuspendidosConstantesFunciones.SMENSAJEREGEXNOMBRE_CIUDAD)
	private String nombre_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSuspendidosConstantesFunciones.SREGEXCODIGO,message=CobrarClientesSuspendidosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSuspendidosConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=CobrarClientesSuspendidosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSuspendidosConstantesFunciones.SREGEXNOMBRE_COMERCIAL,message=CobrarClientesSuspendidosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMERCIAL)
	private String nombre_comercial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSuspendidosConstantesFunciones.SREGEXRUC,message=CobrarClientesSuspendidosConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSuspendidosConstantesFunciones.SREGEXDETALLE_ESTADO,message=CobrarClientesSuspendidosConstantesFunciones.SMENSAJEREGEXDETALLE_ESTADO)
	private String detalle_estado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSuspendidosConstantesFunciones.SREGEXDIRECCION_DIRECCION,message=CobrarClientesSuspendidosConstantesFunciones.SMENSAJEREGEXDIRECCION_DIRECCION)
	private String direccion_direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSuspendidosConstantesFunciones.SREGEXTELEFONO_TELEFONO,message=CobrarClientesSuspendidosConstantesFunciones.SMENSAJEREGEXTELEFONO_TELEFONO)
	private String telefono_telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo;
			
	
	
	
	
	
		
	public CobrarClientesSuspendidos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobrarclientessuspendidosOriginal=this;
		
 		this.id_empresa=0L;
 		this.nombre_ciudad="";
 		this.codigo="";
 		this.nombre_completo="";
 		this.nombre_comercial="";
 		this.ruc="";
 		this.detalle_estado="";
 		this.direccion_direccion="";
 		this.telefono_telefono="";
 		this.saldo=0.0;
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CobrarClientesSuspendidos (Long id,Date versionRow,String nombre_ciudad,String codigo,String nombre_completo,String nombre_comercial,String ruc,String detalle_estado,String direccion_direccion,String telefono_telefono,Double saldo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarclientessuspendidosOriginal=this;
		
 		this.nombre_ciudad=nombre_ciudad;
 		this.codigo=codigo;
 		this.nombre_completo=nombre_completo;
 		this.nombre_comercial=nombre_comercial;
 		this.ruc=ruc;
 		this.detalle_estado=detalle_estado;
 		this.direccion_direccion=direccion_direccion;
 		this.telefono_telefono=telefono_telefono;
 		this.saldo=saldo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CobrarClientesSuspendidos (String nombre_ciudad,String codigo,String nombre_completo,String nombre_comercial,String ruc,String detalle_estado,String direccion_direccion,String telefono_telefono,Double saldo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarclientessuspendidosOriginal=this;
		
 		this.nombre_ciudad=nombre_ciudad;
 		this.codigo=codigo;
 		this.nombre_completo=nombre_completo;
 		this.nombre_comercial=nombre_comercial;
 		this.ruc=ruc;
 		this.detalle_estado=detalle_estado;
 		this.direccion_direccion=direccion_direccion;
 		this.telefono_telefono=telefono_telefono;
 		this.saldo=saldo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CobrarClientesSuspendidos getCobrarClientesSuspendidosOriginal() {
		return this.cobrarclientessuspendidosOriginal;
	}
	
	public void setCobrarClientesSuspendidosOriginal(CobrarClientesSuspendidos cobrarclientessuspendidos) {
		try {
			this.cobrarclientessuspendidosOriginal=cobrarclientessuspendidos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobrarClientesSuspendidosAdditional cobrarclientessuspendidosAdditional=null;
	
	public CobrarClientesSuspendidosAdditional getCobrarClientesSuspendidosAdditional() {
		return this.cobrarclientessuspendidosAdditional;
	}
	
	public void setCobrarClientesSuspendidosAdditional(CobrarClientesSuspendidosAdditional cobrarclientessuspendidosAdditional) {
		try {
			this.cobrarclientessuspendidosAdditional=cobrarclientessuspendidosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre_ciudad() {
		return this.nombre_ciudad;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String getnombre_comercial() {
		return this.nombre_comercial;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getdetalle_estado() {
		return this.detalle_estado;
	}
    
	
	public String getdireccion_direccion() {
		return this.direccion_direccion;
	}
    
	
	public String gettelefono_telefono() {
		return this.telefono_telefono;
	}
    
	
	public Double getsaldo() {
		return this.saldo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSuspendidos:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_ciudad(String newnombre_ciudad)throws Exception
	{
		try {
			if(this.nombre_ciudad!=newnombre_ciudad) {
				if(newnombre_ciudad==null) {
					//newnombre_ciudad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSuspendidos:Valor nulo no permitido en columna nombre_ciudad");
					}
				}

				if(newnombre_ciudad!=null&&newnombre_ciudad.length()>200) {
					newnombre_ciudad=newnombre_ciudad.substring(0,198);
					System.out.println("CobrarClientesSuspendidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_ciudad");
				}

				this.nombre_ciudad=newnombre_ciudad;
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
						System.out.println("CobrarClientesSuspendidos:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CobrarClientesSuspendidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo(String newnombre_completo)throws Exception
	{
		try {
			if(this.nombre_completo!=newnombre_completo) {
				if(newnombre_completo==null) {
					//newnombre_completo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSuspendidos:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>150) {
					newnombre_completo=newnombre_completo.substring(0,148);
					System.out.println("CobrarClientesSuspendidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_comercial(String newnombre_comercial)throws Exception
	{
		try {
			if(this.nombre_comercial!=newnombre_comercial) {
				if(newnombre_comercial==null) {
					//newnombre_comercial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSuspendidos:Valor nulo no permitido en columna nombre_comercial");
					}
				}

				if(newnombre_comercial!=null&&newnombre_comercial.length()>150) {
					newnombre_comercial=newnombre_comercial.substring(0,148);
					System.out.println("CobrarClientesSuspendidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_comercial");
				}

				this.nombre_comercial=newnombre_comercial;
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
						System.out.println("CobrarClientesSuspendidos:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>15) {
					newruc=newruc.substring(0,13);
					System.out.println("CobrarClientesSuspendidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdetalle_estado(String newdetalle_estado)throws Exception
	{
		try {
			if(this.detalle_estado!=newdetalle_estado) {
				if(newdetalle_estado==null) {
					//newdetalle_estado="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSuspendidos:Valor nulo no permitido en columna detalle_estado");
					}
				}

				if(newdetalle_estado!=null&&newdetalle_estado.length()>150) {
					newdetalle_estado=newdetalle_estado.substring(0,148);
					System.out.println("CobrarClientesSuspendidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna detalle_estado");
				}

				this.detalle_estado=newdetalle_estado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_direccion(String newdireccion_direccion)throws Exception
	{
		try {
			if(this.direccion_direccion!=newdireccion_direccion) {
				if(newdireccion_direccion==null) {
					//newdireccion_direccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSuspendidos:Valor nulo no permitido en columna direccion_direccion");
					}
				}

				if(newdireccion_direccion!=null&&newdireccion_direccion.length()>200) {
					newdireccion_direccion=newdireccion_direccion.substring(0,198);
					System.out.println("CobrarClientesSuspendidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna direccion_direccion");
				}

				this.direccion_direccion=newdireccion_direccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_telefono(String newtelefono_telefono)throws Exception
	{
		try {
			if(this.telefono_telefono!=newtelefono_telefono) {
				if(newtelefono_telefono==null) {
					//newtelefono_telefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSuspendidos:Valor nulo no permitido en columna telefono_telefono");
					}
				}

				if(newtelefono_telefono!=null&&newtelefono_telefono.length()>200) {
					newtelefono_telefono=newtelefono_telefono.substring(0,198);
					System.out.println("CobrarClientesSuspendidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono_telefono");
				}

				this.telefono_telefono=newtelefono_telefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo(Double newsaldo)throws Exception
	{
		try {
			if(this.saldo!=newsaldo) {
				if(newsaldo==null) {
					//newsaldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSuspendidos:Valor nulo no permitido en columna saldo");
					}
				}

				this.saldo=newsaldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

