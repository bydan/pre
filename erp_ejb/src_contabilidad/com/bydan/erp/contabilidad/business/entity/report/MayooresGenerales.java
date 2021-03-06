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
package com.bydan.erp.contabilidad.business.entity.report;

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
//import com.bydan.erp.contabilidad.util.MayooresGeneralesConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class MayooresGenerales extends MayooresGeneralesAdditional implements Serializable ,Cloneable {//MayooresGeneralesAdditional,GeneralEntity
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
	
	private MayooresGenerales mayooresgeneralesOriginal;
	
	private Map<String, Object> mapMayooresGenerales;
			
	public Map<String, Object> getMapMayooresGenerales() {
		return mapMayooresGenerales;
	}

	public void setMapMayooresGenerales(Map<String, Object> mapMayooresGenerales) {
		this.mapMayooresGenerales = mapMayooresGenerales;
	}
	
	public void inicializarMapMayooresGenerales() {
		this.mapMayooresGenerales = new HashMap<String,Object>();
	}
	
	public void setMapMayooresGeneralesValue(String sKey,Object oValue) {
		this.mapMayooresGenerales.put(sKey, oValue);
	}
	
	public Object getMapMayooresGeneralesValue(String sKey) {
		return this.mapMayooresGenerales.get(sKey);
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
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MayooresGeneralesConstantesFunciones.SREGEXNOMBRE_SUCURSAL,message=MayooresGeneralesConstantesFunciones.SMENSAJEREGEXNOMBRE_SUCURSAL)
	private String nombre_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MayooresGeneralesConstantesFunciones.SREGEXCODIGO,message=MayooresGeneralesConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MayooresGeneralesConstantesFunciones.SREGEXBENEFICIARIO,message=MayooresGeneralesConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MayooresGeneralesConstantesFunciones.SREGEXDETALLE,message=MayooresGeneralesConstantesFunciones.SMENSAJEREGEXDETALLE)
	private String detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MayooresGeneralesConstantesFunciones.SREGEXCODIGO_TIPO_MOVIMIENTO,message=MayooresGeneralesConstantesFunciones.SMENSAJEREGEXCODIGO_TIPO_MOVIMIENTO)
	private String codigo_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MayooresGeneralesConstantesFunciones.SREGEXNUMERO_MAYOR,message=MayooresGeneralesConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MayooresGeneralesConstantesFunciones.SREGEXNOMBRE_CUENTA_CONTABLE,message=MayooresGeneralesConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE)
	private String nombre_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MayooresGeneralesConstantesFunciones.SREGEXDETALLE_DETALLE_ASIENTO_CONTABLE,message=MayooresGeneralesConstantesFunciones.SMENSAJEREGEXDETALLE_DETALLE_ASIENTO_CONTABLE)
	private String detalle_detalle_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MayooresGeneralesConstantesFunciones.SREGEXCODIGO_CUENTA_CONTABLE,message=MayooresGeneralesConstantesFunciones.SMENSAJEREGEXCODIGO_CUENTA_CONTABLE)
	private String codigo_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	public CuentaContable cuentacontable;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	private String cuentacontable_descripcion;
	
	
		
	public MayooresGenerales () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.mayooresgeneralesOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.id_cuenta_contable=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.nombre_sucursal="";
 		this.codigo="";
 		this.beneficiario="";
 		this.detalle="";
 		this.fecha_emision=new Date();
 		this.codigo_tipo_movimiento="";
 		this.numero_mayor="";
 		this.nombre_cuenta_contable="";
 		this.debito_local=0.0;
 		this.credito_local=0.0;
 		this.detalle_detalle_asiento_contable="";
 		this.codigo_cuenta_contable="";
 		this.saldo=0.0;
		
		
		this.empresa=null;
		this.ejercicio=null;
		this.cuentacontable=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public MayooresGenerales (Long id,Date versionRow,String nombre_sucursal,String codigo,String beneficiario,String detalle,Date fecha_emision,String codigo_tipo_movimiento,String numero_mayor,String nombre_cuenta_contable,Double debito_local,Double credito_local,String detalle_detalle_asiento_contable,String codigo_cuenta_contable,Double saldo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.mayooresgeneralesOriginal=this;
		
 		this.nombre_sucursal=nombre_sucursal;
 		this.codigo=codigo;
 		this.beneficiario=beneficiario;
 		this.detalle=detalle;
 		this.fecha_emision=fecha_emision;
 		this.codigo_tipo_movimiento=codigo_tipo_movimiento;
 		this.numero_mayor=numero_mayor;
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.detalle_detalle_asiento_contable=detalle_detalle_asiento_contable;
 		this.codigo_cuenta_contable=codigo_cuenta_contable;
 		this.saldo=saldo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public MayooresGenerales (String nombre_sucursal,String codigo,String beneficiario,String detalle,Date fecha_emision,String codigo_tipo_movimiento,String numero_mayor,String nombre_cuenta_contable,Double debito_local,Double credito_local,String detalle_detalle_asiento_contable,String codigo_cuenta_contable,Double saldo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.mayooresgeneralesOriginal=this;
		
 		this.nombre_sucursal=nombre_sucursal;
 		this.codigo=codigo;
 		this.beneficiario=beneficiario;
 		this.detalle=detalle;
 		this.fecha_emision=fecha_emision;
 		this.codigo_tipo_movimiento=codigo_tipo_movimiento;
 		this.numero_mayor=numero_mayor;
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.detalle_detalle_asiento_contable=detalle_detalle_asiento_contable;
 		this.codigo_cuenta_contable=codigo_cuenta_contable;
 		this.saldo=saldo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public MayooresGenerales getMayooresGeneralesOriginal() {
		return this.mayooresgeneralesOriginal;
	}
	
	public void setMayooresGeneralesOriginal(MayooresGenerales mayooresgenerales) {
		try {
			this.mayooresgeneralesOriginal=mayooresgenerales;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected MayooresGeneralesAdditional mayooresgeneralesAdditional=null;
	
	public MayooresGeneralesAdditional getMayooresGeneralesAdditional() {
		return this.mayooresgeneralesAdditional;
	}
	
	public void setMayooresGeneralesAdditional(MayooresGeneralesAdditional mayooresgeneralesAdditional) {
		try {
			this.mayooresgeneralesAdditional=mayooresgeneralesAdditional;
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
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getnombre_sucursal() {
		return this.nombre_sucursal;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getbeneficiario() {
		return this.beneficiario;
	}
    
	
	public String getdetalle() {
		return this.detalle;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getcodigo_tipo_movimiento() {
		return this.codigo_tipo_movimiento;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public String getnombre_cuenta_contable() {
		return this.nombre_cuenta_contable;
	}
    
	
	public Double getdebito_local() {
		return this.debito_local;
	}
    
	
	public Double getcredito_local() {
		return this.credito_local;
	}
    
	
	public String getdetalle_detalle_asiento_contable() {
		return this.detalle_detalle_asiento_contable;
	}
    
	
	public String getcodigo_cuenta_contable() {
		return this.codigo_cuenta_contable;
	}
    
	
	public Double getsaldo() {
		return this.saldo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna fecha_emision_desde");
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
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_sucursal(String newnombre_sucursal)throws Exception
	{
		try {
			if(this.nombre_sucursal!=newnombre_sucursal) {
				if(newnombre_sucursal==null) {
					//newnombre_sucursal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna nombre_sucursal");
					}
				}

				if(newnombre_sucursal!=null&&newnombre_sucursal.length()>150) {
					newnombre_sucursal=newnombre_sucursal.substring(0,148);
					System.out.println("MayooresGenerales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sucursal");
				}

				this.nombre_sucursal=newnombre_sucursal;
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
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("MayooresGenerales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>200) {
					newbeneficiario=newbeneficiario.substring(0,198);
					System.out.println("MayooresGenerales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna beneficiario");
				}

				this.beneficiario=newbeneficiario;
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
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna detalle");
					}
				}

				if(newdetalle!=null&&newdetalle.length()>250) {
					newdetalle=newdetalle.substring(0,248);
					System.out.println("MayooresGenerales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna detalle");
				}

				this.detalle=newdetalle;
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
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_tipo_movimiento(String newcodigo_tipo_movimiento)throws Exception
	{
		try {
			if(this.codigo_tipo_movimiento!=newcodigo_tipo_movimiento) {
				if(newcodigo_tipo_movimiento==null) {
					//newcodigo_tipo_movimiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna codigo_tipo_movimiento");
					}
				}

				if(newcodigo_tipo_movimiento!=null&&newcodigo_tipo_movimiento.length()>50) {
					newcodigo_tipo_movimiento=newcodigo_tipo_movimiento.substring(0,48);
					System.out.println("MayooresGenerales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_tipo_movimiento");
				}

				this.codigo_tipo_movimiento=newcodigo_tipo_movimiento;
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
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("MayooresGenerales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cuenta_contable(String newnombre_cuenta_contable)throws Exception
	{
		try {
			if(this.nombre_cuenta_contable!=newnombre_cuenta_contable) {
				if(newnombre_cuenta_contable==null) {
					//newnombre_cuenta_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna nombre_cuenta_contable");
					}
				}

				if(newnombre_cuenta_contable!=null&&newnombre_cuenta_contable.length()>150) {
					newnombre_cuenta_contable=newnombre_cuenta_contable.substring(0,148);
					System.out.println("MayooresGenerales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta_contable");
				}

				this.nombre_cuenta_contable=newnombre_cuenta_contable;
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
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna debito_local");
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
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna credito_local");
					}
				}

				this.credito_local=newcredito_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdetalle_detalle_asiento_contable(String newdetalle_detalle_asiento_contable)throws Exception
	{
		try {
			if(this.detalle_detalle_asiento_contable!=newdetalle_detalle_asiento_contable) {
				if(newdetalle_detalle_asiento_contable==null) {
					//newdetalle_detalle_asiento_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna detalle_detalle_asiento_contable");
					}
				}

				if(newdetalle_detalle_asiento_contable!=null&&newdetalle_detalle_asiento_contable.length()>250) {
					newdetalle_detalle_asiento_contable=newdetalle_detalle_asiento_contable.substring(0,248);
					System.out.println("MayooresGenerales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna detalle_detalle_asiento_contable");
				}

				this.detalle_detalle_asiento_contable=newdetalle_detalle_asiento_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cuenta_contable(String newcodigo_cuenta_contable)throws Exception
	{
		try {
			if(this.codigo_cuenta_contable!=newcodigo_cuenta_contable) {
				if(newcodigo_cuenta_contable==null) {
					//newcodigo_cuenta_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna codigo_cuenta_contable");
					}
				}

				if(newcodigo_cuenta_contable!=null&&newcodigo_cuenta_contable.length()>50) {
					newcodigo_cuenta_contable=newcodigo_cuenta_contable.substring(0,48);
					System.out.println("MayooresGenerales:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cuenta_contable");
				}

				this.codigo_cuenta_contable=newcodigo_cuenta_contable;
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
						System.out.println("MayooresGenerales:Valor nulo no permitido en columna saldo");
					}
				}

				this.saldo=newsaldo;
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

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
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


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
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


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";String id_cuenta_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
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
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";this.id_cuenta_contable_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

