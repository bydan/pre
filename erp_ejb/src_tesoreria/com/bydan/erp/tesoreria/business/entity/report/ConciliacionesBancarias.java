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
//import com.bydan.erp.tesoreria.util.ConciliacionesBancariasConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ConciliacionesBancarias extends ConciliacionesBancariasAdditional implements Serializable ,Cloneable {//ConciliacionesBancariasAdditional,GeneralEntity
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
	
	private ConciliacionesBancarias conciliacionesbancariasOriginal;
	
	private Map<String, Object> mapConciliacionesBancarias;
			
	public Map<String, Object> getMapConciliacionesBancarias() {
		return mapConciliacionesBancarias;
	}

	public void setMapConciliacionesBancarias(Map<String, Object> mapConciliacionesBancarias) {
		this.mapConciliacionesBancarias = mapConciliacionesBancarias;
	}
	
	public void inicializarMapConciliacionesBancarias() {
		this.mapConciliacionesBancarias = new HashMap<String,Object>();
	}
	
	public void setMapConciliacionesBancariasValue(String sKey,Object oValue) {
		this.mapConciliacionesBancarias.put(sKey, oValue);
	}
	
	public Object getMapConciliacionesBancariasValue(String sKey) {
		return this.mapConciliacionesBancarias.get(sKey);
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
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConciliacionesBancariasConstantesFunciones.SREGEXNUMERO_MAYOR,message=ConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConciliacionesBancariasConstantesFunciones.SREGEXCODIGO_CUENTA,message=ConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXCODIGO_CUENTA)
	private String codigo_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConciliacionesBancariasConstantesFunciones.SREGEXNOMBRE_CUENTA,message=ConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA)
	private String nombre_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConciliacionesBancariasConstantesFunciones.SREGEXNUMERO_DEPOSITO,message=ConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXNUMERO_DEPOSITO)
	private String numero_deposito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_extran;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_extran;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConciliacionesBancariasConstantesFunciones.SREGEXDETALLE,message=ConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXDETALLE)
	private String detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConciliacionesBancariasConstantesFunciones.SREGEXBENEFICIARIO,message=ConciliacionesBancariasConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
			
	
	public Empresa empresa;
	public CuentaContable cuentacontable;
	
	
	private String empresa_descripcion;
	private String cuentacontable_descripcion;
	
	
		
	public ConciliacionesBancarias () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.conciliacionesbancariasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cuenta_contable=-1L;
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.numero_mayor="";
 		this.codigo_cuenta="";
 		this.nombre_cuenta="";
 		this.debito_local=0.0;
 		this.credito_local=0.0;
 		this.numero_deposito="";
 		this.debito_extran=0.0;
 		this.credito_extran=0.0;
 		this.fecha=new Date();
 		this.detalle="";
 		this.beneficiario="";
		
		
		this.empresa=null;
		this.cuentacontable=null;
		
		
		this.empresa_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ConciliacionesBancarias (Long id,Date versionRow,String numero_mayor,String codigo_cuenta,String nombre_cuenta,Double debito_local,Double credito_local,String numero_deposito,Double debito_extran,Double credito_extran,Date fecha,String detalle,String beneficiario) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.conciliacionesbancariasOriginal=this;
		
 		this.numero_mayor=numero_mayor;
 		this.codigo_cuenta=codigo_cuenta;
 		this.nombre_cuenta=nombre_cuenta;
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.numero_deposito=numero_deposito;
 		this.debito_extran=debito_extran;
 		this.credito_extran=credito_extran;
 		this.fecha=fecha;
 		this.detalle=detalle;
 		this.beneficiario=beneficiario;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ConciliacionesBancarias (String numero_mayor,String codigo_cuenta,String nombre_cuenta,Double debito_local,Double credito_local,String numero_deposito,Double debito_extran,Double credito_extran,Date fecha,String detalle,String beneficiario) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.conciliacionesbancariasOriginal=this;
		
 		this.numero_mayor=numero_mayor;
 		this.codigo_cuenta=codigo_cuenta;
 		this.nombre_cuenta=nombre_cuenta;
 		this.debito_local=debito_local;
 		this.credito_local=credito_local;
 		this.numero_deposito=numero_deposito;
 		this.debito_extran=debito_extran;
 		this.credito_extran=credito_extran;
 		this.fecha=fecha;
 		this.detalle=detalle;
 		this.beneficiario=beneficiario;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ConciliacionesBancarias getConciliacionesBancariasOriginal() {
		return this.conciliacionesbancariasOriginal;
	}
	
	public void setConciliacionesBancariasOriginal(ConciliacionesBancarias conciliacionesbancarias) {
		try {
			this.conciliacionesbancariasOriginal=conciliacionesbancarias;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ConciliacionesBancariasAdditional conciliacionesbancariasAdditional=null;
	
	public ConciliacionesBancariasAdditional getConciliacionesBancariasAdditional() {
		return this.conciliacionesbancariasAdditional;
	}
	
	public void setConciliacionesBancariasAdditional(ConciliacionesBancariasAdditional conciliacionesbancariasAdditional) {
		try {
			this.conciliacionesbancariasAdditional=conciliacionesbancariasAdditional;
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
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public String getcodigo_cuenta() {
		return this.codigo_cuenta;
	}
    
	
	public String getnombre_cuenta() {
		return this.nombre_cuenta;
	}
    
	
	public Double getdebito_local() {
		return this.debito_local;
	}
    
	
	public Double getcredito_local() {
		return this.credito_local;
	}
    
	
	public String getnumero_deposito() {
		return this.numero_deposito;
	}
    
	
	public Double getdebito_extran() {
		return this.debito_extran;
	}
    
	
	public Double getcredito_extran() {
		return this.credito_extran;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getdetalle() {
		return this.detalle;
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna id_cuenta_contable");
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna fecha_desde");
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("ConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna codigo_cuenta");
					}
				}

				if(newcodigo_cuenta!=null&&newcodigo_cuenta.length()>50) {
					newcodigo_cuenta=newcodigo_cuenta.substring(0,48);
					System.out.println("ConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cuenta");
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna nombre_cuenta");
					}
				}

				if(newnombre_cuenta!=null&&newnombre_cuenta.length()>150) {
					newnombre_cuenta=newnombre_cuenta.substring(0,148);
					System.out.println("ConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta");
				}

				this.nombre_cuenta=newnombre_cuenta;
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna debito_local");
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna credito_local");
					}
				}

				this.credito_local=newcredito_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_deposito(String newnumero_deposito)throws Exception
	{
		try {
			if(this.numero_deposito!=newnumero_deposito) {
				if(newnumero_deposito==null) {
					//newnumero_deposito="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna numero_deposito");
					}
				}

				if(newnumero_deposito!=null&&newnumero_deposito.length()>50) {
					newnumero_deposito=newnumero_deposito.substring(0,48);
					System.out.println("ConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_deposito");
				}

				this.numero_deposito=newnumero_deposito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_extran(Double newdebito_extran)throws Exception
	{
		try {
			if(this.debito_extran!=newdebito_extran) {
				if(newdebito_extran==null) {
					//newdebito_extran=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna debito_extran");
					}
				}

				this.debito_extran=newdebito_extran;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_extran(Double newcredito_extran)throws Exception
	{
		try {
			if(this.credito_extran!=newcredito_extran) {
				if(newcredito_extran==null) {
					//newcredito_extran=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna credito_extran");
					}
				}

				this.credito_extran=newcredito_extran;
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna detalle");
					}
				}

				if(newdetalle!=null&&newdetalle.length()>250) {
					newdetalle=newdetalle.substring(0,248);
					System.out.println("ConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna detalle");
				}

				this.detalle=newdetalle;
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
						System.out.println("ConciliacionesBancarias:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>200) {
					newbeneficiario=newbeneficiario.substring(0,198);
					System.out.println("ConciliacionesBancarias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna beneficiario");
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

