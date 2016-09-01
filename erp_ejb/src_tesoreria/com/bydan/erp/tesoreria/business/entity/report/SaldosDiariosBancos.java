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
//import com.bydan.erp.tesoreria.util.SaldosDiariosBancosConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class SaldosDiariosBancos extends SaldosDiariosBancosAdditional implements Serializable ,Cloneable {//SaldosDiariosBancosAdditional,GeneralEntity
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
	
	private SaldosDiariosBancos saldosdiariosbancosOriginal;
	
	private Map<String, Object> mapSaldosDiariosBancos;
			
	public Map<String, Object> getMapSaldosDiariosBancos() {
		return mapSaldosDiariosBancos;
	}

	public void setMapSaldosDiariosBancos(Map<String, Object> mapSaldosDiariosBancos) {
		this.mapSaldosDiariosBancos = mapSaldosDiariosBancos;
	}
	
	public void inicializarMapSaldosDiariosBancos() {
		this.mapSaldosDiariosBancos = new HashMap<String,Object>();
	}
	
	public void setMapSaldosDiariosBancosValue(String sKey,Object oValue) {
		this.mapSaldosDiariosBancos.put(sKey, oValue);
	}
	
	public Object getMapSaldosDiariosBancosValue(String sKey) {
		return this.mapSaldosDiariosBancos.get(sKey);
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
	private Date fecha_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SaldosDiariosBancosConstantesFunciones.SREGEXCODIGO_CUENTA,message=SaldosDiariosBancosConstantesFunciones.SMENSAJEREGEXCODIGO_CUENTA)
	private String codigo_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SaldosDiariosBancosConstantesFunciones.SREGEXNOMBRE_BANCO,message=SaldosDiariosBancosConstantesFunciones.SMENSAJEREGEXNOMBRE_BANCO)
	private String nombre_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SaldosDiariosBancosConstantesFunciones.SREGEXNUMERO_CUENTA,message=SaldosDiariosBancosConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SaldosDiariosBancosConstantesFunciones.SREGEXNOMBRE_MONEDA,message=SaldosDiariosBancosConstantesFunciones.SMENSAJEREGEXNOMBRE_MONEDA)
	private String nombre_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo_anterior;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double deposito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double nc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ch_girados;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double nd;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SaldosDiariosBancosConstantesFunciones.SREGEXPROCEDENCIA,message=SaldosDiariosBancosConstantesFunciones.SMENSAJEREGEXPROCEDENCIA)
	private String procedencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SaldosDiariosBancosConstantesFunciones.SREGEXDESTINO,message=SaldosDiariosBancosConstantesFunciones.SMENSAJEREGEXDESTINO)
	private String destino;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	
	
		
	public SaldosDiariosBancos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.saldosdiariosbancosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.codigo_cuenta="";
 		this.nombre_banco="";
 		this.numero_cuenta="";
 		this.nombre_moneda="";
 		this.saldo_anterior=0.0;
 		this.deposito=0.0;
 		this.nc=0.0;
 		this.ch_girados=0.0;
 		this.nd=0.0;
 		this.procedencia="";
 		this.destino="";
		
		
		this.empresa=null;
		this.ejercicio=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public SaldosDiariosBancos (Long id,Date versionRow,String codigo_cuenta,String nombre_banco,String numero_cuenta,String nombre_moneda,Double saldo_anterior,Double deposito,Double nc,Double ch_girados,Double nd,String procedencia,String destino) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.saldosdiariosbancosOriginal=this;
		
 		this.codigo_cuenta=codigo_cuenta;
 		this.nombre_banco=nombre_banco;
 		this.numero_cuenta=numero_cuenta;
 		this.nombre_moneda=nombre_moneda;
 		this.saldo_anterior=saldo_anterior;
 		this.deposito=deposito;
 		this.nc=nc;
 		this.ch_girados=ch_girados;
 		this.nd=nd;
 		this.procedencia=procedencia;
 		this.destino=destino;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public SaldosDiariosBancos (String codigo_cuenta,String nombre_banco,String numero_cuenta,String nombre_moneda,Double saldo_anterior,Double deposito,Double nc,Double ch_girados,Double nd,String procedencia,String destino) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.saldosdiariosbancosOriginal=this;
		
 		this.codigo_cuenta=codigo_cuenta;
 		this.nombre_banco=nombre_banco;
 		this.numero_cuenta=numero_cuenta;
 		this.nombre_moneda=nombre_moneda;
 		this.saldo_anterior=saldo_anterior;
 		this.deposito=deposito;
 		this.nc=nc;
 		this.ch_girados=ch_girados;
 		this.nd=nd;
 		this.procedencia=procedencia;
 		this.destino=destino;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public SaldosDiariosBancos getSaldosDiariosBancosOriginal() {
		return this.saldosdiariosbancosOriginal;
	}
	
	public void setSaldosDiariosBancosOriginal(SaldosDiariosBancos saldosdiariosbancos) {
		try {
			this.saldosdiariosbancosOriginal=saldosdiariosbancos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected SaldosDiariosBancosAdditional saldosdiariosbancosAdditional=null;
	
	public SaldosDiariosBancosAdditional getSaldosDiariosBancosAdditional() {
		return this.saldosdiariosbancosAdditional;
	}
	
	public void setSaldosDiariosBancosAdditional(SaldosDiariosBancosAdditional saldosdiariosbancosAdditional) {
		try {
			this.saldosdiariosbancosAdditional=saldosdiariosbancosAdditional;
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
    
	
	public Date getfecha_desde() {
		return this.fecha_desde;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public String getcodigo_cuenta() {
		return this.codigo_cuenta;
	}
    
	
	public String getnombre_banco() {
		return this.nombre_banco;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public String getnombre_moneda() {
		return this.nombre_moneda;
	}
    
	
	public Double getsaldo_anterior() {
		return this.saldo_anterior;
	}
    
	
	public Double getdeposito() {
		return this.deposito;
	}
    
	
	public Double getnc() {
		return this.nc;
	}
    
	
	public Double getch_girados() {
		return this.ch_girados;
	}
    
	
	public Double getnd() {
		return this.nd;
	}
    
	
	public String getprocedencia() {
		return this.procedencia;
	}
    
	
	public String getdestino() {
		return this.destino;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
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
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna fecha_desde");
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
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
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
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna codigo_cuenta");
					}
				}

				if(newcodigo_cuenta!=null&&newcodigo_cuenta.length()>50) {
					newcodigo_cuenta=newcodigo_cuenta.substring(0,48);
					System.out.println("SaldosDiariosBancos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cuenta");
				}

				this.codigo_cuenta=newcodigo_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_banco(String newnombre_banco)throws Exception
	{
		try {
			if(this.nombre_banco!=newnombre_banco) {
				if(newnombre_banco==null) {
					//newnombre_banco="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna nombre_banco");
					}
				}

				if(newnombre_banco!=null&&newnombre_banco.length()>150) {
					newnombre_banco=newnombre_banco.substring(0,148);
					System.out.println("SaldosDiariosBancos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_banco");
				}

				this.nombre_banco=newnombre_banco;
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
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>50) {
					newnumero_cuenta=newnumero_cuenta.substring(0,48);
					System.out.println("SaldosDiariosBancos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_moneda(String newnombre_moneda)throws Exception
	{
		try {
			if(this.nombre_moneda!=newnombre_moneda) {
				if(newnombre_moneda==null) {
					//newnombre_moneda="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna nombre_moneda");
					}
				}

				if(newnombre_moneda!=null&&newnombre_moneda.length()>50) {
					newnombre_moneda=newnombre_moneda.substring(0,48);
					System.out.println("SaldosDiariosBancos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_moneda");
				}

				this.nombre_moneda=newnombre_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo_anterior(Double newsaldo_anterior)throws Exception
	{
		try {
			if(this.saldo_anterior!=newsaldo_anterior) {
				if(newsaldo_anterior==null) {
					//newsaldo_anterior=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna saldo_anterior");
					}
				}

				this.saldo_anterior=newsaldo_anterior;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdeposito(Double newdeposito)throws Exception
	{
		try {
			if(this.deposito!=newdeposito) {
				if(newdeposito==null) {
					//newdeposito=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna deposito");
					}
				}

				this.deposito=newdeposito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnc(Double newnc)throws Exception
	{
		try {
			if(this.nc!=newnc) {
				if(newnc==null) {
					//newnc=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna nc");
					}
				}

				this.nc=newnc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setch_girados(Double newch_girados)throws Exception
	{
		try {
			if(this.ch_girados!=newch_girados) {
				if(newch_girados==null) {
					//newch_girados=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna ch_girados");
					}
				}

				this.ch_girados=newch_girados;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnd(Double newnd)throws Exception
	{
		try {
			if(this.nd!=newnd) {
				if(newnd==null) {
					//newnd=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna nd");
					}
				}

				this.nd=newnd;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprocedencia(String newprocedencia)throws Exception
	{
		try {
			if(this.procedencia!=newprocedencia) {
				if(newprocedencia==null) {
					//newprocedencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna procedencia");
					}
				}

				if(newprocedencia!=null&&newprocedencia.length()>100) {
					newprocedencia=newprocedencia.substring(0,98);
					System.out.println("SaldosDiariosBancos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna procedencia");
				}

				this.procedencia=newprocedencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdestino(String newdestino)throws Exception
	{
		try {
			if(this.destino!=newdestino) {
				if(newdestino==null) {
					//newdestino="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SaldosDiariosBancos:Valor nulo no permitido en columna destino");
					}
				}

				if(newdestino!=null&&newdestino.length()>100) {
					newdestino=newdestino.substring(0,98);
					System.out.println("SaldosDiariosBancos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna destino");
				}

				this.destino=newdestino;
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

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

