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
//import com.bydan.erp.importaciones.util.DetalleLiquidacionImpuestoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleLiquidacionImpuestoImpor extends DetalleLiquidacionImpuestoImporAdditional implements Serializable ,Cloneable {//DetalleLiquidacionImpuestoImporAdditional,GeneralEntity
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
	
	private DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporOriginal;
	
	private Map<String, Object> mapDetalleLiquidacionImpuestoImpor;
			
	public Map<String, Object> getMapDetalleLiquidacionImpuestoImpor() {
		return mapDetalleLiquidacionImpuestoImpor;
	}

	public void setMapDetalleLiquidacionImpuestoImpor(Map<String, Object> mapDetalleLiquidacionImpuestoImpor) {
		this.mapDetalleLiquidacionImpuestoImpor = mapDetalleLiquidacionImpuestoImpor;
	}
	
	public void inicializarMapDetalleLiquidacionImpuestoImpor() {
		this.mapDetalleLiquidacionImpuestoImpor = new HashMap<String,Object>();
	}
	
	public void setMapDetalleLiquidacionImpuestoImporValue(String sKey,Object oValue) {
		this.mapDetalleLiquidacionImpuestoImpor.put(sKey, oValue);
	}
	
	public Object getMapDetalleLiquidacionImpuestoImporValue(String sKey) {
		return this.mapDetalleLiquidacionImpuestoImpor.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_liquidacion_impuesto_impor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double fob;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_arancel;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_aplicar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double seguro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_imponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_arancel;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_fodi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_fodi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_imponible;
			
	
	public LiquidacionImpuestoImpor liquidacionimpuestoimpor;
	public Empresa empresa;
	public Sucursal sucursal;
	
	
	private String liquidacionimpuestoimpor_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	
	
		
	public DetalleLiquidacionImpuestoImpor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleliquidacionimpuestoimporOriginal=this;
		
 		this.id_liquidacion_impuesto_impor=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.cantidad=0;
 		this.valor=0.0;
 		this.fob=0.0;
 		this.porcentaje_iva=0.0;
 		this.porcentaje_arancel=0.0;
 		this.porcentaje_aplicar=0.0;
 		this.flete=0.0;
 		this.seguro=0.0;
 		this.base_imponible=0.0;
 		this.valor_arancel=0.0;
 		this.valor_fodi=0.0;
 		this.valor_iva=0.0;
 		this.numero_comprobante=0;
 		this.porcentaje_fodi=0.0;
 		this.valor_imponible=0.0;
		
		
		this.liquidacionimpuestoimpor=null;
		this.empresa=null;
		this.sucursal=null;
		
		
		this.liquidacionimpuestoimpor_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleLiquidacionImpuestoImpor (Long id,Date versionRow,Long id_liquidacion_impuesto_impor,Long id_empresa,Long id_sucursal,Integer cantidad,Double valor,Double fob,Double porcentaje_iva,Double porcentaje_arancel,Double porcentaje_aplicar,Double flete,Double seguro,Double base_imponible,Double valor_arancel,Double valor_fodi,Double valor_iva,Integer numero_comprobante,Double porcentaje_fodi,Double valor_imponible) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleliquidacionimpuestoimporOriginal=this;
		
 		this.id_liquidacion_impuesto_impor=id_liquidacion_impuesto_impor;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.cantidad=cantidad;
 		this.valor=valor;
 		this.fob=fob;
 		this.porcentaje_iva=porcentaje_iva;
 		this.porcentaje_arancel=porcentaje_arancel;
 		this.porcentaje_aplicar=porcentaje_aplicar;
 		this.flete=flete;
 		this.seguro=seguro;
 		this.base_imponible=base_imponible;
 		this.valor_arancel=valor_arancel;
 		this.valor_fodi=valor_fodi;
 		this.valor_iva=valor_iva;
 		this.numero_comprobante=numero_comprobante;
 		this.porcentaje_fodi=porcentaje_fodi;
 		this.valor_imponible=valor_imponible;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleLiquidacionImpuestoImpor (Long id_liquidacion_impuesto_impor,Long id_empresa,Long id_sucursal,Integer cantidad,Double valor,Double fob,Double porcentaje_iva,Double porcentaje_arancel,Double porcentaje_aplicar,Double flete,Double seguro,Double base_imponible,Double valor_arancel,Double valor_fodi,Double valor_iva,Integer numero_comprobante,Double porcentaje_fodi,Double valor_imponible) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleliquidacionimpuestoimporOriginal=this;
		
 		this.id_liquidacion_impuesto_impor=id_liquidacion_impuesto_impor;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.cantidad=cantidad;
 		this.valor=valor;
 		this.fob=fob;
 		this.porcentaje_iva=porcentaje_iva;
 		this.porcentaje_arancel=porcentaje_arancel;
 		this.porcentaje_aplicar=porcentaje_aplicar;
 		this.flete=flete;
 		this.seguro=seguro;
 		this.base_imponible=base_imponible;
 		this.valor_arancel=valor_arancel;
 		this.valor_fodi=valor_fodi;
 		this.valor_iva=valor_iva;
 		this.numero_comprobante=numero_comprobante;
 		this.porcentaje_fodi=porcentaje_fodi;
 		this.valor_imponible=valor_imponible;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimporLocal=null;
		
		if(object!=null) {
			detalleliquidacionimpuestoimporLocal=(DetalleLiquidacionImpuestoImpor)object;
			
			if(detalleliquidacionimpuestoimporLocal!=null) {
				if(this.getId()!=null && detalleliquidacionimpuestoimporLocal.getId()!=null) {
					if(this.getId().equals(detalleliquidacionimpuestoimporLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleLiquidacionImpuestoImporConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleLiquidacionImpuestoImporConstantesFunciones.getDetalleLiquidacionImpuestoImporDescripcion(this);
		} else {
			sDetalle=DetalleLiquidacionImpuestoImporConstantesFunciones.getDetalleLiquidacionImpuestoImporDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleLiquidacionImpuestoImpor getDetalleLiquidacionImpuestoImporOriginal() {
		return this.detalleliquidacionimpuestoimporOriginal;
	}
	
	public void setDetalleLiquidacionImpuestoImporOriginal(DetalleLiquidacionImpuestoImpor detalleliquidacionimpuestoimpor) {
		try {
			this.detalleliquidacionimpuestoimporOriginal=detalleliquidacionimpuestoimpor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleLiquidacionImpuestoImporAdditional detalleliquidacionimpuestoimporAdditional=null;
	
	public DetalleLiquidacionImpuestoImporAdditional getDetalleLiquidacionImpuestoImporAdditional() {
		return this.detalleliquidacionimpuestoimporAdditional;
	}
	
	public void setDetalleLiquidacionImpuestoImporAdditional(DetalleLiquidacionImpuestoImporAdditional detalleliquidacionimpuestoimporAdditional) {
		try {
			this.detalleliquidacionimpuestoimporAdditional=detalleliquidacionimpuestoimporAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_liquidacion_impuesto_impor() {
		return this.id_liquidacion_impuesto_impor;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Double getfob() {
		return this.fob;
	}
    
	
	public Double getporcentaje_iva() {
		return this.porcentaje_iva;
	}
    
	
	public Double getporcentaje_arancel() {
		return this.porcentaje_arancel;
	}
    
	
	public Double getporcentaje_aplicar() {
		return this.porcentaje_aplicar;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double getseguro() {
		return this.seguro;
	}
    
	
	public Double getbase_imponible() {
		return this.base_imponible;
	}
    
	
	public Double getvalor_arancel() {
		return this.valor_arancel;
	}
    
	
	public Double getvalor_fodi() {
		return this.valor_fodi;
	}
    
	
	public Double getvalor_iva() {
		return this.valor_iva;
	}
    
	
	public Integer getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public Double getporcentaje_fodi() {
		return this.porcentaje_fodi;
	}
    
	
	public Double getvalor_imponible() {
		return this.valor_imponible;
	}
	
    
	public void setid_liquidacion_impuesto_impor(Long newid_liquidacion_impuesto_impor)throws Exception
	{
		try {
			if(this.id_liquidacion_impuesto_impor!=newid_liquidacion_impuesto_impor) {
				if(newid_liquidacion_impuesto_impor==null) {
					//newid_liquidacion_impuesto_impor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna id_liquidacion_impuesto_impor");
					}
				}

				this.id_liquidacion_impuesto_impor=newid_liquidacion_impuesto_impor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfob(Double newfob)throws Exception
	{
		try {
			if(this.fob!=newfob) {
				if(newfob==null) {
					//newfob=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna fob");
					}
				}

				this.fob=newfob;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_iva(Double newporcentaje_iva)throws Exception
	{
		try {
			if(this.porcentaje_iva!=newporcentaje_iva) {
				if(newporcentaje_iva==null) {
					//newporcentaje_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna porcentaje_iva");
					}
				}

				this.porcentaje_iva=newporcentaje_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_arancel(Double newporcentaje_arancel)throws Exception
	{
		try {
			if(this.porcentaje_arancel!=newporcentaje_arancel) {
				if(newporcentaje_arancel==null) {
					//newporcentaje_arancel=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna porcentaje_arancel");
					}
				}

				this.porcentaje_arancel=newporcentaje_arancel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_aplicar(Double newporcentaje_aplicar)throws Exception
	{
		try {
			if(this.porcentaje_aplicar!=newporcentaje_aplicar) {
				if(newporcentaje_aplicar==null) {
					//newporcentaje_aplicar=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna porcentaje_aplicar");
					}
				}

				this.porcentaje_aplicar=newporcentaje_aplicar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setflete(Double newflete)throws Exception
	{
		try {
			if(this.flete!=newflete) {
				if(newflete==null) {
					//newflete=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setseguro(Double newseguro)throws Exception
	{
		try {
			if(this.seguro!=newseguro) {
				if(newseguro==null) {
					//newseguro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna seguro");
					}
				}

				this.seguro=newseguro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase_imponible(Double newbase_imponible)throws Exception
	{
		try {
			if(this.base_imponible!=newbase_imponible) {
				if(newbase_imponible==null) {
					//newbase_imponible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna base_imponible");
					}
				}

				this.base_imponible=newbase_imponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_arancel(Double newvalor_arancel)throws Exception
	{
		try {
			if(this.valor_arancel!=newvalor_arancel) {
				if(newvalor_arancel==null) {
					//newvalor_arancel=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna valor_arancel");
					}
				}

				this.valor_arancel=newvalor_arancel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_fodi(Double newvalor_fodi)throws Exception
	{
		try {
			if(this.valor_fodi!=newvalor_fodi) {
				if(newvalor_fodi==null) {
					//newvalor_fodi=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna valor_fodi");
					}
				}

				this.valor_fodi=newvalor_fodi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_iva(Double newvalor_iva)throws Exception
	{
		try {
			if(this.valor_iva!=newvalor_iva) {
				if(newvalor_iva==null) {
					//newvalor_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna valor_iva");
					}
				}

				this.valor_iva=newvalor_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_comprobante(Integer newnumero_comprobante)throws Exception
	{
		try {
			if(this.numero_comprobante!=newnumero_comprobante) {
				if(newnumero_comprobante==null) {
					//newnumero_comprobante=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_fodi(Double newporcentaje_fodi)throws Exception
	{
		try {
			if(this.porcentaje_fodi!=newporcentaje_fodi) {
				if(newporcentaje_fodi==null) {
					//newporcentaje_fodi=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna porcentaje_fodi");
					}
				}

				this.porcentaje_fodi=newporcentaje_fodi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_imponible(Double newvalor_imponible)throws Exception
	{
		try {
			if(this.valor_imponible!=newvalor_imponible) {
				if(newvalor_imponible==null) {
					//newvalor_imponible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpuestoImpor:Valor nulo no permitido en columna valor_imponible");
					}
				}

				this.valor_imponible=newvalor_imponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public LiquidacionImpuestoImpor getLiquidacionImpuestoImpor() {
		return this.liquidacionimpuestoimpor;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	
	
	public String getliquidacionimpuestoimpor_descripcion() {
		return this.liquidacionimpuestoimpor_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	
	
	public  void  setLiquidacionImpuestoImpor(LiquidacionImpuestoImpor liquidacionimpuestoimpor) {
		try {
			this.liquidacionimpuestoimpor=liquidacionimpuestoimpor;
		} catch(Exception e) {
			;
		}
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


	
	
	public  void  setliquidacionimpuestoimpor_descripcion(String liquidacionimpuestoimpor_descripcion) {
		try {
			this.liquidacionimpuestoimpor_descripcion=liquidacionimpuestoimpor_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_liquidacion_impuesto_impor_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";
	
	
	public String getid_liquidacion_impuesto_impor_descripcion() {
		return id_liquidacion_impuesto_impor_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	
	
	public void setid_liquidacion_impuesto_impor_descripcion(String newid_liquidacion_impuesto_impor_descripcion)throws Exception {
		try {
			this.id_liquidacion_impuesto_impor_descripcion=newid_liquidacion_impuesto_impor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
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
	
	public void inicializarVariablesParaReporte() {
		this.id_liquidacion_impuesto_impor_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

