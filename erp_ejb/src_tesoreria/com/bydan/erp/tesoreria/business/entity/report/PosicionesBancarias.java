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
package com.bydan.erp.tesoreria.business.entity.report;

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
//import com.bydan.erp.tesoreria.util.PosicionesBancariasConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class PosicionesBancarias extends PosicionesBancariasAdditional implements Serializable ,Cloneable {//PosicionesBancariasAdditional,GeneralEntity
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
	
	private PosicionesBancarias posicionesbancariasOriginal;
	
	private Map<String, Object> mapPosicionesBancarias;
			
	public Map<String, Object> getMapPosicionesBancarias() {
		return mapPosicionesBancarias;
	}

	public void setMapPosicionesBancarias(Map<String, Object> mapPosicionesBancarias) {
		this.mapPosicionesBancarias = mapPosicionesBancarias;
	}
	
	public void inicializarMapPosicionesBancarias() {
		this.mapPosicionesBancarias = new HashMap<String,Object>();
	}
	
	public void setMapPosicionesBancariasValue(String sKey,Object oValue) {
		this.mapPosicionesBancarias.put(sKey, oValue);
	}
	
	public Object getMapPosicionesBancariasValue(String sKey) {
		return this.mapPosicionesBancarias.get(sKey);
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
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long orden_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long orden_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PosicionesBancariasConstantesFunciones.SREGEXTIPO_DOCUMENTO,message=PosicionesBancariasConstantesFunciones.SMENSAJEREGEXTIPO_DOCUMENTO)
	private String tipo_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PosicionesBancariasConstantesFunciones.SREGEXDETALLE,message=PosicionesBancariasConstantesFunciones.SMENSAJEREGEXDETALLE)
	private String detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PosicionesBancariasConstantesFunciones.SREGEXCODIGO_CUENTA,message=PosicionesBancariasConstantesFunciones.SMENSAJEREGEXCODIGO_CUENTA)
	private String codigo_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PosicionesBancariasConstantesFunciones.SREGEXNOMBRE_CUENTA,message=PosicionesBancariasConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA)
	private String nombre_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PosicionesBancariasConstantesFunciones.SREGEXNUMERO_MAYOR,message=PosicionesBancariasConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PosicionesBancariasConstantesFunciones.SREGEXTIPO_MOVIMIENTO,message=PosicionesBancariasConstantesFunciones.SMENSAJEREGEXTIPO_MOVIMIENTO)
	private String tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PosicionesBancariasConstantesFunciones.SREGEXBENEFICIARIO,message=PosicionesBancariasConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	public TipoMovimiento tipomovimiento;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	private String tipomovimiento_descripcion;
	
	
		
	public PosicionesBancarias () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.posicionesbancariasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.id_tipo_movimiento=-1L;
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.orden_desde=0L;
 		this.orden_hasta=0L;
 		this.tipo_documento="";
 		this.detalle="";
 		this.codigo_cuenta="";
 		this.nombre_cuenta="";
 		this.numero_mayor="";
 		this.debito_local=0.0;
 		this.credito_local=0.0;
 		this.tipo_movimiento="";
 		this.fecha_emision=new Date();
 		this.fecha=new Date();
 		this.beneficiario="";
		
		
		this.empresa=null;
		this.ejercicio=null;
		this.tipomovimiento=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		this.tipomovimiento_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PosicionesBancarias (Long id,Date versionRow,String tipo_documento,String detalle,String codigo_cuenta,String nombre_cuenta,String numero_mayor,Double debito_local,Double credito_local,String tipo_movimiento,Date fecha_emision,Date fecha,String beneficiario) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.posicionesbancariasOriginal=this;
		
 		this.tipo_documento=tipo_documento;
 		this.detalle=detalle;
 		this.codigo_cuenta=codigo_cuenta;
 		this.nombre_cuenta=nombre_cuenta;
 		this.numero_mayor=numero_mayor;
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.tipo_movimiento=tipo_movimiento;
 		this.fecha_emision=fecha_emision;
 		this.fecha=fecha;
 		this.beneficiario=beneficiario;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PosicionesBancarias (String tipo_documento,String detalle,String codigo_cuenta,String nombre_cuenta,String numero_mayor,Double debito_local,Double credito_local,String tipo_movimiento,Date fecha_emision,Date fecha,String beneficiario) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.posicionesbancariasOriginal=this;
		
 		this.tipo_documento=tipo_documento;
 		this.detalle=detalle;
 		this.codigo_cuenta=codigo_cuenta;
 		this.nombre_cuenta=nombre_cuenta;
 		this.numero_mayor=numero_mayor;
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.tipo_movimiento=tipo_movimiento;
 		this.fecha_emision=fecha_emision;
 		this.fecha=fecha;
 		this.beneficiario=beneficiario;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public PosicionesBancarias getPosicionesBancariasOriginal() {
		return this.posicionesbancariasOriginal;
	}
	
	public void setPosicionesBancariasOriginal(PosicionesBancarias posicionesbancarias) {
		try {
			this.posicionesbancariasOriginal=posicionesbancarias;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PosicionesBancariasAdditional posicionesbancariasAdditional=null;
	
	public PosicionesBancariasAdditional getPosicionesBancariasAdditional() {
		return this.posicionesbancariasAdditional;
	}
	
	public void setPosicionesBancariasAdditional(PosicionesBancariasAdditional posicionesbancariasAdditional) {
		try {
			this.posicionesbancariasAdditional=posicionesbancariasAdditional;
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
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public Date getfecha_desde() {
		return this.fecha_desde;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public Long getorden_desde() {
		return this.orden_desde;
	}
    
	
	public Long getorden_hasta() {
		return this.orden_hasta;
	}
    
	
	public String gettipo_documento() {
		return this.tipo_documento;
	}
    
	
	public String getdetalle() {
		return this.detalle;
	}
    
	
	public String getcodigo_cuenta() {
		return this.codigo_cuenta;
	}
    
	
	public String getnombre_cuenta() {
		return this.nombre_cuenta;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public Double getdebito_local() {
		return this.debito_local;
	}
    
	
	public Double getcredito_local() {
		return this.credito_local;
	}
    
	
	public String gettipo_movimiento() {
		return this.tipo_movimiento;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getbeneficiario() {
		return this.beneficiario;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento)throws Exception
	{
		try {
			if(this.id_tipo_movimiento!=newid_tipo_movimiento) {
				if(newid_tipo_movimiento==null) {
					//newid_tipo_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_desde(Date newfecha_desde)throws Exception
	{
		try {
			if(this.fecha_desde!=newfecha_desde) {
				if(newfecha_desde==null) {
					//newfecha_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna fecha_desde");
					}
				}

				this.fecha_desde=newfecha_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_hasta(Date newfecha_hasta)throws Exception
	{
		try {
			if(this.fecha_hasta!=newfecha_hasta) {
				if(newfecha_hasta==null) {
					//newfecha_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorden_desde(Long neworden_desde)throws Exception
	{
		try {
			if(this.orden_desde!=neworden_desde) {
				if(neworden_desde==null) {
					//neworden_desde=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna orden_desde");
					}
				}

				this.orden_desde=neworden_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorden_hasta(Long neworden_hasta)throws Exception
	{
		try {
			if(this.orden_hasta!=neworden_hasta) {
				if(neworden_hasta==null) {
					//neworden_hasta=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna orden_hasta");
					}
				}

				this.orden_hasta=neworden_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_documento(String newtipo_documento)throws Exception
	{
		try {
			if(this.tipo_documento!=newtipo_documento) {
				if(newtipo_documento==null) {
					//newtipo_documento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna tipo_documento");
					}
				}

				if(newtipo_documento!=null&&newtipo_documento.length()>100) {
					newtipo_documento=newtipo_documento.substring(0,98);
					System.out.println("PosicionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna tipo_documento");
				}

				this.tipo_documento=newtipo_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdetalle(String newdetalle)throws Exception
	{
		try {
			if(this.detalle!=newdetalle) {
				if(newdetalle==null) {
					//newdetalle="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna detalle");
					}
				}

				if(newdetalle!=null&&newdetalle.length()>250) {
					newdetalle=newdetalle.substring(0,248);
					System.out.println("PosicionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna detalle");
				}

				this.detalle=newdetalle;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cuenta(String newcodigo_cuenta)throws Exception
	{
		try {
			if(this.codigo_cuenta!=newcodigo_cuenta) {
				if(newcodigo_cuenta==null) {
					//newcodigo_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna codigo_cuenta");
					}
				}

				if(newcodigo_cuenta!=null&&newcodigo_cuenta.length()>50) {
					newcodigo_cuenta=newcodigo_cuenta.substring(0,48);
					System.out.println("PosicionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cuenta");
				}

				this.codigo_cuenta=newcodigo_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cuenta(String newnombre_cuenta)throws Exception
	{
		try {
			if(this.nombre_cuenta!=newnombre_cuenta) {
				if(newnombre_cuenta==null) {
					//newnombre_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna nombre_cuenta");
					}
				}

				if(newnombre_cuenta!=null&&newnombre_cuenta.length()>150) {
					newnombre_cuenta=newnombre_cuenta.substring(0,148);
					System.out.println("PosicionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta");
				}

				this.nombre_cuenta=newnombre_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_mayor(String newnumero_mayor)throws Exception
	{
		try {
			if(this.numero_mayor!=newnumero_mayor) {
				if(newnumero_mayor==null) {
					//newnumero_mayor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("PosicionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_local(Double newdebito_local)throws Exception
	{
		try {
			if(this.debito_local!=newdebito_local) {
				if(newdebito_local==null) {
					//newdebito_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna debito_local");
					}
				}

				this.debito_local=newdebito_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_local(Double newcredito_local)throws Exception
	{
		try {
			if(this.credito_local!=newcredito_local) {
				if(newcredito_local==null) {
					//newcredito_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna credito_local");
					}
				}

				this.credito_local=newcredito_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_movimiento(String newtipo_movimiento)throws Exception
	{
		try {
			if(this.tipo_movimiento!=newtipo_movimiento) {
				if(newtipo_movimiento==null) {
					//newtipo_movimiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna tipo_movimiento");
					}
				}

				if(newtipo_movimiento!=null&&newtipo_movimiento.length()>100) {
					newtipo_movimiento=newtipo_movimiento.substring(0,98);
					System.out.println("PosicionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna tipo_movimiento");
				}

				this.tipo_movimiento=newtipo_movimiento;
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
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
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
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbeneficiario(String newbeneficiario)throws Exception
	{
		try {
			if(this.beneficiario!=newbeneficiario) {
				if(newbeneficiario==null) {
					//newbeneficiario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PosicionesBancarias:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>200) {
					newbeneficiario=newbeneficiario.substring(0,198);
					System.out.println("PosicionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna beneficiario");
				}

				this.beneficiario=newbeneficiario;
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

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
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


	public  void  setTipoMovimiento(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimiento=tipomovimiento;
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


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";String id_tipo_movimiento_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
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
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";this.id_tipo_movimiento_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

