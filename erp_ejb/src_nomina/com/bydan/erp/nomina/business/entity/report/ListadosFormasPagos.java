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
package com.bydan.erp.nomina.business.entity.report;

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
//import com.bydan.erp.nomina.util.ListadosFormasPagosConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ListadosFormasPagos extends ListadosFormasPagosAdditional implements Serializable ,Cloneable {//ListadosFormasPagosAdditional,GeneralEntity
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
	
	private ListadosFormasPagos listadosformaspagosOriginal;
	
	private Map<String, Object> mapListadosFormasPagos;
			
	public Map<String, Object> getMapListadosFormasPagos() {
		return mapListadosFormasPagos;
	}

	public void setMapListadosFormasPagos(Map<String, Object> mapListadosFormasPagos) {
		this.mapListadosFormasPagos = mapListadosFormasPagos;
	}
	
	public void inicializarMapListadosFormasPagos() {
		this.mapListadosFormasPagos = new HashMap<String,Object>();
	}
	
	public void setMapListadosFormasPagosValue(String sKey,Object oValue) {
		this.mapListadosFormasPagos.put(sKey, oValue);
	}
	
	public Object getMapListadosFormasPagosValue(String sKey) {
		return this.mapListadosFormasPagos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_grupo_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosFormasPagosConstantesFunciones.SREGEXCODIGO,message=ListadosFormasPagosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosFormasPagosConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=ListadosFormasPagosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosFormasPagosConstantesFunciones.SREGEXCODIGO_TIPO_CUENTA_BANCO_GLOBAL,message=ListadosFormasPagosConstantesFunciones.SMENSAJEREGEXCODIGO_TIPO_CUENTA_BANCO_GLOBAL)
	private String codigo_tipo_cuenta_banco_global;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosFormasPagosConstantesFunciones.SREGEXNUMERO_CUENTA,message=ListadosFormasPagosConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosFormasPagosConstantesFunciones.SREGEXCODIGO_ESTADO_ANTI_CLIENTE,message=ListadosFormasPagosConstantesFunciones.SMENSAJEREGEXCODIGO_ESTADO_ANTI_CLIENTE)
	private String codigo_estado_anti_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_adicional;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosFormasPagosConstantesFunciones.SREGEXNOMBRE_TIPO_GRUPO_FORMA_PAGO,message=ListadosFormasPagosConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_GRUPO_FORMA_PAGO)
	private String nombre_tipo_grupo_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
			
	
	public TipoGrupoFormaPago tipogrupoformapago;
	public Empresa empresa;
	public Sucursal sucursal;
	
	
	private String tipogrupoformapago_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	
	
		
	public ListadosFormasPagos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.listadosformaspagosOriginal=this;
		
 		this.id_tipo_grupo_forma_pago=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.codigo="";
 		this.nombre_completo="";
 		this.codigo_tipo_cuenta_banco_global="";
 		this.numero_cuenta="";
 		this.codigo_estado_anti_cliente="";
 		this.fecha=new Date();
 		this.valor=0.0;
 		this.valor_adicional=0.0;
 		this.nombre_tipo_grupo_forma_pago="";
 		this.total=0.0;
		
		
		this.tipogrupoformapago=null;
		this.empresa=null;
		this.sucursal=null;
		
		
		this.tipogrupoformapago_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ListadosFormasPagos (Long id,Date versionRow,String codigo,String nombre_completo,String codigo_tipo_cuenta_banco_global,String numero_cuenta,String codigo_estado_anti_cliente,Date fecha,Double valor,Double valor_adicional,String nombre_tipo_grupo_forma_pago,Double total) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.listadosformaspagosOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre_completo=nombre_completo;
 		this.codigo_tipo_cuenta_banco_global=codigo_tipo_cuenta_banco_global;
 		this.numero_cuenta=numero_cuenta;
 		this.codigo_estado_anti_cliente=codigo_estado_anti_cliente;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.valor_adicional=valor_adicional;
 		this.nombre_tipo_grupo_forma_pago=nombre_tipo_grupo_forma_pago;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ListadosFormasPagos (String codigo,String nombre_completo,String codigo_tipo_cuenta_banco_global,String numero_cuenta,String codigo_estado_anti_cliente,Date fecha,Double valor,Double valor_adicional,String nombre_tipo_grupo_forma_pago,Double total) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.listadosformaspagosOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre_completo=nombre_completo;
 		this.codigo_tipo_cuenta_banco_global=codigo_tipo_cuenta_banco_global;
 		this.numero_cuenta=numero_cuenta;
 		this.codigo_estado_anti_cliente=codigo_estado_anti_cliente;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.valor_adicional=valor_adicional;
 		this.nombre_tipo_grupo_forma_pago=nombre_tipo_grupo_forma_pago;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ListadosFormasPagos getListadosFormasPagosOriginal() {
		return this.listadosformaspagosOriginal;
	}
	
	public void setListadosFormasPagosOriginal(ListadosFormasPagos listadosformaspagos) {
		try {
			this.listadosformaspagosOriginal=listadosformaspagos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ListadosFormasPagosAdditional listadosformaspagosAdditional=null;
	
	public ListadosFormasPagosAdditional getListadosFormasPagosAdditional() {
		return this.listadosformaspagosAdditional;
	}
	
	public void setListadosFormasPagosAdditional(ListadosFormasPagosAdditional listadosformaspagosAdditional) {
		try {
			this.listadosformaspagosAdditional=listadosformaspagosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_tipo_grupo_forma_pago() {
		return this.id_tipo_grupo_forma_pago;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Date getfecha_desde() {
		return this.fecha_desde;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String getcodigo_tipo_cuenta_banco_global() {
		return this.codigo_tipo_cuenta_banco_global;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public String getcodigo_estado_anti_cliente() {
		return this.codigo_estado_anti_cliente;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Double getvalor_adicional() {
		return this.valor_adicional;
	}
    
	
	public String getnombre_tipo_grupo_forma_pago() {
		return this.nombre_tipo_grupo_forma_pago;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
	
    
	public void setid_tipo_grupo_forma_pago(Long newid_tipo_grupo_forma_pago)throws Exception
	{
		try {
			if(this.id_tipo_grupo_forma_pago!=newid_tipo_grupo_forma_pago) {
				if(newid_tipo_grupo_forma_pago==null) {
					//newid_tipo_grupo_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna id_tipo_grupo_forma_pago");
					}
				}

				this.id_tipo_grupo_forma_pago=newid_tipo_grupo_forma_pago;
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
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_desde(Date newfecha_desde)throws Exception
	{
		try {
			if(this.fecha_desde!=newfecha_desde) {
				if(newfecha_desde==null) {
					//newfecha_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna fecha_desde");
					}
				}

				this.fecha_desde=newfecha_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_hasta(Date newfecha_hasta)throws Exception
	{
		try {
			if(this.fecha_hasta!=newfecha_hasta) {
				if(newfecha_hasta==null) {
					//newfecha_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
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
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("ListadosFormasPagos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>200) {
					newnombre_completo=newnombre_completo.substring(0,198);
					System.out.println("ListadosFormasPagos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_tipo_cuenta_banco_global(String newcodigo_tipo_cuenta_banco_global)throws Exception
	{
		try {
			if(this.codigo_tipo_cuenta_banco_global!=newcodigo_tipo_cuenta_banco_global) {
				if(newcodigo_tipo_cuenta_banco_global==null) {
					//newcodigo_tipo_cuenta_banco_global="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna codigo_tipo_cuenta_banco_global");
					}
				}

				if(newcodigo_tipo_cuenta_banco_global!=null&&newcodigo_tipo_cuenta_banco_global.length()>50) {
					newcodigo_tipo_cuenta_banco_global=newcodigo_tipo_cuenta_banco_global.substring(0,48);
					System.out.println("ListadosFormasPagos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_tipo_cuenta_banco_global");
				}

				this.codigo_tipo_cuenta_banco_global=newcodigo_tipo_cuenta_banco_global;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuenta(String newnumero_cuenta)throws Exception
	{
		try {
			if(this.numero_cuenta!=newnumero_cuenta) {
				if(newnumero_cuenta==null) {
					//newnumero_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>50) {
					newnumero_cuenta=newnumero_cuenta.substring(0,48);
					System.out.println("ListadosFormasPagos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_estado_anti_cliente(String newcodigo_estado_anti_cliente)throws Exception
	{
		try {
			if(this.codigo_estado_anti_cliente!=newcodigo_estado_anti_cliente) {
				if(newcodigo_estado_anti_cliente==null) {
					//newcodigo_estado_anti_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna codigo_estado_anti_cliente");
					}
				}

				if(newcodigo_estado_anti_cliente!=null&&newcodigo_estado_anti_cliente.length()>50) {
					newcodigo_estado_anti_cliente=newcodigo_estado_anti_cliente.substring(0,48);
					System.out.println("ListadosFormasPagos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_estado_anti_cliente");
				}

				this.codigo_estado_anti_cliente=newcodigo_estado_anti_cliente;
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
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_adicional(Double newvalor_adicional)throws Exception
	{
		try {
			if(this.valor_adicional!=newvalor_adicional) {
				if(newvalor_adicional==null) {
					//newvalor_adicional=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna valor_adicional");
					}
				}

				this.valor_adicional=newvalor_adicional;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_grupo_forma_pago(String newnombre_tipo_grupo_forma_pago)throws Exception
	{
		try {
			if(this.nombre_tipo_grupo_forma_pago!=newnombre_tipo_grupo_forma_pago) {
				if(newnombre_tipo_grupo_forma_pago==null) {
					//newnombre_tipo_grupo_forma_pago="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna nombre_tipo_grupo_forma_pago");
					}
				}

				if(newnombre_tipo_grupo_forma_pago!=null&&newnombre_tipo_grupo_forma_pago.length()>150) {
					newnombre_tipo_grupo_forma_pago=newnombre_tipo_grupo_forma_pago.substring(0,148);
					System.out.println("ListadosFormasPagos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_tipo_grupo_forma_pago");
				}

				this.nombre_tipo_grupo_forma_pago=newnombre_tipo_grupo_forma_pago;
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
						System.out.println("ListadosFormasPagos:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public TipoGrupoFormaPago getTipoGrupoFormaPago() {
		return this.tipogrupoformapago;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	
	
	public String gettipogrupoformapago_descripcion() {
		return this.tipogrupoformapago_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	
	
	public  void  setTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapago) {
		try {
			this.tipogrupoformapago=tipogrupoformapago;
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


	
	
	public  void  settipogrupoformapago_descripcion(String tipogrupoformapago_descripcion) {
		try {
			this.tipogrupoformapago_descripcion=tipogrupoformapago_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_tipo_grupo_forma_pago_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";
	
	
	public String getid_tipo_grupo_forma_pago_descripcion() {
		return id_tipo_grupo_forma_pago_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	
	
	public void setid_tipo_grupo_forma_pago_descripcion(String newid_tipo_grupo_forma_pago_descripcion)throws Exception {
		try {
			this.id_tipo_grupo_forma_pago_descripcion=newid_tipo_grupo_forma_pago_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_tipo_grupo_forma_pago_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

