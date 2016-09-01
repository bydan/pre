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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.ParametroFactuSecuencialConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class ParametroFactuSecuencial extends ParametroFactuSecuencialAdditional implements Serializable ,Cloneable {//ParametroFactuSecuencialAdditional,GeneralEntity
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
	
	private ParametroFactuSecuencial parametrofactusecuencialOriginal;
	
	private Map<String, Object> mapParametroFactuSecuencial;
			
	public Map<String, Object> getMapParametroFactuSecuencial() {
		return mapParametroFactuSecuencial;
	}

	public void setMapParametroFactuSecuencial(Map<String, Object> mapParametroFactuSecuencial) {
		this.mapParametroFactuSecuencial = mapParametroFactuSecuencial;
	}
	
	public void inicializarMapParametroFactuSecuencial() {
		this.mapParametroFactuSecuencial = new HashMap<String,Object>();
	}
	
	public void setMapParametroFactuSecuencialValue(String sKey,Object oValue) {
		this.mapParametroFactuSecuencial.put(sKey, oValue);
	}
	
	public Object getMapParametroFactuSecuencialValue(String sKey) {
		return this.mapParametroFactuSecuencial.get(sKey);
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
	private Long id_tipo_documento_general;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroFactuSecuencialConstantesFunciones.SREGEXSECUENCIAL,message=ParametroFactuSecuencialConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_digitos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_items;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_adiicionales;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_digito_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_digito_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_dias_plazo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_lector;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_param_factu_plazo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_transferencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_transferencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_transferencia;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TipoDocumentoGeneral tipodocumentogeneral;
	public Bodega bodega;
	public TipoParamFactuPlazo tipoparamfactuplazo;
	public Formato formato;
	public Bodega bodegatransferencia;
	public Transaccion transacciontransferencia;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tipodocumentogeneral_descripcion;
	private String bodega_descripcion;
	private String tipoparamfactuplazo_descripcion;
	private String formato_descripcion;
	private String bodegatransferencia_descripcion;
	private String transacciontransferencia_descripcion;
	
	
		
	public ParametroFactuSecuencial () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrofactusecuencialOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_tipo_documento_general=-1L;
 		this.secuencial="";
 		this.numero_digitos=0;
 		this.numero_items=0;
 		this.numero_descuento=0;
 		this.numero_adiicionales=0;
 		this.numero_digito_inicio=0;
 		this.numero_digito_fin=0;
 		this.numero_dias_plazo=0;
 		this.con_detalle=false;
 		this.con_lector=false;
 		this.id_bodega=-1L;
 		this.id_tipo_param_factu_plazo=-1L;
 		this.id_formato=-1L;
 		this.con_transferencia=false;
 		this.id_bodega_transferencia=-1L;
 		this.id_transaccion_transferencia=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tipodocumentogeneral=null;
		this.bodega=null;
		this.tipoparamfactuplazo=null;
		this.formato=null;
		this.bodegatransferencia=null;
		this.transacciontransferencia=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tipodocumentogeneral_descripcion="";
		this.bodega_descripcion="";
		this.tipoparamfactuplazo_descripcion="";
		this.formato_descripcion="";
		this.bodegatransferencia_descripcion="";
		this.transacciontransferencia_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroFactuSecuencial (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_tipo_documento_general,String secuencial,Integer numero_digitos,Integer numero_items,Integer numero_descuento,Integer numero_adiicionales,Integer numero_digito_inicio,Integer numero_digito_fin,Integer numero_dias_plazo,Boolean con_detalle,Boolean con_lector,Long id_bodega,Long id_tipo_param_factu_plazo,Long id_formato,Boolean con_transferencia,Long id_bodega_transferencia,Long id_transaccion_transferencia) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofactusecuencialOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_documento_general=id_tipo_documento_general;
 		this.secuencial=secuencial;
 		this.numero_digitos=numero_digitos;
 		this.numero_items=numero_items;
 		this.numero_descuento=numero_descuento;
 		this.numero_adiicionales=numero_adiicionales;
 		this.numero_digito_inicio=numero_digito_inicio;
 		this.numero_digito_fin=numero_digito_fin;
 		this.numero_dias_plazo=numero_dias_plazo;
 		this.con_detalle=con_detalle;
 		this.con_lector=con_lector;
 		this.id_bodega=id_bodega;
 		this.id_tipo_param_factu_plazo=id_tipo_param_factu_plazo;
 		this.id_formato=id_formato;
 		this.con_transferencia=con_transferencia;
 		this.id_bodega_transferencia=id_bodega_transferencia;
 		this.id_transaccion_transferencia=id_transaccion_transferencia;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroFactuSecuencial (Long id_empresa,Long id_sucursal,Long id_tipo_documento_general,String secuencial,Integer numero_digitos,Integer numero_items,Integer numero_descuento,Integer numero_adiicionales,Integer numero_digito_inicio,Integer numero_digito_fin,Integer numero_dias_plazo,Boolean con_detalle,Boolean con_lector,Long id_bodega,Long id_tipo_param_factu_plazo,Long id_formato,Boolean con_transferencia,Long id_bodega_transferencia,Long id_transaccion_transferencia) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofactusecuencialOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_documento_general=id_tipo_documento_general;
 		this.secuencial=secuencial;
 		this.numero_digitos=numero_digitos;
 		this.numero_items=numero_items;
 		this.numero_descuento=numero_descuento;
 		this.numero_adiicionales=numero_adiicionales;
 		this.numero_digito_inicio=numero_digito_inicio;
 		this.numero_digito_fin=numero_digito_fin;
 		this.numero_dias_plazo=numero_dias_plazo;
 		this.con_detalle=con_detalle;
 		this.con_lector=con_lector;
 		this.id_bodega=id_bodega;
 		this.id_tipo_param_factu_plazo=id_tipo_param_factu_plazo;
 		this.id_formato=id_formato;
 		this.con_transferencia=con_transferencia;
 		this.id_bodega_transferencia=id_bodega_transferencia;
 		this.id_transaccion_transferencia=id_transaccion_transferencia;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroFactuSecuencial parametrofactusecuencialLocal=null;
		
		if(object!=null) {
			parametrofactusecuencialLocal=(ParametroFactuSecuencial)object;
			
			if(parametrofactusecuencialLocal!=null) {
				if(this.getId()!=null && parametrofactusecuencialLocal.getId()!=null) {
					if(this.getId().equals(parametrofactusecuencialLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroFactuSecuencialConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroFactuSecuencialConstantesFunciones.getParametroFactuSecuencialDescripcion(this);
		} else {
			sDetalle=ParametroFactuSecuencialConstantesFunciones.getParametroFactuSecuencialDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroFactuSecuencial getParametroFactuSecuencialOriginal() {
		return this.parametrofactusecuencialOriginal;
	}
	
	public void setParametroFactuSecuencialOriginal(ParametroFactuSecuencial parametrofactusecuencial) {
		try {
			this.parametrofactusecuencialOriginal=parametrofactusecuencial;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroFactuSecuencialAdditional parametrofactusecuencialAdditional=null;
	
	public ParametroFactuSecuencialAdditional getParametroFactuSecuencialAdditional() {
		return this.parametrofactusecuencialAdditional;
	}
	
	public void setParametroFactuSecuencialAdditional(ParametroFactuSecuencialAdditional parametrofactusecuencialAdditional) {
		try {
			this.parametrofactusecuencialAdditional=parametrofactusecuencialAdditional;
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
    
	
	public Long getid_tipo_documento_general() {
		return this.id_tipo_documento_general;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Integer getnumero_digitos() {
		return this.numero_digitos;
	}
    
	
	public Integer getnumero_items() {
		return this.numero_items;
	}
    
	
	public Integer getnumero_descuento() {
		return this.numero_descuento;
	}
    
	
	public Integer getnumero_adiicionales() {
		return this.numero_adiicionales;
	}
    
	
	public Integer getnumero_digito_inicio() {
		return this.numero_digito_inicio;
	}
    
	
	public Integer getnumero_digito_fin() {
		return this.numero_digito_fin;
	}
    
	
	public Integer getnumero_dias_plazo() {
		return this.numero_dias_plazo;
	}
    
	
	public Boolean getcon_detalle() {
		return this.con_detalle;
	}
    
	
	public Boolean getcon_lector() {
		return this.con_lector;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_tipo_param_factu_plazo() {
		return this.id_tipo_param_factu_plazo;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Boolean getcon_transferencia() {
		return this.con_transferencia;
	}
    
	
	public Long getid_bodega_transferencia() {
		return this.id_bodega_transferencia;
	}
    
	
	public Long getid_transaccion_transferencia() {
		return this.id_transaccion_transferencia;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento_general(Long newid_tipo_documento_general)throws Exception
	{
		try {
			if(this.id_tipo_documento_general!=newid_tipo_documento_general) {
				if(newid_tipo_documento_general==null) {
					//newid_tipo_documento_general=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna id_tipo_documento_general");
					}
				}

				this.id_tipo_documento_general=newid_tipo_documento_general;
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
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("ParametroFactuSecuencial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_digitos(Integer newnumero_digitos)throws Exception
	{
		try {
			if(this.numero_digitos!=newnumero_digitos) {
				if(newnumero_digitos==null) {
					//newnumero_digitos=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna numero_digitos");
					}
				}

				this.numero_digitos=newnumero_digitos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_items(Integer newnumero_items)throws Exception
	{
		try {
			if(this.numero_items!=newnumero_items) {
				if(newnumero_items==null) {
					//newnumero_items=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna numero_items");
					}
				}

				this.numero_items=newnumero_items;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_descuento(Integer newnumero_descuento)throws Exception
	{
		try {
			if(this.numero_descuento!=newnumero_descuento) {
				if(newnumero_descuento==null) {
					//newnumero_descuento=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna numero_descuento");
					}
				}

				this.numero_descuento=newnumero_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_adiicionales(Integer newnumero_adiicionales)throws Exception
	{
		try {
			if(this.numero_adiicionales!=newnumero_adiicionales) {
				if(newnumero_adiicionales==null) {
					//newnumero_adiicionales=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna numero_adiicionales");
					}
				}

				this.numero_adiicionales=newnumero_adiicionales;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_digito_inicio(Integer newnumero_digito_inicio)throws Exception
	{
		try {
			if(this.numero_digito_inicio!=newnumero_digito_inicio) {
				if(newnumero_digito_inicio==null) {
					//newnumero_digito_inicio=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna numero_digito_inicio");
					}
				}

				this.numero_digito_inicio=newnumero_digito_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_digito_fin(Integer newnumero_digito_fin)throws Exception
	{
		try {
			if(this.numero_digito_fin!=newnumero_digito_fin) {
				if(newnumero_digito_fin==null) {
					//newnumero_digito_fin=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna numero_digito_fin");
					}
				}

				this.numero_digito_fin=newnumero_digito_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dias_plazo(Integer newnumero_dias_plazo)throws Exception
	{
		try {
			if(this.numero_dias_plazo!=newnumero_dias_plazo) {
				if(newnumero_dias_plazo==null) {
					//newnumero_dias_plazo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna numero_dias_plazo");
					}
				}

				this.numero_dias_plazo=newnumero_dias_plazo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_detalle(Boolean newcon_detalle)throws Exception
	{
		try {
			if(this.con_detalle!=newcon_detalle) {
				if(newcon_detalle==null) {
					//newcon_detalle=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna con_detalle");
					}
				}

				this.con_detalle=newcon_detalle;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_lector(Boolean newcon_lector)throws Exception
	{
		try {
			if(this.con_lector!=newcon_lector) {
				if(newcon_lector==null) {
					//newcon_lector=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna con_lector");
					}
				}

				this.con_lector=newcon_lector;
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
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_param_factu_plazo(Long newid_tipo_param_factu_plazo)throws Exception
	{
		try {
			if(this.id_tipo_param_factu_plazo!=newid_tipo_param_factu_plazo) {
				if(newid_tipo_param_factu_plazo==null) {
					//newid_tipo_param_factu_plazo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna id_tipo_param_factu_plazo");
					}
				}

				this.id_tipo_param_factu_plazo=newid_tipo_param_factu_plazo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato)throws Exception
	{
		try {
			if(this.id_formato!=newid_formato) {
				if(newid_formato==null) {
					//newid_formato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_transferencia(Boolean newcon_transferencia)throws Exception
	{
		try {
			if(this.con_transferencia!=newcon_transferencia) {
				if(newcon_transferencia==null) {
					//newcon_transferencia=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna con_transferencia");
					}
				}

				this.con_transferencia=newcon_transferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_transferencia(Long newid_bodega_transferencia)throws Exception
	{
		try {
			if(this.id_bodega_transferencia!=newid_bodega_transferencia) {
				if(newid_bodega_transferencia==null) {
					//newid_bodega_transferencia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna id_bodega_transferencia");
					}
				}

				this.id_bodega_transferencia=newid_bodega_transferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_transferencia(Long newid_transaccion_transferencia)throws Exception
	{
		try {
			if(this.id_transaccion_transferencia!=newid_transaccion_transferencia) {
				if(newid_transaccion_transferencia==null) {
					//newid_transaccion_transferencia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuSecuencial:Valor nulo no permitido en columna id_transaccion_transferencia");
					}
				}

				this.id_transaccion_transferencia=newid_transaccion_transferencia;
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

	public TipoDocumentoGeneral getTipoDocumentoGeneral() {
		return this.tipodocumentogeneral;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public TipoParamFactuPlazo getTipoParamFactuPlazo() {
		return this.tipoparamfactuplazo;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public Bodega getBodegaTransferencia() {
		return this.bodegatransferencia;
	}

	public Transaccion getTransaccionTransferencia() {
		return this.transacciontransferencia;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettipodocumentogeneral_descripcion() {
		return this.tipodocumentogeneral_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String gettipoparamfactuplazo_descripcion() {
		return this.tipoparamfactuplazo_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getbodegatransferencia_descripcion() {
		return this.bodegatransferencia_descripcion;
	}

	public String gettransacciontransferencia_descripcion() {
		return this.transacciontransferencia_descripcion;
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


	public  void  setTipoDocumentoGeneral(TipoDocumentoGeneral tipodocumentogeneral) {
		try {
			this.tipodocumentogeneral=tipodocumentogeneral;
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


	public  void  setTipoParamFactuPlazo(TipoParamFactuPlazo tipoparamfactuplazo) {
		try {
			this.tipoparamfactuplazo=tipoparamfactuplazo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato(Formato formato) {
		try {
			this.formato=formato;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodegaTransferencia(Bodega bodegatransferencia) {
		try {
			this.bodegatransferencia=bodegatransferencia;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionTransferencia(Transaccion transacciontransferencia) {
		try {
			this.transacciontransferencia=transacciontransferencia;
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


	public  void  settipodocumentogeneral_descripcion(String tipodocumentogeneral_descripcion) {
		try {
			this.tipodocumentogeneral_descripcion=tipodocumentogeneral_descripcion;
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


	public  void  settipoparamfactuplazo_descripcion(String tipoparamfactuplazo_descripcion) {
		try {
			this.tipoparamfactuplazo_descripcion=tipoparamfactuplazo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformato_descripcion(String formato_descripcion) {
		try {
			this.formato_descripcion=formato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodegatransferencia_descripcion(String bodegatransferencia_descripcion) {
		try {
			this.bodegatransferencia_descripcion=bodegatransferencia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransacciontransferencia_descripcion(String transacciontransferencia_descripcion) {
		try {
			this.transacciontransferencia_descripcion=transacciontransferencia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tipo_documento_general_descripcion="";String con_detalle_descripcion="";String con_lector_descripcion="";String id_bodega_descripcion="";String id_tipo_param_factu_plazo_descripcion="";String id_formato_descripcion="";String con_transferencia_descripcion="";String id_bodega_transferencia_descripcion="";String id_transaccion_transferencia_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_documento_general_descripcion() {
		return id_tipo_documento_general_descripcion;
	}
	public String getcon_detalle_descripcion() {
		return con_detalle_descripcion;
	}
	public String getcon_lector_descripcion() {
		return con_lector_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_tipo_param_factu_plazo_descripcion() {
		return id_tipo_param_factu_plazo_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getcon_transferencia_descripcion() {
		return con_transferencia_descripcion;
	}
	public String getid_bodega_transferencia_descripcion() {
		return id_bodega_transferencia_descripcion;
	}
	public String getid_transaccion_transferencia_descripcion() {
		return id_transaccion_transferencia_descripcion;
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
	public void setid_tipo_documento_general_descripcion(String newid_tipo_documento_general_descripcion)throws Exception {
		try {
			this.id_tipo_documento_general_descripcion=newid_tipo_documento_general_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_detalle_descripcion(String newcon_detalle_descripcion)throws Exception {
		try {
			this.con_detalle_descripcion=newcon_detalle_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_lector_descripcion(String newcon_lector_descripcion)throws Exception {
		try {
			this.con_lector_descripcion=newcon_lector_descripcion;
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
	public void setid_tipo_param_factu_plazo_descripcion(String newid_tipo_param_factu_plazo_descripcion)throws Exception {
		try {
			this.id_tipo_param_factu_plazo_descripcion=newid_tipo_param_factu_plazo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_descripcion(String newid_formato_descripcion)throws Exception {
		try {
			this.id_formato_descripcion=newid_formato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_transferencia_descripcion(String newcon_transferencia_descripcion)throws Exception {
		try {
			this.con_transferencia_descripcion=newcon_transferencia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_transferencia_descripcion(String newid_bodega_transferencia_descripcion)throws Exception {
		try {
			this.id_bodega_transferencia_descripcion=newid_bodega_transferencia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_transferencia_descripcion(String newid_transaccion_transferencia_descripcion)throws Exception {
		try {
			this.id_transaccion_transferencia_descripcion=newid_transaccion_transferencia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_documento_general_descripcion="";this.con_detalle_descripcion="";this.con_lector_descripcion="";this.id_bodega_descripcion="";this.id_tipo_param_factu_plazo_descripcion="";this.id_formato_descripcion="";this.con_transferencia_descripcion="";this.id_bodega_transferencia_descripcion="";this.id_transaccion_transferencia_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

