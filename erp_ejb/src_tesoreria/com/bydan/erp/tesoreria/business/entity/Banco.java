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
package com.bydan.erp.tesoreria.business.entity;

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
//import com.bydan.erp.tesoreria.util.BancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class Banco extends BancoAdditional implements Serializable ,Cloneable {//BancoAdditional,GeneralEntity
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
	
	private Banco bancoOriginal;
	
	private Map<String, Object> mapBanco;
			
	public Map<String, Object> getMapBanco() {
		return mapBanco;
	}

	public void setMapBanco(Map<String, Object> mapBanco) {
		this.mapBanco = mapBanco;
	}
	
	public void inicializarMapBanco() {
		this.mapBanco = new HashMap<String,Object>();
	}
	
	public void setMapBancoValue(String sKey,Object oValue) {
		this.mapBanco.put(sKey, oValue);
	}
	
	public Object getMapBancoValue(String sKey) {
		return this.mapBanco.get(sKey);
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
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BancoConstantesFunciones.SREGEXCODIGO,message=BancoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BancoConstantesFunciones.SREGEXCODIGO_INSTITUCION,message=BancoConstantesFunciones.SMENSAJEREGEXCODIGO_INSTITUCION)
	private String codigo_institucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BancoConstantesFunciones.SREGEXNOMBRE,message=BancoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dias_efectivo_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dias_efectivo_extranjero;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_debito;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=BancoConstantesFunciones.SREGEXDELIMITADOR,message=BancoConstantesFunciones.SMENSAJEREGEXDELIMITADOR)
	private String delimitador;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_formato1;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_formato2;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TipoBanco tipobanco;
	public CuentaContable cuentacontabledebito;
	public CuentaContable cuentacontablecredito;
	public Formato formato1;
	public Formato formato2;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tipobanco_descripcion;
	private String cuentacontabledebito_descripcion;
	private String cuentacontablecredito_descripcion;
	private String formato1_descripcion;
	private String formato2_descripcion;
	
	
	public List<AutoriPago> autoripagos;
	public List<TarjetaCredito> tarjetacreditos;
	public List<CuentaBancoPunVen> cuentabancopunvens;
	public List<PoliticasCliente> politicasclientes;
	public List<FormaPagoPuntoVenta> formapagopuntoventas;
	public List<CuentaBanco> cuentabancos;
	public List<TipoCuentaBancoGeneral> tipocuentabancogenerals;
		
	public Banco () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.bancoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.codigo="";
 		this.codigo_institucion="";
 		this.nombre="";
 		this.id_tipo_banco=-1L;
 		this.dias_efectivo_local=0;
 		this.dias_efectivo_extranjero=0;
 		this.id_cuenta_contable_debito=null;
 		this.id_cuenta_contable_credito=null;
 		this.delimitador="";
 		this.id_formato1=null;
 		this.id_formato2=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tipobanco=null;
		this.cuentacontabledebito=null;
		this.cuentacontablecredito=null;
		this.formato1=null;
		this.formato2=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tipobanco_descripcion="";
		this.cuentacontabledebito_descripcion="";
		this.cuentacontablecredito_descripcion="";
		this.formato1_descripcion="";
		this.formato2_descripcion="";
		
		
		this.autoripagos=null;
		this.tarjetacreditos=null;
		this.cuentabancopunvens=null;
		this.politicasclientes=null;
		this.formapagopuntoventas=null;
		this.cuentabancos=null;
		this.tipocuentabancogenerals=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Banco (Long id,Date versionRow,Long id_empresa,Long id_sucursal,String codigo,String codigo_institucion,String nombre,Long id_tipo_banco,Integer dias_efectivo_local,Integer dias_efectivo_extranjero,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,String delimitador,Long id_formato1,Long id_formato2) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.bancoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.codigo_institucion=codigo_institucion;
 		this.nombre=nombre;
 		this.id_tipo_banco=id_tipo_banco;
 		this.dias_efectivo_local=dias_efectivo_local;
 		this.dias_efectivo_extranjero=dias_efectivo_extranjero;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.delimitador=delimitador;
 		this.id_formato1=id_formato1;
 		this.id_formato2=id_formato2;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Banco (Long id_empresa,Long id_sucursal,String codigo,String codigo_institucion,String nombre,Long id_tipo_banco,Integer dias_efectivo_local,Integer dias_efectivo_extranjero,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,String delimitador,Long id_formato1,Long id_formato2) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.bancoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.codigo_institucion=codigo_institucion;
 		this.nombre=nombre;
 		this.id_tipo_banco=id_tipo_banco;
 		this.dias_efectivo_local=dias_efectivo_local;
 		this.dias_efectivo_extranjero=dias_efectivo_extranjero;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.delimitador=delimitador;
 		this.id_formato1=id_formato1;
 		this.id_formato2=id_formato2;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Banco bancoLocal=null;
		
		if(object!=null) {
			bancoLocal=(Banco)object;
			
			if(bancoLocal!=null) {
				if(this.getId()!=null && bancoLocal.getId()!=null) {
					if(this.getId().equals(bancoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!BancoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=BancoConstantesFunciones.getBancoDescripcion(this);
		} else {
			sDetalle=BancoConstantesFunciones.getBancoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Banco getBancoOriginal() {
		return this.bancoOriginal;
	}
	
	public void setBancoOriginal(Banco banco) {
		try {
			this.bancoOriginal=banco;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected BancoAdditional bancoAdditional=null;
	
	public BancoAdditional getBancoAdditional() {
		return this.bancoAdditional;
	}
	
	public void setBancoAdditional(BancoAdditional bancoAdditional) {
		try {
			this.bancoAdditional=bancoAdditional;
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
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getcodigo_institucion() {
		return this.codigo_institucion;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_tipo_banco() {
		return this.id_tipo_banco;
	}
    
	
	public Integer getdias_efectivo_local() {
		return this.dias_efectivo_local;
	}
    
	
	public Integer getdias_efectivo_extranjero() {
		return this.dias_efectivo_extranjero;
	}
    
	
	public Long getid_cuenta_contable_debito() {
		return this.id_cuenta_contable_debito;
	}
    
	
	public Long getid_cuenta_contable_credito() {
		return this.id_cuenta_contable_credito;
	}
    
	
	public String getdelimitador() {
		return this.delimitador;
	}
    
	
	public Long getid_formato1() {
		return this.id_formato1;
	}
    
	
	public Long getid_formato2() {
		return this.id_formato2;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Banco:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Banco:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("Banco:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>100) {
					newcodigo=newcodigo.substring(0,98);
					System.out.println("Banco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_institucion(String newcodigo_institucion)throws Exception
	{
		try {
			if(this.codigo_institucion!=newcodigo_institucion) {
				if(newcodigo_institucion==null) {
					//newcodigo_institucion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Banco:Valor nulo no permitido en columna codigo_institucion");
					}
				}

				if(newcodigo_institucion!=null&&newcodigo_institucion.length()>50) {
					newcodigo_institucion=newcodigo_institucion.substring(0,48);
					System.out.println("Banco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_institucion");
				}

				this.codigo_institucion=newcodigo_institucion;
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
						System.out.println("Banco:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Banco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_banco(Long newid_tipo_banco)throws Exception
	{
		try {
			if(this.id_tipo_banco!=newid_tipo_banco) {
				if(newid_tipo_banco==null) {
					//newid_tipo_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Banco:Valor nulo no permitido en columna id_tipo_banco");
					}
				}

				this.id_tipo_banco=newid_tipo_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_efectivo_local(Integer newdias_efectivo_local)throws Exception
	{
		try {
			if(this.dias_efectivo_local!=newdias_efectivo_local) {
				if(newdias_efectivo_local==null) {
					//newdias_efectivo_local=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Banco:Valor nulo no permitido en columna dias_efectivo_local");
					}
				}

				this.dias_efectivo_local=newdias_efectivo_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_efectivo_extranjero(Integer newdias_efectivo_extranjero)throws Exception
	{
		try {
			if(this.dias_efectivo_extranjero!=newdias_efectivo_extranjero) {
				if(newdias_efectivo_extranjero==null) {
					//newdias_efectivo_extranjero=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Banco:Valor nulo no permitido en columna dias_efectivo_extranjero");
					}
				}

				this.dias_efectivo_extranjero=newdias_efectivo_extranjero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_debito(Long newid_cuenta_contable_debito) {
		if(this.id_cuenta_contable_debito==null&&newid_cuenta_contable_debito!=null) {
			this.id_cuenta_contable_debito=newid_cuenta_contable_debito;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_debito!=null&&!this.id_cuenta_contable_debito.equals(newid_cuenta_contable_debito)) {

			this.id_cuenta_contable_debito=newid_cuenta_contable_debito;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_credito(Long newid_cuenta_contable_credito) {
		if(this.id_cuenta_contable_credito==null&&newid_cuenta_contable_credito!=null) {
			this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_credito!=null&&!this.id_cuenta_contable_credito.equals(newid_cuenta_contable_credito)) {

			this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
				this.setIsChanged(true);
		}
	}
    
	public void setdelimitador(String newdelimitador)throws Exception
	{
		try {
			if(this.delimitador!=newdelimitador) {
				if(newdelimitador==null) {
					//newdelimitador="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Banco:Valor nulo no permitido en columna delimitador");
					}
				}

				if(newdelimitador!=null&&newdelimitador.length()>20) {
					newdelimitador=newdelimitador.substring(0,18);
					System.out.println("Banco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna delimitador");
				}

				this.delimitador=newdelimitador;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato1(Long newid_formato1) {
		if(this.id_formato1==null&&newid_formato1!=null) {
			this.id_formato1=newid_formato1;
				this.setIsChanged(true);
		}

		if(this.id_formato1!=null&&!this.id_formato1.equals(newid_formato1)) {

			this.id_formato1=newid_formato1;
				this.setIsChanged(true);
		}
	}
    
	public void setid_formato2(Long newid_formato2) {
		if(this.id_formato2==null&&newid_formato2!=null) {
			this.id_formato2=newid_formato2;
				this.setIsChanged(true);
		}

		if(this.id_formato2!=null&&!this.id_formato2.equals(newid_formato2)) {

			this.id_formato2=newid_formato2;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public TipoBanco getTipoBanco() {
		return this.tipobanco;
	}

	public CuentaContable getCuentaContableDebito() {
		return this.cuentacontabledebito;
	}

	public CuentaContable getCuentaContableCredito() {
		return this.cuentacontablecredito;
	}

	public Formato getFormato1() {
		return this.formato1;
	}

	public Formato getFormato2() {
		return this.formato2;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettipobanco_descripcion() {
		return this.tipobanco_descripcion;
	}

	public String getcuentacontabledebito_descripcion() {
		return this.cuentacontabledebito_descripcion;
	}

	public String getcuentacontablecredito_descripcion() {
		return this.cuentacontablecredito_descripcion;
	}

	public String getformato1_descripcion() {
		return this.formato1_descripcion;
	}

	public String getformato2_descripcion() {
		return this.formato2_descripcion;
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


	public  void  setTipoBanco(TipoBanco tipobanco) {
		try {
			this.tipobanco=tipobanco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDebito(CuentaContable cuentacontabledebito) {
		try {
			this.cuentacontabledebito=cuentacontabledebito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCredito(CuentaContable cuentacontablecredito) {
		try {
			this.cuentacontablecredito=cuentacontablecredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato1(Formato formato1) {
		try {
			this.formato1=formato1;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato2(Formato formato2) {
		try {
			this.formato2=formato2;
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


	public  void  settipobanco_descripcion(String tipobanco_descripcion) {
		try {
			this.tipobanco_descripcion=tipobanco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledebito_descripcion(String cuentacontabledebito_descripcion) {
		try {
			this.cuentacontabledebito_descripcion=cuentacontabledebito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecredito_descripcion(String cuentacontablecredito_descripcion) {
		try {
			this.cuentacontablecredito_descripcion=cuentacontablecredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformato1_descripcion(String formato1_descripcion) {
		try {
			this.formato1_descripcion=formato1_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformato2_descripcion(String formato2_descripcion) {
		try {
			this.formato2_descripcion=formato2_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<AutoriPago> getAutoriPagos() {
		return this.autoripagos;
	}

	public List<TarjetaCredito> getTarjetaCreditos() {
		return this.tarjetacreditos;
	}

	public List<CuentaBancoPunVen> getCuentaBancoPunVens() {
		return this.cuentabancopunvens;
	}

	public List<PoliticasCliente> getPoliticasClientes() {
		return this.politicasclientes;
	}

	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas() {
		return this.formapagopuntoventas;
	}

	public List<CuentaBanco> getCuentaBancos() {
		return this.cuentabancos;
	}

	public List<TipoCuentaBancoGeneral> getTipoCuentaBancoGenerals() {
		return this.tipocuentabancogenerals;
	}

	
	
	public  void  setAutoriPagos(List<AutoriPago> autoripagos) {
		try {
			this.autoripagos=autoripagos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTarjetaCreditos(List<TarjetaCredito> tarjetacreditos) {
		try {
			this.tarjetacreditos=tarjetacreditos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCuentaBancoPunVens(List<CuentaBancoPunVen> cuentabancopunvens) {
		try {
			this.cuentabancopunvens=cuentabancopunvens;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPoliticasClientes(List<PoliticasCliente> politicasclientes) {
		try {
			this.politicasclientes=politicasclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFormaPagoPuntoVentas(List<FormaPagoPuntoVenta> formapagopuntoventas) {
		try {
			this.formapagopuntoventas=formapagopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCuentaBancos(List<CuentaBanco> cuentabancos) {
		try {
			this.cuentabancos=cuentabancos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTipoCuentaBancoGenerals(List<TipoCuentaBancoGeneral> tipocuentabancogenerals) {
		try {
			this.tipocuentabancogenerals=tipocuentabancogenerals;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tipo_banco_descripcion="";String id_cuenta_contable_debito_descripcion="";String id_cuenta_contable_credito_descripcion="";String id_formato1_descripcion="";String id_formato2_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_banco_descripcion() {
		return id_tipo_banco_descripcion;
	}
	public String getid_cuenta_contable_debito_descripcion() {
		return id_cuenta_contable_debito_descripcion;
	}
	public String getid_cuenta_contable_credito_descripcion() {
		return id_cuenta_contable_credito_descripcion;
	}
	public String getid_formato1_descripcion() {
		return id_formato1_descripcion;
	}
	public String getid_formato2_descripcion() {
		return id_formato2_descripcion;
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
	public void setid_tipo_banco_descripcion(String newid_tipo_banco_descripcion)throws Exception {
		try {
			this.id_tipo_banco_descripcion=newid_tipo_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_debito_descripcion(String newid_cuenta_contable_debito_descripcion) {
		this.id_cuenta_contable_debito_descripcion=newid_cuenta_contable_debito_descripcion;
	}
	public void setid_cuenta_contable_credito_descripcion(String newid_cuenta_contable_credito_descripcion) {
		this.id_cuenta_contable_credito_descripcion=newid_cuenta_contable_credito_descripcion;
	}
	public void setid_formato1_descripcion(String newid_formato1_descripcion) {
		this.id_formato1_descripcion=newid_formato1_descripcion;
	}
	public void setid_formato2_descripcion(String newid_formato2_descripcion) {
		this.id_formato2_descripcion=newid_formato2_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_banco_descripcion="";this.id_cuenta_contable_debito_descripcion="";this.id_cuenta_contable_credito_descripcion="";this.id_formato1_descripcion="";this.id_formato2_descripcion="";
	}
	
	
	Object cuentabancopunvensDescripcionReporte;
	Object politicasclientesDescripcionReporte;
	Object formulariorentaextrasDescripcionReporte;
	Object datogeneralempleadosDescripcionReporte;
	Object formapagopuntoventasDescripcionReporte;
	Object autoripagoordencomprasDescripcionReporte;
	Object recibopuntoventasDescripcionReporte;
	Object tarjetacreditosDescripcionReporte;
	Object autoripagosDescripcionReporte;
	Object tipocuentabancogeneralsDescripcionReporte;
	Object referenciabancariasDescripcionReporte;
	Object depositobancosDescripcionReporte;
	Object bancotipocuentabancoglobalsDescripcionReporte;
	Object cuentabancosDescripcionReporte;
	
	
	public Object getcuentabancopunvensDescripcionReporte() {
		return cuentabancopunvensDescripcionReporte;
	}

	public Object getpoliticasclientesDescripcionReporte() {
		return politicasclientesDescripcionReporte;
	}

	public Object getformulariorentaextrasDescripcionReporte() {
		return formulariorentaextrasDescripcionReporte;
	}

	public Object getdatogeneralempleadosDescripcionReporte() {
		return datogeneralempleadosDescripcionReporte;
	}

	public Object getformapagopuntoventasDescripcionReporte() {
		return formapagopuntoventasDescripcionReporte;
	}

	public Object getautoripagoordencomprasDescripcionReporte() {
		return autoripagoordencomprasDescripcionReporte;
	}

	public Object getrecibopuntoventasDescripcionReporte() {
		return recibopuntoventasDescripcionReporte;
	}

	public Object gettarjetacreditosDescripcionReporte() {
		return tarjetacreditosDescripcionReporte;
	}

	public Object getautoripagosDescripcionReporte() {
		return autoripagosDescripcionReporte;
	}

	public Object gettipocuentabancogeneralsDescripcionReporte() {
		return tipocuentabancogeneralsDescripcionReporte;
	}

	public Object getreferenciabancariasDescripcionReporte() {
		return referenciabancariasDescripcionReporte;
	}

	public Object getdepositobancosDescripcionReporte() {
		return depositobancosDescripcionReporte;
	}

	public Object getbancotipocuentabancoglobalsDescripcionReporte() {
		return bancotipocuentabancoglobalsDescripcionReporte;
	}

	public Object getcuentabancosDescripcionReporte() {
		return cuentabancosDescripcionReporte;
	}

	
	
	public  void  setcuentabancopunvensDescripcionReporte(Object cuentabancopunvens) {
		try {
			this.cuentabancopunvensDescripcionReporte=cuentabancopunvens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpoliticasclientesDescripcionReporte(Object politicasclientes) {
		try {
			this.politicasclientesDescripcionReporte=politicasclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformulariorentaextrasDescripcionReporte(Object formulariorentaextras) {
		try {
			this.formulariorentaextrasDescripcionReporte=formulariorentaextras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdatogeneralempleadosDescripcionReporte(Object datogeneralempleados) {
		try {
			this.datogeneralempleadosDescripcionReporte=datogeneralempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformapagopuntoventasDescripcionReporte(Object formapagopuntoventas) {
		try {
			this.formapagopuntoventasDescripcionReporte=formapagopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoripagoordencomprasDescripcionReporte(Object autoripagoordencompras) {
		try {
			this.autoripagoordencomprasDescripcionReporte=autoripagoordencompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrecibopuntoventasDescripcionReporte(Object recibopuntoventas) {
		try {
			this.recibopuntoventasDescripcionReporte=recibopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settarjetacreditosDescripcionReporte(Object tarjetacreditos) {
		try {
			this.tarjetacreditosDescripcionReporte=tarjetacreditos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoripagosDescripcionReporte(Object autoripagos) {
		try {
			this.autoripagosDescripcionReporte=autoripagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settipocuentabancogeneralsDescripcionReporte(Object tipocuentabancogenerals) {
		try {
			this.tipocuentabancogeneralsDescripcionReporte=tipocuentabancogenerals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setreferenciabancariasDescripcionReporte(Object referenciabancarias) {
		try {
			this.referenciabancariasDescripcionReporte=referenciabancarias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdepositobancosDescripcionReporte(Object depositobancos) {
		try {
			this.depositobancosDescripcionReporte=depositobancos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setbancotipocuentabancoglobalsDescripcionReporte(Object bancotipocuentabancoglobals) {
		try {
			this.bancotipocuentabancoglobalsDescripcionReporte=bancotipocuentabancoglobals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuentabancosDescripcionReporte(Object cuentabancos) {
		try {
			this.cuentabancosDescripcionReporte=cuentabancos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

