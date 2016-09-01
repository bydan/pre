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
//import com.bydan.erp.tesoreria.util.HistorialConciliacionesBancariasConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class HistorialConciliacionesBancarias extends HistorialConciliacionesBancariasAdditional implements Serializable ,Cloneable {//HistorialConciliacionesBancariasAdditional,GeneralEntity
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
	
	private HistorialConciliacionesBancarias historialconciliacionesbancariasOriginal;
	
	private Map<String, Object> mapHistorialConciliacionesBancarias;
			
	public Map<String, Object> getMapHistorialConciliacionesBancarias() {
		return mapHistorialConciliacionesBancarias;
	}

	public void setMapHistorialConciliacionesBancarias(Map<String, Object> mapHistorialConciliacionesBancarias) {
		this.mapHistorialConciliacionesBancarias = mapHistorialConciliacionesBancarias;
	}
	
	public void inicializarMapHistorialConciliacionesBancarias() {
		this.mapHistorialConciliacionesBancarias = new HashMap<String,Object>();
	}
	
	public void setMapHistorialConciliacionesBancariasValue(String sKey,Object oValue) {
		this.mapHistorialConciliacionesBancarias.put(sKey, oValue);
	}
	
	public Object getMapHistorialConciliacionesBancariasValue(String sKey) {
		return this.mapHistorialConciliacionesBancarias.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialConciliacionesBancariasConstantesFunciones.SREGEXNUMERO_CHEQUE,message=HistorialConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialConciliacionesBancariasConstantesFunciones.SREGEXCODIGO,message=HistorialConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialConciliacionesBancariasConstantesFunciones.SREGEXBENEFICIARIO,message=HistorialConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialConciliacionesBancariasConstantesFunciones.SREGEXDETALLE,message=HistorialConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXDETALLE)
	private String detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialConciliacionesBancariasConstantesFunciones.SREGEXCUENTA,message=HistorialConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXCUENTA)
	private String cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialConciliacionesBancariasConstantesFunciones.SREGEXTIPO_DOCUMENTO,message=HistorialConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXTIPO_DOCUMENTO)
	private String tipo_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialConciliacionesBancariasConstantesFunciones.SREGEXNUMERO_MAYOR,message=HistorialConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_finalizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialConciliacionesBancariasConstantesFunciones.SREGEXTIPO_MOVIMIENTO,message=HistorialConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXTIPO_MOVIMIENTO)
	private String tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo_libros;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialConciliacionesBancariasConstantesFunciones.SREGEXNUMERO_CUENTA,message=HistorialConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=HistorialConciliacionesBancariasConstantesFunciones.SREGEXNOMBRE_CUENTA_CONTABLE,message=HistorialConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE)
	private String nombre_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double anterior;
			
	
	public Empresa empresa;
	public CuentaContable cuentacontable;
	
	
	private String empresa_descripcion;
	private String cuentacontable_descripcion;
	
	
		
	public HistorialConciliacionesBancarias () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.historialconciliacionesbancariasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cuenta_contable=-1L;
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.debito_local=0.0;
 		this.credito_local=0.0;
 		this.numero_cheque="";
 		this.codigo="";
 		this.beneficiario="";
 		this.detalle="";
 		this.cuenta="";
 		this.tipo_documento="";
 		this.numero_mayor="";
 		this.fecha_finalizacion=new Date();
 		this.tipo_movimiento="";
 		this.saldo_libros=0.0;
 		this.fecha=new Date();
 		this.numero_cuenta="";
 		this.nombre_cuenta_contable="";
 		this.anterior=0.0;
		
		
		this.empresa=null;
		this.cuentacontable=null;
		
		
		this.empresa_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public HistorialConciliacionesBancarias (Long id,Date versionRow,Double debito_local,Double credito_local,String numero_cheque,String codigo,String beneficiario,String detalle,String cuenta,String tipo_documento,String numero_mayor,Date fecha_finalizacion,String tipo_movimiento,Double saldo_libros,Date fecha,String numero_cuenta,String nombre_cuenta_contable,Double anterior) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.historialconciliacionesbancariasOriginal=this;
		
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.numero_cheque=numero_cheque;
 		this.codigo=codigo;
 		this.beneficiario=beneficiario;
 		this.detalle=detalle;
 		this.cuenta=cuenta;
 		this.tipo_documento=tipo_documento;
 		this.numero_mayor=numero_mayor;
 		this.fecha_finalizacion=fecha_finalizacion;
 		this.tipo_movimiento=tipo_movimiento;
 		this.saldo_libros=saldo_libros;
 		this.fecha=fecha;
 		this.numero_cuenta=numero_cuenta;
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.anterior=anterior;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public HistorialConciliacionesBancarias (Double debito_local,Double credito_local,String numero_cheque,String codigo,String beneficiario,String detalle,String cuenta,String tipo_documento,String numero_mayor,Date fecha_finalizacion,String tipo_movimiento,Double saldo_libros,Date fecha,String numero_cuenta,String nombre_cuenta_contable,Double anterior) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.historialconciliacionesbancariasOriginal=this;
		
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.numero_cheque=numero_cheque;
 		this.codigo=codigo;
 		this.beneficiario=beneficiario;
 		this.detalle=detalle;
 		this.cuenta=cuenta;
 		this.tipo_documento=tipo_documento;
 		this.numero_mayor=numero_mayor;
 		this.fecha_finalizacion=fecha_finalizacion;
 		this.tipo_movimiento=tipo_movimiento;
 		this.saldo_libros=saldo_libros;
 		this.fecha=fecha;
 		this.numero_cuenta=numero_cuenta;
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.anterior=anterior;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public HistorialConciliacionesBancarias getHistorialConciliacionesBancariasOriginal() {
		return this.historialconciliacionesbancariasOriginal;
	}
	
	public void setHistorialConciliacionesBancariasOriginal(HistorialConciliacionesBancarias historialconciliacionesbancarias) {
		try {
			this.historialconciliacionesbancariasOriginal=historialconciliacionesbancarias;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected HistorialConciliacionesBancariasAdditional historialconciliacionesbancariasAdditional=null;
	
	public HistorialConciliacionesBancariasAdditional getHistorialConciliacionesBancariasAdditional() {
		return this.historialconciliacionesbancariasAdditional;
	}
	
	public void setHistorialConciliacionesBancariasAdditional(HistorialConciliacionesBancariasAdditional historialconciliacionesbancariasAdditional) {
		try {
			this.historialconciliacionesbancariasAdditional=historialconciliacionesbancariasAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Date getfecha_desde() {
		return this.fecha_desde;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public Double getdebito_local() {
		return this.debito_local;
	}
    
	
	public Double getcredito_local() {
		return this.credito_local;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
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
    
	
	public String getcuenta() {
		return this.cuenta;
	}
    
	
	public String gettipo_documento() {
		return this.tipo_documento;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public Date getfecha_finalizacion() {
		return this.fecha_finalizacion;
	}
    
	
	public String gettipo_movimiento() {
		return this.tipo_movimiento;
	}
    
	
	public Double getsaldo_libros() {
		return this.saldo_libros;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public String getnombre_cuenta_contable() {
		return this.nombre_cuenta_contable;
	}
    
	
	public Double getanterior() {
		return this.anterior;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna fecha_desde");
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna debito_local");
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna credito_local");
					}
				}

				this.credito_local=newcredito_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cheque(String newnumero_cheque)throws Exception
	{
		try {
			if(this.numero_cheque!=newnumero_cheque) {
				if(newnumero_cheque==null) {
					//newnumero_cheque="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("HistorialConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("HistorialConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>100) {
					newbeneficiario=newbeneficiario.substring(0,98);
					System.out.println("HistorialConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna beneficiario");
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna detalle");
					}
				}

				if(newdetalle!=null&&newdetalle.length()>250) {
					newdetalle=newdetalle.substring(0,248);
					System.out.println("HistorialConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna detalle");
				}

				this.detalle=newdetalle;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcuenta(String newcuenta)throws Exception
	{
		try {
			if(this.cuenta!=newcuenta) {
				if(newcuenta==null) {
					//newcuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna cuenta");
					}
				}

				if(newcuenta!=null&&newcuenta.length()>50) {
					newcuenta=newcuenta.substring(0,48);
					System.out.println("HistorialConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna cuenta");
				}

				this.cuenta=newcuenta;
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna tipo_documento");
					}
				}

				if(newtipo_documento!=null&&newtipo_documento.length()>100) {
					newtipo_documento=newtipo_documento.substring(0,98);
					System.out.println("HistorialConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna tipo_documento");
				}

				this.tipo_documento=newtipo_documento;
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("HistorialConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_finalizacion(Date newfecha_finalizacion)throws Exception
	{
		try {
			if(this.fecha_finalizacion!=newfecha_finalizacion) {
				if(newfecha_finalizacion==null) {
					//newfecha_finalizacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna fecha_finalizacion");
					}
				}

				this.fecha_finalizacion=newfecha_finalizacion;
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna tipo_movimiento");
					}
				}

				if(newtipo_movimiento!=null&&newtipo_movimiento.length()>100) {
					newtipo_movimiento=newtipo_movimiento.substring(0,98);
					System.out.println("HistorialConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna tipo_movimiento");
				}

				this.tipo_movimiento=newtipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo_libros(Double newsaldo_libros)throws Exception
	{
		try {
			if(this.saldo_libros!=newsaldo_libros) {
				if(newsaldo_libros==null) {
					//newsaldo_libros=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna saldo_libros");
					}
				}

				this.saldo_libros=newsaldo_libros;
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuenta(String newnumero_cuenta)throws Exception
	{
		try {
			if(this.numero_cuenta!=newnumero_cuenta) {
				if(newnumero_cuenta==null) {
					//newnumero_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>50) {
					newnumero_cuenta=newnumero_cuenta.substring(0,48);
					System.out.println("HistorialConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
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
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna nombre_cuenta_contable");
					}
				}

				if(newnombre_cuenta_contable!=null&&newnombre_cuenta_contable.length()>150) {
					newnombre_cuenta_contable=newnombre_cuenta_contable.substring(0,148);
					System.out.println("HistorialConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta_contable");
				}

				this.nombre_cuenta_contable=newnombre_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanterior(Double newanterior)throws Exception
	{
		try {
			if(this.anterior!=newanterior) {
				if(newanterior==null) {
					//newanterior=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialConciliacionesBancarias:Valor nulo no permitido en columna anterior");
					}
				}

				this.anterior=newanterior;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
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


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cuenta_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
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
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cuenta_contable_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

