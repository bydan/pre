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
//import com.bydan.erp.facturacion.util.TransportistaConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class Transportista extends TransportistaAdditional implements Serializable ,Cloneable {//TransportistaAdditional,GeneralEntity
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
	
	private Transportista transportistaOriginal;
	
	private Map<String, Object> mapTransportista;
			
	public Map<String, Object> getMapTransportista() {
		return mapTransportista;
	}

	public void setMapTransportista(Map<String, Object> mapTransportista) {
		this.mapTransportista = mapTransportista;
	}
	
	public void inicializarMapTransportista() {
		this.mapTransportista = new HashMap<String,Object>();
	}
	
	public void setMapTransportistaValue(String sKey,Object oValue) {
		this.mapTransportista.put(sKey, oValue);
	}
	
	public Object getMapTransportistaValue(String sKey) {
		return this.mapTransportista.get(sKey);
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
	private Long id_tipo_via_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=25,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransportistaConstantesFunciones.SREGEXIDENTIFICACION,message=TransportistaConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TransportistaConstantesFunciones.SREGEXRUC,message=TransportistaConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransportistaConstantesFunciones.SREGEXNOMBRE,message=TransportistaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransportistaConstantesFunciones.SREGEXAPELLIDO,message=TransportistaConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TransportistaConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=TransportistaConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransportistaConstantesFunciones.SREGEXTELEFONO,message=TransportistaConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TransportistaConstantesFunciones.SREGEXDIRECCION,message=TransportistaConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransportistaConstantesFunciones.SREGEXPLACA,message=TransportistaConstantesFunciones.SMENSAJEREGEXPLACA)
	private String placa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TransportistaConstantesFunciones.SREGEXNUMERO,message=TransportistaConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TransportistaConstantesFunciones.SREGEXOBSERVACION,message=TransportistaConstantesFunciones.SMENSAJEREGEXOBSERVACION)
	private String observacion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TipoViaTransporte tipoviatransporte;
	public Cliente cliente;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tipoviatransporte_descripcion;
	private String cliente_descripcion;
	
	
		
	public Transportista () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.transportistaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_tipo_via_transporte=-1L;
 		this.identificacion="";
 		this.ruc="";
 		this.nombre="";
 		this.apellido="";
 		this.nombre_completo="";
 		this.telefono="";
 		this.direccion="";
 		this.id_cliente=-1L;
 		this.placa="";
 		this.numero="";
 		this.observacion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tipoviatransporte=null;
		this.cliente=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tipoviatransporte_descripcion="";
		this.cliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Transportista (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_tipo_via_transporte,String identificacion,String ruc,String nombre,String apellido,String nombre_completo,String telefono,String direccion,Long id_cliente,String placa,String numero,String observacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transportistaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.identificacion=identificacion;
 		this.ruc=ruc;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.nombre_completo=nombre_completo;
 		this.telefono=telefono;
 		this.direccion=direccion;
 		this.id_cliente=id_cliente;
 		this.placa=placa;
 		this.numero=numero;
 		this.observacion=observacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Transportista (Long id_empresa,Long id_sucursal,Long id_tipo_via_transporte,String identificacion,String ruc,String nombre,String apellido,String nombre_completo,String telefono,String direccion,Long id_cliente,String placa,String numero,String observacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transportistaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.identificacion=identificacion;
 		this.ruc=ruc;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.nombre_completo=nombre_completo;
 		this.telefono=telefono;
 		this.direccion=direccion;
 		this.id_cliente=id_cliente;
 		this.placa=placa;
 		this.numero=numero;
 		this.observacion=observacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Transportista transportistaLocal=null;
		
		if(object!=null) {
			transportistaLocal=(Transportista)object;
			
			if(transportistaLocal!=null) {
				if(this.getId()!=null && transportistaLocal.getId()!=null) {
					if(this.getId().equals(transportistaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TransportistaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TransportistaConstantesFunciones.getTransportistaDescripcion(this);
		} else {
			sDetalle=TransportistaConstantesFunciones.getTransportistaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Transportista getTransportistaOriginal() {
		return this.transportistaOriginal;
	}
	
	public void setTransportistaOriginal(Transportista transportista) {
		try {
			this.transportistaOriginal=transportista;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TransportistaAdditional transportistaAdditional=null;
	
	public TransportistaAdditional getTransportistaAdditional() {
		return this.transportistaAdditional;
	}
	
	public void setTransportistaAdditional(TransportistaAdditional transportistaAdditional) {
		try {
			this.transportistaAdditional=transportistaAdditional;
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
    
	
	public Long getid_tipo_via_transporte() {
		return this.id_tipo_via_transporte;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getapellido() {
		return this.apellido;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getplaca() {
		return this.placa;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getobservacion() {
		return this.observacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Transportista:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_via_transporte(Long newid_tipo_via_transporte)throws Exception
	{
		try {
			if(this.id_tipo_via_transporte!=newid_tipo_via_transporte) {
				if(newid_tipo_via_transporte==null) {
					//newid_tipo_via_transporte=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna id_tipo_via_transporte");
					}
				}

				this.id_tipo_via_transporte=newid_tipo_via_transporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidentificacion(String newidentificacion)throws Exception
	{
		try {
			if(this.identificacion!=newidentificacion) {
				if(newidentificacion==null) {
					//newidentificacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>25) {
					newidentificacion=newidentificacion.substring(0,23);
					System.out.println("Transportista:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=25 en columna identificacion");
				}

				this.identificacion=newidentificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>15) {
					newruc=newruc.substring(0,13);
					System.out.println("Transportista:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Transportista:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellido(String newapellido)throws Exception
	{
		try {
			if(this.apellido!=newapellido) {
				if(newapellido==null) {
					//newapellido="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>100) {
					newapellido=newapellido.substring(0,98);
					System.out.println("Transportista:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellido");
				}

				this.apellido=newapellido;
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
						System.out.println("Transportista:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>200) {
					newnombre_completo=newnombre_completo.substring(0,198);
					System.out.println("Transportista:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("Transportista:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("Transportista:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
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
						System.out.println("Transportista:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setplaca(String newplaca)throws Exception
	{
		try {
			if(this.placa!=newplaca) {
				if(newplaca==null) {
					//newplaca="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna placa");
					}
				}

				if(newplaca!=null&&newplaca.length()>50) {
					newplaca=newplaca.substring(0,48);
					System.out.println("Transportista:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna placa");
				}

				this.placa=newplaca;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("Transportista:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion(String newobservacion)throws Exception
	{
		try {
			if(this.observacion!=newobservacion) {
				if(newobservacion==null) {
					//newobservacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Transportista:Valor nulo no permitido en columna observacion");
					}
				}

				if(newobservacion!=null&&newobservacion.length()>250) {
					newobservacion=newobservacion.substring(0,248);
					System.out.println("Transportista:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna observacion");
				}

				this.observacion=newobservacion;
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

	public TipoViaTransporte getTipoViaTransporte() {
		return this.tipoviatransporte;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettipoviatransporte_descripcion() {
		return this.tipoviatransporte_descripcion;
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


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoViaTransporte(TipoViaTransporte tipoviatransporte) {
		try {
			this.tipoviatransporte=tipoviatransporte;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoviatransporte_descripcion(String tipoviatransporte_descripcion) {
		try {
			this.tipoviatransporte_descripcion=tipoviatransporte_descripcion;
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
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tipo_via_transporte_descripcion="";String id_cliente_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_via_transporte_descripcion() {
		return id_tipo_via_transporte_descripcion;
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
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_via_transporte_descripcion(String newid_tipo_via_transporte_descripcion)throws Exception {
		try {
			this.id_tipo_via_transporte_descripcion=newid_tipo_via_transporte_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_via_transporte_descripcion="";this.id_cliente_descripcion="";
	}
	
	
	Object notacreditosolisDescripcionReporte;
	Object guiaremisionsDescripcionReporte;
	Object transferenciasDescripcionReporte;
	Object pedidoexporsDescripcionReporte;
	Object comprasDescripcionReporte;
	Object movimientoinventariosDescripcionReporte;
	Object ordencomprasDescripcionReporte;
	Object facturasDescripcionReporte;
	Object pedidosDescripcionReporte;
	Object consignacionsDescripcionReporte;
	Object notacreditosDescripcionReporte;
	Object serviciotransportesDescripcionReporte;
	
	
	public Object getnotacreditosolisDescripcionReporte() {
		return notacreditosolisDescripcionReporte;
	}

	public Object getguiaremisionsDescripcionReporte() {
		return guiaremisionsDescripcionReporte;
	}

	public Object gettransferenciasDescripcionReporte() {
		return transferenciasDescripcionReporte;
	}

	public Object getpedidoexporsDescripcionReporte() {
		return pedidoexporsDescripcionReporte;
	}

	public Object getcomprasDescripcionReporte() {
		return comprasDescripcionReporte;
	}

	public Object getmovimientoinventariosDescripcionReporte() {
		return movimientoinventariosDescripcionReporte;
	}

	public Object getordencomprasDescripcionReporte() {
		return ordencomprasDescripcionReporte;
	}

	public Object getfacturasDescripcionReporte() {
		return facturasDescripcionReporte;
	}

	public Object getpedidosDescripcionReporte() {
		return pedidosDescripcionReporte;
	}

	public Object getconsignacionsDescripcionReporte() {
		return consignacionsDescripcionReporte;
	}

	public Object getnotacreditosDescripcionReporte() {
		return notacreditosDescripcionReporte;
	}

	public Object getserviciotransportesDescripcionReporte() {
		return serviciotransportesDescripcionReporte;
	}

	
	
	public  void  setnotacreditosolisDescripcionReporte(Object notacreditosolis) {
		try {
			this.notacreditosolisDescripcionReporte=notacreditosolis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setguiaremisionsDescripcionReporte(Object guiaremisions) {
		try {
			this.guiaremisionsDescripcionReporte=guiaremisions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransferenciasDescripcionReporte(Object transferencias) {
		try {
			this.transferenciasDescripcionReporte=transferencias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidoexporsDescripcionReporte(Object pedidoexpors) {
		try {
			this.pedidoexporsDescripcionReporte=pedidoexpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomprasDescripcionReporte(Object compras) {
		try {
			this.comprasDescripcionReporte=compras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmovimientoinventariosDescripcionReporte(Object movimientoinventarios) {
		try {
			this.movimientoinventariosDescripcionReporte=movimientoinventarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setordencomprasDescripcionReporte(Object ordencompras) {
		try {
			this.ordencomprasDescripcionReporte=ordencompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturasDescripcionReporte(Object facturas) {
		try {
			this.facturasDescripcionReporte=facturas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidosDescripcionReporte(Object pedidos) {
		try {
			this.pedidosDescripcionReporte=pedidos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setconsignacionsDescripcionReporte(Object consignacions) {
		try {
			this.consignacionsDescripcionReporte=consignacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditosDescripcionReporte(Object notacreditos) {
		try {
			this.notacreditosDescripcionReporte=notacreditos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setserviciotransportesDescripcionReporte(Object serviciotransportes) {
		try {
			this.serviciotransportesDescripcionReporte=serviciotransportes;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

