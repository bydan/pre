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
//import com.bydan.erp.tesoreria.util.ListadosDocumentosConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ListadosDocumentos extends ListadosDocumentosAdditional implements Serializable ,Cloneable {//ListadosDocumentosAdditional,GeneralEntity
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
	
	private ListadosDocumentos listadosdocumentosOriginal;
	
	private Map<String, Object> mapListadosDocumentos;
			
	public Map<String, Object> getMapListadosDocumentos() {
		return mapListadosDocumentos;
	}

	public void setMapListadosDocumentos(Map<String, Object> mapListadosDocumentos) {
		this.mapListadosDocumentos = mapListadosDocumentos;
	}
	
	public void inicializarMapListadosDocumentos() {
		this.mapListadosDocumentos = new HashMap<String,Object>();
	}
	
	public void setMapListadosDocumentosValue(String sKey,Object oValue) {
		this.mapListadosDocumentos.put(sKey, oValue);
	}
	
	public Object getMapListadosDocumentosValue(String sKey) {
		return this.mapListadosDocumentos.get(sKey);
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXTIPO_MOVIMIENTO,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXTIPO_MOVIMIENTO)
	private String tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXCODIGO,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXBENEFICIARIO,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXBENEFICIARIO_CHEQUE,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXBENEFICIARIO_CHEQUE)
	private String beneficiario_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXDETALLE,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXDETALLE)
	private String detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXNOMBRE_EMPRESA,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXNOMBRE_EMPRESA)
	private String nombre_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXRUC_EMPRESA,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXRUC_EMPRESA)
	private String ruc_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXDIRECCION_EMPRESA,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXDIRECCION_EMPRESA)
	private String direccion_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXNOMBRE_SUCURSAL,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXNOMBRE_SUCURSAL)
	private String nombre_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXNUMERO_MAYOR,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_finalizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXNOMBRE_USUARIO,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXNOMBRE_USUARIO)
	private String nombre_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ListadosDocumentosConstantesFunciones.SREGEXNUMERO_CHEQUE,message=ListadosDocumentosConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public TipoMovimiento tipomovimiento;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String tipomovimiento_descripcion;
	
	
		
	public ListadosDocumentos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.listadosdocumentosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_tipo_movimiento=-1L;
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.fecha=new Date();
 		this.tipo_movimiento="";
 		this.codigo="";
 		this.beneficiario="";
 		this.beneficiario_cheque="";
 		this.detalle="";
 		this.valor_cheque=0.0;
 		this.nombre_empresa="";
 		this.ruc_empresa="";
 		this.direccion_empresa="";
 		this.nombre_sucursal="";
 		this.valor=0.0;
 		this.numero_mayor="";
 		this.fecha_emision=new Date();
 		this.fecha_finalizacion=new Date();
 		this.nombre_usuario="";
 		this.numero_cheque="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.tipomovimiento=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.tipomovimiento_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ListadosDocumentos (Long id,Date versionRow,Date fecha,String tipo_movimiento,String codigo,String beneficiario,String beneficiario_cheque,String detalle,Double valor_cheque,String nombre_empresa,String ruc_empresa,String direccion_empresa,String nombre_sucursal,Double valor,String numero_mayor,Date fecha_emision,Date fecha_finalizacion,String nombre_usuario,String numero_cheque) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.listadosdocumentosOriginal=this;
		
 		this.fecha=fecha;
 		this.tipo_movimiento=tipo_movimiento;
 		this.codigo=codigo;
 		this.beneficiario=beneficiario;
 		this.beneficiario_cheque=beneficiario_cheque;
 		this.detalle=detalle;
 		this.valor_cheque=valor_cheque;
 		this.nombre_empresa=nombre_empresa;
 		this.ruc_empresa=ruc_empresa;
 		this.direccion_empresa=direccion_empresa;
 		this.nombre_sucursal=nombre_sucursal;
 		this.valor=valor;
 		this.numero_mayor=numero_mayor;
 		this.fecha_emision=fecha_emision;
 		this.fecha_finalizacion=fecha_finalizacion;
 		this.nombre_usuario=nombre_usuario;
 		this.numero_cheque=numero_cheque;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ListadosDocumentos (Date fecha,String tipo_movimiento,String codigo,String beneficiario,String beneficiario_cheque,String detalle,Double valor_cheque,String nombre_empresa,String ruc_empresa,String direccion_empresa,String nombre_sucursal,Double valor,String numero_mayor,Date fecha_emision,Date fecha_finalizacion,String nombre_usuario,String numero_cheque) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.listadosdocumentosOriginal=this;
		
 		this.fecha=fecha;
 		this.tipo_movimiento=tipo_movimiento;
 		this.codigo=codigo;
 		this.beneficiario=beneficiario;
 		this.beneficiario_cheque=beneficiario_cheque;
 		this.detalle=detalle;
 		this.valor_cheque=valor_cheque;
 		this.nombre_empresa=nombre_empresa;
 		this.ruc_empresa=ruc_empresa;
 		this.direccion_empresa=direccion_empresa;
 		this.nombre_sucursal=nombre_sucursal;
 		this.valor=valor;
 		this.numero_mayor=numero_mayor;
 		this.fecha_emision=fecha_emision;
 		this.fecha_finalizacion=fecha_finalizacion;
 		this.nombre_usuario=nombre_usuario;
 		this.numero_cheque=numero_cheque;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ListadosDocumentos getListadosDocumentosOriginal() {
		return this.listadosdocumentosOriginal;
	}
	
	public void setListadosDocumentosOriginal(ListadosDocumentos listadosdocumentos) {
		try {
			this.listadosdocumentosOriginal=listadosdocumentos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ListadosDocumentosAdditional listadosdocumentosAdditional=null;
	
	public ListadosDocumentosAdditional getListadosDocumentosAdditional() {
		return this.listadosdocumentosAdditional;
	}
	
	public void setListadosDocumentosAdditional(ListadosDocumentosAdditional listadosdocumentosAdditional) {
		try {
			this.listadosdocumentosAdditional=listadosdocumentosAdditional;
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
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public Date getfecha_desde() {
		return this.fecha_desde;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String gettipo_movimiento() {
		return this.tipo_movimiento;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getbeneficiario() {
		return this.beneficiario;
	}
    
	
	public String getbeneficiario_cheque() {
		return this.beneficiario_cheque;
	}
    
	
	public String getdetalle() {
		return this.detalle;
	}
    
	
	public Double getvalor_cheque() {
		return this.valor_cheque;
	}
    
	
	public String getnombre_empresa() {
		return this.nombre_empresa;
	}
    
	
	public String getruc_empresa() {
		return this.ruc_empresa;
	}
    
	
	public String getdireccion_empresa() {
		return this.direccion_empresa;
	}
    
	
	public String getnombre_sucursal() {
		return this.nombre_sucursal;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_finalizacion() {
		return this.fecha_finalizacion;
	}
    
	
	public String getnombre_usuario() {
		return this.nombre_usuario;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento)throws Exception
	{
		try {
			if(this.id_tipo_movimiento!=newid_tipo_movimiento) {
				if(newid_tipo_movimiento==null) {
					//newid_tipo_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna fecha_desde");
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna fecha");
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna tipo_movimiento");
					}
				}

				if(newtipo_movimiento!=null&&newtipo_movimiento.length()>100) {
					newtipo_movimiento=newtipo_movimiento.substring(0,98);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna tipo_movimiento");
				}

				this.tipo_movimiento=newtipo_movimiento;
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbeneficiario(String newbeneficiario)throws Exception
	{
		try {
			if(this.beneficiario!=newbeneficiario) {
				if(newbeneficiario==null) {
					//newbeneficiario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>200) {
					newbeneficiario=newbeneficiario.substring(0,198);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna beneficiario");
				}

				this.beneficiario=newbeneficiario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbeneficiario_cheque(String newbeneficiario_cheque)throws Exception
	{
		try {
			if(this.beneficiario_cheque!=newbeneficiario_cheque) {
				if(newbeneficiario_cheque==null) {
					//newbeneficiario_cheque="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna beneficiario_cheque");
					}
				}

				if(newbeneficiario_cheque!=null&&newbeneficiario_cheque.length()>200) {
					newbeneficiario_cheque=newbeneficiario_cheque.substring(0,198);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna beneficiario_cheque");
				}

				this.beneficiario_cheque=newbeneficiario_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdetalle(String newdetalle)throws Exception
	{
		try {
			if(this.detalle!=newdetalle) {
				if(newdetalle==null) {
					//newdetalle="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna detalle");
					}
				}

				if(newdetalle!=null&&newdetalle.length()>250) {
					newdetalle=newdetalle.substring(0,248);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna detalle");
				}

				this.detalle=newdetalle;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_cheque(Double newvalor_cheque)throws Exception
	{
		try {
			if(this.valor_cheque!=newvalor_cheque) {
				if(newvalor_cheque==null) {
					//newvalor_cheque=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna valor_cheque");
					}
				}

				this.valor_cheque=newvalor_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_empresa(String newnombre_empresa)throws Exception
	{
		try {
			if(this.nombre_empresa!=newnombre_empresa) {
				if(newnombre_empresa==null) {
					//newnombre_empresa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna nombre_empresa");
					}
				}

				if(newnombre_empresa!=null&&newnombre_empresa.length()>150) {
					newnombre_empresa=newnombre_empresa.substring(0,148);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_empresa");
				}

				this.nombre_empresa=newnombre_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc_empresa(String newruc_empresa)throws Exception
	{
		try {
			if(this.ruc_empresa!=newruc_empresa) {
				if(newruc_empresa==null) {
					//newruc_empresa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna ruc_empresa");
					}
				}

				if(newruc_empresa!=null&&newruc_empresa.length()>15) {
					newruc_empresa=newruc_empresa.substring(0,13);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc_empresa");
				}

				this.ruc_empresa=newruc_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_empresa(String newdireccion_empresa)throws Exception
	{
		try {
			if(this.direccion_empresa!=newdireccion_empresa) {
				if(newdireccion_empresa==null) {
					//newdireccion_empresa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna direccion_empresa");
					}
				}

				if(newdireccion_empresa!=null&&newdireccion_empresa.length()>250) {
					newdireccion_empresa=newdireccion_empresa.substring(0,248);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna direccion_empresa");
				}

				this.direccion_empresa=newdireccion_empresa;
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna nombre_sucursal");
					}
				}

				if(newnombre_sucursal!=null&&newnombre_sucursal.length()>150) {
					newnombre_sucursal=newnombre_sucursal.substring(0,148);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sucursal");
				}

				this.nombre_sucursal=newnombre_sucursal;
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
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
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_finalizacion(Date newfecha_finalizacion)throws Exception
	{
		try {
			if(this.fecha_finalizacion!=newfecha_finalizacion) {
				if(newfecha_finalizacion==null) {
					//newfecha_finalizacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna fecha_finalizacion");
					}
				}

				this.fecha_finalizacion=newfecha_finalizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_usuario(String newnombre_usuario)throws Exception
	{
		try {
			if(this.nombre_usuario!=newnombre_usuario) {
				if(newnombre_usuario==null) {
					//newnombre_usuario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna nombre_usuario");
					}
				}

				if(newnombre_usuario!=null&&newnombre_usuario.length()>50) {
					newnombre_usuario=newnombre_usuario.substring(0,48);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_usuario");
				}

				this.nombre_usuario=newnombre_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cheque(String newnumero_cheque)throws Exception
	{
		try {
			if(this.numero_cheque!=newnumero_cheque) {
				if(newnumero_cheque==null) {
					//newnumero_cheque="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ListadosDocumentos:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("ListadosDocumentos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
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

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
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

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
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


	public  void  setTipoMovimiento(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimiento=tipomovimiento;
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


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_tipo_movimiento_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
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
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_tipo_movimiento_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

