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
//import com.bydan.erp.contabilidad.util.EstadosResultadosPerdidasGananciasConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class EstadosResultadosPerdidasGanancias extends EstadosResultadosPerdidasGananciasAdditional implements Serializable ,Cloneable {//EstadosResultadosPerdidasGananciasAdditional,GeneralEntity
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
	
	private EstadosResultadosPerdidasGanancias estadosresultadosperdidasgananciasOriginal;
	
	private Map<String, Object> mapEstadosResultadosPerdidasGanancias;
			
	public Map<String, Object> getMapEstadosResultadosPerdidasGanancias() {
		return mapEstadosResultadosPerdidasGanancias;
	}

	public void setMapEstadosResultadosPerdidasGanancias(Map<String, Object> mapEstadosResultadosPerdidasGanancias) {
		this.mapEstadosResultadosPerdidasGanancias = mapEstadosResultadosPerdidasGanancias;
	}
	
	public void inicializarMapEstadosResultadosPerdidasGanancias() {
		this.mapEstadosResultadosPerdidasGanancias = new HashMap<String,Object>();
	}
	
	public void setMapEstadosResultadosPerdidasGananciasValue(String sKey,Object oValue) {
		this.mapEstadosResultadosPerdidasGanancias.put(sKey, oValue);
	}
	
	public Object getMapEstadosResultadosPerdidasGananciasValue(String sKey) {
		return this.mapEstadosResultadosPerdidasGanancias.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_nivel_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=EstadosResultadosPerdidasGananciasConstantesFunciones.SREGEXCODIGO,message=EstadosResultadosPerdidasGananciasConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=EstadosResultadosPerdidasGananciasConstantesFunciones.SREGEXNOMBRE,message=EstadosResultadosPerdidasGananciasConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=EstadosResultadosPerdidasGananciasConstantesFunciones.SREGEXNOMBRE_NIVEL_CUENTA,message=EstadosResultadosPerdidasGananciasConstantesFunciones.SMENSAJEREGEXNOMBRE_NIVEL_CUENTA)
	private String nombre_nivel_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_inicial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_inicial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo_inicial;
			
	
	public Empresa empresa;
	public NivelCuenta nivelcuenta;
	public Ejercicio ejercicio;
	public Periodo periodo;
	
	
	private String empresa_descripcion;
	private String nivelcuenta_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	
	
		
	public EstadosResultadosPerdidasGanancias () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.estadosresultadosperdidasgananciasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_nivel_cuenta=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.nombre_nivel_cuenta="";
 		this.debito_inicial=0.0;
 		this.credito_inicial=0.0;
 		this.saldo_inicial=0.0;
		
		
		this.empresa=null;
		this.nivelcuenta=null;
		this.ejercicio=null;
		this.periodo=null;
		
		
		this.empresa_descripcion="";
		this.nivelcuenta_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EstadosResultadosPerdidasGanancias (Long id,Date versionRow,String codigo,String nombre,String nombre_nivel_cuenta,Double debito_inicial,Double credito_inicial,Double saldo_inicial) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadosresultadosperdidasgananciasOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_nivel_cuenta=nombre_nivel_cuenta;
 		this.debito_inicial=debito_inicial;
 		this.credito_inicial=credito_inicial;
 		this.saldo_inicial=saldo_inicial;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EstadosResultadosPerdidasGanancias (String codigo,String nombre,String nombre_nivel_cuenta,Double debito_inicial,Double credito_inicial,Double saldo_inicial) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadosresultadosperdidasgananciasOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_nivel_cuenta=nombre_nivel_cuenta;
 		this.debito_inicial=debito_inicial;
 		this.credito_inicial=credito_inicial;
 		this.saldo_inicial=saldo_inicial;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public EstadosResultadosPerdidasGanancias getEstadosResultadosPerdidasGananciasOriginal() {
		return this.estadosresultadosperdidasgananciasOriginal;
	}
	
	public void setEstadosResultadosPerdidasGananciasOriginal(EstadosResultadosPerdidasGanancias estadosresultadosperdidasganancias) {
		try {
			this.estadosresultadosperdidasgananciasOriginal=estadosresultadosperdidasganancias;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EstadosResultadosPerdidasGananciasAdditional estadosresultadosperdidasgananciasAdditional=null;
	
	public EstadosResultadosPerdidasGananciasAdditional getEstadosResultadosPerdidasGananciasAdditional() {
		return this.estadosresultadosperdidasgananciasAdditional;
	}
	
	public void setEstadosResultadosPerdidasGananciasAdditional(EstadosResultadosPerdidasGananciasAdditional estadosresultadosperdidasgananciasAdditional) {
		try {
			this.estadosresultadosperdidasgananciasAdditional=estadosresultadosperdidasgananciasAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_nivel_cuenta() {
		return this.id_nivel_cuenta;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getnombre_nivel_cuenta() {
		return this.nombre_nivel_cuenta;
	}
    
	
	public Double getdebito_inicial() {
		return this.debito_inicial;
	}
    
	
	public Double getcredito_inicial() {
		return this.credito_inicial;
	}
    
	
	public Double getsaldo_inicial() {
		return this.saldo_inicial;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosResultadosPerdidasGanancias:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_nivel_cuenta(Long newid_nivel_cuenta)throws Exception
	{
		try {
			if(this.id_nivel_cuenta!=newid_nivel_cuenta) {
				if(newid_nivel_cuenta==null) {
					//newid_nivel_cuenta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosResultadosPerdidasGanancias:Valor nulo no permitido en columna id_nivel_cuenta");
					}
				}

				this.id_nivel_cuenta=newid_nivel_cuenta;
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
						System.out.println("EstadosResultadosPerdidasGanancias:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosResultadosPerdidasGanancias:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
						System.out.println("EstadosResultadosPerdidasGanancias:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("EstadosResultadosPerdidasGanancias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("EstadosResultadosPerdidasGanancias:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("EstadosResultadosPerdidasGanancias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_nivel_cuenta(String newnombre_nivel_cuenta)throws Exception
	{
		try {
			if(this.nombre_nivel_cuenta!=newnombre_nivel_cuenta) {
				if(newnombre_nivel_cuenta==null) {
					//newnombre_nivel_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosResultadosPerdidasGanancias:Valor nulo no permitido en columna nombre_nivel_cuenta");
					}
				}

				if(newnombre_nivel_cuenta!=null&&newnombre_nivel_cuenta.length()>150) {
					newnombre_nivel_cuenta=newnombre_nivel_cuenta.substring(0,148);
					System.out.println("EstadosResultadosPerdidasGanancias:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_nivel_cuenta");
				}

				this.nombre_nivel_cuenta=newnombre_nivel_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_inicial(Double newdebito_inicial)throws Exception
	{
		try {
			if(this.debito_inicial!=newdebito_inicial) {
				if(newdebito_inicial==null) {
					//newdebito_inicial=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosResultadosPerdidasGanancias:Valor nulo no permitido en columna debito_inicial");
					}
				}

				this.debito_inicial=newdebito_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_inicial(Double newcredito_inicial)throws Exception
	{
		try {
			if(this.credito_inicial!=newcredito_inicial) {
				if(newcredito_inicial==null) {
					//newcredito_inicial=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosResultadosPerdidasGanancias:Valor nulo no permitido en columna credito_inicial");
					}
				}

				this.credito_inicial=newcredito_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo_inicial(Double newsaldo_inicial)throws Exception
	{
		try {
			if(this.saldo_inicial!=newsaldo_inicial) {
				if(newsaldo_inicial==null) {
					//newsaldo_inicial=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosResultadosPerdidasGanancias:Valor nulo no permitido en columna saldo_inicial");
					}
				}

				this.saldo_inicial=newsaldo_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public NivelCuenta getNivelCuenta() {
		return this.nivelcuenta;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getnivelcuenta_descripcion() {
		return this.nivelcuenta_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setNivelCuenta(NivelCuenta nivelcuenta) {
		try {
			this.nivelcuenta=nivelcuenta;
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


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
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


	public  void  setnivelcuenta_descripcion(String nivelcuenta_descripcion) {
		try {
			this.nivelcuenta_descripcion=nivelcuenta_descripcion;
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


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_nivel_cuenta_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_nivel_cuenta_descripcion() {
		return id_nivel_cuenta_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_nivel_cuenta_descripcion(String newid_nivel_cuenta_descripcion)throws Exception {
		try {
			this.id_nivel_cuenta_descripcion=newid_nivel_cuenta_descripcion;
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
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_nivel_cuenta_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

