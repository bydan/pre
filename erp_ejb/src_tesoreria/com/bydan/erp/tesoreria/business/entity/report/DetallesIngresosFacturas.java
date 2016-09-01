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
package com.bydan.erp.tesoreria.business.entity.report;

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
//import com.bydan.erp.tesoreria.util.DetallesIngresosFacturasConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class DetallesIngresosFacturas extends DetallesIngresosFacturasAdditional implements Serializable ,Cloneable {//DetallesIngresosFacturasAdditional,GeneralEntity
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
	
	private DetallesIngresosFacturas detallesingresosfacturasOriginal;
	
	private Map<String, Object> mapDetallesIngresosFacturas;
			
	public Map<String, Object> getMapDetallesIngresosFacturas() {
		return mapDetallesIngresosFacturas;
	}

	public void setMapDetallesIngresosFacturas(Map<String, Object> mapDetallesIngresosFacturas) {
		this.mapDetallesIngresosFacturas = mapDetallesIngresosFacturas;
	}
	
	public void inicializarMapDetallesIngresosFacturas() {
		this.mapDetallesIngresosFacturas = new HashMap<String,Object>();
	}
	
	public void setMapDetallesIngresosFacturasValue(String sKey,Object oValue) {
		this.mapDetallesIngresosFacturas.put(sKey, oValue);
	}
	
	public Object getMapDetallesIngresosFacturasValue(String sKey) {
		return this.mapDetallesIngresosFacturas.get(sKey);
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
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DetallesIngresosFacturasConstantesFunciones.SREGEXTIPO_MOVIMIENTO,message=DetallesIngresosFacturasConstantesFunciones.SMENSAJEREGEXTIPO_MOVIMIENTO)
	private String tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DetallesIngresosFacturasConstantesFunciones.SREGEXNUMERO_MAYOR,message=DetallesIngresosFacturasConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DetallesIngresosFacturasConstantesFunciones.SREGEXNUMERO_FACTURA,message=DetallesIngresosFacturasConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DetallesIngresosFacturasConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=DetallesIngresosFacturasConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DetallesIngresosFacturasConstantesFunciones.SREGEXSIGLAS_PAGO,message=DetallesIngresosFacturasConstantesFunciones.SMENSAJEREGEXSIGLAS_PAGO)
	private String siglas_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DetallesIngresosFacturasConstantesFunciones.SREGEXNOMBRE_PAGO,message=DetallesIngresosFacturasConstantesFunciones.SMENSAJEREGEXNOMBRE_PAGO)
	private String nombre_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DetallesIngresosFacturasConstantesFunciones.SREGEXCODIGO,message=DetallesIngresosFacturasConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_mone_local;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	
	
		
	public DetallesIngresosFacturas () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detallesingresosfacturasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.fecha=new Date();
 		this.tipo_movimiento="";
 		this.numero_mayor="";
 		this.numero_factura="";
 		this.nombre_cliente="";
 		this.siglas_pago="";
 		this.nombre_pago="";
 		this.codigo="";
 		this.credito_mone_local=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetallesIngresosFacturas (Long id,Date versionRow,Date fecha,String tipo_movimiento,String numero_mayor,String numero_factura,String nombre_cliente,String siglas_pago,String nombre_pago,String codigo,Double credito_mone_local) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallesingresosfacturasOriginal=this;
		
 		this.fecha=fecha;
 		this.tipo_movimiento=tipo_movimiento;
 		this.numero_mayor=numero_mayor;
 		this.numero_factura=numero_factura;
 		this.nombre_cliente=nombre_cliente;
 		this.siglas_pago=siglas_pago;
 		this.nombre_pago=nombre_pago;
 		this.codigo=codigo;
 		this.credito_mone_local=credito_mone_local;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetallesIngresosFacturas (Date fecha,String tipo_movimiento,String numero_mayor,String numero_factura,String nombre_cliente,String siglas_pago,String nombre_pago,String codigo,Double credito_mone_local) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallesingresosfacturasOriginal=this;
		
 		this.fecha=fecha;
 		this.tipo_movimiento=tipo_movimiento;
 		this.numero_mayor=numero_mayor;
 		this.numero_factura=numero_factura;
 		this.nombre_cliente=nombre_cliente;
 		this.siglas_pago=siglas_pago;
 		this.nombre_pago=nombre_pago;
 		this.codigo=codigo;
 		this.credito_mone_local=credito_mone_local;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public DetallesIngresosFacturas getDetallesIngresosFacturasOriginal() {
		return this.detallesingresosfacturasOriginal;
	}
	
	public void setDetallesIngresosFacturasOriginal(DetallesIngresosFacturas detallesingresosfacturas) {
		try {
			this.detallesingresosfacturasOriginal=detallesingresosfacturas;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetallesIngresosFacturasAdditional detallesingresosfacturasAdditional=null;
	
	public DetallesIngresosFacturasAdditional getDetallesIngresosFacturasAdditional() {
		return this.detallesingresosfacturasAdditional;
	}
	
	public void setDetallesIngresosFacturasAdditional(DetallesIngresosFacturasAdditional detallesingresosfacturasAdditional) {
		try {
			this.detallesingresosfacturasAdditional=detallesingresosfacturasAdditional;
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
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String gettipo_movimiento() {
		return this.tipo_movimiento;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public String getnombre_cliente() {
		return this.nombre_cliente;
	}
    
	
	public String getsiglas_pago() {
		return this.siglas_pago;
	}
    
	
	public String getnombre_pago() {
		return this.nombre_pago;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public Double getcredito_mone_local() {
		return this.credito_mone_local;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
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
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_movimiento(String newtipo_movimiento)throws Exception
	{
		try {
			if(this.tipo_movimiento!=newtipo_movimiento) {
				if(newtipo_movimiento==null) {
					//newtipo_movimiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna tipo_movimiento");
					}
				}

				if(newtipo_movimiento!=null&&newtipo_movimiento.length()>100) {
					newtipo_movimiento=newtipo_movimiento.substring(0,98);
					System.out.println("DetallesIngresosFacturas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna tipo_movimiento");
				}

				this.tipo_movimiento=newtipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_mayor(String newnumero_mayor)throws Exception
	{
		try {
			if(this.numero_mayor!=newnumero_mayor) {
				if(newnumero_mayor==null) {
					//newnumero_mayor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("DetallesIngresosFacturas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
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
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("DetallesIngresosFacturas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
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
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>150) {
					newnombre_cliente=newnombre_cliente.substring(0,148);
					System.out.println("DetallesIngresosFacturas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cliente");
				}

				this.nombre_cliente=newnombre_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsiglas_pago(String newsiglas_pago)throws Exception
	{
		try {
			if(this.siglas_pago!=newsiglas_pago) {
				if(newsiglas_pago==null) {
					//newsiglas_pago="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna siglas_pago");
					}
				}

				if(newsiglas_pago!=null&&newsiglas_pago.length()>20) {
					newsiglas_pago=newsiglas_pago.substring(0,18);
					System.out.println("DetallesIngresosFacturas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna siglas_pago");
				}

				this.siglas_pago=newsiglas_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_pago(String newnombre_pago)throws Exception
	{
		try {
			if(this.nombre_pago!=newnombre_pago) {
				if(newnombre_pago==null) {
					//newnombre_pago="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna nombre_pago");
					}
				}

				if(newnombre_pago!=null&&newnombre_pago.length()>100) {
					newnombre_pago=newnombre_pago.substring(0,98);
					System.out.println("DetallesIngresosFacturas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_pago");
				}

				this.nombre_pago=newnombre_pago;
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
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("DetallesIngresosFacturas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_mone_local(Double newcredito_mone_local)throws Exception
	{
		try {
			if(this.credito_mone_local!=newcredito_mone_local) {
				if(newcredito_mone_local==null) {
					//newcredito_mone_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetallesIngresosFacturas:Valor nulo no permitido en columna credito_mone_local");
					}
				}

				this.credito_mone_local=newcredito_mone_local;
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

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
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


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
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


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
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
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

