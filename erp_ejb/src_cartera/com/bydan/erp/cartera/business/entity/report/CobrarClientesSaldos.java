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
//import com.bydan.erp.cartera.util.CobrarClientesSaldosConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class CobrarClientesSaldos extends CobrarClientesSaldosAdditional implements Serializable ,Cloneable {//CobrarClientesSaldosAdditional,GeneralEntity
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
	
	private CobrarClientesSaldos cobrarclientessaldosOriginal;
	
	private Map<String, Object> mapCobrarClientesSaldos;
			
	public Map<String, Object> getMapCobrarClientesSaldos() {
		return mapCobrarClientesSaldos;
	}

	public void setMapCobrarClientesSaldos(Map<String, Object> mapCobrarClientesSaldos) {
		this.mapCobrarClientesSaldos = mapCobrarClientesSaldos;
	}
	
	public void inicializarMapCobrarClientesSaldos() {
		this.mapCobrarClientesSaldos = new HashMap<String,Object>();
	}
	
	public void setMapCobrarClientesSaldosValue(String sKey,Object oValue) {
		this.mapCobrarClientesSaldos.put(sKey, oValue);
	}
	
	public Object getMapCobrarClientesSaldosValue(String sKey) {
		return this.mapCobrarClientesSaldos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSaldosConstantesFunciones.SREGEXCODIGO,message=CobrarClientesSaldosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSaldosConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=CobrarClientesSaldosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSaldosConstantesFunciones.SREGEXNOMBRE_COMERCIAL,message=CobrarClientesSaldosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMERCIAL)
	private String nombre_comercial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesSaldosConstantesFunciones.SREGEXNOMBRE_GARANTIA,message=CobrarClientesSaldosConstantesFunciones.SMENSAJEREGEXNOMBRE_GARANTIA)
	private String nombre_garantia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double limite_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_pedidos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_saldos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_cheques;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	
	
		
	public CobrarClientesSaldos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobrarclientessaldosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.fecha_emision_hasta=new Date();
 		this.codigo="";
 		this.nombre_completo="";
 		this.nombre_comercial="";
 		this.nombre_garantia="";
 		this.limite_credito=0.0;
 		this.total_pedidos=0.0;
 		this.total_saldos=0.0;
 		this.total_cheques=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CobrarClientesSaldos (Long id,Date versionRow,String codigo,String nombre_completo,String nombre_comercial,String nombre_garantia,Double limite_credito,Double total_pedidos,Double total_saldos,Double total_cheques) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarclientessaldosOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre_completo=nombre_completo;
 		this.nombre_comercial=nombre_comercial;
 		this.nombre_garantia=nombre_garantia;
 		this.limite_credito=limite_credito;
 		this.total_pedidos=total_pedidos;
 		this.total_saldos=total_saldos;
 		this.total_cheques=total_cheques;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CobrarClientesSaldos (String codigo,String nombre_completo,String nombre_comercial,String nombre_garantia,Double limite_credito,Double total_pedidos,Double total_saldos,Double total_cheques) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarclientessaldosOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre_completo=nombre_completo;
 		this.nombre_comercial=nombre_comercial;
 		this.nombre_garantia=nombre_garantia;
 		this.limite_credito=limite_credito;
 		this.total_pedidos=total_pedidos;
 		this.total_saldos=total_saldos;
 		this.total_cheques=total_cheques;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CobrarClientesSaldos getCobrarClientesSaldosOriginal() {
		return this.cobrarclientessaldosOriginal;
	}
	
	public void setCobrarClientesSaldosOriginal(CobrarClientesSaldos cobrarclientessaldos) {
		try {
			this.cobrarclientessaldosOriginal=cobrarclientessaldos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobrarClientesSaldosAdditional cobrarclientessaldosAdditional=null;
	
	public CobrarClientesSaldosAdditional getCobrarClientesSaldosAdditional() {
		return this.cobrarclientessaldosAdditional;
	}
	
	public void setCobrarClientesSaldosAdditional(CobrarClientesSaldosAdditional cobrarclientessaldosAdditional) {
		try {
			this.cobrarclientessaldosAdditional=cobrarclientessaldosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
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
    
	
	public String getnombre_garantia() {
		return this.nombre_garantia;
	}
    
	
	public Double getlimite_credito() {
		return this.limite_credito;
	}
    
	
	public Double gettotal_pedidos() {
		return this.total_pedidos;
	}
    
	
	public Double gettotal_saldos() {
		return this.total_saldos;
	}
    
	
	public Double gettotal_cheques() {
		return this.total_cheques;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
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
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
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
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CobrarClientesSaldos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>150) {
					newnombre_completo=newnombre_completo.substring(0,148);
					System.out.println("CobrarClientesSaldos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo");
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
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna nombre_comercial");
					}
				}

				if(newnombre_comercial!=null&&newnombre_comercial.length()>150) {
					newnombre_comercial=newnombre_comercial.substring(0,148);
					System.out.println("CobrarClientesSaldos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_comercial");
				}

				this.nombre_comercial=newnombre_comercial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_garantia(String newnombre_garantia)throws Exception
	{
		try {
			if(this.nombre_garantia!=newnombre_garantia) {
				if(newnombre_garantia==null) {
					//newnombre_garantia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna nombre_garantia");
					}
				}

				if(newnombre_garantia!=null&&newnombre_garantia.length()>150) {
					newnombre_garantia=newnombre_garantia.substring(0,148);
					System.out.println("CobrarClientesSaldos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_garantia");
				}

				this.nombre_garantia=newnombre_garantia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlimite_credito(Double newlimite_credito)throws Exception
	{
		try {
			if(this.limite_credito!=newlimite_credito) {
				if(newlimite_credito==null) {
					//newlimite_credito=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna limite_credito");
					}
				}

				this.limite_credito=newlimite_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_pedidos(Double newtotal_pedidos)throws Exception
	{
		try {
			if(this.total_pedidos!=newtotal_pedidos) {
				if(newtotal_pedidos==null) {
					//newtotal_pedidos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna total_pedidos");
					}
				}

				this.total_pedidos=newtotal_pedidos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_saldos(Double newtotal_saldos)throws Exception
	{
		try {
			if(this.total_saldos!=newtotal_saldos) {
				if(newtotal_saldos==null) {
					//newtotal_saldos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna total_saldos");
					}
				}

				this.total_saldos=newtotal_saldos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_cheques(Double newtotal_cheques)throws Exception
	{
		try {
			if(this.total_cheques!=newtotal_cheques) {
				if(newtotal_cheques==null) {
					//newtotal_cheques=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesSaldos:Valor nulo no permitido en columna total_cheques");
					}
				}

				this.total_cheques=newtotal_cheques;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
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


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
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
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
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
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

