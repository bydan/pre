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
package com.bydan.erp.facturacion.business.entity.report;

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
//import com.bydan.erp.facturacion.util.IngresosReferendosConstantesFunciones;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.facturacion.business.entity.*;






@SuppressWarnings("unused")
public class IngresosReferendos extends IngresosReferendosAdditional implements Serializable ,Cloneable {//IngresosReferendosAdditional,GeneralEntity
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
	
	private IngresosReferendos ingresosreferendosOriginal;
	
	private Map<String, Object> mapIngresosReferendos;
			
	public Map<String, Object> getMapIngresosReferendos() {
		return mapIngresosReferendos;
	}

	public void setMapIngresosReferendos(Map<String, Object> mapIngresosReferendos) {
		this.mapIngresosReferendos = mapIngresosReferendos;
	}
	
	public void inicializarMapIngresosReferendos() {
		this.mapIngresosReferendos = new HashMap<String,Object>();
	}
	
	public void setMapIngresosReferendosValue(String sKey,Object oValue) {
		this.mapIngresosReferendos.put(sKey, oValue);
	}
	
	public Object getMapIngresosReferendosValue(String sKey) {
		return this.mapIngresosReferendos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosReferendosConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=IngresosReferendosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosReferendosConstantesFunciones.SREGEXNUMERO,message=IngresosReferendosConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosReferendosConstantesFunciones.SREGEXNUMERO_AUTORIZACION,message=IngresosReferendosConstantesFunciones.SMENSAJEREGEXNUMERO_AUTORIZACION)
	private String numero_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosReferendosConstantesFunciones.SREGEXNUMERO_FUE,message=IngresosReferendosConstantesFunciones.SMENSAJEREGEXNUMERO_FUE)
	private String numero_fue;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosReferendosConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO,message=IngresosReferendosConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO)
	private String numero_pre_impreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosReferendosConstantesFunciones.SREGEXNUMERO_DAU,message=IngresosReferendosConstantesFunciones.SMENSAJEREGEXNUMERO_DAU)
	private String numero_dau;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosReferendosConstantesFunciones.SREGEXNUMERO_REFERENDO,message=IngresosReferendosConstantesFunciones.SMENSAJEREGEXNUMERO_REFERENDO)
	private String numero_referendo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_referendo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosReferendosConstantesFunciones.SREGEXAFORO_REFERENDO,message=IngresosReferendosConstantesFunciones.SMENSAJEREGEXAFORO_REFERENDO)
	private String aforo_referendo;
			
	
	
	
	
	
		
	public IngresosReferendos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.ingresosreferendosOriginal=this;
		
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.nombre_completo_cliente="";
 		this.numero="";
 		this.numero_autorizacion="";
 		this.numero_fue="";
 		this.numero_pre_impreso="";
 		this.numero_dau="";
 		this.numero_referendo="";
 		this.fecha_referendo=new Date();
 		this.aforo_referendo="";
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public IngresosReferendos (Long id,Date versionRow,String nombre_completo_cliente,String numero,String numero_autorizacion,String numero_fue,String numero_pre_impreso,String numero_dau,String numero_referendo,Date fecha_referendo,String aforo_referendo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ingresosreferendosOriginal=this;
		
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.numero=numero;
 		this.numero_autorizacion=numero_autorizacion;
 		this.numero_fue=numero_fue;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.numero_dau=numero_dau;
 		this.numero_referendo=numero_referendo;
 		this.fecha_referendo=fecha_referendo;
 		this.aforo_referendo=aforo_referendo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public IngresosReferendos (String nombre_completo_cliente,String numero,String numero_autorizacion,String numero_fue,String numero_pre_impreso,String numero_dau,String numero_referendo,Date fecha_referendo,String aforo_referendo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ingresosreferendosOriginal=this;
		
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.numero=numero;
 		this.numero_autorizacion=numero_autorizacion;
 		this.numero_fue=numero_fue;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.numero_dau=numero_dau;
 		this.numero_referendo=numero_referendo;
 		this.fecha_referendo=fecha_referendo;
 		this.aforo_referendo=aforo_referendo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public IngresosReferendos getIngresosReferendosOriginal() {
		return this.ingresosreferendosOriginal;
	}
	
	public void setIngresosReferendosOriginal(IngresosReferendos ingresosreferendos) {
		try {
			this.ingresosreferendosOriginal=ingresosreferendos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected IngresosReferendosAdditional ingresosreferendosAdditional=null;
	
	public IngresosReferendosAdditional getIngresosReferendosAdditional() {
		return this.ingresosreferendosAdditional;
	}
	
	public void setIngresosReferendosAdditional(IngresosReferendosAdditional ingresosreferendosAdditional) {
		try {
			this.ingresosreferendosAdditional=ingresosreferendosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getnombre_completo_cliente() {
		return this.nombre_completo_cliente;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getnumero_autorizacion() {
		return this.numero_autorizacion;
	}
    
	
	public String getnumero_fue() {
		return this.numero_fue;
	}
    
	
	public String getnumero_pre_impreso() {
		return this.numero_pre_impreso;
	}
    
	
	public String getnumero_dau() {
		return this.numero_dau;
	}
    
	
	public String getnumero_referendo() {
		return this.numero_referendo;
	}
    
	
	public Date getfecha_referendo() {
		return this.fecha_referendo;
	}
    
	
	public String getaforo_referendo() {
		return this.aforo_referendo;
	}
	
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna fecha_emision_desde");
					}
				}

				this.fecha_emision_desde=newfecha_emision_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_hasta(Date newfecha_emision_hasta)throws Exception
	{
		try {
			if(this.fecha_emision_hasta!=newfecha_emision_hasta) {
				if(newfecha_emision_hasta==null) {
					//newfecha_emision_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo_cliente(String newnombre_completo_cliente)throws Exception
	{
		try {
			if(this.nombre_completo_cliente!=newnombre_completo_cliente) {
				if(newnombre_completo_cliente==null) {
					//newnombre_completo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("IngresosReferendos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
				}

				this.nombre_completo_cliente=newnombre_completo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("IngresosReferendos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_autorizacion(String newnumero_autorizacion)throws Exception
	{
		try {
			if(this.numero_autorizacion!=newnumero_autorizacion) {
				if(newnumero_autorizacion==null) {
					//newnumero_autorizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna numero_autorizacion");
					}
				}

				if(newnumero_autorizacion!=null&&newnumero_autorizacion.length()>50) {
					newnumero_autorizacion=newnumero_autorizacion.substring(0,48);
					System.out.println("IngresosReferendos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_autorizacion");
				}

				this.numero_autorizacion=newnumero_autorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_fue(String newnumero_fue)throws Exception
	{
		try {
			if(this.numero_fue!=newnumero_fue) {
				if(newnumero_fue==null) {
					//newnumero_fue="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna numero_fue");
					}
				}

				if(newnumero_fue!=null&&newnumero_fue.length()>50) {
					newnumero_fue=newnumero_fue.substring(0,48);
					System.out.println("IngresosReferendos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_fue");
				}

				this.numero_fue=newnumero_fue;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso(String newnumero_pre_impreso)throws Exception
	{
		try {
			if(this.numero_pre_impreso!=newnumero_pre_impreso) {
				if(newnumero_pre_impreso==null) {
					//newnumero_pre_impreso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna numero_pre_impreso");
					}
				}

				if(newnumero_pre_impreso!=null&&newnumero_pre_impreso.length()>50) {
					newnumero_pre_impreso=newnumero_pre_impreso.substring(0,48);
					System.out.println("IngresosReferendos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso");
				}

				this.numero_pre_impreso=newnumero_pre_impreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dau(String newnumero_dau)throws Exception
	{
		try {
			if(this.numero_dau!=newnumero_dau) {
				if(newnumero_dau==null) {
					//newnumero_dau="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna numero_dau");
					}
				}

				if(newnumero_dau!=null&&newnumero_dau.length()>50) {
					newnumero_dau=newnumero_dau.substring(0,48);
					System.out.println("IngresosReferendos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_dau");
				}

				this.numero_dau=newnumero_dau;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_referendo(String newnumero_referendo)throws Exception
	{
		try {
			if(this.numero_referendo!=newnumero_referendo) {
				if(newnumero_referendo==null) {
					//newnumero_referendo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna numero_referendo");
					}
				}

				if(newnumero_referendo!=null&&newnumero_referendo.length()>50) {
					newnumero_referendo=newnumero_referendo.substring(0,48);
					System.out.println("IngresosReferendos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_referendo");
				}

				this.numero_referendo=newnumero_referendo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_referendo(Date newfecha_referendo)throws Exception
	{
		try {
			if(this.fecha_referendo!=newfecha_referendo) {
				if(newfecha_referendo==null) {
					//newfecha_referendo=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna fecha_referendo");
					}
				}

				this.fecha_referendo=newfecha_referendo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setaforo_referendo(String newaforo_referendo)throws Exception
	{
		try {
			if(this.aforo_referendo!=newaforo_referendo) {
				if(newaforo_referendo==null) {
					//newaforo_referendo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosReferendos:Valor nulo no permitido en columna aforo_referendo");
					}
				}

				if(newaforo_referendo!=null&&newaforo_referendo.length()>50) {
					newaforo_referendo=newaforo_referendo.substring(0,48);
					System.out.println("IngresosReferendos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna aforo_referendo");
				}

				this.aforo_referendo=newaforo_referendo;
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

