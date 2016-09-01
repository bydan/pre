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
//import com.bydan.erp.cartera.util.ReferenciaBancariaConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class ReferenciaBancaria extends ReferenciaBancariaAdditional implements Serializable ,Cloneable {//ReferenciaBancariaAdditional,GeneralEntity
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
	
	private ReferenciaBancaria referenciabancariaOriginal;
	
	private Map<String, Object> mapReferenciaBancaria;
			
	public Map<String, Object> getMapReferenciaBancaria() {
		return mapReferenciaBancaria;
	}

	public void setMapReferenciaBancaria(Map<String, Object> mapReferenciaBancaria) {
		this.mapReferenciaBancaria = mapReferenciaBancaria;
	}
	
	public void inicializarMapReferenciaBancaria() {
		this.mapReferenciaBancaria = new HashMap<String,Object>();
	}
	
	public void setMapReferenciaBancariaValue(String sKey,Object oValue) {
		this.mapReferenciaBancaria.put(sKey, oValue);
	}
	
	public Object getMapReferenciaBancariaValue(String sKey) {
		return this.mapReferenciaBancaria.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idcliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclientebanco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclienteproductobanco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclientecuentabanco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaBancariaConstantesFunciones.SREGEXNUMERO_CUENTA_TARJETA,message=ReferenciaBancariaConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA_TARJETA)
	private String numero_cuenta_tarjeta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean tiene_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_creditos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean tiene_protestos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_protestos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaBancariaConstantesFunciones.SREGEXSALDOS_PROMEDIOS,message=ReferenciaBancariaConstantesFunciones.SMENSAJEREGEXSALDOS_PROMEDIOS)
	private String saldos_promedios;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaBancariaConstantesFunciones.SREGEXPROPIETARIO_CUENTA,message=ReferenciaBancariaConstantesFunciones.SMENSAJEREGEXPROPIETARIO_CUENTA)
	private String propietario_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_valoracion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esactivo;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public Banco banco;
	public TipoProduBanco tipoprodubanco;
	public TipoCuentaBanco tipocuentabanco;
	public TipoValoracion tipovaloracion;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String banco_descripcion;
	private String tipoprodubanco_descripcion;
	private String tipocuentabanco_descripcion;
	private String tipovaloracion_descripcion;
	
	
		
	public ReferenciaBancaria () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.referenciabancariaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.idcliente=-1L;
 		this.idvalorclientebanco=-1L;
 		this.idvalorclienteproductobanco=-1L;
 		this.idvalorclientecuentabanco=-1L;
 		this.numero_cuenta_tarjeta="";
 		this.fecha_emision=new Date();
 		this.fecha_vencimiento=new Date();
 		this.cupo=0.0;
 		this.tiene_credito=false;
 		this.numero_creditos=0;
 		this.tiene_protestos=false;
 		this.numero_protestos=0;
 		this.saldos_promedios="";
 		this.propietario_cuenta="";
 		this.id_tipo_valoracion=-1L;
 		this.esactivo=false;
		
		
		this.empresa=null;
		this.cliente=null;
		this.banco=null;
		this.tipoprodubanco=null;
		this.tipocuentabanco=null;
		this.tipovaloracion=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.banco_descripcion="";
		this.tipoprodubanco_descripcion="";
		this.tipocuentabanco_descripcion="";
		this.tipovaloracion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ReferenciaBancaria (Long id,Date versionRow,Long id_empresa,Long idcliente,Long idvalorclientebanco,Long idvalorclienteproductobanco,Long idvalorclientecuentabanco,String numero_cuenta_tarjeta,Date fecha_emision,Date fecha_vencimiento,Double cupo,Boolean tiene_credito,Integer numero_creditos,Boolean tiene_protestos,Integer numero_protestos,String saldos_promedios,String propietario_cuenta,Long id_tipo_valoracion,Boolean esactivo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.referenciabancariaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.idcliente=idcliente;
 		this.idvalorclientebanco=idvalorclientebanco;
 		this.idvalorclienteproductobanco=idvalorclienteproductobanco;
 		this.idvalorclientecuentabanco=idvalorclientecuentabanco;
 		this.numero_cuenta_tarjeta=numero_cuenta_tarjeta;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.cupo=cupo;
 		this.tiene_credito=tiene_credito;
 		this.numero_creditos=numero_creditos;
 		this.tiene_protestos=tiene_protestos;
 		this.numero_protestos=numero_protestos;
 		this.saldos_promedios=saldos_promedios;
 		this.propietario_cuenta=propietario_cuenta;
 		this.id_tipo_valoracion=id_tipo_valoracion;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ReferenciaBancaria (Long id_empresa,Long idcliente,Long idvalorclientebanco,Long idvalorclienteproductobanco,Long idvalorclientecuentabanco,String numero_cuenta_tarjeta,Date fecha_emision,Date fecha_vencimiento,Double cupo,Boolean tiene_credito,Integer numero_creditos,Boolean tiene_protestos,Integer numero_protestos,String saldos_promedios,String propietario_cuenta,Long id_tipo_valoracion,Boolean esactivo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.referenciabancariaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.idcliente=idcliente;
 		this.idvalorclientebanco=idvalorclientebanco;
 		this.idvalorclienteproductobanco=idvalorclienteproductobanco;
 		this.idvalorclientecuentabanco=idvalorclientecuentabanco;
 		this.numero_cuenta_tarjeta=numero_cuenta_tarjeta;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.cupo=cupo;
 		this.tiene_credito=tiene_credito;
 		this.numero_creditos=numero_creditos;
 		this.tiene_protestos=tiene_protestos;
 		this.numero_protestos=numero_protestos;
 		this.saldos_promedios=saldos_promedios;
 		this.propietario_cuenta=propietario_cuenta;
 		this.id_tipo_valoracion=id_tipo_valoracion;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ReferenciaBancaria referenciabancariaLocal=null;
		
		if(object!=null) {
			referenciabancariaLocal=(ReferenciaBancaria)object;
			
			if(referenciabancariaLocal!=null) {
				if(this.getId()!=null && referenciabancariaLocal.getId()!=null) {
					if(this.getId().equals(referenciabancariaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ReferenciaBancariaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ReferenciaBancariaConstantesFunciones.getReferenciaBancariaDescripcion(this);
		} else {
			sDetalle=ReferenciaBancariaConstantesFunciones.getReferenciaBancariaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ReferenciaBancaria getReferenciaBancariaOriginal() {
		return this.referenciabancariaOriginal;
	}
	
	public void setReferenciaBancariaOriginal(ReferenciaBancaria referenciabancaria) {
		try {
			this.referenciabancariaOriginal=referenciabancaria;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ReferenciaBancariaAdditional referenciabancariaAdditional=null;
	
	public ReferenciaBancariaAdditional getReferenciaBancariaAdditional() {
		return this.referenciabancariaAdditional;
	}
	
	public void setReferenciaBancariaAdditional(ReferenciaBancariaAdditional referenciabancariaAdditional) {
		try {
			this.referenciabancariaAdditional=referenciabancariaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getidcliente() {
		return this.idcliente;
	}
    
	
	public Long getidvalorclientebanco() {
		return this.idvalorclientebanco;
	}
    
	
	public Long getidvalorclienteproductobanco() {
		return this.idvalorclienteproductobanco;
	}
    
	
	public Long getidvalorclientecuentabanco() {
		return this.idvalorclientecuentabanco;
	}
    
	
	public String getnumero_cuenta_tarjeta() {
		return this.numero_cuenta_tarjeta;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public Double getcupo() {
		return this.cupo;
	}
    
	
	public Boolean gettiene_credito() {
		return this.tiene_credito;
	}
    
	
	public Integer getnumero_creditos() {
		return this.numero_creditos;
	}
    
	
	public Boolean gettiene_protestos() {
		return this.tiene_protestos;
	}
    
	
	public Integer getnumero_protestos() {
		return this.numero_protestos;
	}
    
	
	public String getsaldos_promedios() {
		return this.saldos_promedios;
	}
    
	
	public String getpropietario_cuenta() {
		return this.propietario_cuenta;
	}
    
	
	public Long getid_tipo_valoracion() {
		return this.id_tipo_valoracion;
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
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidcliente(Long newidcliente)throws Exception
	{
		try {
			if(this.idcliente!=newidcliente) {
				if(newidcliente==null) {
					//newidcliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna idcliente");
					}
				}

				this.idcliente=newidcliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclientebanco(Long newidvalorclientebanco)throws Exception
	{
		try {
			if(this.idvalorclientebanco!=newidvalorclientebanco) {
				if(newidvalorclientebanco==null) {
					//newidvalorclientebanco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna idvalorclientebanco");
					}
				}

				this.idvalorclientebanco=newidvalorclientebanco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclienteproductobanco(Long newidvalorclienteproductobanco)throws Exception
	{
		try {
			if(this.idvalorclienteproductobanco!=newidvalorclienteproductobanco) {
				if(newidvalorclienteproductobanco==null) {
					//newidvalorclienteproductobanco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna idvalorclienteproductobanco");
					}
				}

				this.idvalorclienteproductobanco=newidvalorclienteproductobanco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclientecuentabanco(Long newidvalorclientecuentabanco)throws Exception
	{
		try {
			if(this.idvalorclientecuentabanco!=newidvalorclientecuentabanco) {
				if(newidvalorclientecuentabanco==null) {
					//newidvalorclientecuentabanco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna idvalorclientecuentabanco");
					}
				}

				this.idvalorclientecuentabanco=newidvalorclientecuentabanco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuenta_tarjeta(String newnumero_cuenta_tarjeta)throws Exception
	{
		try {
			if(this.numero_cuenta_tarjeta!=newnumero_cuenta_tarjeta) {
				if(newnumero_cuenta_tarjeta==null) {
					//newnumero_cuenta_tarjeta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna numero_cuenta_tarjeta");
					}
				}

				if(newnumero_cuenta_tarjeta!=null&&newnumero_cuenta_tarjeta.length()>50) {
					newnumero_cuenta_tarjeta=newnumero_cuenta_tarjeta.substring(0,48);
					System.out.println("ReferenciaBancaria:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta_tarjeta");
				}

				this.numero_cuenta_tarjeta=newnumero_cuenta_tarjeta;
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
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcupo(Double newcupo)throws Exception
	{
		try {
			if(this.cupo!=newcupo) {
				if(newcupo==null) {
					//newcupo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna cupo");
					}
				}

				this.cupo=newcupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settiene_credito(Boolean newtiene_credito)throws Exception
	{
		try {
			if(this.tiene_credito!=newtiene_credito) {
				if(newtiene_credito==null) {
					//newtiene_credito=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna tiene_credito");
					}
				}

				this.tiene_credito=newtiene_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_creditos(Integer newnumero_creditos)throws Exception
	{
		try {
			if(this.numero_creditos!=newnumero_creditos) {
				if(newnumero_creditos==null) {
					//newnumero_creditos=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna numero_creditos");
					}
				}

				this.numero_creditos=newnumero_creditos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settiene_protestos(Boolean newtiene_protestos)throws Exception
	{
		try {
			if(this.tiene_protestos!=newtiene_protestos) {
				if(newtiene_protestos==null) {
					//newtiene_protestos=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna tiene_protestos");
					}
				}

				this.tiene_protestos=newtiene_protestos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_protestos(Integer newnumero_protestos)throws Exception
	{
		try {
			if(this.numero_protestos!=newnumero_protestos) {
				if(newnumero_protestos==null) {
					//newnumero_protestos=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna numero_protestos");
					}
				}

				this.numero_protestos=newnumero_protestos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldos_promedios(String newsaldos_promedios)throws Exception
	{
		try {
			if(this.saldos_promedios!=newsaldos_promedios) {
				if(newsaldos_promedios==null) {
					//newsaldos_promedios="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna saldos_promedios");
					}
				}

				if(newsaldos_promedios!=null&&newsaldos_promedios.length()>50) {
					newsaldos_promedios=newsaldos_promedios.substring(0,48);
					System.out.println("ReferenciaBancaria:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna saldos_promedios");
				}

				this.saldos_promedios=newsaldos_promedios;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpropietario_cuenta(String newpropietario_cuenta)throws Exception
	{
		try {
			if(this.propietario_cuenta!=newpropietario_cuenta) {
				if(newpropietario_cuenta==null) {
					//newpropietario_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna propietario_cuenta");
					}
				}

				if(newpropietario_cuenta!=null&&newpropietario_cuenta.length()>50) {
					newpropietario_cuenta=newpropietario_cuenta.substring(0,48);
					System.out.println("ReferenciaBancaria:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna propietario_cuenta");
				}

				this.propietario_cuenta=newpropietario_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_valoracion(Long newid_tipo_valoracion)throws Exception
	{
		try {
			if(this.id_tipo_valoracion!=newid_tipo_valoracion) {
				if(newid_tipo_valoracion==null) {
					//newid_tipo_valoracion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna id_tipo_valoracion");
					}
				}

				this.id_tipo_valoracion=newid_tipo_valoracion;
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
						System.out.println("ReferenciaBancaria:Valor nulo no permitido en columna esactivo");
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

	public Banco getBanco() {
		return this.banco;
	}

	public TipoProduBanco getTipoProduBanco() {
		return this.tipoprodubanco;
	}

	public TipoCuentaBanco getTipoCuentaBanco() {
		return this.tipocuentabanco;
	}

	public TipoValoracion getTipoValoracion() {
		return this.tipovaloracion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	public String gettipoprodubanco_descripcion() {
		return this.tipoprodubanco_descripcion;
	}

	public String gettipocuentabanco_descripcion() {
		return this.tipocuentabanco_descripcion;
	}

	public String gettipovaloracion_descripcion() {
		return this.tipovaloracion_descripcion;
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


	public  void  setBanco(Banco banco) {
		try {
			this.banco=banco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoProduBanco(TipoProduBanco tipoprodubanco) {
		try {
			this.tipoprodubanco=tipoprodubanco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCuentaBanco(TipoCuentaBanco tipocuentabanco) {
		try {
			this.tipocuentabanco=tipocuentabanco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoValoracion(TipoValoracion tipovaloracion) {
		try {
			this.tipovaloracion=tipovaloracion;
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


	public  void  setbanco_descripcion(String banco_descripcion) {
		try {
			this.banco_descripcion=banco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoprodubanco_descripcion(String tipoprodubanco_descripcion) {
		try {
			this.tipoprodubanco_descripcion=tipoprodubanco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocuentabanco_descripcion(String tipocuentabanco_descripcion) {
		try {
			this.tipocuentabanco_descripcion=tipocuentabanco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipovaloracion_descripcion(String tipovaloracion_descripcion) {
		try {
			this.tipovaloracion_descripcion=tipovaloracion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String idcliente_descripcion="";String idvalorclientebanco_descripcion="";String idvalorclienteproductobanco_descripcion="";String idvalorclientecuentabanco_descripcion="";String tiene_credito_descripcion="";String tiene_protestos_descripcion="";String id_tipo_valoracion_descripcion="";String esactivo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getidcliente_descripcion() {
		return idcliente_descripcion;
	}
	public String getidvalorclientebanco_descripcion() {
		return idvalorclientebanco_descripcion;
	}
	public String getidvalorclienteproductobanco_descripcion() {
		return idvalorclienteproductobanco_descripcion;
	}
	public String getidvalorclientecuentabanco_descripcion() {
		return idvalorclientecuentabanco_descripcion;
	}
	public String gettiene_credito_descripcion() {
		return tiene_credito_descripcion;
	}
	public String gettiene_protestos_descripcion() {
		return tiene_protestos_descripcion;
	}
	public String getid_tipo_valoracion_descripcion() {
		return id_tipo_valoracion_descripcion;
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
	public void setidcliente_descripcion(String newidcliente_descripcion)throws Exception {
		try {
			this.idcliente_descripcion=newidcliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclientebanco_descripcion(String newidvalorclientebanco_descripcion)throws Exception {
		try {
			this.idvalorclientebanco_descripcion=newidvalorclientebanco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclienteproductobanco_descripcion(String newidvalorclienteproductobanco_descripcion)throws Exception {
		try {
			this.idvalorclienteproductobanco_descripcion=newidvalorclienteproductobanco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclientecuentabanco_descripcion(String newidvalorclientecuentabanco_descripcion)throws Exception {
		try {
			this.idvalorclientecuentabanco_descripcion=newidvalorclientecuentabanco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void settiene_credito_descripcion(String newtiene_credito_descripcion)throws Exception {
		try {
			this.tiene_credito_descripcion=newtiene_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void settiene_protestos_descripcion(String newtiene_protestos_descripcion)throws Exception {
		try {
			this.tiene_protestos_descripcion=newtiene_protestos_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_valoracion_descripcion(String newid_tipo_valoracion_descripcion)throws Exception {
		try {
			this.id_tipo_valoracion_descripcion=newid_tipo_valoracion_descripcion;
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
		this.id_empresa_descripcion="";this.idcliente_descripcion="";this.idvalorclientebanco_descripcion="";this.idvalorclienteproductobanco_descripcion="";this.idvalorclientecuentabanco_descripcion="";this.tiene_credito_descripcion="";this.tiene_protestos_descripcion="";this.id_tipo_valoracion_descripcion="";this.esactivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

