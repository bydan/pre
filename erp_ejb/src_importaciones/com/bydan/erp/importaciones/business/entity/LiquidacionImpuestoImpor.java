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
//import com.bydan.erp.importaciones.util.LiquidacionImpuestoImporConstantesFunciones;
import com.bydan.erp.importaciones.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class LiquidacionImpuestoImpor extends LiquidacionImpuestoImporAdditional implements Serializable ,Cloneable {//LiquidacionImpuestoImporAdditional,GeneralEntity
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
	
	private LiquidacionImpuestoImpor liquidacionimpuestoimporOriginal;
	
	private Map<String, Object> mapLiquidacionImpuestoImpor;
			
	public Map<String, Object> getMapLiquidacionImpuestoImpor() {
		return mapLiquidacionImpuestoImpor;
	}

	public void setMapLiquidacionImpuestoImpor(Map<String, Object> mapLiquidacionImpuestoImpor) {
		this.mapLiquidacionImpuestoImpor = mapLiquidacionImpuestoImpor;
	}
	
	public void inicializarMapLiquidacionImpuestoImpor() {
		this.mapLiquidacionImpuestoImpor = new HashMap<String,Object>();
	}
	
	public void setMapLiquidacionImpuestoImporValue(String sKey,Object oValue) {
		this.mapLiquidacionImpuestoImpor.put(sKey, oValue);
	}
	
	public Object getMapLiquidacionImpuestoImporValue(String sKey) {
		return this.mapLiquidacionImpuestoImpor.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pedido_compra_impor;
	
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
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=LiquidacionImpuestoImporConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=LiquidacionImpuestoImporConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=LiquidacionImpuestoImporConstantesFunciones.SREGEXNUMERO_DUI,message=LiquidacionImpuestoImporConstantesFunciones.SMENSAJEREGEXNUMERO_DUI)
	private String numero_dui;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double fob;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double seguro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_fodi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double tasa_control;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cfr;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cif;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
			
	
	public PedidoCompraImpor pedidocompraimpor;
	public Empresa empresa;
	public Sucursal sucursal;
	public Cliente cliente;
	public Factura factura;
	
	
	private String pedidocompraimpor_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String cliente_descripcion;
	private String factura_descripcion;
	
	
	public List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors;
		
	public LiquidacionImpuestoImpor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.liquidacionimpuestoimporOriginal=this;
		
 		this.id_pedido_compra_impor=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_cliente=-1L;
 		this.id_factura=-1L;
 		this.numero_comprobante="";
 		this.numero_dui="";
 		this.fecha=new Date();
 		this.fecha_pago=new Date();
 		this.fob=0.0;
 		this.seguro=0.0;
 		this.flete=0.0;
 		this.porcentaje_fodi=0.0;
 		this.porcentaje_iva=0.0;
 		this.tasa_control=0.0;
 		this.cfr=0.0;
 		this.cif=0.0;
 		this.total=0.0;
		
		
		this.pedidocompraimpor=null;
		this.empresa=null;
		this.sucursal=null;
		this.cliente=null;
		this.factura=null;
		
		
		this.pedidocompraimpor_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.cliente_descripcion="";
		this.factura_descripcion="";
		
		
		this.detalleliquidacionimpuestoimpors=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public LiquidacionImpuestoImpor (Long id,Date versionRow,Long id_pedido_compra_impor,Long id_empresa,Long id_sucursal,Long id_cliente,Long id_factura,String numero_comprobante,String numero_dui,Date fecha,Date fecha_pago,Double fob,Double seguro,Double flete,Double porcentaje_fodi,Double porcentaje_iva,Double tasa_control,Double cfr,Double cif,Double total) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.liquidacionimpuestoimporOriginal=this;
		
 		this.id_pedido_compra_impor=id_pedido_compra_impor;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cliente=id_cliente;
 		this.id_factura=id_factura;
 		this.numero_comprobante=numero_comprobante;
 		this.numero_dui=numero_dui;
 		this.fecha=fecha;
 		this.fecha_pago=fecha_pago;
 		this.fob=fob;
 		this.seguro=seguro;
 		this.flete=flete;
 		this.porcentaje_fodi=porcentaje_fodi;
 		this.porcentaje_iva=porcentaje_iva;
 		this.tasa_control=tasa_control;
 		this.cfr=cfr;
 		this.cif=cif;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public LiquidacionImpuestoImpor (Long id_pedido_compra_impor,Long id_empresa,Long id_sucursal,Long id_cliente,Long id_factura,String numero_comprobante,String numero_dui,Date fecha,Date fecha_pago,Double fob,Double seguro,Double flete,Double porcentaje_fodi,Double porcentaje_iva,Double tasa_control,Double cfr,Double cif,Double total) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.liquidacionimpuestoimporOriginal=this;
		
 		this.id_pedido_compra_impor=id_pedido_compra_impor;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cliente=id_cliente;
 		this.id_factura=id_factura;
 		this.numero_comprobante=numero_comprobante;
 		this.numero_dui=numero_dui;
 		this.fecha=fecha;
 		this.fecha_pago=fecha_pago;
 		this.fob=fob;
 		this.seguro=seguro;
 		this.flete=flete;
 		this.porcentaje_fodi=porcentaje_fodi;
 		this.porcentaje_iva=porcentaje_iva;
 		this.tasa_control=tasa_control;
 		this.cfr=cfr;
 		this.cif=cif;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		LiquidacionImpuestoImpor liquidacionimpuestoimporLocal=null;
		
		if(object!=null) {
			liquidacionimpuestoimporLocal=(LiquidacionImpuestoImpor)object;
			
			if(liquidacionimpuestoimporLocal!=null) {
				if(this.getId()!=null && liquidacionimpuestoimporLocal.getId()!=null) {
					if(this.getId().equals(liquidacionimpuestoimporLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!LiquidacionImpuestoImporConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=LiquidacionImpuestoImporConstantesFunciones.getLiquidacionImpuestoImporDescripcion(this);
		} else {
			sDetalle=LiquidacionImpuestoImporConstantesFunciones.getLiquidacionImpuestoImporDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public LiquidacionImpuestoImpor getLiquidacionImpuestoImporOriginal() {
		return this.liquidacionimpuestoimporOriginal;
	}
	
	public void setLiquidacionImpuestoImporOriginal(LiquidacionImpuestoImpor liquidacionimpuestoimpor) {
		try {
			this.liquidacionimpuestoimporOriginal=liquidacionimpuestoimpor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected LiquidacionImpuestoImporAdditional liquidacionimpuestoimporAdditional=null;
	
	public LiquidacionImpuestoImporAdditional getLiquidacionImpuestoImporAdditional() {
		return this.liquidacionimpuestoimporAdditional;
	}
	
	public void setLiquidacionImpuestoImporAdditional(LiquidacionImpuestoImporAdditional liquidacionimpuestoimporAdditional) {
		try {
			this.liquidacionimpuestoimporAdditional=liquidacionimpuestoimporAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_pedido_compra_impor() {
		return this.id_pedido_compra_impor;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public String getnumero_dui() {
		return this.numero_dui;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Date getfecha_pago() {
		return this.fecha_pago;
	}
    
	
	public Double getfob() {
		return this.fob;
	}
    
	
	public Double getseguro() {
		return this.seguro;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double getporcentaje_fodi() {
		return this.porcentaje_fodi;
	}
    
	
	public Double getporcentaje_iva() {
		return this.porcentaje_iva;
	}
    
	
	public Double gettasa_control() {
		return this.tasa_control;
	}
    
	
	public Double getcfr() {
		return this.cfr;
	}
    
	
	public Double getcif() {
		return this.cif;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
	
    
	public void setid_pedido_compra_impor(Long newid_pedido_compra_impor)throws Exception
	{
		try {
			if(this.id_pedido_compra_impor!=newid_pedido_compra_impor) {
				if(newid_pedido_compra_impor==null) {
					//newid_pedido_compra_impor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna id_pedido_compra_impor");
					}
				}

				this.id_pedido_compra_impor=newid_pedido_compra_impor;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna id_factura");
					}
				}

				this.id_factura=newid_factura;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("LiquidacionImpuestoImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dui(String newnumero_dui)throws Exception
	{
		try {
			if(this.numero_dui!=newnumero_dui) {
				if(newnumero_dui==null) {
					//newnumero_dui="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna numero_dui");
					}
				}

				if(newnumero_dui!=null&&newnumero_dui.length()>50) {
					newnumero_dui=newnumero_dui.substring(0,48);
					System.out.println("LiquidacionImpuestoImpor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_dui");
				}

				this.numero_dui=newnumero_dui;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna fecha_pago");
					}
				}

				this.fecha_pago=newfecha_pago;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna fob");
					}
				}

				this.fob=newfob;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna seguro");
					}
				}

				this.seguro=newseguro;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna porcentaje_fodi");
					}
				}

				this.porcentaje_fodi=newporcentaje_fodi;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna porcentaje_iva");
					}
				}

				this.porcentaje_iva=newporcentaje_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settasa_control(Double newtasa_control)throws Exception
	{
		try {
			if(this.tasa_control!=newtasa_control) {
				if(newtasa_control==null) {
					//newtasa_control=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna tasa_control");
					}
				}

				this.tasa_control=newtasa_control;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcfr(Double newcfr)throws Exception
	{
		try {
			if(this.cfr!=newcfr) {
				if(newcfr==null) {
					//newcfr=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna cfr");
					}
				}

				this.cfr=newcfr;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcif(Double newcif)throws Exception
	{
		try {
			if(this.cif!=newcif) {
				if(newcif==null) {
					//newcif=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna cif");
					}
				}

				this.cif=newcif;
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
						System.out.println("LiquidacionImpuestoImpor:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public PedidoCompraImpor getPedidoCompraImpor() {
		return this.pedidocompraimpor;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Factura getFactura() {
		return this.factura;
	}

	
	
	public String getpedidocompraimpor_descripcion() {
		return this.pedidocompraimpor_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	
	
	public  void  setPedidoCompraImpor(PedidoCompraImpor pedidocompraimpor) {
		try {
			this.pedidocompraimpor=pedidocompraimpor;
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
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


	
	
	public  void  setpedidocompraimpor_descripcion(String pedidocompraimpor_descripcion) {
		try {
			this.pedidocompraimpor_descripcion=pedidocompraimpor_descripcion;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
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


	
	
	public List<DetalleLiquidacionImpuestoImpor> getDetalleLiquidacionImpuestoImpors() {
		return this.detalleliquidacionimpuestoimpors;
	}

	
	
	public  void  setDetalleLiquidacionImpuestoImpors(List<DetalleLiquidacionImpuestoImpor> detalleliquidacionimpuestoimpors) {
		try {
			this.detalleliquidacionimpuestoimpors=detalleliquidacionimpuestoimpors;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_pedido_compra_impor_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_cliente_descripcion="";String id_factura_descripcion="";
	
	
	public String getid_pedido_compra_impor_descripcion() {
		return id_pedido_compra_impor_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	
	
	public void setid_pedido_compra_impor_descripcion(String newid_pedido_compra_impor_descripcion)throws Exception {
		try {
			this.id_pedido_compra_impor_descripcion=newid_pedido_compra_impor_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
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
		this.id_pedido_compra_impor_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_cliente_descripcion="";this.id_factura_descripcion="";
	}
	
	
	Object detalleliquidacionimpuestoimporsDescripcionReporte;
	
	
	public Object getdetalleliquidacionimpuestoimporsDescripcionReporte() {
		return detalleliquidacionimpuestoimporsDescripcionReporte;
	}

	
	
	public  void  setdetalleliquidacionimpuestoimporsDescripcionReporte(Object detalleliquidacionimpuestoimpors) {
		try {
			this.detalleliquidacionimpuestoimporsDescripcionReporte=detalleliquidacionimpuestoimpors;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

