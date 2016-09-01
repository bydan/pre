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
//import com.bydan.erp.importaciones.util.ParametroImporConstantesFunciones;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class ParametroImpor extends ParametroImporAdditional implements Serializable ,Cloneable {//ParametroImporAdditional,GeneralEntity
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
	
	private ParametroImpor parametroimporOriginal;
	
	private Map<String, Object> mapParametroImpor;
			
	public Map<String, Object> getMapParametroImpor() {
		return mapParametroImpor;
	}

	public void setMapParametroImpor(Map<String, Object> mapParametroImpor) {
		this.mapParametroImpor = mapParametroImpor;
	}
	
	public void inicializarMapParametroImpor() {
		this.mapParametroImpor = new HashMap<String,Object>();
	}
	
	public void setMapParametroImporValue(String sKey,Object oValue) {
		this.mapParametroImpor.put(sKey, oValue);
	}
	
	public Object getMapParametroImporValue(String sKey) {
		return this.mapParametroImpor.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_orden_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_orden_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_liquidacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dias_llega_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_seguro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double fodin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double corpei;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroImporConstantesFunciones.SREGEXSECUENCIAL,message=ParametroImporConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_peso_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_conversion;
			
	
	public Empresa empresa;
	public Pais pais;
	public Bodega bodega;
	public CentroCosto centrocosto;
	public CuentaContable cuentacontable;
	public Transaccion transaccionordencompra;
	public Transaccion transaccioningreso;
	public Formato formatoordencompra;
	public Formato formatoingreso;
	public Formato formatopedido;
	public Formato formatoliquidacion;
	
	
	private String empresa_descripcion;
	private String pais_descripcion;
	private String bodega_descripcion;
	private String centrocosto_descripcion;
	private String cuentacontable_descripcion;
	private String transaccionordencompra_descripcion;
	private String transaccioningreso_descripcion;
	private String formatoordencompra_descripcion;
	private String formatoingreso_descripcion;
	private String formatopedido_descripcion;
	private String formatoliquidacion_descripcion;
	
	
		
	public ParametroImpor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametroimporOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_pais=-1L;
 		this.id_bodega=-1L;
 		this.id_centro_costo=null;
 		this.id_cuenta_contable=-1L;
 		this.id_transaccion_orden_compra=-1L;
 		this.id_transaccion_ingreso=-1L;
 		this.id_formato_orden_compra=-1L;
 		this.id_formato_ingreso=-1L;
 		this.id_formato_pedido=-1L;
 		this.id_formato_liquidacion=-1L;
 		this.dias_llega_bodega=0;
 		this.porcentaje_seguro=0.0;
 		this.fodin=0.0;
 		this.corpei=0.0;
 		this.con_secuencial=false;
 		this.secuencial="";
 		this.con_peso_precio=false;
 		this.con_lote=false;
 		this.con_unidad=false;
 		this.con_conversion=false;
		
		
		this.empresa=null;
		this.pais=null;
		this.bodega=null;
		this.centrocosto=null;
		this.cuentacontable=null;
		this.transaccionordencompra=null;
		this.transaccioningreso=null;
		this.formatoordencompra=null;
		this.formatoingreso=null;
		this.formatopedido=null;
		this.formatoliquidacion=null;
		
		
		this.empresa_descripcion="";
		this.pais_descripcion="";
		this.bodega_descripcion="";
		this.centrocosto_descripcion="";
		this.cuentacontable_descripcion="";
		this.transaccionordencompra_descripcion="";
		this.transaccioningreso_descripcion="";
		this.formatoordencompra_descripcion="";
		this.formatoingreso_descripcion="";
		this.formatopedido_descripcion="";
		this.formatoliquidacion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroImpor (Long id,Date versionRow,Long id_empresa,Long id_pais,Long id_bodega,Long id_centro_costo,Long id_cuenta_contable,Long id_transaccion_orden_compra,Long id_transaccion_ingreso,Long id_formato_orden_compra,Long id_formato_ingreso,Long id_formato_pedido,Long id_formato_liquidacion,Integer dias_llega_bodega,Double porcentaje_seguro,Double fodin,Double corpei,Boolean con_secuencial,String secuencial,Boolean con_peso_precio,Boolean con_lote,Boolean con_unidad,Boolean con_conversion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroimporOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_pais=id_pais;
 		this.id_bodega=id_bodega;
 		this.id_centro_costo=id_centro_costo;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_transaccion_orden_compra=id_transaccion_orden_compra;
 		this.id_transaccion_ingreso=id_transaccion_ingreso;
 		this.id_formato_orden_compra=id_formato_orden_compra;
 		this.id_formato_ingreso=id_formato_ingreso;
 		this.id_formato_pedido=id_formato_pedido;
 		this.id_formato_liquidacion=id_formato_liquidacion;
 		this.dias_llega_bodega=dias_llega_bodega;
 		this.porcentaje_seguro=porcentaje_seguro;
 		this.fodin=fodin;
 		this.corpei=corpei;
 		this.con_secuencial=con_secuencial;
 		this.secuencial=secuencial;
 		this.con_peso_precio=con_peso_precio;
 		this.con_lote=con_lote;
 		this.con_unidad=con_unidad;
 		this.con_conversion=con_conversion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroImpor (Long id_empresa,Long id_pais,Long id_bodega,Long id_centro_costo,Long id_cuenta_contable,Long id_transaccion_orden_compra,Long id_transaccion_ingreso,Long id_formato_orden_compra,Long id_formato_ingreso,Long id_formato_pedido,Long id_formato_liquidacion,Integer dias_llega_bodega,Double porcentaje_seguro,Double fodin,Double corpei,Boolean con_secuencial,String secuencial,Boolean con_peso_precio,Boolean con_lote,Boolean con_unidad,Boolean con_conversion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroimporOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_pais=id_pais;
 		this.id_bodega=id_bodega;
 		this.id_centro_costo=id_centro_costo;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_transaccion_orden_compra=id_transaccion_orden_compra;
 		this.id_transaccion_ingreso=id_transaccion_ingreso;
 		this.id_formato_orden_compra=id_formato_orden_compra;
 		this.id_formato_ingreso=id_formato_ingreso;
 		this.id_formato_pedido=id_formato_pedido;
 		this.id_formato_liquidacion=id_formato_liquidacion;
 		this.dias_llega_bodega=dias_llega_bodega;
 		this.porcentaje_seguro=porcentaje_seguro;
 		this.fodin=fodin;
 		this.corpei=corpei;
 		this.con_secuencial=con_secuencial;
 		this.secuencial=secuencial;
 		this.con_peso_precio=con_peso_precio;
 		this.con_lote=con_lote;
 		this.con_unidad=con_unidad;
 		this.con_conversion=con_conversion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroImpor parametroimporLocal=null;
		
		if(object!=null) {
			parametroimporLocal=(ParametroImpor)object;
			
			if(parametroimporLocal!=null) {
				if(this.getId()!=null && parametroimporLocal.getId()!=null) {
					if(this.getId().equals(parametroimporLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroImporConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroImporConstantesFunciones.getParametroImporDescripcion(this);
		} else {
			sDetalle=ParametroImporConstantesFunciones.getParametroImporDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroImpor getParametroImporOriginal() {
		return this.parametroimporOriginal;
	}
	
	public void setParametroImporOriginal(ParametroImpor parametroimpor) {
		try {
			this.parametroimporOriginal=parametroimpor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroImporAdditional parametroimporAdditional=null;
	
	public ParametroImporAdditional getParametroImporAdditional() {
		return this.parametroimporAdditional;
	}
	
	public void setParametroImporAdditional(ParametroImporAdditional parametroimporAdditional) {
		try {
			this.parametroimporAdditional=parametroimporAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_transaccion_orden_compra() {
		return this.id_transaccion_orden_compra;
	}
    
	
	public Long getid_transaccion_ingreso() {
		return this.id_transaccion_ingreso;
	}
    
	
	public Long getid_formato_orden_compra() {
		return this.id_formato_orden_compra;
	}
    
	
	public Long getid_formato_ingreso() {
		return this.id_formato_ingreso;
	}
    
	
	public Long getid_formato_pedido() {
		return this.id_formato_pedido;
	}
    
	
	public Long getid_formato_liquidacion() {
		return this.id_formato_liquidacion;
	}
    
	
	public Integer getdias_llega_bodega() {
		return this.dias_llega_bodega;
	}
    
	
	public Double getporcentaje_seguro() {
		return this.porcentaje_seguro;
	}
    
	
	public Double getfodin() {
		return this.fodin;
	}
    
	
	public Double getcorpei() {
		return this.corpei;
	}
    
	
	public Boolean getcon_secuencial() {
		return this.con_secuencial;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Boolean getcon_peso_precio() {
		return this.con_peso_precio;
	}
    
	
	public Boolean getcon_lote() {
		return this.con_lote;
	}
    
	
	public Boolean getcon_unidad() {
		return this.con_unidad;
	}
    
	
	public Boolean getcon_conversion() {
		return this.con_conversion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega(Long newid_bodega)throws Exception
	{
		try {
			if(this.id_bodega!=newid_bodega) {
				if(newid_bodega==null) {
					//newid_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_costo(Long newid_centro_costo) {
		if(this.id_centro_costo==null&&newid_centro_costo!=null) {
			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}

		if(this.id_centro_costo!=null&&!this.id_centro_costo.equals(newid_centro_costo)) {

			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_orden_compra(Long newid_transaccion_orden_compra)throws Exception
	{
		try {
			if(this.id_transaccion_orden_compra!=newid_transaccion_orden_compra) {
				if(newid_transaccion_orden_compra==null) {
					//newid_transaccion_orden_compra=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna id_transaccion_orden_compra");
					}
				}

				this.id_transaccion_orden_compra=newid_transaccion_orden_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_ingreso(Long newid_transaccion_ingreso)throws Exception
	{
		try {
			if(this.id_transaccion_ingreso!=newid_transaccion_ingreso) {
				if(newid_transaccion_ingreso==null) {
					//newid_transaccion_ingreso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna id_transaccion_ingreso");
					}
				}

				this.id_transaccion_ingreso=newid_transaccion_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_orden_compra(Long newid_formato_orden_compra)throws Exception
	{
		try {
			if(this.id_formato_orden_compra!=newid_formato_orden_compra) {
				if(newid_formato_orden_compra==null) {
					//newid_formato_orden_compra=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna id_formato_orden_compra");
					}
				}

				this.id_formato_orden_compra=newid_formato_orden_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_ingreso(Long newid_formato_ingreso)throws Exception
	{
		try {
			if(this.id_formato_ingreso!=newid_formato_ingreso) {
				if(newid_formato_ingreso==null) {
					//newid_formato_ingreso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna id_formato_ingreso");
					}
				}

				this.id_formato_ingreso=newid_formato_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_pedido(Long newid_formato_pedido)throws Exception
	{
		try {
			if(this.id_formato_pedido!=newid_formato_pedido) {
				if(newid_formato_pedido==null) {
					//newid_formato_pedido=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna id_formato_pedido");
					}
				}

				this.id_formato_pedido=newid_formato_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_liquidacion(Long newid_formato_liquidacion)throws Exception
	{
		try {
			if(this.id_formato_liquidacion!=newid_formato_liquidacion) {
				if(newid_formato_liquidacion==null) {
					//newid_formato_liquidacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna id_formato_liquidacion");
					}
				}

				this.id_formato_liquidacion=newid_formato_liquidacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_llega_bodega(Integer newdias_llega_bodega)throws Exception
	{
		try {
			if(this.dias_llega_bodega!=newdias_llega_bodega) {
				if(newdias_llega_bodega==null) {
					//newdias_llega_bodega=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna dias_llega_bodega");
					}
				}

				this.dias_llega_bodega=newdias_llega_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_seguro(Double newporcentaje_seguro)throws Exception
	{
		try {
			if(this.porcentaje_seguro!=newporcentaje_seguro) {
				if(newporcentaje_seguro==null) {
					//newporcentaje_seguro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna porcentaje_seguro");
					}
				}

				this.porcentaje_seguro=newporcentaje_seguro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfodin(Double newfodin)throws Exception
	{
		try {
			if(this.fodin!=newfodin) {
				if(newfodin==null) {
					//newfodin=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna fodin");
					}
				}

				this.fodin=newfodin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcorpei(Double newcorpei)throws Exception
	{
		try {
			if(this.corpei!=newcorpei) {
				if(newcorpei==null) {
					//newcorpei=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna corpei");
					}
				}

				this.corpei=newcorpei;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_secuencial(Boolean newcon_secuencial)throws Exception
	{
		try {
			if(this.con_secuencial!=newcon_secuencial) {
				if(newcon_secuencial==null) {
					//newcon_secuencial=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna con_secuencial");
					}
				}

				this.con_secuencial=newcon_secuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(String newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("ParametroImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_peso_precio(Boolean newcon_peso_precio)throws Exception
	{
		try {
			if(this.con_peso_precio!=newcon_peso_precio) {
				if(newcon_peso_precio==null) {
					//newcon_peso_precio=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna con_peso_precio");
					}
				}

				this.con_peso_precio=newcon_peso_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_lote(Boolean newcon_lote)throws Exception
	{
		try {
			if(this.con_lote!=newcon_lote) {
				if(newcon_lote==null) {
					//newcon_lote=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna con_lote");
					}
				}

				this.con_lote=newcon_lote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_unidad(Boolean newcon_unidad)throws Exception
	{
		try {
			if(this.con_unidad!=newcon_unidad) {
				if(newcon_unidad==null) {
					//newcon_unidad=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna con_unidad");
					}
				}

				this.con_unidad=newcon_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_conversion(Boolean newcon_conversion)throws Exception
	{
		try {
			if(this.con_conversion!=newcon_conversion) {
				if(newcon_conversion==null) {
					//newcon_conversion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroImpor:Valor nulo no permitido en columna con_conversion");
					}
				}

				this.con_conversion=newcon_conversion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public Transaccion getTransaccionOrdenCompra() {
		return this.transaccionordencompra;
	}

	public Transaccion getTransaccionIngreso() {
		return this.transaccioningreso;
	}

	public Formato getFormatoOrdenCompra() {
		return this.formatoordencompra;
	}

	public Formato getFormatoIngreso() {
		return this.formatoingreso;
	}

	public Formato getFormatoPedido() {
		return this.formatopedido;
	}

	public Formato getFormatoLiquidacion() {
		return this.formatoliquidacion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String gettransaccionordencompra_descripcion() {
		return this.transaccionordencompra_descripcion;
	}

	public String gettransaccioningreso_descripcion() {
		return this.transaccioningreso_descripcion;
	}

	public String getformatoordencompra_descripcion() {
		return this.formatoordencompra_descripcion;
	}

	public String getformatoingreso_descripcion() {
		return this.formatoingreso_descripcion;
	}

	public String getformatopedido_descripcion() {
		return this.formatopedido_descripcion;
	}

	public String getformatoliquidacion_descripcion() {
		return this.formatoliquidacion_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodega(Bodega bodega) {
		try {
			this.bodega=bodega;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
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


	public  void  setTransaccionOrdenCompra(Transaccion transaccionordencompra) {
		try {
			this.transaccionordencompra=transaccionordencompra;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionIngreso(Transaccion transaccioningreso) {
		try {
			this.transaccioningreso=transaccioningreso;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoOrdenCompra(Formato formatoordencompra) {
		try {
			this.formatoordencompra=formatoordencompra;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoIngreso(Formato formatoingreso) {
		try {
			this.formatoingreso=formatoingreso;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoPedido(Formato formatopedido) {
		try {
			this.formatopedido=formatopedido;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoLiquidacion(Formato formatoliquidacion) {
		try {
			this.formatoliquidacion=formatoliquidacion;
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


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodega_descripcion(String bodega_descripcion) {
		try {
			this.bodega_descripcion=bodega_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
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


	public  void  settransaccionordencompra_descripcion(String transaccionordencompra_descripcion) {
		try {
			this.transaccionordencompra_descripcion=transaccionordencompra_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioningreso_descripcion(String transaccioningreso_descripcion) {
		try {
			this.transaccioningreso_descripcion=transaccioningreso_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoordencompra_descripcion(String formatoordencompra_descripcion) {
		try {
			this.formatoordencompra_descripcion=formatoordencompra_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoingreso_descripcion(String formatoingreso_descripcion) {
		try {
			this.formatoingreso_descripcion=formatoingreso_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatopedido_descripcion(String formatopedido_descripcion) {
		try {
			this.formatopedido_descripcion=formatopedido_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatoliquidacion_descripcion(String formatoliquidacion_descripcion) {
		try {
			this.formatoliquidacion_descripcion=formatoliquidacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_pais_descripcion="";String id_bodega_descripcion="";String id_centro_costo_descripcion="";String id_cuenta_contable_descripcion="";String id_transaccion_orden_compra_descripcion="";String id_transaccion_ingreso_descripcion="";String id_formato_orden_compra_descripcion="";String id_formato_ingreso_descripcion="";String id_formato_pedido_descripcion="";String id_formato_liquidacion_descripcion="";String con_secuencial_descripcion="";String con_peso_precio_descripcion="";String con_lote_descripcion="";String con_unidad_descripcion="";String con_conversion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_transaccion_orden_compra_descripcion() {
		return id_transaccion_orden_compra_descripcion;
	}
	public String getid_transaccion_ingreso_descripcion() {
		return id_transaccion_ingreso_descripcion;
	}
	public String getid_formato_orden_compra_descripcion() {
		return id_formato_orden_compra_descripcion;
	}
	public String getid_formato_ingreso_descripcion() {
		return id_formato_ingreso_descripcion;
	}
	public String getid_formato_pedido_descripcion() {
		return id_formato_pedido_descripcion;
	}
	public String getid_formato_liquidacion_descripcion() {
		return id_formato_liquidacion_descripcion;
	}
	public String getcon_secuencial_descripcion() {
		return con_secuencial_descripcion;
	}
	public String getcon_peso_precio_descripcion() {
		return con_peso_precio_descripcion;
	}
	public String getcon_lote_descripcion() {
		return con_lote_descripcion;
	}
	public String getcon_unidad_descripcion() {
		return con_unidad_descripcion;
	}
	public String getcon_conversion_descripcion() {
		return con_conversion_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_descripcion(String newid_bodega_descripcion)throws Exception {
		try {
			this.id_bodega_descripcion=newid_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
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
	public void setid_transaccion_orden_compra_descripcion(String newid_transaccion_orden_compra_descripcion)throws Exception {
		try {
			this.id_transaccion_orden_compra_descripcion=newid_transaccion_orden_compra_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_ingreso_descripcion(String newid_transaccion_ingreso_descripcion)throws Exception {
		try {
			this.id_transaccion_ingreso_descripcion=newid_transaccion_ingreso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_orden_compra_descripcion(String newid_formato_orden_compra_descripcion)throws Exception {
		try {
			this.id_formato_orden_compra_descripcion=newid_formato_orden_compra_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_ingreso_descripcion(String newid_formato_ingreso_descripcion)throws Exception {
		try {
			this.id_formato_ingreso_descripcion=newid_formato_ingreso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_pedido_descripcion(String newid_formato_pedido_descripcion)throws Exception {
		try {
			this.id_formato_pedido_descripcion=newid_formato_pedido_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_liquidacion_descripcion(String newid_formato_liquidacion_descripcion)throws Exception {
		try {
			this.id_formato_liquidacion_descripcion=newid_formato_liquidacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_secuencial_descripcion(String newcon_secuencial_descripcion)throws Exception {
		try {
			this.con_secuencial_descripcion=newcon_secuencial_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_peso_precio_descripcion(String newcon_peso_precio_descripcion)throws Exception {
		try {
			this.con_peso_precio_descripcion=newcon_peso_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_lote_descripcion(String newcon_lote_descripcion)throws Exception {
		try {
			this.con_lote_descripcion=newcon_lote_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_unidad_descripcion(String newcon_unidad_descripcion)throws Exception {
		try {
			this.con_unidad_descripcion=newcon_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_conversion_descripcion(String newcon_conversion_descripcion)throws Exception {
		try {
			this.con_conversion_descripcion=newcon_conversion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_pais_descripcion="";this.id_bodega_descripcion="";this.id_centro_costo_descripcion="";this.id_cuenta_contable_descripcion="";this.id_transaccion_orden_compra_descripcion="";this.id_transaccion_ingreso_descripcion="";this.id_formato_orden_compra_descripcion="";this.id_formato_ingreso_descripcion="";this.id_formato_pedido_descripcion="";this.id_formato_liquidacion_descripcion="";this.con_secuencial_descripcion="";this.con_peso_precio_descripcion="";this.con_lote_descripcion="";this.con_unidad_descripcion="";this.con_conversion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

