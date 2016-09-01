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
package com.bydan.erp.puntoventa.business.entity.report;

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
//import com.bydan.erp.puntoventa.util.ComprobanteFacturaConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.cartera.util.*;

import com.bydan.erp.puntoventa.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class ComprobanteFactura extends ComprobanteFacturaAdditional implements Serializable ,Cloneable {//ComprobanteFacturaAdditional,GeneralEntity
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
	
	private ComprobanteFactura comprobantefacturaOriginal;
	
	private Map<String, Object> mapComprobanteFactura;
			
	public Map<String, Object> getMapComprobanteFactura() {
		return mapComprobanteFactura;
	}

	public void setMapComprobanteFactura(Map<String, Object> mapComprobanteFactura) {
		this.mapComprobanteFactura = mapComprobanteFactura;
	}
	
	public void inicializarMapComprobanteFactura() {
		this.mapComprobanteFactura = new HashMap<String,Object>();
	}
	
	public void setMapComprobanteFacturaValue(String sKey,Object oValue) {
		this.mapComprobanteFactura.put(sKey, oValue);
	}
	
	public Object getMapComprobanteFacturaValue(String sKey) {
		return this.mapComprobanteFactura.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFacturaConstantesFunciones.SREGEXNOMBRE_CAJA,message=ComprobanteFacturaConstantesFunciones.SMENSAJEREGEXNOMBRE_CAJA)
	private String nombre_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFacturaConstantesFunciones.SREGEXSECUENCIAL,message=ComprobanteFacturaConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFacturaConstantesFunciones.SREGEXCODIGO_CLIENTE,message=ComprobanteFacturaConstantesFunciones.SMENSAJEREGEXCODIGO_CLIENTE)
	private String codigo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComprobanteFacturaConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=ComprobanteFacturaConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double subtotal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double financiamiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_formas_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_real;
			
	
	public Empresa empresa;
	public Vendedor vendedor;
	public Caja caja;
	public Cliente cliente;
	
	
	private String empresa_descripcion;
	private String vendedor_descripcion;
	private String caja_descripcion;
	private String cliente_descripcion;
	
	
		
	public ComprobanteFactura () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.comprobantefacturaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_vendedor=-1L;
 		this.fecha_inicio=new Date();
 		this.fecha_fin=new Date();
 		this.id_caja=-1L;
 		this.id_cliente=-1L;
 		this.nombre_caja="";
 		this.secuencial="";
 		this.fecha=new Date();
 		this.codigo_cliente="";
 		this.nombre_cliente="";
 		this.subtotal=0.0;
 		this.iva=0.0;
 		this.descuento=0.0;
 		this.financiamiento=0.0;
 		this.flete=0.0;
 		this.ice=0.0;
 		this.total=0.0;
 		this.cantidad_formas_pago=0;
 		this.descuento_real=0.0;
		
		
		this.empresa=null;
		this.vendedor=null;
		this.caja=null;
		this.cliente=null;
		
		
		this.empresa_descripcion="";
		this.vendedor_descripcion="";
		this.caja_descripcion="";
		this.cliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ComprobanteFactura (Long id,Date versionRow,Long id_caja,Long id_cliente,String nombre_caja,String secuencial,Date fecha,String codigo_cliente,String nombre_cliente,Double subtotal,Double iva,Double descuento,Double financiamiento,Double flete,Double ice,Double total,Integer cantidad_formas_pago,Double descuento_real) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comprobantefacturaOriginal=this;
		
 		this.id_caja=id_caja;
 		this.id_cliente=id_cliente;
 		this.nombre_caja=nombre_caja;
 		this.secuencial=secuencial;
 		this.fecha=fecha;
 		this.codigo_cliente=codigo_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.subtotal=subtotal;
 		this.iva=iva;
 		this.descuento=descuento;
 		this.financiamiento=financiamiento;
 		this.flete=flete;
 		this.ice=ice;
 		this.total=total;
 		this.cantidad_formas_pago=cantidad_formas_pago;
 		this.descuento_real=descuento_real;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ComprobanteFactura (Long id_caja,Long id_cliente,String nombre_caja,String secuencial,Date fecha,String codigo_cliente,String nombre_cliente,Double subtotal,Double iva,Double descuento,Double financiamiento,Double flete,Double ice,Double total,Integer cantidad_formas_pago,Double descuento_real) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comprobantefacturaOriginal=this;
		
 		this.id_caja=id_caja;
 		this.id_cliente=id_cliente;
 		this.nombre_caja=nombre_caja;
 		this.secuencial=secuencial;
 		this.fecha=fecha;
 		this.codigo_cliente=codigo_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.subtotal=subtotal;
 		this.iva=iva;
 		this.descuento=descuento;
 		this.financiamiento=financiamiento;
 		this.flete=flete;
 		this.ice=ice;
 		this.total=total;
 		this.cantidad_formas_pago=cantidad_formas_pago;
 		this.descuento_real=descuento_real;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ComprobanteFactura getComprobanteFacturaOriginal() {
		return this.comprobantefacturaOriginal;
	}
	
	public void setComprobanteFacturaOriginal(ComprobanteFactura comprobantefactura) {
		try {
			this.comprobantefacturaOriginal=comprobantefactura;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ComprobanteFacturaAdditional comprobantefacturaAdditional=null;
	
	public ComprobanteFacturaAdditional getComprobanteFacturaAdditional() {
		return this.comprobantefacturaAdditional;
	}
	
	public void setComprobanteFacturaAdditional(ComprobanteFacturaAdditional comprobantefacturaAdditional) {
		try {
			this.comprobantefacturaAdditional=comprobantefacturaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_fin() {
		return this.fecha_fin;
	}
    
	
	public Long getid_caja() {
		return this.id_caja;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getnombre_caja() {
		return this.nombre_caja;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getcodigo_cliente() {
		return this.codigo_cliente;
	}
    
	
	public String getnombre_cliente() {
		return this.nombre_cliente;
	}
    
	
	public Double getsubtotal() {
		return this.subtotal;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double getfinanciamiento() {
		return this.financiamiento;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Integer getcantidad_formas_pago() {
		return this.cantidad_formas_pago;
	}
    
	
	public Double getdescuento_real() {
		return this.descuento_real;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_fin(Date newfecha_fin)throws Exception
	{
		try {
			if(this.fecha_fin!=newfecha_fin) {
				if(newfecha_fin==null) {
					//newfecha_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna fecha_fin");
					}
				}

				this.fecha_fin=newfecha_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_caja(Long newid_caja)throws Exception
	{
		try {
			if(this.id_caja!=newid_caja) {
				if(newid_caja==null) {
					//newid_caja=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna id_caja");
					}
				}

				this.id_caja=newid_caja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_caja(String newnombre_caja)throws Exception
	{
		try {
			if(this.nombre_caja!=newnombre_caja) {
				if(newnombre_caja==null) {
					//newnombre_caja="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna nombre_caja");
					}
				}

				if(newnombre_caja!=null&&newnombre_caja.length()>100) {
					newnombre_caja=newnombre_caja.substring(0,98);
					System.out.println("ComprobanteFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_caja");
				}

				this.nombre_caja=newnombre_caja;
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
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("ComprobanteFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
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
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cliente(String newcodigo_cliente)throws Exception
	{
		try {
			if(this.codigo_cliente!=newcodigo_cliente) {
				if(newcodigo_cliente==null) {
					//newcodigo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna codigo_cliente");
					}
				}

				if(newcodigo_cliente!=null&&newcodigo_cliente.length()>20) {
					newcodigo_cliente=newcodigo_cliente.substring(0,18);
					System.out.println("ComprobanteFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna codigo_cliente");
				}

				this.codigo_cliente=newcodigo_cliente;
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
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>100) {
					newnombre_cliente=newnombre_cliente.substring(0,98);
					System.out.println("ComprobanteFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_cliente");
				}

				this.nombre_cliente=newnombre_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsubtotal(Double newsubtotal)throws Exception
	{
		try {
			if(this.subtotal!=newsubtotal) {
				if(newsubtotal==null) {
					//newsubtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna subtotal");
					}
				}

				this.subtotal=newsubtotal;
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
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento(Double newdescuento)throws Exception
	{
		try {
			if(this.descuento!=newdescuento) {
				if(newdescuento==null) {
					//newdescuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfinanciamiento(Double newfinanciamiento)throws Exception
	{
		try {
			if(this.financiamiento!=newfinanciamiento) {
				if(newfinanciamiento==null) {
					//newfinanciamiento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna financiamiento");
					}
				}

				this.financiamiento=newfinanciamiento;
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
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice(Double newice)throws Exception
	{
		try {
			if(this.ice!=newice) {
				if(newice==null) {
					//newice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
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
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_formas_pago(Integer newcantidad_formas_pago)throws Exception
	{
		try {
			if(this.cantidad_formas_pago!=newcantidad_formas_pago) {
				if(newcantidad_formas_pago==null) {
					//newcantidad_formas_pago=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna cantidad_formas_pago");
					}
				}

				this.cantidad_formas_pago=newcantidad_formas_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_real(Double newdescuento_real)throws Exception
	{
		try {
			if(this.descuento_real!=newdescuento_real) {
				if(newdescuento_real==null) {
					//newdescuento_real=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComprobanteFactura:Valor nulo no permitido en columna descuento_real");
					}
				}

				this.descuento_real=newdescuento_real;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public Caja getCaja() {
		return this.caja;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getcaja_descripcion() {
		return this.caja_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setCaja(Caja caja) {
		try {
			this.caja=caja;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
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


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcaja_descripcion(String caja_descripcion) {
		try {
			this.caja_descripcion=caja_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_vendedor_descripcion="";String id_caja_descripcion="";String id_cliente_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_caja_descripcion() {
		return id_caja_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_caja_descripcion(String newid_caja_descripcion)throws Exception {
		try {
			this.id_caja_descripcion=newid_caja_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_vendedor_descripcion="";this.id_caja_descripcion="";this.id_cliente_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

