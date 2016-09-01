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
//import com.bydan.erp.tesoreria.util.PagosAutorizadosProcesoConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class PagosAutorizadosProceso extends PagosAutorizadosProcesoAdditional implements Serializable ,Cloneable {//PagosAutorizadosProcesoAdditional,GeneralEntity
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
	
	private PagosAutorizadosProceso pagosautorizadosprocesoOriginal;
	
	private Map<String, Object> mapPagosAutorizadosProceso;
			
	public Map<String, Object> getMapPagosAutorizadosProceso() {
		return mapPagosAutorizadosProceso;
	}

	public void setMapPagosAutorizadosProceso(Map<String, Object> mapPagosAutorizadosProceso) {
		this.mapPagosAutorizadosProceso = mapPagosAutorizadosProceso;
	}
	
	public void inicializarMapPagosAutorizadosProceso() {
		this.mapPagosAutorizadosProceso = new HashMap<String,Object>();
	}
	
	public void setMapPagosAutorizadosProcesoValue(String sKey,Object oValue) {
		this.mapPagosAutorizadosProceso.put(sKey, oValue);
	}
	
	public Object getMapPagosAutorizadosProcesoValue(String sKey) {
		return this.mapPagosAutorizadosProceso.get(sKey);
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
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosProcesoConstantesFunciones.SREGEXNOMBRE_TIPO_DOCUMENTO,message=PagosAutorizadosProcesoConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_DOCUMENTO)
	private String nombre_tipo_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosProcesoConstantesFunciones.SREGEXCODIGO,message=PagosAutorizadosProcesoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosProcesoConstantesFunciones.SREGEXBENEFICIARIO,message=PagosAutorizadosProcesoConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosProcesoConstantesFunciones.SREGEXCODIGO_TIPO_MOVIMIENTO_MODULO,message=PagosAutorizadosProcesoConstantesFunciones.SMENSAJEREGEXCODIGO_TIPO_MOVIMIENTO_MODULO)
	private String codigo_tipo_movimiento_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosProcesoConstantesFunciones.SREGEXNUMERO_MAYOR,message=PagosAutorizadosProcesoConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosProcesoConstantesFunciones.SREGEXCODIGO_CUENTA_BANCO,message=PagosAutorizadosProcesoConstantesFunciones.SMENSAJEREGEXCODIGO_CUENTA_BANCO)
	private String codigo_cuenta_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosProcesoConstantesFunciones.SREGEXNUMERO_CHEQUE,message=PagosAutorizadosProcesoConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=PagosAutorizadosProcesoConstantesFunciones.SREGEXBENEFICIARIO_DETALLE_CHEQUE_GIRADO,message=PagosAutorizadosProcesoConstantesFunciones.SMENSAJEREGEXBENEFICIARIO_DETALLE_CHEQUE_GIRADO)
	private String beneficiario_detalle_cheque_girado;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	
	
		
	public PagosAutorizadosProceso () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.pagosautorizadosprocesoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.nombre_tipo_documento="";
 		this.codigo="";
 		this.beneficiario="";
 		this.fecha=new Date();
 		this.fecha_emision=new Date();
 		this.codigo_tipo_movimiento_modulo="";
 		this.numero_mayor="";
 		this.valor=0.0;
 		this.codigo_cuenta_banco="";
 		this.numero_cheque="";
 		this.beneficiario_detalle_cheque_girado="";
		
		
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
	public PagosAutorizadosProceso (Long id,Date versionRow,String nombre_tipo_documento,String codigo,String beneficiario,Date fecha,Date fecha_emision,String codigo_tipo_movimiento_modulo,String numero_mayor,Double valor,String codigo_cuenta_banco,String numero_cheque,String beneficiario_detalle_cheque_girado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pagosautorizadosprocesoOriginal=this;
		
 		this.nombre_tipo_documento=nombre_tipo_documento;
 		this.codigo=codigo;
 		this.beneficiario=beneficiario;
 		this.fecha=fecha;
 		this.fecha_emision=fecha_emision;
 		this.codigo_tipo_movimiento_modulo=codigo_tipo_movimiento_modulo;
 		this.numero_mayor=numero_mayor;
 		this.valor=valor;
 		this.codigo_cuenta_banco=codigo_cuenta_banco;
 		this.numero_cheque=numero_cheque;
 		this.beneficiario_detalle_cheque_girado=beneficiario_detalle_cheque_girado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PagosAutorizadosProceso (String nombre_tipo_documento,String codigo,String beneficiario,Date fecha,Date fecha_emision,String codigo_tipo_movimiento_modulo,String numero_mayor,Double valor,String codigo_cuenta_banco,String numero_cheque,String beneficiario_detalle_cheque_girado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pagosautorizadosprocesoOriginal=this;
		
 		this.nombre_tipo_documento=nombre_tipo_documento;
 		this.codigo=codigo;
 		this.beneficiario=beneficiario;
 		this.fecha=fecha;
 		this.fecha_emision=fecha_emision;
 		this.codigo_tipo_movimiento_modulo=codigo_tipo_movimiento_modulo;
 		this.numero_mayor=numero_mayor;
 		this.valor=valor;
 		this.codigo_cuenta_banco=codigo_cuenta_banco;
 		this.numero_cheque=numero_cheque;
 		this.beneficiario_detalle_cheque_girado=beneficiario_detalle_cheque_girado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public PagosAutorizadosProceso getPagosAutorizadosProcesoOriginal() {
		return this.pagosautorizadosprocesoOriginal;
	}
	
	public void setPagosAutorizadosProcesoOriginal(PagosAutorizadosProceso pagosautorizadosproceso) {
		try {
			this.pagosautorizadosprocesoOriginal=pagosautorizadosproceso;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PagosAutorizadosProcesoAdditional pagosautorizadosprocesoAdditional=null;
	
	public PagosAutorizadosProcesoAdditional getPagosAutorizadosProcesoAdditional() {
		return this.pagosautorizadosprocesoAdditional;
	}
	
	public void setPagosAutorizadosProcesoAdditional(PagosAutorizadosProcesoAdditional pagosautorizadosprocesoAdditional) {
		try {
			this.pagosautorizadosprocesoAdditional=pagosautorizadosprocesoAdditional;
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
    
	
	public String getnombre_tipo_documento() {
		return this.nombre_tipo_documento;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getbeneficiario() {
		return this.beneficiario;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getcodigo_tipo_movimiento_modulo() {
		return this.codigo_tipo_movimiento_modulo;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getcodigo_cuenta_banco() {
		return this.codigo_cuenta_banco;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
	}
    
	
	public String getbeneficiario_detalle_cheque_girado() {
		return this.beneficiario_detalle_cheque_girado;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_documento(String newnombre_tipo_documento)throws Exception
	{
		try {
			if(this.nombre_tipo_documento!=newnombre_tipo_documento) {
				if(newnombre_tipo_documento==null) {
					//newnombre_tipo_documento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna nombre_tipo_documento");
					}
				}

				if(newnombre_tipo_documento!=null&&newnombre_tipo_documento.length()>100) {
					newnombre_tipo_documento=newnombre_tipo_documento.substring(0,98);
					System.out.println("PagosAutorizadosProceso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_documento");
				}

				this.nombre_tipo_documento=newnombre_tipo_documento;
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
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("PagosAutorizadosProceso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>200) {
					newbeneficiario=newbeneficiario.substring(0,198);
					System.out.println("PagosAutorizadosProceso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna beneficiario");
				}

				this.beneficiario=newbeneficiario;
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
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_tipo_movimiento_modulo(String newcodigo_tipo_movimiento_modulo)throws Exception
	{
		try {
			if(this.codigo_tipo_movimiento_modulo!=newcodigo_tipo_movimiento_modulo) {
				if(newcodigo_tipo_movimiento_modulo==null) {
					//newcodigo_tipo_movimiento_modulo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna codigo_tipo_movimiento_modulo");
					}
				}

				if(newcodigo_tipo_movimiento_modulo!=null&&newcodigo_tipo_movimiento_modulo.length()>50) {
					newcodigo_tipo_movimiento_modulo=newcodigo_tipo_movimiento_modulo.substring(0,48);
					System.out.println("PagosAutorizadosProceso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_tipo_movimiento_modulo");
				}

				this.codigo_tipo_movimiento_modulo=newcodigo_tipo_movimiento_modulo;
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
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>100) {
					newnumero_mayor=newnumero_mayor.substring(0,98);
					System.out.println("PagosAutorizadosProceso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
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
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cuenta_banco(String newcodigo_cuenta_banco)throws Exception
	{
		try {
			if(this.codigo_cuenta_banco!=newcodigo_cuenta_banco) {
				if(newcodigo_cuenta_banco==null) {
					//newcodigo_cuenta_banco="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna codigo_cuenta_banco");
					}
				}

				if(newcodigo_cuenta_banco!=null&&newcodigo_cuenta_banco.length()>100) {
					newcodigo_cuenta_banco=newcodigo_cuenta_banco.substring(0,98);
					System.out.println("PagosAutorizadosProceso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna codigo_cuenta_banco");
				}

				this.codigo_cuenta_banco=newcodigo_cuenta_banco;
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
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("PagosAutorizadosProceso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbeneficiario_detalle_cheque_girado(String newbeneficiario_detalle_cheque_girado)throws Exception
	{
		try {
			if(this.beneficiario_detalle_cheque_girado!=newbeneficiario_detalle_cheque_girado) {
				if(newbeneficiario_detalle_cheque_girado==null) {
					//newbeneficiario_detalle_cheque_girado="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagosAutorizadosProceso:Valor nulo no permitido en columna beneficiario_detalle_cheque_girado");
					}
				}

				if(newbeneficiario_detalle_cheque_girado!=null&&newbeneficiario_detalle_cheque_girado.length()>100) {
					newbeneficiario_detalle_cheque_girado=newbeneficiario_detalle_cheque_girado.substring(0,98);
					System.out.println("PagosAutorizadosProceso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna beneficiario_detalle_cheque_girado");
				}

				this.beneficiario_detalle_cheque_girado=newbeneficiario_detalle_cheque_girado;
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

