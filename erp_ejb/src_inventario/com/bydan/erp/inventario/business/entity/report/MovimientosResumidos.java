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
package com.bydan.erp.inventario.business.entity.report;

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
//import com.bydan.erp.inventario.util.MovimientosResumidosConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;

import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class MovimientosResumidos extends MovimientosResumidosAdditional implements Serializable ,Cloneable {//MovimientosResumidosAdditional,GeneralEntity
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
	
	private MovimientosResumidos movimientosresumidosOriginal;
	
	private Map<String, Object> mapMovimientosResumidos;
			
	public Map<String, Object> getMapMovimientosResumidos() {
		return mapMovimientosResumidos;
	}

	public void setMapMovimientosResumidos(Map<String, Object> mapMovimientosResumidos) {
		this.mapMovimientosResumidos = mapMovimientosResumidos;
	}
	
	public void inicializarMapMovimientosResumidos() {
		this.mapMovimientosResumidos = new HashMap<String,Object>();
	}
	
	public void setMapMovimientosResumidosValue(String sKey,Object oValue) {
		this.mapMovimientosResumidos.put(sKey, oValue);
	}
	
	public Object getMapMovimientosResumidosValue(String sKey) {
		return this.mapMovimientosResumidos.get(sKey);
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
	private Long id_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosResumidosConstantesFunciones.SREGEXNOMBRE_SUCURSAL,message=MovimientosResumidosConstantesFunciones.SMENSAJEREGEXNOMBRE_SUCURSAL)
	private String nombre_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosResumidosConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=MovimientosResumidosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosResumidosConstantesFunciones.SREGEXNOMBRE_TRANSACCION,message=MovimientosResumidosConstantesFunciones.SMENSAJEREGEXNOMBRE_TRANSACCION)
	private String nombre_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosResumidosConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=MovimientosResumidosConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosResumidosConstantesFunciones.SREGEXNUMERO_FACTURA,message=MovimientosResumidosConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosResumidosConstantesFunciones.SREGEXNUMERO_SECUENCIAL,message=MovimientosResumidosConstantesFunciones.SMENSAJEREGEXNUMERO_SECUENCIAL)
	private String numero_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_otro;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Transaccion transaccion;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String transaccion_descripcion;
	
	
		
	public MovimientosResumidos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.movimientosresumidosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_transaccion=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.nombre_sucursal="";
 		this.nombre_completo_cliente="";
 		this.nombre_transaccion="";
 		this.numero_comprobante="";
 		this.numero_factura="";
 		this.total=0.0;
 		this.iva=0.0;
 		this.numero_secuencial="";
 		this.fecha_emision=new Date();
 		this.total_descuento=0.0;
 		this.ice=0.0;
 		this.retencion=0.0;
 		this.total_otro=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.transaccion=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.transaccion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public MovimientosResumidos (Long id,Date versionRow,String nombre_sucursal,String nombre_completo_cliente,String nombre_transaccion,String numero_comprobante,String numero_factura,Double total,Double iva,String numero_secuencial,Date fecha_emision,Double total_descuento,Double ice,Double retencion,Double total_otro) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.movimientosresumidosOriginal=this;
		
 		this.nombre_sucursal=nombre_sucursal;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.nombre_transaccion=nombre_transaccion;
 		this.numero_comprobante=numero_comprobante;
 		this.numero_factura=numero_factura;
 		this.total=total;
 		this.iva=iva;
 		this.numero_secuencial=numero_secuencial;
 		this.fecha_emision=fecha_emision;
 		this.total_descuento=total_descuento;
 		this.ice=ice;
 		this.retencion=retencion;
 		this.total_otro=total_otro;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public MovimientosResumidos (String nombre_sucursal,String nombre_completo_cliente,String nombre_transaccion,String numero_comprobante,String numero_factura,Double total,Double iva,String numero_secuencial,Date fecha_emision,Double total_descuento,Double ice,Double retencion,Double total_otro) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.movimientosresumidosOriginal=this;
		
 		this.nombre_sucursal=nombre_sucursal;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.nombre_transaccion=nombre_transaccion;
 		this.numero_comprobante=numero_comprobante;
 		this.numero_factura=numero_factura;
 		this.total=total;
 		this.iva=iva;
 		this.numero_secuencial=numero_secuencial;
 		this.fecha_emision=fecha_emision;
 		this.total_descuento=total_descuento;
 		this.ice=ice;
 		this.retencion=retencion;
 		this.total_otro=total_otro;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public MovimientosResumidos getMovimientosResumidosOriginal() {
		return this.movimientosresumidosOriginal;
	}
	
	public void setMovimientosResumidosOriginal(MovimientosResumidos movimientosresumidos) {
		try {
			this.movimientosresumidosOriginal=movimientosresumidos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected MovimientosResumidosAdditional movimientosresumidosAdditional=null;
	
	public MovimientosResumidosAdditional getMovimientosResumidosAdditional() {
		return this.movimientosresumidosAdditional;
	}
	
	public void setMovimientosResumidosAdditional(MovimientosResumidosAdditional movimientosresumidosAdditional) {
		try {
			this.movimientosresumidosAdditional=movimientosresumidosAdditional;
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
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getnombre_sucursal() {
		return this.nombre_sucursal;
	}
    
	
	public String getnombre_completo_cliente() {
		return this.nombre_completo_cliente;
	}
    
	
	public String getnombre_transaccion() {
		return this.nombre_transaccion;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public String getnumero_secuencial() {
		return this.numero_secuencial;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Double gettotal_descuento() {
		return this.total_descuento;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double getretencion() {
		return this.retencion;
	}
    
	
	public Double gettotal_otro() {
		return this.total_otro;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion(Long newid_transaccion)throws Exception
	{
		try {
			if(this.id_transaccion!=newid_transaccion) {
				if(newid_transaccion==null) {
					//newid_transaccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna fecha_emision_desde");
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_sucursal(String newnombre_sucursal)throws Exception
	{
		try {
			if(this.nombre_sucursal!=newnombre_sucursal) {
				if(newnombre_sucursal==null) {
					//newnombre_sucursal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna nombre_sucursal");
					}
				}

				if(newnombre_sucursal!=null&&newnombre_sucursal.length()>150) {
					newnombre_sucursal=newnombre_sucursal.substring(0,148);
					System.out.println("MovimientosResumidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sucursal");
				}

				this.nombre_sucursal=newnombre_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo_cliente(String newnombre_completo_cliente)throws Exception
	{
		try {
			if(this.nombre_completo_cliente!=newnombre_completo_cliente) {
				if(newnombre_completo_cliente==null) {
					//newnombre_completo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("MovimientosResumidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
				}

				this.nombre_completo_cliente=newnombre_completo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_transaccion(String newnombre_transaccion)throws Exception
	{
		try {
			if(this.nombre_transaccion!=newnombre_transaccion) {
				if(newnombre_transaccion==null) {
					//newnombre_transaccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna nombre_transaccion");
					}
				}

				if(newnombre_transaccion!=null&&newnombre_transaccion.length()>150) {
					newnombre_transaccion=newnombre_transaccion.substring(0,148);
					System.out.println("MovimientosResumidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_transaccion");
				}

				this.nombre_transaccion=newnombre_transaccion;
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("MovimientosResumidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("MovimientosResumidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna total");
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_secuencial(String newnumero_secuencial)throws Exception
	{
		try {
			if(this.numero_secuencial!=newnumero_secuencial) {
				if(newnumero_secuencial==null) {
					//newnumero_secuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna numero_secuencial");
					}
				}

				if(newnumero_secuencial!=null&&newnumero_secuencial.length()>50) {
					newnumero_secuencial=newnumero_secuencial.substring(0,48);
					System.out.println("MovimientosResumidos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_secuencial");
				}

				this.numero_secuencial=newnumero_secuencial;
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna total_descuento");
					}
				}

				this.total_descuento=newtotal_descuento;
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setretencion(Double newretencion)throws Exception
	{
		try {
			if(this.retencion!=newretencion) {
				if(newretencion==null) {
					//newretencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna retencion");
					}
				}

				this.retencion=newretencion;
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
						System.out.println("MovimientosResumidos:Valor nulo no permitido en columna total_otro");
					}
				}

				this.total_otro=newtotal_otro;
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

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
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


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
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


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_transaccion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
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
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_transaccion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

