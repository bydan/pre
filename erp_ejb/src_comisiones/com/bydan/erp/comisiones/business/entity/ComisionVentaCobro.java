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
package com.bydan.erp.comisiones.business.entity;

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
//import com.bydan.erp.comisiones.util.ComisionVentaCobroConstantesFunciones;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class ComisionVentaCobro extends ComisionVentaCobroAdditional implements Serializable ,Cloneable {//ComisionVentaCobroAdditional,GeneralEntity
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
	
	private ComisionVentaCobro comisionventacobroOriginal;
	
	private Map<String, Object> mapComisionVentaCobro;
			
	public Map<String, Object> getMapComisionVentaCobro() {
		return mapComisionVentaCobro;
	}

	public void setMapComisionVentaCobro(Map<String, Object> mapComisionVentaCobro) {
		this.mapComisionVentaCobro = mapComisionVentaCobro;
	}
	
	public void inicializarMapComisionVentaCobro() {
		this.mapComisionVentaCobro = new HashMap<String,Object>();
	}
	
	public void setMapComisionVentaCobroValue(String sKey,Object oValue) {
		this.mapComisionVentaCobro.put(sKey, oValue);
	}
	
	public Object getMapComisionVentaCobroValue(String sKey) {
		return this.mapComisionVentaCobro.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ComisionVentaCobroConstantesFunciones.SREGEXNUMERO_FACTURA,message=ComisionVentaCobroConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ComisionVentaCobroConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=ComisionVentaCobroConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ComisionVentaCobroConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=ComisionVentaCobroConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=5,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ComisionVentaCobroConstantesFunciones.SREGEXESTADO,message=ComisionVentaCobroConstantesFunciones.SMENSAJEREGEXESTADO)
	private String estado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_abono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_comision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_comision_cobro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_dias;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Vendedor vendedor;
	public Factura factura;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String vendedor_descripcion;
	private String factura_descripcion;
	
	
		
	public ComisionVentaCobro () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.comisionventacobroOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_vendedor=-1L;
 		this.id_factura=-1L;
 		this.numero_factura="";
 		this.fecha_pago=new Date();
 		this.nombre_cliente="";
 		this.numero_comprobante="";
 		this.estado="";
 		this.total_factura=0.0;
 		this.total_abono=0.0;
 		this.porcentaje_comision=0.0;
 		this.total_comision_cobro=0.0;
 		this.numero_dias=0;
		
		
		this.empresa=null;
		this.ejercicio=null;
		this.periodo=null;
		this.vendedor=null;
		this.factura=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.vendedor_descripcion="";
		this.factura_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ComisionVentaCobro (Long id,Date versionRow,Long id_empresa,Long id_ejercicio,Long id_periodo,Long id_vendedor,Long id_factura,String numero_factura,Date fecha_pago,String nombre_cliente,String numero_comprobante,String estado,Double total_factura,Double total_abono,Double porcentaje_comision,Double total_comision_cobro,Integer numero_dias) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comisionventacobroOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_vendedor=id_vendedor;
 		this.id_factura=id_factura;
 		this.numero_factura=numero_factura;
 		this.fecha_pago=fecha_pago;
 		this.nombre_cliente=nombre_cliente;
 		this.numero_comprobante=numero_comprobante;
 		this.estado=estado;
 		this.total_factura=total_factura;
 		this.total_abono=total_abono;
 		this.porcentaje_comision=porcentaje_comision;
 		this.total_comision_cobro=total_comision_cobro;
 		this.numero_dias=numero_dias;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ComisionVentaCobro (Long id_empresa,Long id_ejercicio,Long id_periodo,Long id_vendedor,Long id_factura,String numero_factura,Date fecha_pago,String nombre_cliente,String numero_comprobante,String estado,Double total_factura,Double total_abono,Double porcentaje_comision,Double total_comision_cobro,Integer numero_dias) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comisionventacobroOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_vendedor=id_vendedor;
 		this.id_factura=id_factura;
 		this.numero_factura=numero_factura;
 		this.fecha_pago=fecha_pago;
 		this.nombre_cliente=nombre_cliente;
 		this.numero_comprobante=numero_comprobante;
 		this.estado=estado;
 		this.total_factura=total_factura;
 		this.total_abono=total_abono;
 		this.porcentaje_comision=porcentaje_comision;
 		this.total_comision_cobro=total_comision_cobro;
 		this.numero_dias=numero_dias;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ComisionVentaCobro comisionventacobroLocal=null;
		
		if(object!=null) {
			comisionventacobroLocal=(ComisionVentaCobro)object;
			
			if(comisionventacobroLocal!=null) {
				if(this.getId()!=null && comisionventacobroLocal.getId()!=null) {
					if(this.getId().equals(comisionventacobroLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ComisionVentaCobroConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ComisionVentaCobroConstantesFunciones.getComisionVentaCobroDescripcion(this);
		} else {
			sDetalle=ComisionVentaCobroConstantesFunciones.getComisionVentaCobroDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ComisionVentaCobro getComisionVentaCobroOriginal() {
		return this.comisionventacobroOriginal;
	}
	
	public void setComisionVentaCobroOriginal(ComisionVentaCobro comisionventacobro) {
		try {
			this.comisionventacobroOriginal=comisionventacobro;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ComisionVentaCobroAdditional comisionventacobroAdditional=null;
	
	public ComisionVentaCobroAdditional getComisionVentaCobroAdditional() {
		return this.comisionventacobroAdditional;
	}
	
	public void setComisionVentaCobroAdditional(ComisionVentaCobroAdditional comisionventacobroAdditional) {
		try {
			this.comisionventacobroAdditional=comisionventacobroAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public Date getfecha_pago() {
		return this.fecha_pago;
	}
    
	
	public String getnombre_cliente() {
		return this.nombre_cliente;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public String getestado() {
		return this.estado;
	}
    
	
	public Double gettotal_factura() {
		return this.total_factura;
	}
    
	
	public Double gettotal_abono() {
		return this.total_abono;
	}
    
	
	public Double getporcentaje_comision() {
		return this.porcentaje_comision;
	}
    
	
	public Double gettotal_comision_cobro() {
		return this.total_comision_cobro;
	}
    
	
	public Integer getnumero_dias() {
		return this.numero_dias;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_factura(Long newid_factura)throws Exception
	{
		try {
			if(this.id_factura!=newid_factura) {
				if(newid_factura==null) {
					//newid_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna id_factura");
					}
				}

				this.id_factura=newid_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_factura(String newnumero_factura)throws Exception
	{
		try {
			if(this.numero_factura!=newnumero_factura) {
				if(newnumero_factura==null) {
					//newnumero_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("ComisionVentaCobro:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_pago(Date newfecha_pago)throws Exception
	{
		try {
			if(this.fecha_pago!=newfecha_pago) {
				if(newfecha_pago==null) {
					//newfecha_pago=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna fecha_pago");
					}
				}

				this.fecha_pago=newfecha_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cliente(String newnombre_cliente)throws Exception
	{
		try {
			if(this.nombre_cliente!=newnombre_cliente) {
				if(newnombre_cliente==null) {
					//newnombre_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>200) {
					newnombre_cliente=newnombre_cliente.substring(0,198);
					System.out.println("ComisionVentaCobro:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_cliente");
				}

				this.nombre_cliente=newnombre_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_comprobante(String newnumero_comprobante)throws Exception
	{
		try {
			if(this.numero_comprobante!=newnumero_comprobante) {
				if(newnumero_comprobante==null) {
					//newnumero_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("ComisionVentaCobro:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setestado(String newestado)throws Exception
	{
		try {
			if(this.estado!=newestado) {
				if(newestado==null) {
					//newestado="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna estado");
					}
				}

				if(newestado!=null&&newestado.length()>5) {
					newestado=newestado.substring(0,3);
					System.out.println("ComisionVentaCobro:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=5 en columna estado");
				}

				this.estado=newestado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_factura(Double newtotal_factura)throws Exception
	{
		try {
			if(this.total_factura!=newtotal_factura) {
				if(newtotal_factura==null) {
					//newtotal_factura=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna total_factura");
					}
				}

				this.total_factura=newtotal_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_abono(Double newtotal_abono)throws Exception
	{
		try {
			if(this.total_abono!=newtotal_abono) {
				if(newtotal_abono==null) {
					//newtotal_abono=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna total_abono");
					}
				}

				this.total_abono=newtotal_abono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_comision(Double newporcentaje_comision)throws Exception
	{
		try {
			if(this.porcentaje_comision!=newporcentaje_comision) {
				if(newporcentaje_comision==null) {
					//newporcentaje_comision=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna porcentaje_comision");
					}
				}

				this.porcentaje_comision=newporcentaje_comision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_comision_cobro(Double newtotal_comision_cobro)throws Exception
	{
		try {
			if(this.total_comision_cobro!=newtotal_comision_cobro) {
				if(newtotal_comision_cobro==null) {
					//newtotal_comision_cobro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna total_comision_cobro");
					}
				}

				this.total_comision_cobro=newtotal_comision_cobro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dias(Integer newnumero_dias)throws Exception
	{
		try {
			if(this.numero_dias!=newnumero_dias) {
				if(newnumero_dias==null) {
					//newnumero_dias=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComisionVentaCobro:Valor nulo no permitido en columna numero_dias");
					}
				}

				this.numero_dias=newnumero_dias;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public Factura getFactura() {
		return this.factura;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
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


	public  void  setFactura(Factura factura) {
		try {
			this.factura=factura;
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


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
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


	public  void  setfactura_descripcion(String factura_descripcion) {
		try {
			this.factura_descripcion=factura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_vendedor_descripcion="";String id_factura_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
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
	public void setid_factura_descripcion(String newid_factura_descripcion)throws Exception {
		try {
			this.id_factura_descripcion=newid_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_vendedor_descripcion="";this.id_factura_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

