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
package com.bydan.erp.sris.business.entity.report;

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
//import com.bydan.erp.sris.util.SriRetencionesConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.sris.util.*;

import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;




@SuppressWarnings("unused")
public class SriRetenciones extends SriRetencionesAdditional implements Serializable ,Cloneable {//SriRetencionesAdditional,GeneralEntity
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
	
	private SriRetenciones sriretencionesOriginal;
	
	private Map<String, Object> mapSriRetenciones;
			
	public Map<String, Object> getMapSriRetenciones() {
		return mapSriRetenciones;
	}

	public void setMapSriRetenciones(Map<String, Object> mapSriRetenciones) {
		this.mapSriRetenciones = mapSriRetenciones;
	}
	
	public void inicializarMapSriRetenciones() {
		this.mapSriRetenciones = new HashMap<String,Object>();
	}
	
	public void setMapSriRetencionesValue(String sKey,Object oValue) {
		this.mapSriRetenciones.put(sKey, oValue);
	}
	
	public Object getMapSriRetencionesValue(String sKey) {
		return this.mapSriRetenciones.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo_declara;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriRetencionesConstantesFunciones.SREGEXRUC,message=SriRetencionesConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriRetencionesConstantesFunciones.SREGEXNOMBRE_MODULO,message=SriRetencionesConstantesFunciones.SMENSAJEREGEXNOMBRE_MODULO)
	private String nombre_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriRetencionesConstantesFunciones.SREGEXNOMBRE_TIPO_COMPROBANTE,message=SriRetencionesConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_COMPROBANTE)
	private String nombre_tipo_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriRetencionesConstantesFunciones.SREGEXNUMERO_DOCUMENTO,message=SriRetencionesConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO)
	private String numero_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_registro_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriRetencionesConstantesFunciones.SREGEXNUMERO_SERIE,message=SriRetencionesConstantesFunciones.SMENSAJEREGEXNUMERO_SERIE)
	private String numero_serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriRetencionesConstantesFunciones.SREGEXNUMERO_DOCUMENTO_CONTABLE,message=SriRetencionesConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO_CONTABLE)
	private String numero_documento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriRetencionesConstantesFunciones.SREGEXNOMBRE_CUENTA_CONTABLE_RETENCION,message=SriRetencionesConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE_RETENCION)
	private String nombre_cuenta_contable_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriRetencionesConstantesFunciones.SREGEXNOMBRE_BENEF,message=SriRetencionesConstantesFunciones.SMENSAJEREGEXNOMBRE_BENEF)
	private String nombre_benef;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	public PeriodoDeclara periododeclara;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	private String periododeclara_descripcion;
	
	
		
	public SriRetenciones () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.sriretencionesOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo_declara=-1L;
 		this.ruc="";
 		this.nombre_modulo="";
 		this.nombre_tipo_comprobante="";
 		this.numero_documento="";
 		this.fecha_emision=new Date();
 		this.fecha_registro_contable=new Date();
 		this.numero_serie="";
 		this.total_iva=0.0;
 		this.monto_iva=0.0;
 		this.numero_documento_contable="";
 		this.nombre_cuenta_contable_retencion="";
 		this.porcentaje=0.0;
 		this.valor=0.0;
 		this.nombre_benef="";
		
		
		this.empresa=null;
		this.ejercicio=null;
		this.periododeclara=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		this.periododeclara_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public SriRetenciones (Long id,Date versionRow,String nombre_modulo,String nombre_tipo_comprobante,String numero_documento,Date fecha_emision,Date fecha_registro_contable,String numero_serie,Double total_iva,Double monto_iva,String numero_documento_contable,String nombre_cuenta_contable_retencion,Double porcentaje,Double valor,String nombre_benef) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.sriretencionesOriginal=this;
		
 		this.nombre_modulo=nombre_modulo;
 		this.nombre_tipo_comprobante=nombre_tipo_comprobante;
 		this.numero_documento=numero_documento;
 		this.fecha_emision=fecha_emision;
 		this.fecha_registro_contable=fecha_registro_contable;
 		this.numero_serie=numero_serie;
 		this.total_iva=total_iva;
 		this.monto_iva=monto_iva;
 		this.numero_documento_contable=numero_documento_contable;
 		this.nombre_cuenta_contable_retencion=nombre_cuenta_contable_retencion;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
 		this.nombre_benef=nombre_benef;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public SriRetenciones (String nombre_modulo,String nombre_tipo_comprobante,String numero_documento,Date fecha_emision,Date fecha_registro_contable,String numero_serie,Double total_iva,Double monto_iva,String numero_documento_contable,String nombre_cuenta_contable_retencion,Double porcentaje,Double valor,String nombre_benef) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.sriretencionesOriginal=this;
		
 		this.nombre_modulo=nombre_modulo;
 		this.nombre_tipo_comprobante=nombre_tipo_comprobante;
 		this.numero_documento=numero_documento;
 		this.fecha_emision=fecha_emision;
 		this.fecha_registro_contable=fecha_registro_contable;
 		this.numero_serie=numero_serie;
 		this.total_iva=total_iva;
 		this.monto_iva=monto_iva;
 		this.numero_documento_contable=numero_documento_contable;
 		this.nombre_cuenta_contable_retencion=nombre_cuenta_contable_retencion;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
 		this.nombre_benef=nombre_benef;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public SriRetenciones getSriRetencionesOriginal() {
		return this.sriretencionesOriginal;
	}
	
	public void setSriRetencionesOriginal(SriRetenciones sriretenciones) {
		try {
			this.sriretencionesOriginal=sriretenciones;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected SriRetencionesAdditional sriretencionesAdditional=null;
	
	public SriRetencionesAdditional getSriRetencionesAdditional() {
		return this.sriretencionesAdditional;
	}
	
	public void setSriRetencionesAdditional(SriRetencionesAdditional sriretencionesAdditional) {
		try {
			this.sriretencionesAdditional=sriretencionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo_declara() {
		return this.id_periodo_declara;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getnombre_modulo() {
		return this.nombre_modulo;
	}
    
	
	public String getnombre_tipo_comprobante() {
		return this.nombre_tipo_comprobante;
	}
    
	
	public String getnumero_documento() {
		return this.numero_documento;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_registro_contable() {
		return this.fecha_registro_contable;
	}
    
	
	public String getnumero_serie() {
		return this.numero_serie;
	}
    
	
	public Double gettotal_iva() {
		return this.total_iva;
	}
    
	
	public Double getmonto_iva() {
		return this.monto_iva;
	}
    
	
	public String getnumero_documento_contable() {
		return this.numero_documento_contable;
	}
    
	
	public String getnombre_cuenta_contable_retencion() {
		return this.nombre_cuenta_contable_retencion;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getnombre_benef() {
		return this.nombre_benef;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo_declara(Long newid_periodo_declara)throws Exception
	{
		try {
			if(this.id_periodo_declara!=newid_periodo_declara) {
				if(newid_periodo_declara==null) {
					//newid_periodo_declara=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna id_periodo_declara");
					}
				}

				this.id_periodo_declara=newid_periodo_declara;
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
						System.out.println("SriRetenciones:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("SriRetenciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_modulo(String newnombre_modulo)throws Exception
	{
		try {
			if(this.nombre_modulo!=newnombre_modulo) {
				if(newnombre_modulo==null) {
					//newnombre_modulo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna nombre_modulo");
					}
				}

				if(newnombre_modulo!=null&&newnombre_modulo.length()>150) {
					newnombre_modulo=newnombre_modulo.substring(0,148);
					System.out.println("SriRetenciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_modulo");
				}

				this.nombre_modulo=newnombre_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_comprobante(String newnombre_tipo_comprobante)throws Exception
	{
		try {
			if(this.nombre_tipo_comprobante!=newnombre_tipo_comprobante) {
				if(newnombre_tipo_comprobante==null) {
					//newnombre_tipo_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna nombre_tipo_comprobante");
					}
				}

				if(newnombre_tipo_comprobante!=null&&newnombre_tipo_comprobante.length()>100) {
					newnombre_tipo_comprobante=newnombre_tipo_comprobante.substring(0,98);
					System.out.println("SriRetenciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_comprobante");
				}

				this.nombre_tipo_comprobante=newnombre_tipo_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_documento(String newnumero_documento)throws Exception
	{
		try {
			if(this.numero_documento!=newnumero_documento) {
				if(newnumero_documento==null) {
					//newnumero_documento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna numero_documento");
					}
				}

				if(newnumero_documento!=null&&newnumero_documento.length()>50) {
					newnumero_documento=newnumero_documento.substring(0,48);
					System.out.println("SriRetenciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento");
				}

				this.numero_documento=newnumero_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_registro_contable(Date newfecha_registro_contable)throws Exception
	{
		try {
			if(this.fecha_registro_contable!=newfecha_registro_contable) {
				if(newfecha_registro_contable==null) {
					//newfecha_registro_contable=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna fecha_registro_contable");
					}
				}

				this.fecha_registro_contable=newfecha_registro_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_serie(String newnumero_serie)throws Exception
	{
		try {
			if(this.numero_serie!=newnumero_serie) {
				if(newnumero_serie==null) {
					//newnumero_serie="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna numero_serie");
					}
				}

				if(newnumero_serie!=null&&newnumero_serie.length()>50) {
					newnumero_serie=newnumero_serie.substring(0,48);
					System.out.println("SriRetenciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_serie");
				}

				this.numero_serie=newnumero_serie;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_iva(Double newtotal_iva)throws Exception
	{
		try {
			if(this.total_iva!=newtotal_iva) {
				if(newtotal_iva==null) {
					//newtotal_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna total_iva");
					}
				}

				this.total_iva=newtotal_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_iva(Double newmonto_iva)throws Exception
	{
		try {
			if(this.monto_iva!=newmonto_iva) {
				if(newmonto_iva==null) {
					//newmonto_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna monto_iva");
					}
				}

				this.monto_iva=newmonto_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_documento_contable(String newnumero_documento_contable)throws Exception
	{
		try {
			if(this.numero_documento_contable!=newnumero_documento_contable) {
				if(newnumero_documento_contable==null) {
					//newnumero_documento_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna numero_documento_contable");
					}
				}

				if(newnumero_documento_contable!=null&&newnumero_documento_contable.length()>50) {
					newnumero_documento_contable=newnumero_documento_contable.substring(0,48);
					System.out.println("SriRetenciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento_contable");
				}

				this.numero_documento_contable=newnumero_documento_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cuenta_contable_retencion(String newnombre_cuenta_contable_retencion)throws Exception
	{
		try {
			if(this.nombre_cuenta_contable_retencion!=newnombre_cuenta_contable_retencion) {
				if(newnombre_cuenta_contable_retencion==null) {
					//newnombre_cuenta_contable_retencion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna nombre_cuenta_contable_retencion");
					}
				}

				if(newnombre_cuenta_contable_retencion!=null&&newnombre_cuenta_contable_retencion.length()>150) {
					newnombre_cuenta_contable_retencion=newnombre_cuenta_contable_retencion.substring(0,148);
					System.out.println("SriRetenciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta_contable_retencion");
				}

				this.nombre_cuenta_contable_retencion=newnombre_cuenta_contable_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_benef(String newnombre_benef)throws Exception
	{
		try {
			if(this.nombre_benef!=newnombre_benef) {
				if(newnombre_benef==null) {
					//newnombre_benef="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriRetenciones:Valor nulo no permitido en columna nombre_benef");
					}
				}

				if(newnombre_benef!=null&&newnombre_benef.length()>150) {
					newnombre_benef=newnombre_benef.substring(0,148);
					System.out.println("SriRetenciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_benef");
				}

				this.nombre_benef=newnombre_benef;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public PeriodoDeclara getPeriodoDeclara() {
		return this.periododeclara;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiododeclara_descripcion() {
		return this.periododeclara_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodoDeclara(PeriodoDeclara periododeclara) {
		try {
			this.periododeclara=periododeclara;
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


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperiododeclara_descripcion(String periododeclara_descripcion) {
		try {
			this.periododeclara_descripcion=periododeclara_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";String id_periodo_declara_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_declara_descripcion() {
		return id_periodo_declara_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_declara_descripcion(String newid_periodo_declara_descripcion)throws Exception {
		try {
			this.id_periodo_declara_descripcion=newid_periodo_declara_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_declara_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

