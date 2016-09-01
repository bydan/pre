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
package com.bydan.erp.importaciones.business.entity;

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
//import com.bydan.erp.importaciones.util.CostoGastoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class CostoGastoImpor extends CostoGastoImporAdditional implements Serializable ,Cloneable {//CostoGastoImporAdditional,GeneralEntity
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
	
	private CostoGastoImpor costogastoimporOriginal;
	
	private Map<String, Object> mapCostoGastoImpor;
			
	public Map<String, Object> getMapCostoGastoImpor() {
		return mapCostoGastoImpor;
	}

	public void setMapCostoGastoImpor(Map<String, Object> mapCostoGastoImpor) {
		this.mapCostoGastoImpor = mapCostoGastoImpor;
	}
	
	public void inicializarMapCostoGastoImpor() {
		this.mapCostoGastoImpor = new HashMap<String,Object>();
	}
	
	public void setMapCostoGastoImporValue(String sKey,Object oValue) {
		this.mapCostoGastoImpor.put(sKey, oValue);
	}
	
	public Object getMapCostoGastoImporValue(String sKey) {
		return this.mapCostoGastoImpor.get(sKey);
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
	private Long id_tipo_costo_gasto_impor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CostoGastoImporConstantesFunciones.SREGEXNOMBRE,message=CostoGastoImporConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_activo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_agrupa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_prorratea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_arancel;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_seguro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_total_general;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_digitado;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TipoCostoGastoImpor tipocostogastoimpor;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tipocostogastoimpor_descripcion;
	
	
	public List<DetalleLiquidacionImpor> detalleliquidacionimpors;
		
	public CostoGastoImpor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.costogastoimporOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_tipo_costo_gasto_impor=-1L;
 		this.nombre="";
 		this.es_activo=false;
 		this.con_agrupa=false;
 		this.con_prorratea=false;
 		this.con_factura=false;
 		this.con_flete=false;
 		this.con_arancel=false;
 		this.con_seguro=false;
 		this.con_total_general=false;
 		this.con_digitado=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tipocostogastoimpor=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tipocostogastoimpor_descripcion="";
		
		
		this.detalleliquidacionimpors=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CostoGastoImpor (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_tipo_costo_gasto_impor,String nombre,Boolean es_activo,Boolean con_agrupa,Boolean con_prorratea,Boolean con_factura,Boolean con_flete,Boolean con_arancel,Boolean con_seguro,Boolean con_total_general,Boolean con_digitado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.costogastoimporOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_costo_gasto_impor=id_tipo_costo_gasto_impor;
 		this.nombre=nombre;
 		this.es_activo=es_activo;
 		this.con_agrupa=con_agrupa;
 		this.con_prorratea=con_prorratea;
 		this.con_factura=con_factura;
 		this.con_flete=con_flete;
 		this.con_arancel=con_arancel;
 		this.con_seguro=con_seguro;
 		this.con_total_general=con_total_general;
 		this.con_digitado=con_digitado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CostoGastoImpor (Long id_empresa,Long id_sucursal,Long id_tipo_costo_gasto_impor,String nombre,Boolean es_activo,Boolean con_agrupa,Boolean con_prorratea,Boolean con_factura,Boolean con_flete,Boolean con_arancel,Boolean con_seguro,Boolean con_total_general,Boolean con_digitado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.costogastoimporOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_costo_gasto_impor=id_tipo_costo_gasto_impor;
 		this.nombre=nombre;
 		this.es_activo=es_activo;
 		this.con_agrupa=con_agrupa;
 		this.con_prorratea=con_prorratea;
 		this.con_factura=con_factura;
 		this.con_flete=con_flete;
 		this.con_arancel=con_arancel;
 		this.con_seguro=con_seguro;
 		this.con_total_general=con_total_general;
 		this.con_digitado=con_digitado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CostoGastoImpor costogastoimporLocal=null;
		
		if(object!=null) {
			costogastoimporLocal=(CostoGastoImpor)object;
			
			if(costogastoimporLocal!=null) {
				if(this.getId()!=null && costogastoimporLocal.getId()!=null) {
					if(this.getId().equals(costogastoimporLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CostoGastoImporConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CostoGastoImporConstantesFunciones.getCostoGastoImporDescripcion(this);
		} else {
			sDetalle=CostoGastoImporConstantesFunciones.getCostoGastoImporDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CostoGastoImpor getCostoGastoImporOriginal() {
		return this.costogastoimporOriginal;
	}
	
	public void setCostoGastoImporOriginal(CostoGastoImpor costogastoimpor) {
		try {
			this.costogastoimporOriginal=costogastoimpor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CostoGastoImporAdditional costogastoimporAdditional=null;
	
	public CostoGastoImporAdditional getCostoGastoImporAdditional() {
		return this.costogastoimporAdditional;
	}
	
	public void setCostoGastoImporAdditional(CostoGastoImporAdditional costogastoimporAdditional) {
		try {
			this.costogastoimporAdditional=costogastoimporAdditional;
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
    
	
	public Long getid_tipo_costo_gasto_impor() {
		return this.id_tipo_costo_gasto_impor;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Boolean getes_activo() {
		return this.es_activo;
	}
    
	
	public Boolean getcon_agrupa() {
		return this.con_agrupa;
	}
    
	
	public Boolean getcon_prorratea() {
		return this.con_prorratea;
	}
    
	
	public Boolean getcon_factura() {
		return this.con_factura;
	}
    
	
	public Boolean getcon_flete() {
		return this.con_flete;
	}
    
	
	public Boolean getcon_arancel() {
		return this.con_arancel;
	}
    
	
	public Boolean getcon_seguro() {
		return this.con_seguro;
	}
    
	
	public Boolean getcon_total_general() {
		return this.con_total_general;
	}
    
	
	public Boolean getcon_digitado() {
		return this.con_digitado;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_costo_gasto_impor(Long newid_tipo_costo_gasto_impor)throws Exception
	{
		try {
			if(this.id_tipo_costo_gasto_impor!=newid_tipo_costo_gasto_impor) {
				if(newid_tipo_costo_gasto_impor==null) {
					//newid_tipo_costo_gasto_impor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna id_tipo_costo_gasto_impor");
					}
				}

				this.id_tipo_costo_gasto_impor=newid_tipo_costo_gasto_impor;
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
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("CostoGastoImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_activo(Boolean newes_activo)throws Exception
	{
		try {
			if(this.es_activo!=newes_activo) {
				if(newes_activo==null) {
					//newes_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna es_activo");
					}
				}

				this.es_activo=newes_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_agrupa(Boolean newcon_agrupa)throws Exception
	{
		try {
			if(this.con_agrupa!=newcon_agrupa) {
				if(newcon_agrupa==null) {
					//newcon_agrupa=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna con_agrupa");
					}
				}

				this.con_agrupa=newcon_agrupa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_prorratea(Boolean newcon_prorratea)throws Exception
	{
		try {
			if(this.con_prorratea!=newcon_prorratea) {
				if(newcon_prorratea==null) {
					//newcon_prorratea=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna con_prorratea");
					}
				}

				this.con_prorratea=newcon_prorratea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_factura(Boolean newcon_factura)throws Exception
	{
		try {
			if(this.con_factura!=newcon_factura) {
				if(newcon_factura==null) {
					//newcon_factura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna con_factura");
					}
				}

				this.con_factura=newcon_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_flete(Boolean newcon_flete)throws Exception
	{
		try {
			if(this.con_flete!=newcon_flete) {
				if(newcon_flete==null) {
					//newcon_flete=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna con_flete");
					}
				}

				this.con_flete=newcon_flete;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_arancel(Boolean newcon_arancel)throws Exception
	{
		try {
			if(this.con_arancel!=newcon_arancel) {
				if(newcon_arancel==null) {
					//newcon_arancel=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna con_arancel");
					}
				}

				this.con_arancel=newcon_arancel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_seguro(Boolean newcon_seguro)throws Exception
	{
		try {
			if(this.con_seguro!=newcon_seguro) {
				if(newcon_seguro==null) {
					//newcon_seguro=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna con_seguro");
					}
				}

				this.con_seguro=newcon_seguro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_total_general(Boolean newcon_total_general)throws Exception
	{
		try {
			if(this.con_total_general!=newcon_total_general) {
				if(newcon_total_general==null) {
					//newcon_total_general=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna con_total_general");
					}
				}

				this.con_total_general=newcon_total_general;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_digitado(Boolean newcon_digitado)throws Exception
	{
		try {
			if(this.con_digitado!=newcon_digitado) {
				if(newcon_digitado==null) {
					//newcon_digitado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CostoGastoImpor:Valor nulo no permitido en columna con_digitado");
					}
				}

				this.con_digitado=newcon_digitado;
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

	public TipoCostoGastoImpor getTipoCostoGastoImpor() {
		return this.tipocostogastoimpor;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettipocostogastoimpor_descripcion() {
		return this.tipocostogastoimpor_descripcion;
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


	public  void  setTipoCostoGastoImpor(TipoCostoGastoImpor tipocostogastoimpor) {
		try {
			this.tipocostogastoimpor=tipocostogastoimpor;
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


	public  void  settipocostogastoimpor_descripcion(String tipocostogastoimpor_descripcion) {
		try {
			this.tipocostogastoimpor_descripcion=tipocostogastoimpor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleLiquidacionImpor> getDetalleLiquidacionImpors() {
		return this.detalleliquidacionimpors;
	}

	
	
	public  void  setDetalleLiquidacionImpors(List<DetalleLiquidacionImpor> detalleliquidacionimpors) {
		try {
			this.detalleliquidacionimpors=detalleliquidacionimpors;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tipo_costo_gasto_impor_descripcion="";String es_activo_descripcion="";String con_agrupa_descripcion="";String con_prorratea_descripcion="";String con_factura_descripcion="";String con_flete_descripcion="";String con_arancel_descripcion="";String con_seguro_descripcion="";String con_total_general_descripcion="";String con_digitado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_costo_gasto_impor_descripcion() {
		return id_tipo_costo_gasto_impor_descripcion;
	}
	public String getes_activo_descripcion() {
		return es_activo_descripcion;
	}
	public String getcon_agrupa_descripcion() {
		return con_agrupa_descripcion;
	}
	public String getcon_prorratea_descripcion() {
		return con_prorratea_descripcion;
	}
	public String getcon_factura_descripcion() {
		return con_factura_descripcion;
	}
	public String getcon_flete_descripcion() {
		return con_flete_descripcion;
	}
	public String getcon_arancel_descripcion() {
		return con_arancel_descripcion;
	}
	public String getcon_seguro_descripcion() {
		return con_seguro_descripcion;
	}
	public String getcon_total_general_descripcion() {
		return con_total_general_descripcion;
	}
	public String getcon_digitado_descripcion() {
		return con_digitado_descripcion;
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
	public void setid_tipo_costo_gasto_impor_descripcion(String newid_tipo_costo_gasto_impor_descripcion)throws Exception {
		try {
			this.id_tipo_costo_gasto_impor_descripcion=newid_tipo_costo_gasto_impor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_activo_descripcion(String newes_activo_descripcion)throws Exception {
		try {
			this.es_activo_descripcion=newes_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_agrupa_descripcion(String newcon_agrupa_descripcion)throws Exception {
		try {
			this.con_agrupa_descripcion=newcon_agrupa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_prorratea_descripcion(String newcon_prorratea_descripcion)throws Exception {
		try {
			this.con_prorratea_descripcion=newcon_prorratea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_factura_descripcion(String newcon_factura_descripcion)throws Exception {
		try {
			this.con_factura_descripcion=newcon_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_flete_descripcion(String newcon_flete_descripcion)throws Exception {
		try {
			this.con_flete_descripcion=newcon_flete_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_arancel_descripcion(String newcon_arancel_descripcion)throws Exception {
		try {
			this.con_arancel_descripcion=newcon_arancel_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_seguro_descripcion(String newcon_seguro_descripcion)throws Exception {
		try {
			this.con_seguro_descripcion=newcon_seguro_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_total_general_descripcion(String newcon_total_general_descripcion)throws Exception {
		try {
			this.con_total_general_descripcion=newcon_total_general_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_digitado_descripcion(String newcon_digitado_descripcion)throws Exception {
		try {
			this.con_digitado_descripcion=newcon_digitado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_costo_gasto_impor_descripcion="";this.es_activo_descripcion="";this.con_agrupa_descripcion="";this.con_prorratea_descripcion="";this.con_factura_descripcion="";this.con_flete_descripcion="";this.con_arancel_descripcion="";this.con_seguro_descripcion="";this.con_total_general_descripcion="";this.con_digitado_descripcion="";
	}
	
	
	Object detalleliquidacionimporsDescripcionReporte;
	
	
	public Object getdetalleliquidacionimporsDescripcionReporte() {
		return detalleliquidacionimporsDescripcionReporte;
	}

	
	
	public  void  setdetalleliquidacionimporsDescripcionReporte(Object detalleliquidacionimpors) {
		try {
			this.detalleliquidacionimporsDescripcionReporte=detalleliquidacionimpors;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

