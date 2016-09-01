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
package com.bydan.erp.seguridad.business.entity;

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
//import com.bydan.erp.seguridad.util.ParametroSeguridadConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class ParametroSeguridad extends ParametroSeguridadAdditional implements Serializable ,Cloneable {//ParametroSeguridadAdditional,GeneralEntity
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
	
	private ParametroSeguridad parametroseguridadOriginal;
	
	private Map<String, Object> mapParametroSeguridad;
			
	public Map<String, Object> getMapParametroSeguridad() {
		return mapParametroSeguridad;
	}

	public void setMapParametroSeguridad(Map<String, Object> mapParametroSeguridad) {
		this.mapParametroSeguridad = mapParametroSeguridad;
	}
	
	public void inicializarMapParametroSeguridad() {
		this.mapParametroSeguridad = new HashMap<String,Object>();
	}
	
	public void setMapParametroSeguridadValue(String sKey,Object oValue) {
		this.mapParametroSeguridad.put(sKey, oValue);
	}
	
	public Object getMapParametroSeguridadValue(String sKey) {
		return this.mapParametroSeguridad.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cartera;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_copiar_clientes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_copiar_proveedores;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_generar_cliente_prove;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean cliente_con_secuencial_auto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cliente_num_maximo_iniciales;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean prove_con_secuencial_auto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer prove_num_maximo_iniciales;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_validar_grupos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean acti_fijo_con_secuencial_auto;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public ParametroSeguridad () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametroseguridadOriginal=this;
		
 		this.id_empresa=-1L;
 		this.con_cartera=false;
 		this.con_copiar_clientes=false;
 		this.con_copiar_proveedores=false;
 		this.con_generar_cliente_prove=false;
 		this.cliente_con_secuencial_auto=false;
 		this.cliente_num_maximo_iniciales=0;
 		this.prove_con_secuencial_auto=false;
 		this.prove_num_maximo_iniciales=0;
 		this.con_validar_grupos=false;
 		this.acti_fijo_con_secuencial_auto=false;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroSeguridad (Long id,Date versionRow,Long id_empresa,Boolean con_cartera,Boolean con_copiar_clientes,Boolean con_copiar_proveedores,Boolean con_generar_cliente_prove,Boolean cliente_con_secuencial_auto,Integer cliente_num_maximo_iniciales,Boolean prove_con_secuencial_auto,Integer prove_num_maximo_iniciales,Boolean con_validar_grupos,Boolean acti_fijo_con_secuencial_auto) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroseguridadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.con_cartera=con_cartera;
 		this.con_copiar_clientes=con_copiar_clientes;
 		this.con_copiar_proveedores=con_copiar_proveedores;
 		this.con_generar_cliente_prove=con_generar_cliente_prove;
 		this.cliente_con_secuencial_auto=cliente_con_secuencial_auto;
 		this.cliente_num_maximo_iniciales=cliente_num_maximo_iniciales;
 		this.prove_con_secuencial_auto=prove_con_secuencial_auto;
 		this.prove_num_maximo_iniciales=prove_num_maximo_iniciales;
 		this.con_validar_grupos=con_validar_grupos;
 		this.acti_fijo_con_secuencial_auto=acti_fijo_con_secuencial_auto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroSeguridad (Long id_empresa,Boolean con_cartera,Boolean con_copiar_clientes,Boolean con_copiar_proveedores,Boolean con_generar_cliente_prove,Boolean cliente_con_secuencial_auto,Integer cliente_num_maximo_iniciales,Boolean prove_con_secuencial_auto,Integer prove_num_maximo_iniciales,Boolean con_validar_grupos,Boolean acti_fijo_con_secuencial_auto) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroseguridadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.con_cartera=con_cartera;
 		this.con_copiar_clientes=con_copiar_clientes;
 		this.con_copiar_proveedores=con_copiar_proveedores;
 		this.con_generar_cliente_prove=con_generar_cliente_prove;
 		this.cliente_con_secuencial_auto=cliente_con_secuencial_auto;
 		this.cliente_num_maximo_iniciales=cliente_num_maximo_iniciales;
 		this.prove_con_secuencial_auto=prove_con_secuencial_auto;
 		this.prove_num_maximo_iniciales=prove_num_maximo_iniciales;
 		this.con_validar_grupos=con_validar_grupos;
 		this.acti_fijo_con_secuencial_auto=acti_fijo_con_secuencial_auto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroSeguridad parametroseguridadLocal=null;
		
		if(object!=null) {
			parametroseguridadLocal=(ParametroSeguridad)object;
			
			if(parametroseguridadLocal!=null) {
				if(this.getId()!=null && parametroseguridadLocal.getId()!=null) {
					if(this.getId().equals(parametroseguridadLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroSeguridadConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroSeguridadConstantesFunciones.getParametroSeguridadDescripcion(this);
		} else {
			sDetalle=ParametroSeguridadConstantesFunciones.getParametroSeguridadDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroSeguridad getParametroSeguridadOriginal() {
		return this.parametroseguridadOriginal;
	}
	
	public void setParametroSeguridadOriginal(ParametroSeguridad parametroseguridad) {
		try {
			this.parametroseguridadOriginal=parametroseguridad;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroSeguridadAdditional parametroseguridadAdditional=null;
	
	public ParametroSeguridadAdditional getParametroSeguridadAdditional() {
		return this.parametroseguridadAdditional;
	}
	
	public void setParametroSeguridadAdditional(ParametroSeguridadAdditional parametroseguridadAdditional) {
		try {
			this.parametroseguridadAdditional=parametroseguridadAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Boolean getcon_cartera() {
		return this.con_cartera;
	}
    
	
	public Boolean getcon_copiar_clientes() {
		return this.con_copiar_clientes;
	}
    
	
	public Boolean getcon_copiar_proveedores() {
		return this.con_copiar_proveedores;
	}
    
	
	public Boolean getcon_generar_cliente_prove() {
		return this.con_generar_cliente_prove;
	}
    
	
	public Boolean getcliente_con_secuencial_auto() {
		return this.cliente_con_secuencial_auto;
	}
    
	
	public Integer getcliente_num_maximo_iniciales() {
		return this.cliente_num_maximo_iniciales;
	}
    
	
	public Boolean getprove_con_secuencial_auto() {
		return this.prove_con_secuencial_auto;
	}
    
	
	public Integer getprove_num_maximo_iniciales() {
		return this.prove_num_maximo_iniciales;
	}
    
	
	public Boolean getcon_validar_grupos() {
		return this.con_validar_grupos;
	}
    
	
	public Boolean getacti_fijo_con_secuencial_auto() {
		return this.acti_fijo_con_secuencial_auto;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cartera(Boolean newcon_cartera)throws Exception
	{
		try {
			if(this.con_cartera!=newcon_cartera) {
				if(newcon_cartera==null) {
					//newcon_cartera=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna con_cartera");
					}
				}

				this.con_cartera=newcon_cartera;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_copiar_clientes(Boolean newcon_copiar_clientes)throws Exception
	{
		try {
			if(this.con_copiar_clientes!=newcon_copiar_clientes) {
				if(newcon_copiar_clientes==null) {
					//newcon_copiar_clientes=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna con_copiar_clientes");
					}
				}

				this.con_copiar_clientes=newcon_copiar_clientes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_copiar_proveedores(Boolean newcon_copiar_proveedores)throws Exception
	{
		try {
			if(this.con_copiar_proveedores!=newcon_copiar_proveedores) {
				if(newcon_copiar_proveedores==null) {
					//newcon_copiar_proveedores=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna con_copiar_proveedores");
					}
				}

				this.con_copiar_proveedores=newcon_copiar_proveedores;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_generar_cliente_prove(Boolean newcon_generar_cliente_prove)throws Exception
	{
		try {
			if(this.con_generar_cliente_prove!=newcon_generar_cliente_prove) {
				if(newcon_generar_cliente_prove==null) {
					//newcon_generar_cliente_prove=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna con_generar_cliente_prove");
					}
				}

				this.con_generar_cliente_prove=newcon_generar_cliente_prove;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcliente_con_secuencial_auto(Boolean newcliente_con_secuencial_auto)throws Exception
	{
		try {
			if(this.cliente_con_secuencial_auto!=newcliente_con_secuencial_auto) {
				if(newcliente_con_secuencial_auto==null) {
					//newcliente_con_secuencial_auto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna cliente_con_secuencial_auto");
					}
				}

				this.cliente_con_secuencial_auto=newcliente_con_secuencial_auto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcliente_num_maximo_iniciales(Integer newcliente_num_maximo_iniciales)throws Exception
	{
		try {
			if(this.cliente_num_maximo_iniciales!=newcliente_num_maximo_iniciales) {
				if(newcliente_num_maximo_iniciales==null) {
					//newcliente_num_maximo_iniciales=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna cliente_num_maximo_iniciales");
					}
				}

				this.cliente_num_maximo_iniciales=newcliente_num_maximo_iniciales;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprove_con_secuencial_auto(Boolean newprove_con_secuencial_auto)throws Exception
	{
		try {
			if(this.prove_con_secuencial_auto!=newprove_con_secuencial_auto) {
				if(newprove_con_secuencial_auto==null) {
					//newprove_con_secuencial_auto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna prove_con_secuencial_auto");
					}
				}

				this.prove_con_secuencial_auto=newprove_con_secuencial_auto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprove_num_maximo_iniciales(Integer newprove_num_maximo_iniciales)throws Exception
	{
		try {
			if(this.prove_num_maximo_iniciales!=newprove_num_maximo_iniciales) {
				if(newprove_num_maximo_iniciales==null) {
					//newprove_num_maximo_iniciales=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna prove_num_maximo_iniciales");
					}
				}

				this.prove_num_maximo_iniciales=newprove_num_maximo_iniciales;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_validar_grupos(Boolean newcon_validar_grupos)throws Exception
	{
		try {
			if(this.con_validar_grupos!=newcon_validar_grupos) {
				if(newcon_validar_grupos==null) {
					//newcon_validar_grupos=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna con_validar_grupos");
					}
				}

				this.con_validar_grupos=newcon_validar_grupos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setacti_fijo_con_secuencial_auto(Boolean newacti_fijo_con_secuencial_auto)throws Exception
	{
		try {
			if(this.acti_fijo_con_secuencial_auto!=newacti_fijo_con_secuencial_auto) {
				if(newacti_fijo_con_secuencial_auto==null) {
					//newacti_fijo_con_secuencial_auto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroSeguridad:Valor nulo no permitido en columna acti_fijo_con_secuencial_auto");
					}
				}

				this.acti_fijo_con_secuencial_auto=newacti_fijo_con_secuencial_auto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String con_cartera_descripcion="";String con_copiar_clientes_descripcion="";String con_copiar_proveedores_descripcion="";String con_generar_cliente_prove_descripcion="";String cliente_con_secuencial_auto_descripcion="";String prove_con_secuencial_auto_descripcion="";String con_validar_grupos_descripcion="";String acti_fijo_con_secuencial_auto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getcon_cartera_descripcion() {
		return con_cartera_descripcion;
	}
	public String getcon_copiar_clientes_descripcion() {
		return con_copiar_clientes_descripcion;
	}
	public String getcon_copiar_proveedores_descripcion() {
		return con_copiar_proveedores_descripcion;
	}
	public String getcon_generar_cliente_prove_descripcion() {
		return con_generar_cliente_prove_descripcion;
	}
	public String getcliente_con_secuencial_auto_descripcion() {
		return cliente_con_secuencial_auto_descripcion;
	}
	public String getprove_con_secuencial_auto_descripcion() {
		return prove_con_secuencial_auto_descripcion;
	}
	public String getcon_validar_grupos_descripcion() {
		return con_validar_grupos_descripcion;
	}
	public String getacti_fijo_con_secuencial_auto_descripcion() {
		return acti_fijo_con_secuencial_auto_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cartera_descripcion(String newcon_cartera_descripcion)throws Exception {
		try {
			this.con_cartera_descripcion=newcon_cartera_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_copiar_clientes_descripcion(String newcon_copiar_clientes_descripcion)throws Exception {
		try {
			this.con_copiar_clientes_descripcion=newcon_copiar_clientes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_copiar_proveedores_descripcion(String newcon_copiar_proveedores_descripcion)throws Exception {
		try {
			this.con_copiar_proveedores_descripcion=newcon_copiar_proveedores_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_generar_cliente_prove_descripcion(String newcon_generar_cliente_prove_descripcion)throws Exception {
		try {
			this.con_generar_cliente_prove_descripcion=newcon_generar_cliente_prove_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcliente_con_secuencial_auto_descripcion(String newcliente_con_secuencial_auto_descripcion)throws Exception {
		try {
			this.cliente_con_secuencial_auto_descripcion=newcliente_con_secuencial_auto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setprove_con_secuencial_auto_descripcion(String newprove_con_secuencial_auto_descripcion)throws Exception {
		try {
			this.prove_con_secuencial_auto_descripcion=newprove_con_secuencial_auto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_validar_grupos_descripcion(String newcon_validar_grupos_descripcion)throws Exception {
		try {
			this.con_validar_grupos_descripcion=newcon_validar_grupos_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setacti_fijo_con_secuencial_auto_descripcion(String newacti_fijo_con_secuencial_auto_descripcion)throws Exception {
		try {
			this.acti_fijo_con_secuencial_auto_descripcion=newacti_fijo_con_secuencial_auto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.con_cartera_descripcion="";this.con_copiar_clientes_descripcion="";this.con_copiar_proveedores_descripcion="";this.con_generar_cliente_prove_descripcion="";this.cliente_con_secuencial_auto_descripcion="";this.prove_con_secuencial_auto_descripcion="";this.con_validar_grupos_descripcion="";this.acti_fijo_con_secuencial_auto_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

