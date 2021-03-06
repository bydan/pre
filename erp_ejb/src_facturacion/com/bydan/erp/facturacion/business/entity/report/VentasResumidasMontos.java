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
package com.bydan.erp.facturacion.business.entity.report;

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
//import com.bydan.erp.facturacion.util.VentasResumidasMontosConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;

import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;




@SuppressWarnings("unused")
public class VentasResumidasMontos extends VentasResumidasMontosAdditional implements Serializable ,Cloneable {//VentasResumidasMontosAdditional,GeneralEntity
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
	
	private VentasResumidasMontos ventasresumidasmontosOriginal;
	
	private Map<String, Object> mapVentasResumidasMontos;
			
	public Map<String, Object> getMapVentasResumidasMontos() {
		return mapVentasResumidasMontos;
	}

	public void setMapVentasResumidasMontos(Map<String, Object> mapVentasResumidasMontos) {
		this.mapVentasResumidasMontos = mapVentasResumidasMontos;
	}
	
	public void inicializarMapVentasResumidasMontos() {
		this.mapVentasResumidasMontos = new HashMap<String,Object>();
	}
	
	public void setMapVentasResumidasMontosValue(String sKey,Object oValue) {
		this.mapVentasResumidasMontos.put(sKey, oValue);
	}
	
	public Object getMapVentasResumidasMontosValue(String sKey) {
		return this.mapVentasResumidasMontos.get(sKey);
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
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasResumidasMontosConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=VentasResumidasMontosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasResumidasMontosConstantesFunciones.SREGEXNOMBRE_VENDEDOR,message=VentasResumidasMontosConstantesFunciones.SMENSAJEREGEXNOMBRE_VENDEDOR)
	private String nombre_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasResumidasMontosConstantesFunciones.SREGEXNOMBRE_TIPO_FACTURA,message=VentasResumidasMontosConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_FACTURA)
	private String nombre_tipo_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasResumidasMontosConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO,message=VentasResumidasMontosConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO)
	private String numero_pre_impreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_otro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sub_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasResumidasMontosConstantesFunciones.SREGEXDESCRIPCION,message=VentasResumidasMontosConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Vendedor vendedor;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String vendedor_descripcion;
	
	
		
	public VentasResumidasMontos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.ventasresumidasmontosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_vendedor=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.nombre_completo="";
 		this.nombre_vendedor="";
 		this.nombre_tipo_factura="";
 		this.fecha_emision=new Date();
 		this.fecha_vencimiento=new Date();
 		this.numero_pre_impreso="";
 		this.total_iva=0.0;
 		this.total_sin_iva=0.0;
 		this.total_descuento=0.0;
 		this.total_otro=0.0;
 		this.sub_total=0.0;
 		this.total=0.0;
 		this.iva=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.vendedor=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.vendedor_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public VentasResumidasMontos (Long id,Date versionRow,String nombre_completo,String nombre_vendedor,String nombre_tipo_factura,Date fecha_emision,Date fecha_vencimiento,String numero_pre_impreso,Double total_iva,Double total_sin_iva,Double total_descuento,Double total_otro,Double sub_total,Double total,Double iva,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ventasresumidasmontosOriginal=this;
		
 		this.nombre_completo=nombre_completo;
 		this.nombre_vendedor=nombre_vendedor;
 		this.nombre_tipo_factura=nombre_tipo_factura;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.total_descuento=total_descuento;
 		this.total_otro=total_otro;
 		this.sub_total=sub_total;
 		this.total=total;
 		this.iva=iva;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public VentasResumidasMontos (String nombre_completo,String nombre_vendedor,String nombre_tipo_factura,Date fecha_emision,Date fecha_vencimiento,String numero_pre_impreso,Double total_iva,Double total_sin_iva,Double total_descuento,Double total_otro,Double sub_total,Double total,Double iva,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ventasresumidasmontosOriginal=this;
		
 		this.nombre_completo=nombre_completo;
 		this.nombre_vendedor=nombre_vendedor;
 		this.nombre_tipo_factura=nombre_tipo_factura;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.total_descuento=total_descuento;
 		this.total_otro=total_otro;
 		this.sub_total=sub_total;
 		this.total=total;
 		this.iva=iva;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public VentasResumidasMontos getVentasResumidasMontosOriginal() {
		return this.ventasresumidasmontosOriginal;
	}
	
	public void setVentasResumidasMontosOriginal(VentasResumidasMontos ventasresumidasmontos) {
		try {
			this.ventasresumidasmontosOriginal=ventasresumidasmontos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VentasResumidasMontosAdditional ventasresumidasmontosAdditional=null;
	
	public VentasResumidasMontosAdditional getVentasResumidasMontosAdditional() {
		return this.ventasresumidasmontosAdditional;
	}
	
	public void setVentasResumidasMontosAdditional(VentasResumidasMontosAdditional ventasresumidasmontosAdditional) {
		try {
			this.ventasresumidasmontosAdditional=ventasresumidasmontosAdditional;
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
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String getnombre_vendedor() {
		return this.nombre_vendedor;
	}
    
	
	public String getnombre_tipo_factura() {
		return this.nombre_tipo_factura;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public String getnumero_pre_impreso() {
		return this.numero_pre_impreso;
	}
    
	
	public Double gettotal_iva() {
		return this.total_iva;
	}
    
	
	public Double gettotal_sin_iva() {
		return this.total_sin_iva;
	}
    
	
	public Double gettotal_descuento() {
		return this.total_descuento;
	}
    
	
	public Double gettotal_otro() {
		return this.total_otro;
	}
    
	
	public Double getsub_total() {
		return this.sub_total;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_vendedor(Long newid_vendedor)throws Exception
	{
		try {
			if(this.id_vendedor!=newid_vendedor) {
				if(newid_vendedor==null) {
					//newid_vendedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna fecha_emision_desde");
					}
				}

				this.fecha_emision_desde=newfecha_emision_desde;
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
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
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
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>150) {
					newnombre_completo=newnombre_completo.substring(0,148);
					System.out.println("VentasResumidasMontos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_vendedor(String newnombre_vendedor)throws Exception
	{
		try {
			if(this.nombre_vendedor!=newnombre_vendedor) {
				if(newnombre_vendedor==null) {
					//newnombre_vendedor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna nombre_vendedor");
					}
				}

				if(newnombre_vendedor!=null&&newnombre_vendedor.length()>150) {
					newnombre_vendedor=newnombre_vendedor.substring(0,148);
					System.out.println("VentasResumidasMontos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_vendedor");
				}

				this.nombre_vendedor=newnombre_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_factura(String newnombre_tipo_factura)throws Exception
	{
		try {
			if(this.nombre_tipo_factura!=newnombre_tipo_factura) {
				if(newnombre_tipo_factura==null) {
					//newnombre_tipo_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna nombre_tipo_factura");
					}
				}

				if(newnombre_tipo_factura!=null&&newnombre_tipo_factura.length()>100) {
					newnombre_tipo_factura=newnombre_tipo_factura.substring(0,98);
					System.out.println("VentasResumidasMontos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_factura");
				}

				this.nombre_tipo_factura=newnombre_tipo_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso(String newnumero_pre_impreso)throws Exception
	{
		try {
			if(this.numero_pre_impreso!=newnumero_pre_impreso) {
				if(newnumero_pre_impreso==null) {
					//newnumero_pre_impreso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna numero_pre_impreso");
					}
				}

				if(newnumero_pre_impreso!=null&&newnumero_pre_impreso.length()>50) {
					newnumero_pre_impreso=newnumero_pre_impreso.substring(0,48);
					System.out.println("VentasResumidasMontos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso");
				}

				this.numero_pre_impreso=newnumero_pre_impreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_iva(Double newtotal_iva)throws Exception
	{
		try {
			if(this.total_iva!=newtotal_iva) {
				if(newtotal_iva==null) {
					//newtotal_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna total_iva");
					}
				}

				this.total_iva=newtotal_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_sin_iva(Double newtotal_sin_iva)throws Exception
	{
		try {
			if(this.total_sin_iva!=newtotal_sin_iva) {
				if(newtotal_sin_iva==null) {
					//newtotal_sin_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna total_sin_iva");
					}
				}

				this.total_sin_iva=newtotal_sin_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_descuento(Double newtotal_descuento)throws Exception
	{
		try {
			if(this.total_descuento!=newtotal_descuento) {
				if(newtotal_descuento==null) {
					//newtotal_descuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna total_descuento");
					}
				}

				this.total_descuento=newtotal_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_otro(Double newtotal_otro)throws Exception
	{
		try {
			if(this.total_otro!=newtotal_otro) {
				if(newtotal_otro==null) {
					//newtotal_otro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna total_otro");
					}
				}

				this.total_otro=newtotal_otro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsub_total(Double newsub_total)throws Exception
	{
		try {
			if(this.sub_total!=newsub_total) {
				if(newsub_total==null) {
					//newsub_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna sub_total");
					}
				}

				this.sub_total=newsub_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal(Double newtotal)throws Exception
	{
		try {
			if(this.total!=newtotal) {
				if(newtotal==null) {
					//newtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidasMontos:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("VentasResumidasMontos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
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


	public  void  setVendedor(Vendedor vendedor) {
		try {
			this.vendedor=vendedor;
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


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_vendedor_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
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
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion)throws Exception {
		try {
			this.id_vendedor_descripcion=newid_vendedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_vendedor_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

