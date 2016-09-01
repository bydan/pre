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
//import com.bydan.erp.cartera.util.VehiculoClienteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class VehiculoCliente extends VehiculoClienteAdditional implements Serializable ,Cloneable {//VehiculoClienteAdditional,GeneralEntity
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
	
	private VehiculoCliente vehiculoclienteOriginal;
	
	private Map<String, Object> mapVehiculoCliente;
			
	public Map<String, Object> getMapVehiculoCliente() {
		return mapVehiculoCliente;
	}

	public void setMapVehiculoCliente(Map<String, Object> mapVehiculoCliente) {
		this.mapVehiculoCliente = mapVehiculoCliente;
	}
	
	public void inicializarMapVehiculoCliente() {
		this.mapVehiculoCliente = new HashMap<String,Object>();
	}
	
	public void setMapVehiculoClienteValue(String sKey,Object oValue) {
		this.mapVehiculoCliente.put(sKey, oValue);
	}
	
	public Object getMapVehiculoClienteValue(String sKey) {
		return this.mapVehiculoCliente.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VehiculoClienteConstantesFunciones.SREGEXCODIGO,message=VehiculoClienteConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VehiculoClienteConstantesFunciones.SREGEXMARCA,message=VehiculoClienteConstantesFunciones.SMENSAJEREGEXMARCA)
	private String marca;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VehiculoClienteConstantesFunciones.SREGEXMODELO,message=VehiculoClienteConstantesFunciones.SMENSAJEREGEXMODELO)
	private String modelo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VehiculoClienteConstantesFunciones.SREGEXPLACA,message=VehiculoClienteConstantesFunciones.SMENSAJEREGEXPLACA)
	private String placa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer anio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_prendado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_avaluo;
			
	
	public Empresa empresa;
	public Cliente cliente;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	
	
		
	public VehiculoCliente () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.vehiculoclienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cliente=-1L;
 		this.codigo="";
 		this.marca="";
 		this.modelo="";
 		this.placa="";
 		this.anio=0;
 		this.es_prendado=false;
 		this.valor_avaluo=0.0;
		
		
		this.empresa=null;
		this.cliente=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public VehiculoCliente (Long id,Date versionRow,Long id_empresa,Long id_cliente,String codigo,String marca,String modelo,String placa,Integer anio,Boolean es_prendado,Double valor_avaluo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.vehiculoclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.codigo=codigo;
 		this.marca=marca;
 		this.modelo=modelo;
 		this.placa=placa;
 		this.anio=anio;
 		this.es_prendado=es_prendado;
 		this.valor_avaluo=valor_avaluo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public VehiculoCliente (Long id_empresa,Long id_cliente,String codigo,String marca,String modelo,String placa,Integer anio,Boolean es_prendado,Double valor_avaluo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.vehiculoclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.codigo=codigo;
 		this.marca=marca;
 		this.modelo=modelo;
 		this.placa=placa;
 		this.anio=anio;
 		this.es_prendado=es_prendado;
 		this.valor_avaluo=valor_avaluo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		VehiculoCliente vehiculoclienteLocal=null;
		
		if(object!=null) {
			vehiculoclienteLocal=(VehiculoCliente)object;
			
			if(vehiculoclienteLocal!=null) {
				if(this.getId()!=null && vehiculoclienteLocal.getId()!=null) {
					if(this.getId().equals(vehiculoclienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!VehiculoClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=VehiculoClienteConstantesFunciones.getVehiculoClienteDescripcion(this);
		} else {
			sDetalle=VehiculoClienteConstantesFunciones.getVehiculoClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public VehiculoCliente getVehiculoClienteOriginal() {
		return this.vehiculoclienteOriginal;
	}
	
	public void setVehiculoClienteOriginal(VehiculoCliente vehiculocliente) {
		try {
			this.vehiculoclienteOriginal=vehiculocliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VehiculoClienteAdditional vehiculoclienteAdditional=null;
	
	public VehiculoClienteAdditional getVehiculoClienteAdditional() {
		return this.vehiculoclienteAdditional;
	}
	
	public void setVehiculoClienteAdditional(VehiculoClienteAdditional vehiculoclienteAdditional) {
		try {
			this.vehiculoclienteAdditional=vehiculoclienteAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getmarca() {
		return this.marca;
	}
    
	
	public String getmodelo() {
		return this.modelo;
	}
    
	
	public String getplaca() {
		return this.placa;
	}
    
	
	public Integer getanio() {
		return this.anio;
	}
    
	
	public Boolean getes_prendado() {
		return this.es_prendado;
	}
    
	
	public Double getvalor_avaluo() {
		return this.valor_avaluo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VehiculoCliente:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VehiculoCliente:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
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
						System.out.println("VehiculoCliente:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("VehiculoCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmarca(String newmarca)throws Exception
	{
		try {
			if(this.marca!=newmarca) {
				if(newmarca==null) {
					//newmarca="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VehiculoCliente:Valor nulo no permitido en columna marca");
					}
				}

				if(newmarca!=null&&newmarca.length()>100) {
					newmarca=newmarca.substring(0,98);
					System.out.println("VehiculoCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna marca");
				}

				this.marca=newmarca;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmodelo(String newmodelo)throws Exception
	{
		try {
			if(this.modelo!=newmodelo) {
				if(newmodelo==null) {
					//newmodelo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VehiculoCliente:Valor nulo no permitido en columna modelo");
					}
				}

				if(newmodelo!=null&&newmodelo.length()>100) {
					newmodelo=newmodelo.substring(0,98);
					System.out.println("VehiculoCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna modelo");
				}

				this.modelo=newmodelo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setplaca(String newplaca)throws Exception
	{
		try {
			if(this.placa!=newplaca) {
				if(newplaca==null) {
					//newplaca="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VehiculoCliente:Valor nulo no permitido en columna placa");
					}
				}

				if(newplaca!=null&&newplaca.length()>20) {
					newplaca=newplaca.substring(0,18);
					System.out.println("VehiculoCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna placa");
				}

				this.placa=newplaca;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanio(Integer newanio)throws Exception
	{
		try {
			if(this.anio!=newanio) {
				if(newanio==null) {
					//newanio=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VehiculoCliente:Valor nulo no permitido en columna anio");
					}
				}

				this.anio=newanio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_prendado(Boolean newes_prendado)throws Exception
	{
		try {
			if(this.es_prendado!=newes_prendado) {
				if(newes_prendado==null) {
					//newes_prendado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VehiculoCliente:Valor nulo no permitido en columna es_prendado");
					}
				}

				this.es_prendado=newes_prendado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_avaluo(Double newvalor_avaluo)throws Exception
	{
		try {
			if(this.valor_avaluo!=newvalor_avaluo) {
				if(newvalor_avaluo==null) {
					//newvalor_avaluo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VehiculoCliente:Valor nulo no permitido en columna valor_avaluo");
					}
				}

				this.valor_avaluo=newvalor_avaluo;
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

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cliente_descripcion="";String es_prendado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getes_prendado_descripcion() {
		return es_prendado_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_prendado_descripcion(String newes_prendado_descripcion)throws Exception {
		try {
			this.es_prendado_descripcion=newes_prendado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cliente_descripcion="";this.es_prendado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

