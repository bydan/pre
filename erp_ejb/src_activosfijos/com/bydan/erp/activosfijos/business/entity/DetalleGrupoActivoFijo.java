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
package com.bydan.erp.activosfijos.business.entity;

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
//import com.bydan.erp.activosfijos.util.DetalleGrupoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class DetalleGrupoActivoFijo extends DetalleGrupoActivoFijoAdditional implements Serializable ,Cloneable {//DetalleGrupoActivoFijoAdditional,GeneralEntity
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
	
	private DetalleGrupoActivoFijo detallegrupoactivofijoOriginal;
	
	private Map<String, Object> mapDetalleGrupoActivoFijo;
			
	public Map<String, Object> getMapDetalleGrupoActivoFijo() {
		return mapDetalleGrupoActivoFijo;
	}

	public void setMapDetalleGrupoActivoFijo(Map<String, Object> mapDetalleGrupoActivoFijo) {
		this.mapDetalleGrupoActivoFijo = mapDetalleGrupoActivoFijo;
	}
	
	public void inicializarMapDetalleGrupoActivoFijo() {
		this.mapDetalleGrupoActivoFijo = new HashMap<String,Object>();
	}
	
	public void setMapDetalleGrupoActivoFijoValue(String sKey,Object oValue) {
		this.mapDetalleGrupoActivoFijo.put(sKey, oValue);
	}
	
	public Object getMapDetalleGrupoActivoFijoValue(String sKey) {
		return this.mapDetalleGrupoActivoFijo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleGrupoActivoFijoConstantesFunciones.SREGEXCODIGO,message=DetalleGrupoActivoFijoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleGrupoActivoFijoConstantesFunciones.SREGEXNOMBRE,message=DetalleGrupoActivoFijoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleGrupoActivoFijoConstantesFunciones.SREGEXSIGLAS,message=DetalleGrupoActivoFijoConstantesFunciones.SMENSAJEREGEXSIGLAS)
	private String siglas;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_costo_original;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_depre_normal;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_depre_gasto_normal;
			
	
	public Empresa empresa;
	public CuentaContable cuentacontablecostooriginal;
	public CuentaContable cuentacontabledeprenormal;
	public CuentaContable cuentacontabledepregastonormal;
	
	
	private String empresa_descripcion;
	private String cuentacontablecostooriginal_descripcion;
	private String cuentacontabledeprenormal_descripcion;
	private String cuentacontabledepregastonormal_descripcion;
	
	
	public List<DetalleActivoFijo> detalleactivofijos;
	public List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis;
	public List<SubGrupoActivoFijo> subgrupoactivofijos;
	public List<GastoDepreciacion> gastodepreciacions;
		
	public DetalleGrupoActivoFijo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detallegrupoactivofijoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.siglas="";
 		this.id_cuenta_contable_costo_original=null;
 		this.id_cuenta_contable_depre_normal=null;
 		this.id_cuenta_contable_depre_gasto_normal=null;
		
		
		this.empresa=null;
		this.cuentacontablecostooriginal=null;
		this.cuentacontabledeprenormal=null;
		this.cuentacontabledepregastonormal=null;
		
		
		this.empresa_descripcion="";
		this.cuentacontablecostooriginal_descripcion="";
		this.cuentacontabledeprenormal_descripcion="";
		this.cuentacontabledepregastonormal_descripcion="";
		
		
		this.detalleactivofijos=null;
		this.cuentacontadetagrupoactis=null;
		this.subgrupoactivofijos=null;
		this.gastodepreciacions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleGrupoActivoFijo (Long id,Date versionRow,Long id_empresa,String codigo,String nombre,String siglas,Long id_cuenta_contable_costo_original,Long id_cuenta_contable_depre_normal,Long id_cuenta_contable_depre_gasto_normal) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallegrupoactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.siglas=siglas;
 		this.id_cuenta_contable_costo_original=id_cuenta_contable_costo_original;
 		this.id_cuenta_contable_depre_normal=id_cuenta_contable_depre_normal;
 		this.id_cuenta_contable_depre_gasto_normal=id_cuenta_contable_depre_gasto_normal;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleGrupoActivoFijo (Long id_empresa,String codigo,String nombre,String siglas,Long id_cuenta_contable_costo_original,Long id_cuenta_contable_depre_normal,Long id_cuenta_contable_depre_gasto_normal) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallegrupoactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.siglas=siglas;
 		this.id_cuenta_contable_costo_original=id_cuenta_contable_costo_original;
 		this.id_cuenta_contable_depre_normal=id_cuenta_contable_depre_normal;
 		this.id_cuenta_contable_depre_gasto_normal=id_cuenta_contable_depre_gasto_normal;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleGrupoActivoFijo detallegrupoactivofijoLocal=null;
		
		if(object!=null) {
			detallegrupoactivofijoLocal=(DetalleGrupoActivoFijo)object;
			
			if(detallegrupoactivofijoLocal!=null) {
				if(this.getId()!=null && detallegrupoactivofijoLocal.getId()!=null) {
					if(this.getId().equals(detallegrupoactivofijoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleGrupoActivoFijoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcion(this);
		} else {
			sDetalle=DetalleGrupoActivoFijoConstantesFunciones.getDetalleGrupoActivoFijoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijoOriginal() {
		return this.detallegrupoactivofijoOriginal;
	}
	
	public void setDetalleGrupoActivoFijoOriginal(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		try {
			this.detallegrupoactivofijoOriginal=detallegrupoactivofijo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleGrupoActivoFijoAdditional detallegrupoactivofijoAdditional=null;
	
	public DetalleGrupoActivoFijoAdditional getDetalleGrupoActivoFijoAdditional() {
		return this.detallegrupoactivofijoAdditional;
	}
	
	public void setDetalleGrupoActivoFijoAdditional(DetalleGrupoActivoFijoAdditional detallegrupoactivofijoAdditional) {
		try {
			this.detallegrupoactivofijoAdditional=detallegrupoactivofijoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getsiglas() {
		return this.siglas;
	}
    
	
	public Long getid_cuenta_contable_costo_original() {
		return this.id_cuenta_contable_costo_original;
	}
    
	
	public Long getid_cuenta_contable_depre_normal() {
		return this.id_cuenta_contable_depre_normal;
	}
    
	
	public Long getid_cuenta_contable_depre_gasto_normal() {
		return this.id_cuenta_contable_depre_gasto_normal;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGrupoActivoFijo:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("DetalleGrupoActivoFijo:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("DetalleGrupoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("DetalleGrupoActivoFijo:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("DetalleGrupoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsiglas(String newsiglas)throws Exception
	{
		try {
			if(this.siglas!=newsiglas) {
				if(newsiglas==null) {
					//newsiglas="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGrupoActivoFijo:Valor nulo no permitido en columna siglas");
					}
				}

				if(newsiglas!=null&&newsiglas.length()>50) {
					newsiglas=newsiglas.substring(0,48);
					System.out.println("DetalleGrupoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna siglas");
				}

				this.siglas=newsiglas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_costo_original(Long newid_cuenta_contable_costo_original) {
		if(this.id_cuenta_contable_costo_original==null&&newid_cuenta_contable_costo_original!=null) {
			this.id_cuenta_contable_costo_original=newid_cuenta_contable_costo_original;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_costo_original!=null&&!this.id_cuenta_contable_costo_original.equals(newid_cuenta_contable_costo_original)) {

			this.id_cuenta_contable_costo_original=newid_cuenta_contable_costo_original;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_depre_normal(Long newid_cuenta_contable_depre_normal) {
		if(this.id_cuenta_contable_depre_normal==null&&newid_cuenta_contable_depre_normal!=null) {
			this.id_cuenta_contable_depre_normal=newid_cuenta_contable_depre_normal;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_depre_normal!=null&&!this.id_cuenta_contable_depre_normal.equals(newid_cuenta_contable_depre_normal)) {

			this.id_cuenta_contable_depre_normal=newid_cuenta_contable_depre_normal;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_depre_gasto_normal(Long newid_cuenta_contable_depre_gasto_normal) {
		if(this.id_cuenta_contable_depre_gasto_normal==null&&newid_cuenta_contable_depre_gasto_normal!=null) {
			this.id_cuenta_contable_depre_gasto_normal=newid_cuenta_contable_depre_gasto_normal;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_depre_gasto_normal!=null&&!this.id_cuenta_contable_depre_gasto_normal.equals(newid_cuenta_contable_depre_gasto_normal)) {

			this.id_cuenta_contable_depre_gasto_normal=newid_cuenta_contable_depre_gasto_normal;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public CuentaContable getCuentaContableCostoOriginal() {
		return this.cuentacontablecostooriginal;
	}

	public CuentaContable getCuentaContableDepreNormal() {
		return this.cuentacontabledeprenormal;
	}

	public CuentaContable getCuentaContableDepreGastoNormal() {
		return this.cuentacontabledepregastonormal;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcuentacontablecostooriginal_descripcion() {
		return this.cuentacontablecostooriginal_descripcion;
	}

	public String getcuentacontabledeprenormal_descripcion() {
		return this.cuentacontabledeprenormal_descripcion;
	}

	public String getcuentacontabledepregastonormal_descripcion() {
		return this.cuentacontabledepregastonormal_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCostoOriginal(CuentaContable cuentacontablecostooriginal) {
		try {
			this.cuentacontablecostooriginal=cuentacontablecostooriginal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDepreNormal(CuentaContable cuentacontabledeprenormal) {
		try {
			this.cuentacontabledeprenormal=cuentacontabledeprenormal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDepreGastoNormal(CuentaContable cuentacontabledepregastonormal) {
		try {
			this.cuentacontabledepregastonormal=cuentacontabledepregastonormal;
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


	public  void  setcuentacontablecostooriginal_descripcion(String cuentacontablecostooriginal_descripcion) {
		try {
			this.cuentacontablecostooriginal_descripcion=cuentacontablecostooriginal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledeprenormal_descripcion(String cuentacontabledeprenormal_descripcion) {
		try {
			this.cuentacontabledeprenormal_descripcion=cuentacontabledeprenormal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledepregastonormal_descripcion(String cuentacontabledepregastonormal_descripcion) {
		try {
			this.cuentacontabledepregastonormal_descripcion=cuentacontabledepregastonormal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleActivoFijo> getDetalleActivoFijos() {
		return this.detalleactivofijos;
	}

	public List<CuentaContaDetaGrupoActi> getCuentaContaDetaGrupoActis() {
		return this.cuentacontadetagrupoactis;
	}

	public List<SubGrupoActivoFijo> getSubGrupoActivoFijos() {
		return this.subgrupoactivofijos;
	}

	public List<GastoDepreciacion> getGastoDepreciacions() {
		return this.gastodepreciacions;
	}

	
	
	public  void  setDetalleActivoFijos(List<DetalleActivoFijo> detalleactivofijos) {
		try {
			this.detalleactivofijos=detalleactivofijos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCuentaContaDetaGrupoActis(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis) {
		try {
			this.cuentacontadetagrupoactis=cuentacontadetagrupoactis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSubGrupoActivoFijos(List<SubGrupoActivoFijo> subgrupoactivofijos) {
		try {
			this.subgrupoactivofijos=subgrupoactivofijos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setGastoDepreciacions(List<GastoDepreciacion> gastodepreciacions) {
		try {
			this.gastodepreciacions=gastodepreciacions;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cuenta_contable_costo_original_descripcion="";String id_cuenta_contable_depre_normal_descripcion="";String id_cuenta_contable_depre_gasto_normal_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cuenta_contable_costo_original_descripcion() {
		return id_cuenta_contable_costo_original_descripcion;
	}
	public String getid_cuenta_contable_depre_normal_descripcion() {
		return id_cuenta_contable_depre_normal_descripcion;
	}
	public String getid_cuenta_contable_depre_gasto_normal_descripcion() {
		return id_cuenta_contable_depre_gasto_normal_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_costo_original_descripcion(String newid_cuenta_contable_costo_original_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_costo_original_descripcion=newid_cuenta_contable_costo_original_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_depre_normal_descripcion(String newid_cuenta_contable_depre_normal_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_depre_normal_descripcion=newid_cuenta_contable_depre_normal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_depre_gasto_normal_descripcion(String newid_cuenta_contable_depre_gasto_normal_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_depre_gasto_normal_descripcion=newid_cuenta_contable_depre_gasto_normal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cuenta_contable_costo_original_descripcion="";this.id_cuenta_contable_depre_normal_descripcion="";this.id_cuenta_contable_depre_gasto_normal_descripcion="";
	}
	
	
	Object detalleactivofijosDescripcionReporte;
	Object cuentacontadetagrupoactisDescripcionReporte;
	Object subgrupoactivofijosDescripcionReporte;
	Object gastodepreciacionsDescripcionReporte;
	
	
	public Object getdetalleactivofijosDescripcionReporte() {
		return detalleactivofijosDescripcionReporte;
	}

	public Object getcuentacontadetagrupoactisDescripcionReporte() {
		return cuentacontadetagrupoactisDescripcionReporte;
	}

	public Object getsubgrupoactivofijosDescripcionReporte() {
		return subgrupoactivofijosDescripcionReporte;
	}

	public Object getgastodepreciacionsDescripcionReporte() {
		return gastodepreciacionsDescripcionReporte;
	}

	
	
	public  void  setdetalleactivofijosDescripcionReporte(Object detalleactivofijos) {
		try {
			this.detalleactivofijosDescripcionReporte=detalleactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuentacontadetagrupoactisDescripcionReporte(Object cuentacontadetagrupoactis) {
		try {
			this.cuentacontadetagrupoactisDescripcionReporte=cuentacontadetagrupoactis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsubgrupoactivofijosDescripcionReporte(Object subgrupoactivofijos) {
		try {
			this.subgrupoactivofijosDescripcionReporte=subgrupoactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setgastodepreciacionsDescripcionReporte(Object gastodepreciacions) {
		try {
			this.gastodepreciacionsDescripcionReporte=gastodepreciacions;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

