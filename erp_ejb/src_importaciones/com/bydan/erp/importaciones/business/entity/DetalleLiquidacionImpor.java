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
//import com.bydan.erp.importaciones.util.DetalleLiquidacionImporConstantesFunciones;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleLiquidacionImpor extends DetalleLiquidacionImporAdditional implements Serializable ,Cloneable {//DetalleLiquidacionImporAdditional,GeneralEntity
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
	
	private DetalleLiquidacionImpor detalleliquidacionimporOriginal;
	
	private Map<String, Object> mapDetalleLiquidacionImpor;
			
	public Map<String, Object> getMapDetalleLiquidacionImpor() {
		return mapDetalleLiquidacionImpor;
	}

	public void setMapDetalleLiquidacionImpor(Map<String, Object> mapDetalleLiquidacionImpor) {
		this.mapDetalleLiquidacionImpor = mapDetalleLiquidacionImpor;
	}
	
	public void inicializarMapDetalleLiquidacionImpor() {
		this.mapDetalleLiquidacionImpor = new HashMap<String,Object>();
	}
	
	public void setMapDetalleLiquidacionImporValue(String sKey,Object oValue) {
		this.mapDetalleLiquidacionImpor.put(sKey, oValue);
	}
	
	public Object getMapDetalleLiquidacionImporValue(String sKey) {
		return this.mapDetalleLiquidacionImpor.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_liquidacion_impor;
	
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
	private Long id_usuario;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_costo_gasto_impor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleLiquidacionImporConstantesFunciones.SREGEXREFERENCIA,message=DetalleLiquidacionImporConstantesFunciones.SMENSAJEREGEXREFERENCIA)
	private String referencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto4;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto5;
			
	
	public LiquidacionImpor liquidacionimpor;
	public Empresa empresa;
	public Sucursal sucursal;
	public Usuario usuario;
	public CentroCosto centrocosto;
	public CostoGastoImpor costogastoimpor;
	
	
	private String liquidacionimpor_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String usuario_descripcion;
	private String centrocosto_descripcion;
	private String costogastoimpor_descripcion;
	
	
		
	public DetalleLiquidacionImpor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleliquidacionimporOriginal=this;
		
 		this.id_liquidacion_impor=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_usuario=-1L;
 		this.id_centro_costo=null;
 		this.id_costo_gasto_impor=-1L;
 		this.valor=0.0;
 		this.fecha=new Date();
 		this.referencia="";
 		this.impuesto=0.0;
 		this.impuesto2=0.0;
 		this.impuesto3=0.0;
 		this.impuesto4=0.0;
 		this.impuesto5=0.0;
		
		
		this.liquidacionimpor=null;
		this.empresa=null;
		this.sucursal=null;
		this.usuario=null;
		this.centrocosto=null;
		this.costogastoimpor=null;
		
		
		this.liquidacionimpor_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.usuario_descripcion="";
		this.centrocosto_descripcion="";
		this.costogastoimpor_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleLiquidacionImpor (Long id,Date versionRow,Long id_liquidacion_impor,Long id_empresa,Long id_sucursal,Long id_usuario,Long id_centro_costo,Long id_costo_gasto_impor,Double valor,Date fecha,String referencia,Double impuesto,Double impuesto2,Double impuesto3,Double impuesto4,Double impuesto5) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleliquidacionimporOriginal=this;
		
 		this.id_liquidacion_impor=id_liquidacion_impor;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_centro_costo=id_centro_costo;
 		this.id_costo_gasto_impor=id_costo_gasto_impor;
 		this.valor=valor;
 		this.fecha=fecha;
 		this.referencia=referencia;
 		this.impuesto=impuesto;
 		this.impuesto2=impuesto2;
 		this.impuesto3=impuesto3;
 		this.impuesto4=impuesto4;
 		this.impuesto5=impuesto5;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleLiquidacionImpor (Long id_liquidacion_impor,Long id_empresa,Long id_sucursal,Long id_usuario,Long id_centro_costo,Long id_costo_gasto_impor,Double valor,Date fecha,String referencia,Double impuesto,Double impuesto2,Double impuesto3,Double impuesto4,Double impuesto5) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleliquidacionimporOriginal=this;
		
 		this.id_liquidacion_impor=id_liquidacion_impor;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_centro_costo=id_centro_costo;
 		this.id_costo_gasto_impor=id_costo_gasto_impor;
 		this.valor=valor;
 		this.fecha=fecha;
 		this.referencia=referencia;
 		this.impuesto=impuesto;
 		this.impuesto2=impuesto2;
 		this.impuesto3=impuesto3;
 		this.impuesto4=impuesto4;
 		this.impuesto5=impuesto5;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleLiquidacionImpor detalleliquidacionimporLocal=null;
		
		if(object!=null) {
			detalleliquidacionimporLocal=(DetalleLiquidacionImpor)object;
			
			if(detalleliquidacionimporLocal!=null) {
				if(this.getId()!=null && detalleliquidacionimporLocal.getId()!=null) {
					if(this.getId().equals(detalleliquidacionimporLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleLiquidacionImporConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleLiquidacionImporConstantesFunciones.getDetalleLiquidacionImporDescripcion(this);
		} else {
			sDetalle=DetalleLiquidacionImporConstantesFunciones.getDetalleLiquidacionImporDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleLiquidacionImpor getDetalleLiquidacionImporOriginal() {
		return this.detalleliquidacionimporOriginal;
	}
	
	public void setDetalleLiquidacionImporOriginal(DetalleLiquidacionImpor detalleliquidacionimpor) {
		try {
			this.detalleliquidacionimporOriginal=detalleliquidacionimpor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleLiquidacionImporAdditional detalleliquidacionimporAdditional=null;
	
	public DetalleLiquidacionImporAdditional getDetalleLiquidacionImporAdditional() {
		return this.detalleliquidacionimporAdditional;
	}
	
	public void setDetalleLiquidacionImporAdditional(DetalleLiquidacionImporAdditional detalleliquidacionimporAdditional) {
		try {
			this.detalleliquidacionimporAdditional=detalleliquidacionimporAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_liquidacion_impor() {
		return this.id_liquidacion_impor;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_costo_gasto_impor() {
		return this.id_costo_gasto_impor;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getreferencia() {
		return this.referencia;
	}
    
	
	public Double getimpuesto() {
		return this.impuesto;
	}
    
	
	public Double getimpuesto2() {
		return this.impuesto2;
	}
    
	
	public Double getimpuesto3() {
		return this.impuesto3;
	}
    
	
	public Double getimpuesto4() {
		return this.impuesto4;
	}
    
	
	public Double getimpuesto5() {
		return this.impuesto5;
	}
	
    
	public void setid_liquidacion_impor(Long newid_liquidacion_impor)throws Exception
	{
		try {
			if(this.id_liquidacion_impor!=newid_liquidacion_impor) {
				if(newid_liquidacion_impor==null) {
					//newid_liquidacion_impor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna id_liquidacion_impor");
					}
				}

				this.id_liquidacion_impor=newid_liquidacion_impor;
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
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
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
    
	public void setid_costo_gasto_impor(Long newid_costo_gasto_impor)throws Exception
	{
		try {
			if(this.id_costo_gasto_impor!=newid_costo_gasto_impor) {
				if(newid_costo_gasto_impor==null) {
					//newid_costo_gasto_impor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna id_costo_gasto_impor");
					}
				}

				this.id_costo_gasto_impor=newid_costo_gasto_impor;
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
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setreferencia(String newreferencia)throws Exception
	{
		try {
			if(this.referencia!=newreferencia) {
				if(newreferencia==null) {
					//newreferencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna referencia");
					}
				}

				if(newreferencia!=null&&newreferencia.length()>50) {
					newreferencia=newreferencia.substring(0,48);
					System.out.println("DetalleLiquidacionImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna referencia");
				}

				this.referencia=newreferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto(Double newimpuesto)throws Exception
	{
		try {
			if(this.impuesto!=newimpuesto) {
				if(newimpuesto==null) {
					//newimpuesto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna impuesto");
					}
				}

				this.impuesto=newimpuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto2(Double newimpuesto2)throws Exception
	{
		try {
			if(this.impuesto2!=newimpuesto2) {
				if(newimpuesto2==null) {
					//newimpuesto2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna impuesto2");
					}
				}

				this.impuesto2=newimpuesto2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto3(Double newimpuesto3)throws Exception
	{
		try {
			if(this.impuesto3!=newimpuesto3) {
				if(newimpuesto3==null) {
					//newimpuesto3=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna impuesto3");
					}
				}

				this.impuesto3=newimpuesto3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto4(Double newimpuesto4)throws Exception
	{
		try {
			if(this.impuesto4!=newimpuesto4) {
				if(newimpuesto4==null) {
					//newimpuesto4=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna impuesto4");
					}
				}

				this.impuesto4=newimpuesto4;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto5(Double newimpuesto5)throws Exception
	{
		try {
			if(this.impuesto5!=newimpuesto5) {
				if(newimpuesto5==null) {
					//newimpuesto5=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleLiquidacionImpor:Valor nulo no permitido en columna impuesto5");
					}
				}

				this.impuesto5=newimpuesto5;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public LiquidacionImpor getLiquidacionImpor() {
		return this.liquidacionimpor;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public CostoGastoImpor getCostoGastoImpor() {
		return this.costogastoimpor;
	}

	
	
	public String getliquidacionimpor_descripcion() {
		return this.liquidacionimpor_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getcostogastoimpor_descripcion() {
		return this.costogastoimpor_descripcion;
	}

	
	
	public  void  setLiquidacionImpor(LiquidacionImpor liquidacionimpor) {
		try {
			this.liquidacionimpor=liquidacionimpor;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setCostoGastoImpor(CostoGastoImpor costogastoimpor) {
		try {
			this.costogastoimpor=costogastoimpor;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setliquidacionimpor_descripcion(String liquidacionimpor_descripcion) {
		try {
			this.liquidacionimpor_descripcion=liquidacionimpor_descripcion;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setcostogastoimpor_descripcion(String costogastoimpor_descripcion) {
		try {
			this.costogastoimpor_descripcion=costogastoimpor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_liquidacion_impor_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_usuario_descripcion="";String id_centro_costo_descripcion="";String id_costo_gasto_impor_descripcion="";
	
	
	public String getid_liquidacion_impor_descripcion() {
		return id_liquidacion_impor_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_costo_gasto_impor_descripcion() {
		return id_costo_gasto_impor_descripcion;
	}
	
	
	public void setid_liquidacion_impor_descripcion(String newid_liquidacion_impor_descripcion)throws Exception {
		try {
			this.id_liquidacion_impor_descripcion=newid_liquidacion_impor_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
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
	public void setid_costo_gasto_impor_descripcion(String newid_costo_gasto_impor_descripcion)throws Exception {
		try {
			this.id_costo_gasto_impor_descripcion=newid_costo_gasto_impor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_liquidacion_impor_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_usuario_descripcion="";this.id_centro_costo_descripcion="";this.id_costo_gasto_impor_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

